package name.reidmiller.iesoreports.client;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ca.ieso.reports.schema.genoutputcapability.IMODocBody;
import ca.ieso.reports.schema.genoutputcapability.IMODocBody.Generators.Generator;
import ca.ieso.reports.schema.genoutputcapability.IMODocBody.Generators.Generator.Outputs.Output;
import ca.ieso.reports.schema.genoutputcapability.IMODocHeader;
import ca.ieso.reports.schema.genoutputcapability.IMODocument;

public class GeneratorOutputCapabilityClient extends DailyReportClient {
	private Logger logger = LogManager.getLogger(this.getClass());
	public static SimpleDateFormat FUEL_TYPE_TOTALS_TIMESTAMP_FORMAT = new SimpleDateFormat(
			"yyyy-MM-dd H:mm:ss");

	public GeneratorOutputCapabilityClient(String defaultUrlString,
			String jaxb2ContextPath) {
		super.setDefaultUrlString(defaultUrlString);
		super.setJaxb2ContextPath(jaxb2ContextPath);
	}

	/**
	 * Unmarshals XML text from {@link #defaultUrlString} into a
	 * {@link IMODocument} using JAXB2. This method is a wrapper around
	 * {@link #getIMODocument(String)}.
	 * 
	 * @return {@link IMODocument}
	 * @throws MalformedURLException
	 * @throws IOException
	 * 
	 */
	public IMODocument getDefaultIMODocument() throws MalformedURLException,
			IOException, ClassCastException {
		return this.getIMODocument(super.getDefaultUrlString());
	}

	/**
	 * This method uses {@link #defaultUrlString} to request the current
	 * (default) {@link IMODocBody}.
	 * 
	 * @return {@link IMODocBody} for the current (default) report.
	 * @throws MalformedURLException
	 * 
	 * @throws IOException
	 */
	public IMODocBody getDefaultIMODocBody() throws MalformedURLException,
			IOException {
		IMODocument imoDocument = this.getDefaultIMODocument();
		return this.getIMODocBody(imoDocument);
	}

	/**
	 * This method uses {@link #defaultUrlString} to request the current
	 * (default) {@link IMODocHeader}.
	 * 
	 * @return {@link IMODocHeader} for the current (default) report.
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public IMODocHeader getDefaultIMODocHeader() throws MalformedURLException,
			IOException {
		IMODocument imoDocument = this.getDefaultIMODocument();
		return this.getIMODocHeader(imoDocument);
	}

	/**
	 * Returns only the {@link IMODocBody} portion of the {@link IMODocument}.
	 * 
	 * @param imoDocument
	 *            {@link IMODocument} comprised of two parts:
	 *            {@link IMODocHeader} and {@link IMODocBody}.
	 * @return {@link IMODocBody}
	 */
	public IMODocBody getIMODocBody(IMODocument imoDocument) {
		List<Object> imoDocHeaderAndImoDocBody = imoDocument
				.getIMODocHeaderAndIMODocBody();
		return super.getDocPart(imoDocHeaderAndImoDocBody, IMODocBody.class);
	}

