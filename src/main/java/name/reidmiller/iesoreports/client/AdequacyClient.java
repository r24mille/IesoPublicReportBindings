package name.reidmiller.iesoreports.client;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.xml.transform.stream.StreamSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import ca.ieso.reports.schema.adequacy.DocBody;
import ca.ieso.reports.schema.adequacy.DocHeader;
import ca.ieso.reports.schema.adequacy.Document;

public class AdequacyClient {
	private Logger logger = LogManager.getLogger(this.getClass());

	private String defaultUrlString;
	private Jaxb2Marshaller jaxb2Marshaller;

	public AdequacyClient(String defaultUrlString,
			Jaxb2Marshaller jaxb2Marshaller) {
		this.defaultUrlString = defaultUrlString;
		this.jaxb2Marshaller = jaxb2Marshaller;
	}

	/**
	 * Unmarshals XML text from {@link #defaultUrlString} into an
	 * {@link Document} using JAXB2. This method is a wrapper around
	 * {@link #unmarshal(String)}.
	 * 
	 * @return {@link Document}
	 * @throws MalformedURLException
	 * @throws IOException
	 * @throws ClassCastException
	 */
	public Document unmarshal() throws MalformedURLException, IOException,
			ClassCastException {
		return this.unmarshal(defaultUrlString);
	}

	/**
	 * Unmarshals XML text into an {@link Document} using JAXB2.
	 * 
	 * @param urlString
	 *            The URL that will be unmarshalled into a {@link Document}.
	 * @return {@link Document}
	 * @throws MalformedURLException
	 * @throws IOException
	 * @throws ClassCastException
	 */
	public Document unmarshal(String urlString) throws MalformedURLException,
			IOException, ClassCastException {
		InputStream input = new URL(urlString).openStream();
		StreamSource source = new StreamSource(input);
		Object unmarshalledObj = this.jaxb2Marshaller.unmarshal(source);

		if (unmarshalledObj instanceof Document) {
			return (Document) unmarshalledObj;
		} else {
			throw new ClassCastException();
		}
	}

	/**
	 * Calls {@link #unmarshal()} and returns only the {@link DocHeader} portion
	 * of the {@link Document}.
	 * 
	 * @return {@link DocHeader}
	 */
	public DocHeader getDocHeader(Document document) {
		List<Object> docHeaderAndDocBody = document.getDocHeaderAndDocBody();

		DocHeader docHeader = null;
		for (Object part : docHeaderAndDocBody) {
			if (part instanceof DocHeader) {
				docHeader = (DocHeader) part;
				break;
			}
		}

		return docHeader;
	}

	/**
	 * Returns only the {@link DocBody} portion of the {@link Document}.
	 * 
	 * @param document
	 *            Unmarshalled {@link Document}
	 * @return {@link DocBody}
	 */
	public DocBody getDocBody(Document document) {
		List<Object> docHeaderAndDocBody = document.getDocHeaderAndDocBody();

		DocBody docBody = null;
		for (Object part : docHeaderAndDocBody) {
			if (part instanceof DocBody) {
				docBody = (DocBody) part;
				break;
			}
		}

		return docBody;
	}

	/**
	 * This method uses {@link #defaultUrlString} to request the current
	 * (default) {@link DocBody}.
	 * 
	 * @return {@link DocBody} for the current (default) report.
	 * @throws MalformedURLException
	 * @throws ClassCastException
	 * @throws IOException
	 */
	public DocBody getDefaultDocBody() throws MalformedURLException,
			ClassCastException, IOException {
		Document document = this.unmarshal();
		return this.getDocBody(document);
	}

	/**
	 * This method uses {@link #defaultUrlString} to request the current
	 * (default) {@link DocHeader}.
	 * 
	 * @return {@link DocHeader} for the current (default) report.
	 * @throws MalformedURLException
	 * @throws ClassCastException
	 * @throws IOException
	 */
	public DocHeader getDefaultDocHeader() throws MalformedURLException,
			ClassCastException, IOException {
		Document document = this.unmarshal();
		return this.getDocHeader(document);
	}

	/**
	 * Get a {@link DocHeader} for a date in past.
	 * 
	 * @param historyDate
	 *            Date in the past that a report header is being requested for.
	 * @return Returns a {@link DocHeader} using {@link #historyUrlString(Date)}
	 *         rather than using {@link #defaultUrlString} for the
	 *         {@link #unmarshal(String)} request.
	 * @throws MalformedURLException
	 * @throws ClassCastException
	 * @throws IOException
	 */
	public DocHeader getDocHeaderForDate(Date historyDate)
			throws MalformedURLException, ClassCastException, IOException {
		String historyUrlString = IesoPublicReportClientUtil.historyUrlString(
				this.defaultUrlString, historyDate);
		Document document = this.unmarshal(historyUrlString);
		return this.getDocHeader(document);
	}

