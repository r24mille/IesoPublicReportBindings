package name.reidmiller.iesoreports.client;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.xml.transform.stream.StreamSource;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import ca.ieso.reports.schema.adequacy.DocBody;
import ca.ieso.reports.schema.adequacy.DocHeader;
import ca.ieso.reports.schema.adequacy.Document;

public class AdequacyClient {
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
}
