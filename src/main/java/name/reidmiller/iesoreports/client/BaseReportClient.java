package name.reidmiller.iesoreports.client;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.xml.transform.stream.StreamSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import ca.ieso.reports.schema.adequacy.DocHeader;

/**
 * <p>
 * All IESO reports have a similar document structure consisting of a header
 * part and a body part. However, they do not all use the same document class
 * due to XML namespace issues.
 * </p>
 * <p>
 * To encapsulate the functionality of unmarshalling XML into the appropriate
 * objects, all report clients will extend and call these generic methods.
 * </p>
 */
public class BaseReportClient {
	protected Logger logger = LogManager.getLogger(BaseReportClient.class);
	/**
	 * IESO's date format in the past report URLs.
	 */
	public static final DateFormat REPORT_DATE_FORMAT = new SimpleDateFormat(
			"yyyyMMdd");

	/**
	 * Iterates over the document to find the part which is an instance of
	 * docPartClazz.
	 * 
	 * @param docHeaderAndDocBody
	 *            List of document parts (ie. header and body).
	 * @param docPartClazz
	 *            Class of document part to retrieve.
	 * @return Document part from docHeaderAndDocBody that is an instance of
	 *         docPartClazz. If the document part is not found, null is
	 *         returned.
	 */
	@SuppressWarnings("unchecked")
	protected <T> T getDocPart(List<Object> docHeaderAndDocBody,
			Class<T> docPartClazz) {
		T docPart = null;
		for (Object part : docHeaderAndDocBody) {
			if (part != null && docPartClazz.isInstance(part)) {
				docPart = (T) part;
				break;
			}
		}
		return docPart;
	}