	/**
	 * Get a {@link IMODocBody} for a date in past.
	 * 
	 * @param historyDate
	 *            Date in the past that a report is being requested for.
	 * @return Returns the {@link IMODocBody} of a past report.
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public IMODocBody getIMODocBodyForDate(Date historyDate)
			throws MalformedURLException, IOException {
		IMODocument imoDocument = super.getDocumentForDate(historyDate,
				IMODocument.class);
		return this.getIMODocBody(imoDocument);
	}

	/**
	 * Makes a request for each Date in the provided range (inclusive) building
	 * out a {@link List} of {@link IMODocBody} objects.
	 * 
	 * @param startDate
	 *            Start point (inclusive) of the date range (ie. date furthest
	 *            in the past).
	 * @param endDate
	 *            End point (inclusive) of the date range (ie. date closest to
	 *            present).
	 * @return If the startDate is in the future, a one-item {@link List} of
	 *         {@link IMODocBody} Objects will be returned. If endDate is in the
	 *         future the {@link List} will stop at the current (default)
	 *         report.
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public List<IMODocBody> getIMODocBodiesInDateRange(Date startDate,
			Date endDate) throws MalformedURLException, IOException {
		List<IMODocBody> imoDocBodies = new ArrayList<IMODocBody>();

		List<IMODocument> documents = super.getDocumentsInDateRange(startDate,
				endDate, IMODocument.class);
		for (IMODocument imoDocument : documents) {
			imoDocBodies.add(this.getIMODocBody(imoDocument));
		}

		return imoDocBodies;
	}

	/**
	 * Returns only the {@link IMODocHeader} portion of the {@link IMODocument}.
	 * 
	 * @param imoDocument
	 *            {@link IMODocument} comprised of two parts:
	 *            {@link IMODocHeader} and {@link IMODocBody}.
	 * 
	 * @return {@link IMODocHeader}
	 */
	public IMODocHeader getIMODocHeader(IMODocument imoDocument) {
		List<Object> imoDocHeaderAndImoDocBody = imoDocument
				.getIMODocHeaderAndIMODocBody();
		return super.getDocPart(imoDocHeaderAndImoDocBody, IMODocHeader.class);
	}

	/**
	 * Get a {@link IMODocHeader} for a date in past.
	 * 
	 * @param historyDate
	 *            Date in the past that a report header is being requested for.
	 * @return Returns the {@link IMODocHeader} of a past report.
	 * @throws MalformedURLException
	 * 
	 * @throws IOException
	 */
	public IMODocHeader getIMODocHeaderForDate(Date historyDate)
			throws MalformedURLException, IOException {
		IMODocument imoDocument = super.getDocumentForDate(historyDate,
				IMODocument.class);
		return this.getIMODocHeader(imoDocument);
	}

	/**
	 * Makes a request for each Date in the provided range (inclusive) building
	 * out a {@link List} of {@link IMODocHeader} Objects.
	 * 
	 * @param startDate
	 *            Start point (inclusive) of the date range (ie. date furthest
	 *            in the past).
	 * @param endDate
	 *            End point (inclusive) of the date range (ie. date closest to
	 *            present).
	 * @return If the startDate is in the future, a one-item {@link List} of
	 *         {@link IMODocHeader} Objects will be returned. If endDate is in
	 *         the future the {@link List} will stop at the current (default)
	 *         report.
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public List<IMODocHeader> getIMODocHeadersInDateRange(Date startDate,
			Date endDate) throws MalformedURLException, IOException {
		List<IMODocHeader> imoDocHeaders = new ArrayList<IMODocHeader>();

		List<IMODocument> imoDocuments = super.getDocumentsInDateRange(
				startDate, endDate, IMODocument.class);
		for (IMODocument imoDocument : imoDocuments) {
			imoDocHeaders.add(this.getIMODocHeader(imoDocument));
		}

		return imoDocHeaders;
	}

	/**
	 * Unmarshals XML text into a {@link IMODocument} using JAXB2, into the
	 * package name specified by {@link #jaxb2ContextPath}.
	 * 
	 * @param urlString
	 *            The URL that will be unmarshalled into a {@link IMODocument}.
	 * @return {@link IMODocument}
	 * @throws MalformedURLException
	 * @throws IOException
	 * 
	 */
	private IMODocument getIMODocument(String urlString)
			throws MalformedURLException, IOException {
		return super.getDocument(urlString, IMODocument.class);
	}

	/**
	 * All possible values from {@link Generator#getFuelType()}.
	 */
	static enum FuelType {
		COAL, GAS, HYDRO, NUCLEAR, OTHER, WIND;
	}

