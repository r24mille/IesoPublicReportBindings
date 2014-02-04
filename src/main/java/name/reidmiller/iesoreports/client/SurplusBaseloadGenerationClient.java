package name.reidmiller.iesoreports.client;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.xml.transform.stream.StreamSource;

import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.XmlMappingException;

import ca.ieso.reports.schema.sbg.DocHeader;
import ca.ieso.reports.schema.sbg.Document;
import ca.ieso.reports.schema.sbg.Document.DocBody;

public class SurplusBaseloadGenerationClient {
	private SimpleDateFormat sbgDateFormat;
	private String urlBase;
	private String urlTail;
	private Date urlDate;
	private Marshaller marshaller;
	private Unmarshaller unmarshaller;

	public SurplusBaseloadGenerationClient(SimpleDateFormat sbgDateFormat,
			Date urlDate, String urlBase, String urlTail,
			Marshaller marshaller, Unmarshaller unmarshaller) {
		this.sbgDateFormat = sbgDateFormat;
		this.urlDate = urlDate;
		this.urlBase = urlBase;
		this.urlTail = urlTail;
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
			InputStream input = this.getURL().openStream();
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
	 * Calls {@link #unmarshal()} and returns only the {@link DocBody} portion
	 * of the {@link Document}.
	 * 
	 * @return {@link DocBody}
	 */
	public DocBody getDocBody() {
		Document Document = this.unmarshal();
		List<Object> docHeaderAndDocBody = Document.getDocHeaderAndDocBody();

		DocBody docBody = null;
		for (Object part : docHeaderAndDocBody) {
			if (part instanceof DocBody) {
				docBody = (DocBody) part;
				break;
			}
		}

		return docBody;
	}

	/**
	 * <p>
	 * URL is dynamically generated using urlBase, urlDate formatted with
	 * sbgDateFormat, and urlTail (eg.
	 * http://www.ieso.ca/weather/mkt4/sbg/PUB_SurplusBaseloadGen_20140201_v1
	 * .xml).
	 * </p>
	 * <p>
	 * To change the URL returned call {@link #setUrlDate(Date)} to return the
	 * data for other dates.
	 * </p>
	 * 
	 * @return dynamically generated URL
	 */
	public URL getURL() {
		String urlString = this.urlBase + sbgDateFormat.format(this.urlDate)
				+ this.urlTail;
		URL url = null;
		try {
			url = new URL(urlString);
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return url;
	}

	public SimpleDateFormat getSbgDateFormat() {
		return sbgDateFormat;
	}

	public void setSbgDateFormat(SimpleDateFormat sbgDateFormat) {
		this.sbgDateFormat = sbgDateFormat;
	}

	public String getUrlBase() {
		return urlBase;
	}

	public void setUrlBase(String urlBase) {
		this.urlBase = urlBase;
	}

	public String getUrlTail() {
		return urlTail;
	}

	public void setUrlTail(String urlTail) {
		this.urlTail = urlTail;
	}

	public Date getUrlDate() {
		return urlDate;
	}

	public void setUrlDate(Date urlDate) {
		this.urlDate = urlDate;
	}

}
