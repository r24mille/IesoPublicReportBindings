package name.reidmiller.iesoreports.client;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.xml.transform.stream.StreamSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

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
	protected Logger logger = LogManager.getLogger(this.getClass());
	private String defaultUrlString;
	private String jaxb2ContextPath;

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
	 * Unmarshals XML text into an document object using JAXB2.
	 * 
	 * @param urlString
	 *            The URL to an XML report.
	 * @param documentClazz
	 *            Class of document to return.
	 * @return Report document.
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	protected <T> T getDocument(String urlString, Class<T> documentClazz)
			throws MalformedURLException, IOException {
		T document = null;
		logger.debug("Unmarshalling the URL " + urlString);
		InputStream input = new URL(urlString).openStream();
		StreamSource source = new StreamSource(input);
		Jaxb2Marshaller marshaller = this
				.buildMarshaller(this.jaxb2ContextPath);
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
	protected Jaxb2Marshaller buildMarshaller(String contextPath) {
		Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
		jaxb2Marshaller.setContextPath(contextPath);
		return jaxb2Marshaller;
	}

	public String getDefaultUrlString() {
		return defaultUrlString;
	}

	public void setDefaultUrlString(String defaultUrlString) {
		this.defaultUrlString = defaultUrlString;
	}

	public String getJaxb2ContextPath() {
		return jaxb2ContextPath;
	}

	public void setJaxb2ContextPath(String jaxb2ContextPath) {
		this.jaxb2ContextPath = jaxb2ContextPath;
	}
}
