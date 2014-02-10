package name.reidmiller.iesoreports.client;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ca.ieso.reports.schema.sbg.DocHeader;
import ca.ieso.reports.schema.sbg.Document;
import ca.ieso.reports.schema.sbg.Document.DocBody;

public class SurplusBaseloadGenerationClient extends BaseReportClient {
	private Logger logger = LogManager.getLogger(this.getClass());
	private String defaultUrlString;
	private String jaxb2ContextPath;

	public SurplusBaseloadGenerationClient(String defaultUrlString, String jaxb2ContextPath) {
		this.defaultUrlString = defaultUrlString;
		this.jaxb2ContextPath = jaxb2ContextPath;
	}

	/**
	 * Unmarshals XML text from {@link #defaultUrlString} into a
	 * {@link Document} using JAXB2. This method is a wrapper around
	 * {@link #getDocument(String)}.
	 * 
	 * @return {@link Document}
	 * @throws MalformedURLException
	 * @throws IOException
	 * 
	 */
	public Document getDefaultDocument() throws MalformedURLException,
			IOException, ClassCastException {
		return this.getDocument(this.defaultUrlString);
	}

	/**
	 * This method uses {@link #defaultUrlString} to request the current
	 * (default) {@link DocBody}.
	 * 
	 * @return {@link DocBody} for the current (default) report.
	 * @throws MalformedURLException
	 * 
	 * @throws IOException
	 */
	public DocBody getDefaultDocBody() throws MalformedURLException,
			IOException {
		Document document = this.getDefaultDocument();
		return this.getDocBody(document);
	}

	/**
	 * This method uses {@link #defaultUrlString} to request the current
	 * (default) {@link DocHeader}.
	 * 
	 * @return {@link DocHeader} for the current (default) report.
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public DocHeader getDefaultDocHeader() throws MalformedURLException,
			IOException {
		Document document = this.getDefaultDocument();
		return this.getDocHeader(document);
	}

	/**
	 * Returns only the {@link DocBody} portion of the {@link Document}.
	 * 
	 * @param document
	 *            {@link Document} comprised of two parts: {@link DocHeader} and
	 *            {@link DocBody}.
	 * @return {@link DocBody}
	 */
	public DocBody getDocBody(Document document) {
		List<Object> docHeaderAndDocBody = document.getDocHeaderAndDocBody();
		return super.getDocPart(docHeaderAndDocBody, DocBody.class);
	}

	/**
	 * Get a {@link DocBody} for a date in past.
	 * 
	 * @param historyDate
	 *            Date in the past that a report is being requested for.
	 * @return Returns the {@link DocBody} of a past report.
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public DocBody getDocBodyForDate(Date historyDate)
			throws MalformedURLException, IOException {
		Document document = this.getDocumentForDate(this.defaultUrlString,
				this.jaxb2ContextPath, historyDate, Document.class);
		return this.getDocBody(document);
	}

	/**
	 * Makes a request for each Date in the provided range (inclusive) building
	 * out a {@link List} of {@link DocBody} objects.
	 * 
	 * @param startDate
	 *            Start point (inclusive) of the date range (ie. date furthest
	 *            in the past).
	 * @param endDate
	 *            End point (inclusive) of the date range (ie. date closest to
	 *            present).
	 * @return If the startDate is in the future, a one-item {@link List} of
	 *         {@link DocBody} Objects will be returned. If endDate is in the
	 *         future the {@link List} will stop at the current (default)
	 *         report.
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public List<DocBody> getDocBodiesInDateRange(Date startDate, Date endDate)
			throws MalformedURLException, IOException {
		List<DocBody> docBodies = new ArrayList<DocBody>();

		List<Document> documents = this.getDocumentsInDateRange(
				this.defaultUrlString, this.jaxb2ContextPath, startDate,
				endDate, Document.class);
		for (Document document : documents) {
			docBodies.add(this.getDocBody(document));
		}

		return docBodies;
	}

	/**
	 * Returns only the {@link DocHeader} portion of the {@link Document}.
	 * 
	 * @param document
	 *            {@link Document} comprised of two parts: {@link DocHeader} and
	 *            {@link DocBody}.
	 * 
	 * @return {@link DocHeader}
	 */
	public DocHeader getDocHeader(Document document) {
		List<Object> docHeaderAndDocBody = document.getDocHeaderAndDocBody();
		return super.getDocPart(docHeaderAndDocBody, DocHeader.class);
	}

	/**
	 * Get a {@link DocHeader} for a date in past.
	 * 
	 * @param historyDate
	 *            Date in the past that a report header is being requested for.
	 * @return Returns the {@link DocHeader} of a past report.
	 * @throws MalformedURLException
	 * 
	 * @throws IOException
	 */
	public DocHeader getDocHeaderForDate(Date historyDate)
			throws MalformedURLException, IOException {
		Document document = this.getDocumentForDate(this.defaultUrlString,
				this.jaxb2ContextPath, historyDate, Document.class);
		return this.getDocHeader(document);
	}

	/**
	 * Makes a request for each Date in the provided range (inclusive) building
	 * out a {@link List} of {@link DocHeader} Objects.
	 * 
	 * @param startDate
	 *            Start point (inclusive) of the date range (ie. date furthest
	 *            in the past).
	 * @param endDate
	 *            End point (inclusive) of the date range (ie. date closest to
	 *            present).
	 * @return If the startDate is in the future, a one-item {@link List} of
	 *         {@link DocHeader} Objects will be returned. If endDate is in the
	 *         future the {@link List} will stop at the current (default)
	 *         report.
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public List<DocHeader> getDocHeadersInDateRange(Date startDate, Date endDate)
			throws MalformedURLException, IOException {
		List<DocHeader> docHeaders = new ArrayList<DocHeader>();

		List<Document> documents = this.getDocumentsInDateRange(
				this.defaultUrlString, this.jaxb2ContextPath, startDate,
				endDate, Document.class);
		for (Document document : documents) {
			docHeaders.add(this.getDocHeader(document));
		}

		return docHeaders;
	}

	/**
	 * Unmarshals XML text into a {@link Document} using JAXB2, into the package
	 * name specified by {@link #jaxb2ContextPath}.
	 * 
	 * @param urlString
	 *            The URL that will be unmarshalled into a {@link Document}.
	 * @return {@link Document}
	 * @throws MalformedURLException
	 * @throws IOException
	 * 
	 */
	private Document getDocument(String urlString)
			throws MalformedURLException, IOException {
		return super.getDocument(urlString, this.jaxb2ContextPath,
				Document.class);
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
	@Override
	protected <T> T getDocumentForDate(String defaultUrlString,
			String jaxb2ContextPath, Date historyDate, Class<T> documentClazz)
			throws MalformedURLException, IOException {
		String historyUrlString = this.historyUrlString(defaultUrlString,
				historyDate);
		return super.getDocument(historyUrlString, jaxb2ContextPath,
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
	@Override
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
				documents.add(super.getDocument(defaultUrlString,
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
	@Override
	protected String historyUrlString(String defaultUrlString, Date historyDate) {
		logger.debug("Creating URL for Date=" + historyDate.toString());
		String historyUrlString = defaultUrlString;

		int extensionIndex = defaultUrlString.lastIndexOf("_v1.xml");
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
