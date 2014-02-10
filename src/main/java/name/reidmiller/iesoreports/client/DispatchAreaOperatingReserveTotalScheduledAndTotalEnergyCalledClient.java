package name.reidmiller.iesoreports.client;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ca.ieso.reports.schema.dispareaopresandenergycalled.DocBody;
import ca.ieso.reports.schema.dispareaopresandenergycalled.DocHeader;
import ca.ieso.reports.schema.dispareaopresandenergycalled.Document;

public class DispatchAreaOperatingReserveTotalScheduledAndTotalEnergyCalledClient
		extends BaseReportClient {
	private Logger logger = LogManager.getLogger(this.getClass());

	public DispatchAreaOperatingReserveTotalScheduledAndTotalEnergyCalledClient(
			String defaultUrlString, String jaxb2ContextPath) {
		super.setDefaultUrlString(defaultUrlString);
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
}
