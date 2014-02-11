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

public class SurplusBaseloadGenerationClient extends DailyReportClient {
	private Logger logger = LogManager.getLogger(this.getClass());
	private String urlBaseString;
	private String urlTailString;

	public SurplusBaseloadGenerationClient(String defaultUrlString,
			String urlBaseString, String urlTailString, String jaxb2ContextPath) {
		super.setDefaultUrlString(defaultUrlString);
		this.urlBaseString = urlBaseString;
		this.urlTailString = urlTailString;
		super.setJaxb2ContextPath(jaxb2ContextPath);
	}

	/**
	 * Unmarshals XML text from {@link #getDefaultUrlString()} into a
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
		return this.getDocument(super.getDefaultUrlString());
	}

	/**
	 * This method uses {@link #getDefaultUrlString()} to request the current
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
	 * This method uses {@link #getDefaultUrlString()} to request the current
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
		Document document = super.getDocumentForDate(historyDate,
				Document.class);
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

		List<Document> documents = super.getDocumentsInDateRange(startDate,
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
		Document document = super.getDocumentForDate(historyDate,
				Document.class);
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

		List<Document> documents = super.getDocumentsInDateRange(startDate,
				endDate, Document.class);
		for (Document document : documents) {
			docHeaders.add(this.getDocHeader(document));
		}

		return docHeaders;
	}

	/**
	 * Unmarshals XML text into a {@link Document} using JAXB2, into the package
	 * name specified by {@link #getJaxb2ContextPath()}.
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
		return super.getDocument(urlString, Document.class);
	}

	/**
	 * Get a document for a date in the past.
	 * 
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
	protected <T> T getDocumentForDate(Date historyDate, Class<T> documentClazz)
			throws MalformedURLException, IOException {
		String historyUrlString = this.historyUrlString(historyDate);
		return super.getDocument(historyUrlString, documentClazz);
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
	protected <T> List<T> getDocumentsInDateRange(Date startDate, Date endDate,
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
				documents.add(super.getDocument(super.getDefaultUrlString(),
						documentClazz));
				break;
			} else {
				documents.add(this.getDocumentForDate(calStep.getTime(),
						documentClazz));
			}

			calStep.add(Calendar.DATE, 1);
		}

		return documents;
	}

	/**
	 * Using defaultUrlString as a starting point, this method and converts it
	 * to a URL string appropriate to request a past report.
	 * 
	 * @param historyDate
	 *            Date in the past that a URL string will be created for.
	 * @return String appropriate to request a past report. If the
	 *         defaultUrlString cannot be parsed according to the history date
	 *         format, then the defaultUrlString is returned.
	 */
	@Override
	protected String historyUrlString(Date historyDate) {
		logger.debug("Creating URL for Date=" + historyDate.toString());
		logger.debug("Injecting " + REPORT_DATE_FORMAT.format(historyDate)
				+ " into default URL " + super.getDefaultUrlString());
		String historyUrlString = this.urlBaseString
				+ REPORT_DATE_FORMAT.format(historyDate) + this.urlTailString;
		return historyUrlString;
	}
}