	/**
	 * Get a {@link DocBody} for a date in past.
	 * 
	 * @param historyDate
	 *            Date in the past that a report is being requested for.
	 * @return Returns a {@link DocBody} using {@link #historyUrlString(Date)}
	 *         rather than using {@link #defaultUrlString} for the
	 *         {@link #unmarshal(String)} request.
	 * @throws MalformedURLException
	 * @throws ClassCastException
	 * @throws IOException
	 */
	public DocBody getDocBodyForDate(Date historyDate)
			throws MalformedURLException, ClassCastException, IOException {
		String historyUrlString = IesoPublicReportClientUtil.historyUrlString(
				this.defaultUrlString, historyDate);
		Document document = this.unmarshal(historyUrlString);
		return this.getDocBody(document);
	}

	/**
	 * Makes a request for each Date in the provided range (inclusive) building
	 * out a {@link List} of {@link DocBody} Objects.
	 * 
	 * @param startDate
	 * @param endDate
	 * @return If the startDate is in the future, a one-item {@link List} of
	 *         {@link DocBody} Objects will be returned. If endDate is in the
	 *         future the {@link List} will stop at the current (default)
	 *         report.
	 * @throws MalformedURLException
	 * @throws ClassCastException
	 * @throws IOException
	 */
	public List<DocBody> getDocBodiesInDateRange(Date startDate, Date endDate)
			throws MalformedURLException, ClassCastException, IOException {
		List<DocBody> docBodies = new ArrayList<DocBody>();

		// Get dates at 00:00:00 for accurate comparison
		Date today = IesoPublicReportClientUtil.getDateAtMidnight(new Date());
		Date endDateCopy = IesoPublicReportClientUtil
				.getDateAtMidnight(endDate);

		// Step through Dates in range
		Calendar calStep = Calendar.getInstance();
		calStep.setTime(IesoPublicReportClientUtil.getDateAtMidnight(startDate));
		while (calStep.getTime().before(endDateCopy)
				|| calStep.getTime().equals(endDateCopy)) {
			// If the step is greater than or equal to the current Date,
			// add the default report as the last item in the List and stop.
			if (calStep.getTime().equals(today) || calStep.after(today)) {
				docBodies.add(this.getDefaultDocBody());
				break;
			} else {
				docBodies.add(this.getDocBodyForDate(calStep.getTime()));
			}

			calStep.roll(Calendar.DATE, true);
		}

		return docBodies;
	}

	/**
	 * Makes a request for each Date in the provided range (inclusive) building
	 * out a {@link List} of {@link DocHeader} Objects.
	 * 
	 * @param startDate
	 * @param endDate
	 * @return If the startDate is in the future, a one-item {@link List} of
	 *         {@link DocHeader} Objects will be returned. If endDate is in the
	 *         future the {@link List} will stop at the current (default)
	 *         report.
	 * @throws MalformedURLException
	 * @throws ClassCastException
	 * @throws IOException
	 */
	public List<DocHeader> getDocHeadersInDateRange(Date startDate, Date endDate)
			throws MalformedURLException, ClassCastException, IOException {
		List<DocHeader> docHeaders = new ArrayList<DocHeader>();

		// Get dates at 00:00:00 for accurate comparison
		Date today = IesoPublicReportClientUtil.getDateAtMidnight(new Date());
		Date endDateCopy = IesoPublicReportClientUtil
				.getDateAtMidnight(endDate);

		// Step through Dates in range
		Calendar calStep = Calendar.getInstance();
		calStep.setTime(IesoPublicReportClientUtil.getDateAtMidnight(startDate));
		while (calStep.getTime().before(endDateCopy)
				|| calStep.getTime().equals(endDateCopy)) {
			// If the step is greater than or equal to the current Date,
			// add the default report as the last item in the List and stop.
			if (calStep.getTime().equals(today) || calStep.after(today)) {
				docHeaders.add(this.getDefaultDocHeader());
				break;
			} else {
				docHeaders.add(this.getDocHeaderForDate(calStep.getTime()));
			}

			calStep.roll(Calendar.DATE, true);
		}

		return docHeaders;
	}
}
