package name.reidmiller.iesoreports.client;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

import javax.xml.transform.stream.StreamSource;

import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.XmlMappingException;

import ca.ieso.reports.schema.trapreauctionttcst.DocHeader;
import ca.ieso.reports.schema.trapreauctionttcst.Document;

public class PreAuctionTransmissionTransferCapabilityStClient {
	private URL url;
	private Marshaller marshaller;
	private Unmarshaller unmarshaller;

	public PreAuctionTransmissionTransferCapabilityStClient(URL url, Marshaller marshaller,
			Unmarshaller unmarshaller) {
		this.url = url;
		this.marshaller = marshaller;
		this.unmarshaller = unmarshaller;
	}

	/**
	 * Unmarshals the XML text into an {@link Document} using JAXB2.
	 * 
	 * @return {@link Document}
	 * @throws ClassCastException
	 */
	public Document unmarshal() throws ClassCastException {
		Object unmarshalledObj = null;

		try {
			InputStream input = this.url.openStream();
			StreamSource source = new StreamSource(input);
			unmarshalledObj = this.unmarshaller.unmarshal(source);
		} catch (XmlMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
	public DocHeader getDocHeader() {
		Document Document = this.unmarshal();
		List<Object> docHeaderAndDocBody = Document.getDocHeaderAndDocBody();

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
	 * Calls {@link #unmarshal()} and returns only the {@link Document.DocBody} portion
	 * of the {@link Document}.
	 * 
	 * @return {@link Document.DocBody}
	 */
	public Document.DocBody getDocBody() {
		Document Document = this.unmarshal();
		List<Object> docHeaderAndDocBody = Document.getDocHeaderAndDocBody();

		Document.DocBody docBody = null;
		for (Object part : docHeaderAndDocBody) {
			if (part instanceof Document.DocBody) {
				docBody = (Document.DocBody) part;
				break;
			}
		}

		return docBody;
	}
}
