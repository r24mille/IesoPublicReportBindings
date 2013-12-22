package name.reidmiller.parseieso.client;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

import javax.xml.transform.stream.StreamSource;

import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.XmlMappingException;

import ca.ieso.reports.schema.dispareaopresandenergycalled.DocBody;
import ca.ieso.reports.schema.dispareaopresandenergycalled.DocHeader;
import ca.ieso.reports.schema.dispareaopresandenergycalled.Document;

public class DispatchAreaOperatingReserveTotalScheduledAndTotalEnergyCalledClient {
	private URL url;
	private Marshaller marshaller;
	private Unmarshaller unmarshaller;

	public DispatchAreaOperatingReserveTotalScheduledAndTotalEnergyCalledClient(
			URL url, Marshaller marshaller, Unmarshaller unmarshaller) {
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
		List<Object> imoHeaderAndBody = Document.getDocHeaderAndDocBody();

		DocHeader DocHeader = null;
		for (Object imoPart : imoHeaderAndBody) {
			if (imoPart instanceof DocHeader) {
				DocHeader = (DocHeader) imoPart;
				break;
			}
		}

		return DocHeader;
	}

	/**
	 * Calls {@link #unmarshal()} and returns only the {@link DocBody} portion
	 * of the {@link Document}.
	 * 
	 * @return {@link DocBody}
	 */
	public DocBody getDocBody() {
		Document Document = this.unmarshal();
		List<Object> imoHeaderAndBody = Document.getDocHeaderAndDocBody();

		DocBody DocBody = null;
		for (Object imoPart : imoHeaderAndBody) {
			if (imoPart instanceof DocBody) {
				DocBody = (DocBody) imoPart;
				break;
			}
		}

		return DocBody;
	}
}