	/**
	 * Get a document for a date in the past.
	 * 
	 * @param defaultUrlString
	 *            The URL to the default XML report. This is used as a starting
	 *            point for {@link #historyUrlString(String, Date)}.
	 * @param jaxb2ContextPath
	 *            The package containing Java objects which the XML will be
	 *            unmarshalled into.
	 * @param historyDate
	 *            Date in the past that a report header is being requested for.
	 * @param documentClazz
	 *            Class of document to return.
	 * @return Returns a document using {@link #historyUrlString(Date)} rather
	 *         than using defaultUrlString for the {@link #getDocument(String)}
	 *         request.
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	protected <T> T getDocumentForDate(String defaultUrlString,
			String jaxb2ContextPath, Date historyDate, Class<T> documentClazz)
			throws MalformedURLException, IOException {
		String historyUrlString = this.historyUrlString(defaultUrlString,
				historyDate);
		return this.getDocument(historyUrlString, jaxb2ContextPath,
				documentClazz);
	}

	/**
	 * Makes a request for each Date in the provided range (inclusive) building
	 * out a {@link List} of {@link DocHeader} Objects.
	 * 
	 * @param defaultUrlString
	 *            The URL to the default XML report.
	 * @param jaxb2ContextPath
	 *            The package containing Java objects which the XML will be
	 *            unmarshalled into.
	 * @param startDate
	 *            Start point (inclusive) of the date range (ie. date furthest
	 *            in the past).
	 * @param endDate
	 *            End point (inclusive) of the date range (ie. date closest to
	 *            present).
	 * @param documentClazz
	 *            Class of document to return.
	 * @return If the startDate is in the future, a one-item {@link List} of
	 *         {@link DocHeader} Objects will be returned. If endDate is in the
	 *         future the {@link List} will stop at the current (default)
	 *         report.
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	protected <T> List<T> getDocumentsInDateRange(String defaultUrlString,
			String jaxb2ContextPath, Date startDate, Date endDate,
			Class<T> documentClazz) throws MalformedURLException, IOException {
		List<T> documents = new ArrayList<T>();

		// Get dates at 00:00:00 for accurate comparison
		Date today = this.getDateAtMidnight(new Date());
		Date endDateCopy = this.getDateAtMidnight(endDate);

		// Step through Dates in range
		Calendar calStep = Calendar.getInstance();
		calStep.setTime(this.getDateAtMidnight(startDate));
		while (calStep.getTime().before(endDateCopy)
				|| calStep.getTime().equals(endDateCopy)) {
			// If the step is greater than or equal to the current Date,
			// add the default report as the last item in the List and stop.
			if (calStep.getTime().equals(today) || calStep.after(today)) {
				documents.add(this.getDocument(defaultUrlString,
						jaxb2ContextPath, documentClazz));
				break;
			} else {
				documents.add(this.getDocumentForDate(defaultUrlString,
						jaxb2ContextPath, calStep.getTime(), documentClazz));
			}

			calStep.roll(Calendar.DATE, true);
		}

		return documents;
	}

	/**
	 * Unmarshals XML text into an document object using JAXB2.
	 * 
	 * @param jaxb2ContextPath
	 *            The package containing Java objects which the XML will be
	 *            unmarshalled into.
	 * @param urlString
	 *            The URL to an XML report.
	 * @param documentClazz
	 *            Class of document to return.
	 * @return Report document.
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	protected <T> T getDocument(String urlString, String jaxb2ContextPath,
			Class<T> documentClazz) throws MalformedURLException, IOException {
		T document = null;
		logger.debug("Unmarshalling the URL " + urlString);
		InputStream input = new URL(urlString).openStream();
		StreamSource source = new StreamSource(input);
		Jaxb2Marshaller marshaller = this.buildMarshaller(jaxb2ContextPath);
		Object unmarshalledObj = marshaller.unmarshal(source);

		if (unmarshalledObj != null
				&& documentClazz.isInstance(unmarshalledObj)) {
			document = (T) unmarshalledObj;
		} else {
			logger.warn("Expected to unmarshal object of type "
					+ documentClazz.getName()
					+ " but the actual object unmarhsalled is of type "
					+ unmarshalledObj.getClass().getName()
					+ ". Returning null object.");
		}

		return document;
	}

	/**
	 * @param contextPath
	 *            The package containing Java objects which the XML will be
	 *            unmarshalled into.
	 * @return {@link Jaxb2Marshaller} for the package name specified.
	 */
	private Jaxb2Marshaller buildMarshaller(String contextPath) {
		Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
		jaxb2Marshaller.setContextPath(contextPath);
		return jaxb2Marshaller;
	}

	/**
	 * Returns a matching date with time set to midnight. This method uses
	 * {@link Calendar} to return a new {@link Date} instance, so this method is
	 * thread-safe.
	 * 
	 * @param date
	 * @return Date object at 00:00:00.
	 */
	private Date getDateAtMidnight(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	/**
	 * Using defaultUrlString as a starting point, this method and converts it
	 * to a URL string appropriate to request a past report.
	 * 
	 * @param defaultUrlString
	 *            The default report URL passed in by the client class.
	 * @param historyDate
	 *            Date in the past that a URL string will be created for.
	 * @return String appropriate to request a past report. If the
	 *         defaultUrlString cannot be parsed according to the history date
	 *         format, then the defaultUrlString is returned.
	 */
	private String historyUrlString(String defaultUrlString, Date historyDate) {
		logger.debug("Creating URL for Date=" + historyDate.toString());
		String historyUrlString = defaultUrlString;

		int extensionIndex = defaultUrlString.lastIndexOf(".xml");
		if (extensionIndex > 0) {
			logger.debug("Injecting " + REPORT_DATE_FORMAT.format(historyDate)
					+ " into default URL " + defaultUrlString);
			historyUrlString = defaultUrlString.substring(0, extensionIndex)
					+ "_" + REPORT_DATE_FORMAT.format(historyDate)
					+ defaultUrlString.substring(extensionIndex);
		} else {
			logger.warn("No index of \".xml\" in " + defaultUrlString
					+ ". Returning defaultUrlString as historyUrlString.");
		}

		return historyUrlString;
	}
}
