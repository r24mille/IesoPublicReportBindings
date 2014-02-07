package name.reidmiller.iesoreports.client;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

public class IesoPublicReportClientUtil {
	protected static Logger logger = LogManager
			.getLogger(IesoPublicReportClientUtil.class);
	/**
	 * IESO's date format in the past report URLs.
	 */
	public static final DateFormat REPORT_DATE_FORMAT = new SimpleDateFormat(
			"yyyyMMdd");

	/**
	 * @param contextPath
	 *            Package name that unmarshalled/marshalled Objects will use.
	 * @return {@link Jaxb2Marshaller} for the package name specified.
	 */
	public static Jaxb2Marshaller buildMarshaller(String contextPath) {
		Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
		jaxb2Marshaller.setContextPath(contextPath);
		return jaxb2Marshaller;
	}

	/**
	 * @param date
	 * @return Date object at 00:00:00.
	 */
	public static Date getDateAtMidnight(Date date) {
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
	public static String historyUrlString(String defaultUrlString,
			Date historyDate) {
		String historyUrlString = defaultUrlString;

		int extensionIndex = defaultUrlString.lastIndexOf(".xml");
		if (extensionIndex > 0) {
			historyUrlString = defaultUrlString.substring(0, extensionIndex)
					+ "_"
					+ IesoPublicReportClientUtil.REPORT_DATE_FORMAT
							.format(historyDate)
					+ defaultUrlString.substring(extensionIndex);
		} else {
			logger.warn("No index of \".xml\" in " + defaultUrlString
					+ ". Returning defaultUrlString as historyUrlString.");
		}

		return historyUrlString;
	}
}
