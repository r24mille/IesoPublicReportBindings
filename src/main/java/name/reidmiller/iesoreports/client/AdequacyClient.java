package name.reidmiller.iesoreports.client;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ca.ieso.reports.schema.adequacy.DocBody;
import ca.ieso.reports.schema.adequacy.DocHeader;
import ca.ieso.reports.schema.adequacy.Document;

public class AdequacyClient extends BaseIesoPublicReportClient {
	private Logger logger = LogManager.getLogger(this.getClass());
	private String defaultUrlString;
	private String jaxb2ContextPath;

	public AdequacyClient(String defaultUrlString, String jaxb2ContextPath) {
		this.defaultUrlString = defaultUrlString;
		this.jaxb2ContextPath = jaxb2ContextPath;
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
		return super.getDocBody(docHeaderAndDocBody, DocBody.class);
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
		Document document = this.unmarshalDefaultUrl();
		return this.getDocBody(document);
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
		logger.debug("Creating URL for Date=" + historyDate.toString());
		String historyUrlString = super.historyUrlString(this.defaultUrlString,
				historyDate);
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
		Date today = super.getDateAtMidnight(new Date());
		Date endDateCopy = super.getDateAtMidnight(endDate);

		// Step through Dates in range
		Calendar calStep = Calendar.getInstance();
		calStep.setTime(super.getDateAtMidnight(startDate));
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
	 * Calls {@link #unmarshal()} and returns only the {@link DocHeader} portion
	 * of the {@link Document}.
	 * 
	 * @return {@link DocHeader}
	 */
	public DocHeader getDocHeader(Document document) {
		List<Object> docHeaderAndDocBody = document.getDocHeaderAndDocBody();
		return super.getDocHeader(docHeaderAndDocBody, DocHeader.class);
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
		Document document = this.unmarshalDefaultUrl();
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
		String historyUrlString = super.historyUrlString(this.defaultUrlString,
				historyDate);
		Document document = this.unmarshal(historyUrlString);
		return this.getDocHeader(document);
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
		Date today = super.getDateAtMidnight(new Date());
		Date endDateCopy = super.getDateAtMidnight(endDate);

		// Step through Dates in range
		Calendar calStep = Calendar.getInstance();
		calStep.setTime(super.getDateAtMidnight(startDate));
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

	/**
	 * Unmarshals XML text into a {@link Document} using JAXB2, into the
	 * package name specified by {@link #jaxb2ContextPath}.
	 * 
	 * @param urlString
	 *            The URL that will be unmarshalled into a {@link Document}.
	 * @return {@link Document}
	 * @throws MalformedURLException
	 * @throws IOException
	 * @throws ClassCastException
	 */
	private Document unmarshal(String urlString) throws MalformedURLException,
			IOException, ClassCastException {
		return super
				.unmarshal(this.jaxb2ContextPath, urlString, Document.class);
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
	public Document unmarshalDefaultUrl() throws MalformedURLException,
			IOException, ClassCastException {
		return this.unmarshal(this.defaultUrlString);
	}
}
