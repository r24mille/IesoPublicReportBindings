package name.reidmiller.iesoreports.client;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.xml.transform.stream.StreamSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

public class BaseIesoPublicReportClient {
	protected Logger logger = LogManager
			.getLogger(BaseIesoPublicReportClient.class);
	/**
	 * IESO's date format in the past report URLs.
	 */
	public static final DateFormat REPORT_DATE_FORMAT = new SimpleDateFormat(
			"yyyyMMdd");

	/**
	 * Unmarshals XML text into an Document using JAXB2.
	 * 
	 * @param jaxb2ContextPath
	 *            Package name that unmarshalled Objects will use.
	 * @param urlString
	 *            The URL that will be unmarshalled into a Document.
	 * @return {@link Object} Should be cast to the appropriate Document by the
	 *         child class.
	 * @throws MalformedURLException
	 * @throws IOException
	 * @throws ClassCastException
	 */
	protected Object unmarshal(String jaxb2ContextPath, String urlString)
			throws MalformedURLException, IOException, ClassCastException {
		logger.debug("Unmarshalling the URL " + urlString);
		InputStream input = new URL(urlString).openStream();
		StreamSource source = new StreamSource(input);
		return this.buildMarshaller(jaxb2ContextPath).unmarshal(source);
	}

	/**
	 * @param contextPath
	 *            Package name that unmarshalled/marshalled Objects will use.
	 * @return {@link Jaxb2Marshaller} for the package name specified.
	 */
	protected Jaxb2Marshaller buildMarshaller(String contextPath) {
		Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
		jaxb2Marshaller.setContextPath(contextPath);
		return jaxb2Marshaller;
	}

	/**
	 * @param date
	 * @return Date object at 00:00:00.
	 */
	protected Date getDateAtMidnight(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	/**
	 * Using defaultUrlString as a starting point, this method and converts it
	 * to a URL string appropriate to request a past report.
	 * 
	 * @param defaultUrlString
	 *            The default report URL passed in by the client class.
	 * @param historyDate
	 *            Date in the past that a URL string will be created for.
	 * @return String appropriate to request a past report. If the
	 *         defaultUrlString cannot be parsed according to the history date
	 *         format, then the defaultUrlString is returned.
	 */
	protected String historyUrlString(String defaultUrlString, Date historyDate) {
		String historyUrlString = defaultUrlString;

		int extensionIndex = defaultUrlString.lastIndexOf(".xml");
		if (extensionIndex > 0) {
			logger.debug("Injecting " + REPORT_DATE_FORMAT.format(historyDate)
					+ " into default URL " + defaultUrlString);
			historyUrlString = defaultUrlString.substring(0, extensionIndex)
					+ "_" + REPORT_DATE_FORMAT.format(historyDate)
					+ defaultUrlString.substring(extensionIndex);
		} else {
			logger.warn("No index of \".xml\" in " + defaultUrlString
					+ ". Returning defaultUrlString as historyUrlString.");
		}

		return historyUrlString;
	}
}