	/**
	 * <p>
	 * Iterates over the {@link Generator} objects in the {@link IMODocBody} and
	 * tabulates the total MW output by {@link FuelType} for each hour.
	 * </p>
	 * 
	 * @param imoDocBody
	 * @return A {@link HashMap} keyed by {@link FuelType} and the value is a
	 *         {@link LinkedHashMap} of timestamp:total for that
	 *         {@link FuelType}.
	 */
	public HashMap<FuelType, LinkedHashMap<String, Float>> getHourlyFuelTypeTotals(
			IMODocBody imoDocBody) {
		List<IMODocBody> imoDocBodies = new ArrayList<IMODocBody>(1);
		imoDocBodies.add(imoDocBody);
		return this.getHourlyFuelTypeTotals(imoDocBodies);
	}

	/**
	 * Iterates over a list of {@link IMODocBody} objects and tabulates the
	 * total MW output by {@link FuelType} for each hour.
	 * 
	 * @param imoDocBodies
	 * @return A {@link HashMap} keyed by {@link FuelType} and the value is a
	 *         {@link LinkedHashMap} of timestamp:total for that
	 *         {@link FuelType}.
	 */
	public HashMap<FuelType, LinkedHashMap<String, Float>> getHourlyFuelTypeTotals(
			List<IMODocBody> imoDocBodies) {
		int fuelHourMapInitCapacity = imoDocBodies.size() * 24;

		// Initial HashMap by FuelType without any timestamp:total values
		HashMap<FuelType, LinkedHashMap<String, Float>> fuelTypeMap = new HashMap<FuelType, LinkedHashMap<String, Float>>(
				6);
		fuelTypeMap.put(FuelType.COAL, new LinkedHashMap<String, Float>(
				fuelHourMapInitCapacity));
		fuelTypeMap.put(FuelType.GAS, new LinkedHashMap<String, Float>(
				fuelHourMapInitCapacity));
		fuelTypeMap.put(FuelType.HYDRO, new LinkedHashMap<String, Float>(
				fuelHourMapInitCapacity));
		fuelTypeMap.put(FuelType.NUCLEAR, new LinkedHashMap<String, Float>(
				fuelHourMapInitCapacity));
		fuelTypeMap.put(FuelType.OTHER, new LinkedHashMap<String, Float>(
				fuelHourMapInitCapacity));
		fuelTypeMap.put(FuelType.WIND, new LinkedHashMap<String, Float>(
				fuelHourMapInitCapacity));

		// Iterate over each imoDocBody in the list (ie. a day)
		for (IMODocBody imoDocBody : imoDocBodies) {
			List<Generator> generators = imoDocBody.getGenerators()
					.getGenerator();

			for (Generator generator : generators) {
				for (Output hourlyOutput : generator.getOutputs().getOutput()) {
					int clockHour = hourlyOutput.getHour() - 1;
					String timeString = imoDocBody.getDate().toString() + " "
							+ clockHour + ":00:00";

					LinkedHashMap<String, Float> fuelHourMap = fuelTypeMap
							.get(generator.getFuelType());
					if (fuelHourMap.keySet().contains(timeString)) {
						float fuelHourVal = fuelHourMap.get(timeString);
						logger.debug("generatorName="
								+ generator.getGeneratorName());
						logger.debug("fuelHourVal=" + fuelHourVal);
						logger.debug("hourlyOutput=" + hourlyOutput);
						logger.debug("energyMW=" + hourlyOutput.getEnergyMW());
						if (hourlyOutput.getEnergyMW() != null) {
							fuelHourVal = fuelHourVal
									+ hourlyOutput.getEnergyMW();
						}
						fuelHourMap.put(timeString, fuelHourVal);
						fuelTypeMap.put(
								FuelType.valueOf(generator.getFuelType()),
								fuelHourMap);
					} else {
						fuelHourMap.put(timeString, hourlyOutput.getEnergyMW());
						fuelTypeMap.put(
								FuelType.valueOf(generator.getFuelType()),
								fuelHourMap);
					}
				}
			}
		}

		return fuelTypeMap;
	}
}
