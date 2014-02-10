package name.reidmiller.iesoreports.client;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ca.ieso.reports.schema.intertiescheduleflow.IMODocBody;
import ca.ieso.reports.schema.intertiescheduleflow.IMODocHeader;
import ca.ieso.reports.schema.intertiescheduleflow.IMODocument;

public class IntertieScheduleAndFlowClient extends BaseReportClient {
	private Logger logger = LogManager.getLogger(this.getClass());
	private String defaultUrlString;
	private String jaxb2ContextPath;

	public IntertieScheduleAndFlowClient(String defaultUrlString,
			String jaxb2ContextPath) {
		this.defaultUrlString = defaultUrlString;
		this.jaxb2ContextPath = jaxb2ContextPath;
	}

	/**
	 * Unmarshals XML text from {@link #defaultUrlString} into a
	 * {@link IMODocument} using JAXB2. This method is a wrapper around
	 * {@link #getIMODocument(String)}.
	 * 
	 * @return {@link IMODocument}
	 * @throws MalformedURLException
	 * @throws IOException
	 * 
	 */
	public IMODocument getDefaultIMODocument() throws MalformedURLException,
			IOException, ClassCastException {
		return this.getIMODocument(this.defaultUrlString);
	}

	/**
	 * This method uses {@link #defaultUrlString} to request the current
	 * (default) {@link IMODocBody}.
	 * 
	 * @return {@link IMODocBody} for the current (default) report.
	 * @throws MalformedURLException
	 * 
	 * @throws IOException
	 */
	public IMODocBody getDefaultIMODocBody() throws MalformedURLException,
			IOException {
		IMODocument imoDocument = this.getDefaultIMODocument();
		return this.getIMODocBody(imoDocument);
	}

	/**
	 * This method uses {@link #defaultUrlString} to request the current
	 * (default) {@link IMODocHeader}.
	 * 
	 * @return {@link IMODocHeader} for the current (default) report.
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public IMODocHeader getDefaultIMODocHeader() throws MalformedURLException,
			IOException {
		IMODocument imoDocument = this.getDefaultIMODocument();
		return this.getIMODocHeader(imoDocument);
	}

	/**
	 * Returns only the {@link IMODocBody} portion of the {@link IMODocument}.
	 * 
	 * @param imoDocument
	 *            {@link IMODocument} comprised of two parts:
	 *            {@link IMODocHeader} and {@link IMODocBody}.
	 * @return {@link IMODocBody}
	 */
	public IMODocBody getIMODocBody(IMODocument imoDocument) {
		List<Object> imoDocHeaderAndImoDocBody = imoDocument
				.getIMODocHeaderAndIMODocBody();
		return super.getDocPart(imoDocHeaderAndImoDocBody, IMODocBody.class);
	}

	/**
	 * Get a {@link IMODocBody} for a date in past.
	 * 
	 * @param historyDate
	 *            Date in the past that a report is being requested for.
	 * @return Returns the {@link IMODocBody} of a past report.
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public IMODocBody getIMODocBodyForDate(Date historyDate)
			throws MalformedURLException, IOException {
		IMODocument imoDocument = super.getDocumentForDate(
				this.defaultUrlString, this.jaxb2ContextPath, historyDate,
				IMODocument.class);
		return this.getIMODocBody(imoDocument);
	}

	/**
	 * Makes a request for each Date in the provided range (inclusive) building
	 * out a {@link List} of {@link IMODocBody} objects.
	 * 
	 * @param startDate
	 *            Start point (inclusive) of the date range (ie. date furthest
	 *            in the past).
	 * @param endDate
	 *            End point (inclusive) of the date range (ie. date closest to
	 *            present).
	 * @return If the startDate is in the future, a one-item {@link List} of
	 *         {@link IMODocBody} Objects will be returned. If endDate is in the
	 *         future the {@link List} will stop at the current (default)
	 *         report.
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public List<IMODocBody> getIMODocBodiesInDateRange(Date startDate,
			Date endDate) throws MalformedURLException, IOException {
		List<IMODocBody> imoDocBodies = new ArrayList<IMODocBody>();

		List<IMODocument> documents = super.getDocumentsInDateRange(
				this.defaultUrlString, this.jaxb2ContextPath, startDate,
				endDate, IMODocument.class);
		for (IMODocument imoDocument : documents) {
			imoDocBodies.add(this.getIMODocBody(imoDocument));
		}

		return imoDocBodies;
	}

	/**
	 * Returns only the {@link IMODocHeader} portion of the {@link IMODocument}.
	 * 
	 * @param imoDocument
	 *            {@link IMODocument} comprised of two parts:
	 *            {@link IMODocHeader} and {@link IMODocBody}.
	 * 
	 * @return {@link IMODocHeader}
	 */
	public IMODocHeader getIMODocHeader(IMODocument imoDocument) {
		List<Object> imoDocHeaderAndImoDocBody = imoDocument
				.getIMODocHeaderAndIMODocBody();
		return super.getDocPart(imoDocHeaderAndImoDocBody, IMODocHeader.class);
	}

	/**
	 * Get a {@link IMODocHeader} for a date in past.
	 * 
	 * @param historyDate
	 *            Date in the past that a report header is being requested for.
	 * @return Returns the {@link IMODocHeader} of a past report.
	 * @throws MalformedURLException
	 * 
	 * @throws IOException
	 */
	public IMODocHeader getIMODocHeaderForDate(Date historyDate)
			throws MalformedURLException, IOException {
		IMODocument imoDocument = super.getDocumentForDate(
				this.defaultUrlString, this.jaxb2ContextPath, historyDate,
				IMODocument.class);
		return this.getIMODocHeader(imoDocument);
	}

	/**
	 * Makes a request for each Date in the provided range (inclusive) building
	 * out a {@link List} of {@link IMODocHeader} Objects.
	 * 
	 * @param startDate
	 *            Start point (inclusive) of the date range (ie. date furthest
	 *            in the past).
	 * @param endDate
	 *            End point (inclusive) of the date range (ie. date closest to
	 *            present).
	 * @return If the startDate is in the future, a one-item {@link List} of
	 *         {@link IMODocHeader} Objects will be returned. If endDate is in
	 *         the future the {@link List} will stop at the current (default)
	 *         report.
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public List<IMODocHeader> getIMODocHeadersInDateRange(Date startDate,
			Date endDate) throws MalformedURLException, IOException {
		List<IMODocHeader> imoDocHeaders = new ArrayList<IMODocHeader>();

		List<IMODocument> imoDocuments = super.getDocumentsInDateRange(
				this.defaultUrlString, this.jaxb2ContextPath, startDate,
				endDate, IMODocument.class);
		for (IMODocument imoDocument : imoDocuments) {
			imoDocHeaders.add(this.getIMODocHeader(imoDocument));
		}

		return imoDocHeaders;
	}

	/**
	 * Unmarshals XML text into a {@link IMODocument} using JAXB2, into the
	 * package name specified by {@link #jaxb2ContextPath}.
	 * 
	 * @param urlString
	 *            The URL that will be unmarshalled into a {@link IMODocument}.
	 * @return {@link IMODocument}
	 * @throws MalformedURLException
	 * @throws IOException
	 * 
	 */
	private IMODocument getIMODocument(String urlString)
			throws MalformedURLException, IOException {
		return super.getDocument(urlString, this.jaxb2ContextPath,
				IMODocument.class);
	}
}
