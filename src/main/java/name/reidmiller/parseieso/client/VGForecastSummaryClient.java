package name.reidmiller.parseieso.client;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

import javax.xml.transform.stream.StreamSource;

import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.XmlMappingException;

import ca.ieso.reports.schema.vgforecastsummary.DocBody;
import ca.ieso.reports.schema.vgforecastsummary.DocHeader;
import ca.ieso.reports.schema.vgforecastsummary.Document;

/**
 * Reads the current "Variable Generation Forecast Summary Report" from
 * Ontario's Independent Electricity System Operator (IESO).
 */
public class VGForecastSummaryClient {
	private URL vgForecastSummaryURL;
	private Marshaller marshaller;
	private Unmarshaller unmarshaller;

	public VGForecastSummaryClient(URL vgForecastSummaryURL,
			Marshaller marshaller, Unmarshaller unmarshaller) {
		this.vgForecastSummaryURL = vgForecastSummaryURL;
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
			InputStream input = this.vgForecastSummaryURL.openStream();
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
		Document document = this.unmarshal();
		List<Object> headerAndBody = document.getDocHeaderAndDocBody();

		DocHeader docHeader = null;
		for (Object part : headerAndBody) {
			if (part instanceof DocHeader) {
				docHeader = (DocHeader) part;
				break;
			}
		}

		return docHeader;
	}

	/**
	 * Calls {@link #unmarshal()} and returns only the {@link DocBody} portion
	 * of the {@link Document}.
	 * 
	 * @return {@link DocBody}
	 */
	public DocBody getDocBody() {
		Document document = this.unmarshal();
		List<Object> headerAndBody = document.getDocHeaderAndDocBody();

		DocBody docBody = null;
		for (Object part : headerAndBody) {
			if (part instanceof DocBody) {
				docBody = (DocBody) part;
				break;
			}
		}

		return docBody;
	}
}
