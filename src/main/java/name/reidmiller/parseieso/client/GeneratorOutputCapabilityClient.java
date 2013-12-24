package name.reidmiller.parseieso.client;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

import javax.xml.transform.stream.StreamSource;

import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.XmlMappingException;

import ca.ieso.reports.schema.genoutputcapability.IMODocBody;
import ca.ieso.reports.schema.genoutputcapability.IMODocHeader;
import ca.ieso.reports.schema.genoutputcapability.IMODocument;

public class GeneratorOutputCapabilityClient {
	private URL genOutputCapabilityURL;
	private Marshaller marshaller;
	private Unmarshaller unmarshaller;

	public GeneratorOutputCapabilityClient(URL genOutputCapabilityURL,
			Marshaller marshaller, Unmarshaller unmarshaller) {
		this.genOutputCapabilityURL = genOutputCapabilityURL;
		this.marshaller = marshaller;
		this.unmarshaller = unmarshaller;
	}

	/**
	 * Unmarshals the XML text into an {@link IMODocument} using JAXB2.
	 * 
	 * @return {@link IMODocument}
	 * @throws ClassCastException
	 */
	public IMODocument unmarshal() throws ClassCastException {
		Object unmarshalledObj = null;

		try {
			InputStream input = this.genOutputCapabilityURL.openStream();
			StreamSource source = new StreamSource(input);
			unmarshalledObj = this.unmarshaller.unmarshal(source);
		} catch (XmlMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (unmarshalledObj instanceof IMODocument) {
			return (IMODocument) unmarshalledObj;
		} else {
			throw new ClassCastException();
		}
	}

	/**
	 * Calls {@link #unmarshal()} and returns only the {@link IMODocHeader}
	 * portion of the {@link IMODocument}.
	 * 
	 * @return {@link IMODocHeader}
	 */
	public IMODocHeader getIMODocHeader() {
		IMODocument imoDocument = this.unmarshal();
		List<Object> imoDocHeaderAndDocBody = imoDocument
				.getIMODocHeaderAndIMODocBody();

		IMODocHeader imoDocHeader = null;
		for (Object imoPart : imoDocHeaderAndDocBody) {
			if (imoPart instanceof IMODocHeader) {
				imoDocHeader = (IMODocHeader) imoPart;
				break;
			}
		}

		return imoDocHeader;
	}

	/**
	 * Calls {@link #unmarshal()} and returns only the {@link IMODocBody}
	 * portion of the {@link IMODocument}.
	 * 
	 * @return {@link IMODocBody}
	 */
	public IMODocBody getIMODocBody() {
		IMODocument imoDocument = this.unmarshal();
		List<Object> imoDocHeaderAndDocBody = imoDocument
				.getIMODocHeaderAndIMODocBody();

		IMODocBody imoDocBody = null;
		for (Object imoPart : imoDocHeaderAndDocBody) {
			if (imoPart instanceof IMODocBody) {
				imoDocBody = (IMODocBody) imoPart;
				break;
			}
		}

		return imoDocBody;
	}
}
