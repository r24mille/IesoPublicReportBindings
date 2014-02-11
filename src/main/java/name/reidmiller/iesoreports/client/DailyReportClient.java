package name.reidmiller.iesoreports.client;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
public class DailyReportClient extends BaseReportClient {
	protected Logger logger = LogManager.getLogger(this.getClass());
	/**
	 * IESO's date format in the past report URLs.
	 */
	public static final DateFormat REPORT_DATE_FORMAT = new SimpleDateFormat(
			"yyyyMMdd");

	/**
	 * Get a document for a date in the past.
	 * 
	 * @param historyDate
	 *            Date in the past that a report header is being requested for.
	 * @param documentClazz
	 *            Class of document to return.
	 * @return Returns a document using {@link #historyUrlString(Date)} rather
	 *         than using defaultUrlString for the {@link #getDocument(String)}
	 *         request.
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	protected <T> T getDocumentForDate(Date historyDate, Class<T> documentClazz)
			throws MalformedURLException, IOException {
		String historyUrlString = this.historyUrlString(historyDate);
		return super.getDocument(historyUrlString, documentClazz);
	}

	/**
	 * Makes a request for each Date in the provided range (inclusive) building
	 * out a {@link List} of documents.
	 * 
	 * @param startDate
	 *            Start point (inclusive) of the date range (ie. date furthest
	 *            in the past).
	 * @param endDate
	 *            End point (inclusive) of the date range (ie. date closest to
	 *            present).
	 * @param documentClazz
	 *            Class of document to return.
	 * @return If the startDate is in the future, a one-item {@link List} of
	 *         documents will be returned. If endDate is in the
	 *         future the {@link List} will stop at the current (default)
	 *         report.
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	protected <T> List<T> getDocumentsInDateRange(Date startDate, Date endDate,
			Class<T> documentClazz) throws MalformedURLException, IOException {
		List<T> documents = new ArrayList<T>();

		// Get dates at 00:00:00 for accurate comparison
		Date today = this.getDateAtMidnight(new Date());
		Date endDateCopy = this.getDateAtMidnight(endDate);

		// Step through Dates in range
		Calendar calStep = Calendar.getInstance();
		calStep.setTime(this.getDateAtMidnight(startDate));
		while (calStep.getTime().before(endDateCopy)
				|| calStep.getTime().equals(endDateCopy)) {
			// If the step is greater than or equal to the current Date,
			// add the default report as the last item in the List and stop.
			if (calStep.getTime().equals(today) || calStep.after(today)) {
				documents.add(this.getDocument(super.getDefaultUrlString(),
						documentClazz));
				break;
			} else {
				documents.add(this.getDocumentForDate(calStep.getTime(),
						documentClazz));
			}

			calStep.add(Calendar.DATE, 1);
		}

		return documents;
	}

	/**
	 * Returns a matching date with time set to midnight. This method uses
	 * {@link Calendar} to return a new {@link Date} instance, so this method is
	 * thread-safe.
	 * 
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
	 * @param historyDate
	 *            Date in the past that a URL string will be created for.
	 * @return String appropriate to request a past report. If the
	 *         defaultUrlString cannot be parsed according to the history date
	 *         format, then the defaultUrlString is returned.
	 */
	protected String historyUrlString(Date historyDate) {
		logger.debug("Creating URL for Date=" + historyDate.toString());
		String historyUrlString = super.getDefaultUrlString();

		int extensionIndex = super.getDefaultUrlString().lastIndexOf(".xml");
		if (extensionIndex > 0) {
			logger.debug("Injecting " + REPORT_DATE_FORMAT.format(historyDate)
					+ " into default URL " + super.getDefaultUrlString());
			historyUrlString = super.getDefaultUrlString().substring(0,
					extensionIndex)
					+ "_"
					+ REPORT_DATE_FORMAT.format(historyDate)
					+ super.getDefaultUrlString().substring(extensionIndex);
		} else {
			logger.warn("No index of \".xml\" in " + super.getDefaultUrlString()
					+ ". Returning defaultUrlString as historyUrlString.");
		}

		return historyUrlString;
	}
}
