package name.reidmiller.iesoreports;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;

import name.reidmiller.iesoreports.client.AdequacyClient;
import name.reidmiller.iesoreports.client.BaseReportClient;
import name.reidmiller.iesoreports.client.DayAheadAdequacyClient;
import name.reidmiller.iesoreports.client.DayAheadAreaOperatingReserveShortfallClient;
import name.reidmiller.iesoreports.client.DayAheadAreaReserveConstraintsClient;
import name.reidmiller.iesoreports.client.DayAheadConstrainedTotalsClient;
import name.reidmiller.iesoreports.client.DayAheadIntertieSchedulingLimitsClient;
import name.reidmiller.iesoreports.client.DayAheadSecurityConstraintsClient;
import name.reidmiller.iesoreports.client.DayAheadShadowPricesClient;
import name.reidmiller.iesoreports.client.DispatchAreaOperatingReserveShortfallsClient;
import name.reidmiller.iesoreports.client.DispatchAreaOperatingReserveTotalScheduledAndTotalEnergyCalledClient;
import name.reidmiller.iesoreports.client.DispatchSecurityConstraintsClient;
import name.reidmiller.iesoreports.client.GeneratorOutputCapabilityClient;
import name.reidmiller.iesoreports.client.GlobalAdjustmentRatesClient;
import name.reidmiller.iesoreports.client.HistoricalTransmissionOutagesClient;
import name.reidmiller.iesoreports.client.HourlyOntarioEnergyPriceReportClient;
import name.reidmiller.iesoreports.client.HourlyUpliftAndIntertieOfferGuaranteeEstimatesClient;
import name.reidmiller.iesoreports.client.IntertieScheduleAndFlowClient;
import name.reidmiller.iesoreports.client.NetInterchangeSchedulingLimitClient;
import name.reidmiller.iesoreports.client.PlannedTransmissionOutagesDayClient;
import name.reidmiller.iesoreports.client.PlannedTransmissionOutagesMonthClient;
import name.reidmiller.iesoreports.client.PlannedTransmissionOutagesSixMonthsClient;
import name.reidmiller.iesoreports.client.PreAuctionMcpLtClient;
import name.reidmiller.iesoreports.client.PreAuctionMcpStClient;
import name.reidmiller.iesoreports.client.PreAuctionTransmissionTransferCapabilityLtClient;
import name.reidmiller.iesoreports.client.PreAuctionTransmissionTransferCapabilityStClient;
import name.reidmiller.iesoreports.client.PredispatchAreaOperatingReserveShortfallsClient;
import name.reidmiller.iesoreports.client.PredispatchAreaReserveConstraintsClient;
import name.reidmiller.iesoreports.client.PredispatchConstrainedTotalsClient;
import name.reidmiller.iesoreports.client.PredispatchIntertieSchedulingLimitsClient;
import name.reidmiller.iesoreports.client.PredispatchMarketPriceClient;
import name.reidmiller.iesoreports.client.PredispatchMarketTotalsClient;
import name.reidmiller.iesoreports.client.PredispatchSecurityConstraintsClient;
import name.reidmiller.iesoreports.client.PredispatchShadowPricesClient;
import name.reidmiller.iesoreports.client.RealtimeAreaReserveConstraintsClient;
import name.reidmiller.iesoreports.client.RealtimeConstrainedTotalsClient;
import name.reidmiller.iesoreports.client.RealtimeIntertieSchedulingLimitsClient;
import name.reidmiller.iesoreports.client.RealtimeMarketPriceClient;
import name.reidmiller.iesoreports.client.RealtimeMarketTotalsClient;
import name.reidmiller.iesoreports.client.RealtimeOperatingReserveInMarketClient;
import name.reidmiller.iesoreports.client.RealtimeShadowPricesClient;
import name.reidmiller.iesoreports.client.SurplusBaseloadGenerationClient;
import name.reidmiller.iesoreports.client.TrHistoricalInterfaceMonthlyClient;
import name.reidmiller.iesoreports.client.TrHourlyZonalPriceMonthlyClient;
import name.reidmiller.iesoreports.client.TraPostAuctionMcpLtRoundOneClient;
import name.reidmiller.iesoreports.client.TraPostAuctionMcpLtRoundTwoClient;
import name.reidmiller.iesoreports.client.TraPostAuctionMcpStRoundOneClient;
import name.reidmiller.iesoreports.client.VariableGenerationForecastSummaryClient;
import name.reidmiller.iesoreports.client.VariableGenerationTieBreakingRankingsClient;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IesoPublicReportBindingsConfig {
	static Logger logger = LogManager
			.getLogger(IesoPublicReportBindingsConfig.class.getName());

	/**
	 * Adequacy
	 * 
	 * @return
	 */
	@Bean
	public static AdequacyClient adequacyClient() {
		return new AdequacyClient(
				"http://reports.ieso.ca/public/Adequacy/PUB_Adequacy.xml",
				"ca.ieso.reports.schema.adequacy");
	}

	/**
	 * Day-Ahead Adequacy
	 * 
	 * @return
	 */
	@Bean
	public static DayAheadAdequacyClient dayAheadAdequacyClient() {
		return new DayAheadAdequacyClient(
				"http://reports.ieso.ca/public/DAAdequacy/PUB_DAAdequacy.xml",
				"ca.ieso.reports.schema.daadequacy");
	}

	/**
	 * Day-Ahead Area Operating Reserve Shortfall
	 * 
	 * @return
	 */
	@Bean
	public static DayAheadAreaOperatingReserveShortfallClient dayAheadAreaOperatingReserveShortfallClient() {
		return new DayAheadAreaOperatingReserveShortfallClient(
				"http://reports.ieso.ca/public/DAAreaOpResShortfall/PUB_DAAreaOpResShortfall.xml",
				"ca.ieso.reports.schema.daareaopresshortfall");
	}

	/**
	 * Day-Ahead Area Reserve Constraints
	 * 
	 * @return
	 */
	@Bean
	public static DayAheadAreaReserveConstraintsClient dayAheadAreaReserveConstraintsClient() {
		return new DayAheadAreaReserveConstraintsClient(
				"http://reports.ieso.ca/public/DAAreaReserveConst/PUB_DAAreaReserveConst.xml",
				"ca.ieso.reports.schema.daareareserveconst");
	}

	/**
	 * Day-Ahead Constrained Totals
	 * 
	 * @return
	 */
	@Bean
	public static DayAheadConstrainedTotalsClient dayAheadConstrainedTotalsClient() {
		return new DayAheadConstrainedTotalsClient(
				"http://reports.ieso.ca/public/DAConstTotals/PUB_DAConstTotals.xml",
				"ca.ieso.reports.schema.daconsttotals");
	}

	/**
	 * Day-Ahead Intertie Scheduling Limits
	 * 
	 * @return
	 */
	@Bean
	public static DayAheadIntertieSchedulingLimitsClient dayAheadIntertieSchedulingLimitsClient() {
		return new DayAheadIntertieSchedulingLimitsClient(
				"http://reports.ieso.ca/public/DAIntertieSchedLimits/PUB_DAIntertieSchedLimits.xml",
				"ca.ieso.reports.schema.daintertieschedlimits");
	}

	/**
	 * Day-Ahead Security Constraints
	 * 
	 * @return
	 */
	@Bean
	public static DayAheadSecurityConstraintsClient dayAheadSecurityConstraintsClient() {
		return new DayAheadSecurityConstraintsClient(
				"http://reports.ieso.ca/public/DASecurityConstraints/PUB_DASecurityConstraints.xml",
				"ca.ieso.reports.schema.dasecurityconstraints");
	}

	/**
	 * Day-Ahead Shadow Prices
	 * 
	 * @return
	 */
	@Bean
	public static DayAheadShadowPricesClient dayAheadShadowPricesClient() {
		return new DayAheadShadowPricesClient(
				"http://reports.ieso.ca/public/DAShadowPrices/PUB_DAShadowPrices.xml",
				"ca.ieso.reports.schema.dashadowprices");
	}

	/**
	 * Dispatch Area Operating Reserve: Total Scheduled and Total Energy Called
	 * 
	 * @return
	 */
	@Bean
	public static DispatchAreaOperatingReserveTotalScheduledAndTotalEnergyCalledClient dispatchAreaOperatingReserveTotalScheduledAndTotalEnergyCalledClient() {
		return new DispatchAreaOperatingReserveTotalScheduledAndTotalEnergyCalledClient(
				"http://reports.ieso.ca/public/DispAreaOpResAndEnergyCalled/PUB_DispAreaOpResAndEnergyCalled.xml",
				"ca.ieso.reports.schema.dispareaopresandenergycalled");
	}

	/**
	 * Dispatch Area Operating Reserve Shortfalls
	 * 
	 * @return
	 */
	@Bean
	public static DispatchAreaOperatingReserveShortfallsClient dispatchAreaOperatingReserveShortfallsClient() {
		return new DispatchAreaOperatingReserveShortfallsClient(
				"http://reports.ieso.ca/public/DispAreaOpResShortfalls/PUB_DispAreaOpResShortfalls.xml",
				"ca.ieso.reports.schema.dispareaopresshortfalls");
	}

	/**
	 * Dispatch Security Constraints
	 * 
	 * @return
	 */
	@Bean
	public static DispatchSecurityConstraintsClient dispatchSecurityConstraintsClient() {
		return new DispatchSecurityConstraintsClient(
				"http://reports.ieso.ca/public/DispSecurityConstraints/PUB_DispSecurityConstraints.xml",
				"ca.ieso.reports.schema.dispsecurityconstraints");
	}

	/**
	 * Hourly Ontario Energy Price (HOEP) Report
	 * 
	 * @return
	 */
	@Bean
	public static HourlyOntarioEnergyPriceReportClient hourlyOntarioEnergyPriceReportClient() {
		return new HourlyOntarioEnergyPriceReportClient(
				"http://reports.ieso.ca/public/DispUnconsHOEP/PUB_DispUnconsHOEP.xml",
				"ca.ieso.reports.schema.dispunconshoep");
	}

	/**
	 * Generator Output Capability
	 * 
	 * @return
	 */
	@Bean
	public static GeneratorOutputCapabilityClient generatorOutputCapabilityClient() {
		return new GeneratorOutputCapabilityClient(
				"http://reports.ieso.ca/public/GenOutputCapability/PUB_GenOutputCapability.xml",
				"ca.ieso.reports.schema.genoutputcapability");
	}

	/**
	 * IESO Global Adjustment Class B Rates
	 * 
	 * @return
	 */
	@Bean
	public static GlobalAdjustmentRatesClient globalAdjustmentRatesClient() {
		return new GlobalAdjustmentRatesClient(
				"http://reports.ieso.ca/public/GlobalAdjustment/PUB_GlobalAdjustment.xml",
				"ca.ieso.reports.schema.globaladjustment");
	}

	/**
	 * Historical Transmission Outages
	 * 
	 * @return
	 */
	@Bean
	public static HistoricalTransmissionOutagesClient historicalTransmissionOutagesClient() {
		return new HistoricalTransmissionOutagesClient(
				"http://reports.ieso.ca/public/IOMSPublicHistoricOutageHour/PUB_IOMSPublicHistoricOutageHour.xml",
				"ca.ieso.reports.schema.iomspublichistoricoutagehour");
	}

	/**
	 * Planned Transmission Outages (Day)
	 * 
	 * @return
	 */
	@Bean
	public static PlannedTransmissionOutagesDayClient plannedTransmissionOutagesDayClient() {
		return new PlannedTransmissionOutagesDayClient(
				"http://reports.ieso.ca/public/IOMSPublicPlannedOutageDay/PUB_IOMSPublicPlannedOutageDay.xml",
				"ca.ieso.reports.schema.iomspublicplannedoutageday");
	}

	/**
	 * Planned Transmission Outages (Month)
	 * 
	 * @return
	 */
	@Bean
	public static PlannedTransmissionOutagesMonthClient plannedTransmissionOutagesMonthClient() {
		return new PlannedTransmissionOutagesMonthClient(
				"http://reports.ieso.ca/public/IOMSPublicPlannedOutageMonth/PUB_IOMSPublicPlannedOutageMonth.xml",
				"ca.ieso.reports.schema.iomspublicplanneodutagemonth");
	}

	/**
	 * Planned Transmission Outages (Six Months)
	 * 
	 * @return
	 */
	@Bean
	public static PlannedTransmissionOutagesSixMonthsClient plannedTransmissionOutagesSixMonthsClient() {
		return new PlannedTransmissionOutagesSixMonthsClient(
				"http://reports.ieso.ca/public/IOMSPublicPlannedOutageSixMonths/PUB_IOMSPublicPlannedOutageSixMonths.xml",
				"ca.ieso.reports.schema.iomspublicplannedoutagesixmonths");
	}

	/**
	 * Intertie Schedule and Flow Report
	 * 
	 * @return
	 */
	@Bean
	public static IntertieScheduleAndFlowClient intertieScheduleAndFlowClient() {
		return new IntertieScheduleAndFlowClient(
				"http://reports.ieso.ca/public/IntertieScheduleFlow/PUB_IntertieScheduleFlow.xml",
				"ca.ieso.reports.schema.intertiescheduleflow");
	}

	/**
	 * Net Interchange Scheduling Limit Report
	 * 
	 * @return
	 */
	@Bean
	public static NetInterchangeSchedulingLimitClient netInterchangeSchedulingLimitClient() {
		return new NetInterchangeSchedulingLimitClient(
				"http://reports.ieso.ca/public/NISLShadowPrices/PUB_NISLShadowPrices.xml",
				"ca.ieso.reports.schema.nislshadowprices");
	}

	/**
	 * Predispatch Area Operating Reserve Shortfalls
	 * 
	 * @return
	 */
	@Bean
	public static PredispatchAreaOperatingReserveShortfallsClient predispatchAreaOperatingReserveShortfallsClient() {
		return new PredispatchAreaOperatingReserveShortfallsClient(
				"http://reports.ieso.ca/public/PredispAreaOpResShortfalls/PUB_PredispAreaOpResShortfalls.xml",
				"ca.ieso.reports.schema.predispareaopresshortfalls");
	}

	/**
	 * Predispatch Area Reserve Constraints Report
	 * 
	 * @return
	 */
	@Bean
	public static PredispatchAreaReserveConstraintsClient predispatchAreaReserveConstraintsClient() {
		return new PredispatchAreaReserveConstraintsClient(
				"http://reports.ieso.ca/public/PredispAreaReserveConst/PUB_PredispAreaReserveConst.xml",
				"ca.ieso.reports.schema.predispareareserveconst");
	}

	/**
	 * Predispatch Constrained Totals Report
	 * 
	 * @return
	 */
	@Bean
	public static PredispatchConstrainedTotalsClient predispatchConstrainedTotalsClient() {
		return new PredispatchConstrainedTotalsClient(
				"http://reports.ieso.ca/public/PredispConstTotals/PUB_PredispConstTotals.xml",
				"ca.ieso.reports.schema.predispconsttotals");
	}

	/**
	 * Predispatch Intertie Scheduling Limits Report
	 * 
	 * @return
	 */
	@Bean
	public static PredispatchIntertieSchedulingLimitsClient predispatchIntertieSchedulingLimitsClient() {
		return new PredispatchIntertieSchedulingLimitsClient(
				"http://reports.ieso.ca/public/PredispIntertieSchedLimits/PUB_PredispIntertieSchedLimits.xml",
				"ca.ieso.reports.schema.predispintertieschedlimits");
	}

	/**
	 * Predispatch Market Price Report
	 * 
	 * @return
	 */
	@Bean
	public static PredispatchMarketPriceClient predispatchMarketPriceClient() {
		return new PredispatchMarketPriceClient(
				"http://reports.ieso.ca/public/PredispMktPrice/PUB_PredispMktPrice.xml",
				"ca.ieso.reports.schema.predispmktprice");
	}

	/**
	 * Predispatch Market Totals Report
	 * 
	 * @return
	 */
	@Bean
	public static PredispatchMarketTotalsClient predispatchMarketTotalsClient() {
		return new PredispatchMarketTotalsClient(
				"http://reports.ieso.ca/public/PredispMktTotals/PUB_PredispMktTotals.xml",
				"ca.ieso.reports.schema.predispmkttotals");
	}

	/**
	 * Predispatch Security Constraints
	 * 
	 * @return
	 */
	@Bean
	public static PredispatchSecurityConstraintsClient predispatchSecurityConstraintsClient() {
		return new PredispatchSecurityConstraintsClient(
				"http://reports.ieso.ca/public/PredispSecurityConstraints/PUB_PredispSecurityConstraints.xml",
				"ca.ieso.reports.schema.predispsecurityconstraints");
	}

	/**
	 * Predispatch Shadow Prices Report
	 * 
	 * @return
	 */
	@Bean
	public static PredispatchShadowPricesClient predispatchShadowPricesClient() {
		return new PredispatchShadowPricesClient(
				"http://reports.ieso.ca/public/PredispShadowPrices/PUB_PredispShadowPrices.xml",
				"ca.ieso.reports.schema.predispshadowprices");
	}

	/**
	 * Realtime Area Reserve Constraints Report
	 * 
	 * @return
	 */
	@Bean
	public static RealtimeAreaReserveConstraintsClient realtimeAreaReserveConstraintsClient() {
		return new RealtimeAreaReserveConstraintsClient(
				"http://reports.ieso.ca/public/RealtimeAreaReserveConst/PUB_RealtimeAreaReserveConst.xml",
				"ca.ieso.reports.schema.realtimeareareserveconst");
	}

	/**
	 * Realtime Constrained Totals Report
	 * 
	 * @return
	 */
	@Bean
	public static RealtimeConstrainedTotalsClient realtimeConstrainedTotalsClient() {
		return new RealtimeConstrainedTotalsClient(
				"http://reports.ieso.ca/public/RealtimeConstTotals/PUB_RealtimeConstTotals.xml",
				"ca.ieso.reports.schema.realtimeconsttotals");
	}

	/**
	 * Realtime Intertie Scheduling Limits Report
	 * 
	 * @return
	 */
	@Bean
	public static RealtimeIntertieSchedulingLimitsClient realtimeIntertieSchedulingLimitsClient() {
		return new RealtimeIntertieSchedulingLimitsClient(
				"http://reports.ieso.ca/public/RealtimeIntertieSchedLimits/PUB_RealtimeIntertieSchedLimits.xml",
				"ca.ieso.reports.schema.realtimeintertieschedlimits");
	}

	/**
	 * Realtime Market Price Report
	 * 
	 * @return
	 */
	@Bean
	public static RealtimeMarketPriceClient realtimeMarketPriceClient() {
		return new RealtimeMarketPriceClient(
				"http://reports.ieso.ca/public/RealtimeMktPrice/PUB_RealtimeMktPrice.xml",
				"ca.ieso.reports.schema.realtimemktprice");
	}

	/**
	 * Realtime Market Totals Report
	 * 
	 * @return
	 */
	@Bean
	public static RealtimeMarketTotalsClient realtimeMarketTotalsClient() {
		return new RealtimeMarketTotalsClient(
				"http://reports.ieso.ca/public/PredispMktTotals/PUB_PredispMktTotals.xml",
				"ca.ieso.reports.schema.realtimemkttotals");
	}

	/**
	 * Realtime Operating Reserve In Market Report
	 * 
	 * @return
	 */
	@Bean
	public static RealtimeOperatingReserveInMarketClient realtimeOperatingReserveInMarketClient() {
		return new RealtimeOperatingReserveInMarketClient(
				"http://reports.ieso.ca/public/RealtimeORIM/PUB_RealtimeORIM.xml",
				"ca.ieso.reports.schema.realtimeorim");
	}

	/**
	 * Realtime Shadow Prices Report
	 * 
	 * @return
	 */
	@Bean
	public static RealtimeShadowPricesClient realtimeShadowPricesClient() {
		return new RealtimeShadowPricesClient(
				"http://reports.ieso.ca/public/RealtimeShadowPrices/PUB_RealtimeShadowPrices.xml",
				"ca.ieso.reports.schema.realtimeshadowprices");
	}

	/**
	 * <p>
	 * Surplus Baseload Generation Report
	 * </p>
	 * <p>
	 * The URL for the XML is variable. The client tries today's date by
	 * default. If no report exists it will check five days into the past for a
	 * valid report XML location.
	 * </p>
	 * <p>
	 * If a different date is desired just adjust
	 * {@link SurplusBaseloadGenerationClient#setUrlDate(Date)} and the
	 * marshaller will be adjusted appropriaftely.
	 * </p>
	 * 
	 * @return
	 */
	@Bean
	public static SurplusBaseloadGenerationClient surplusBaseloadGenerationClient() {
		Calendar urlCalendar = Calendar.getInstance();
		String urlBaseString = "http://www.ieso.ca/weather/mkt4/sbg/PUB_SurplusBaseloadGen_";
		String urlTailString = "_v1.xml";
		String defaultUrlString = urlBaseString
				+ BaseReportClient.REPORT_DATE_FORMAT.format(urlCalendar
						.getTime()) + urlTailString;

		// Check URL for today, if not then check up to five days in the past.
		for (int i = 0; i < 5; i++) {
			boolean success = false;
			defaultUrlString = urlBaseString
					+ BaseReportClient.REPORT_DATE_FORMAT.format(urlCalendar
							.getTime()) + urlTailString;

			try {
				HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(
						defaultUrlString).openConnection();
				httpURLConnection.setRequestMethod("HEAD");
				int responseCode = httpURLConnection.getResponseCode();
				if (responseCode == 200) {
					break;
				}
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (success) {
				break;
			} else {
				urlCalendar.roll(Calendar.DATE, false);
			}

		}

		logger.debug("Default Date used to set urlDate "
				+ urlCalendar.getTime().toString());

		return new SurplusBaseloadGenerationClient(defaultUrlString,
				"ca.ieso.reports.schema.sbg");
	}

	/**
	 * Transmission Rights Auction (TRA) Post Auction MCP LT Round 1 Report
	 * 
	 * @return
	 */
	@Bean
	public static TraPostAuctionMcpLtRoundOneClient traPostAuctionMcpLtRoundOneClient() {
		return new TraPostAuctionMcpLtRoundOneClient(
				"http://reports.ieso.ca/public/TRAPostauctionMCPLTr1/PUB_TRAPostauctionMCPLTr1.xml",
				"ca.ieso.reports.schema.trapostauctionmcpltr1");
	}

	/**
	 * Transmission Rights Auction (TRA) Post Auction MCP LT Round 2 Report
	 * 
	 * @return
	 */
	@Bean
	public static TraPostAuctionMcpLtRoundTwoClient traPostAuctionMcpLtRoundTwoClient() {
		return new TraPostAuctionMcpLtRoundTwoClient(
				"http://reports.ieso.ca/public/TRAPostauctionMCPLTr2/PUB_TRAPostauctionMCPLTr2.xml",
				"ca.ieso.reports.schema.trapostauctionmcpltr2");
	}

	/**
	 * Transmission Rights Auction (TRA) Post Auction MCP ST Round 1 Report
	 * 
	 * @return
	 */
	@Bean
	public static TraPostAuctionMcpStRoundOneClient traPostAuctionMcpStRoundOneClient() {
		return new TraPostAuctionMcpStRoundOneClient(
				"http://reports.ieso.ca/public/TRAPostauctionMCPSTr1/PUB_TRAPostauctionMCPSTr1.xml",
				"ca.ieso.reports.schema.trapostauctionmcpstr1");
	}

	/**
	 * Transmission Rights (TR) Hourly Zonal Price Report (Monthly)
	 * 
	 * @return
	 */
	@Bean
	public static TrHourlyZonalPriceMonthlyClient trHourlyZonalPriceMonthlyClient() {
		return new TrHourlyZonalPriceMonthlyClient(
				"http://reports.ieso.ca/public/TRAPreauctionHZMCPMonthly/PUB_TRAPreauctionHZMCPMonthly.xml",
				"ca.ieso.reports.schema.trapreauctionhzmcpmonthly");
	}

	/**
	 * Transmission Rights (TR) Historical Interface (Monthly)
	 * 
	 * @return
	 */
	@Bean
	public static TrHistoricalInterfaceMonthlyClient trHistoricalInterfaceMonthlyClient() {
		return new TrHistoricalInterfaceMonthlyClient(
				"http://reports.ieso.ca/public/TRAPreauctionInterfaceHistoryMonthly/PUB_TRAPreauctionInterfaceHistoryMonthly.xml",
				"ca.ieso.reports.schema.trapreauctioninterfacehistorymonthly");
	}

	/**
	 * Pre Auction MCP LT
	 * 
	 * @return
	 */
	@Bean
	public static PreAuctionMcpLtClient preAuctionMcpLtClient() {
		return new PreAuctionMcpLtClient(
				"http://reports.ieso.ca/public/TRAPreauctionMCPLT/PUB_TRAPreauctionMCPLT.xml",
				"ca.ieso.reports.schema.trapreauctionmcplt");
	}

	/**
	 * Pre Auction MCP ST
	 * 
	 * @return
	 */
	@Bean
	public static PreAuctionMcpStClient preAuctionMcpStClient() {
		return new PreAuctionMcpStClient(
				"http://reports.ieso.ca/public/TRAPreauctionMCPST/PUB_TRAPreauctionMCPST.xml",
				"ca.ieso.reports.schema.trapreauctionmcpst");
	}

	/**
	 * Pre Auction Transmission Transfer Capability (TTC) LT
	 * 
	 * @return
	 */
	@Bean
	public static PreAuctionTransmissionTransferCapabilityLtClient preAuctionTransmissionTransferCapabilityLtClient() {
		return new PreAuctionTransmissionTransferCapabilityLtClient(
				"http://reports.ieso.ca/public/TRAPreauctionTTCLT/PUB_TRAPreauctionTTCLT.xml",
				"ca.ieso.reports.schema.trapreauctionttclt");
	}

	/**
	 * Pre Auction Transmission Transfer Capability (TTC) ST
	 * 
	 * @return
	 */
	@Bean
	public static PreAuctionTransmissionTransferCapabilityStClient preAuctionTransmissionTransferCapabilityStClient() {
		return new PreAuctionTransmissionTransferCapabilityStClient(
				"http://reports.ieso.ca/public/TRAPreauctionTTCST/PUB_TRAPreauctionTTCST.xml",
				"ca.ieso.reports.schema.trapreauctionttcst");
	}

	/**
	 * Hourly Uplift and Intertie Offer Guarantee Estimates
	 * 
	 * @return
	 */
	@Bean
	public static HourlyUpliftAndIntertieOfferGuaranteeEstimatesClient hourlyUpliftAndIntertieOfferGuaranteeEstimatesClient() {
		return new HourlyUpliftAndIntertieOfferGuaranteeEstimatesClient(
				"http://reports.ieso.ca/public/Uplift/PUB_Uplift.xml",
				"ca.ieso.reports.schema.uplift");
	}

	/**
	 * Variable Generation Forecast Summary
	 * 
	 * @return
	 */
	@Bean
	public static VariableGenerationForecastSummaryClient variableGenerationForecastSummaryClient() {
		return new VariableGenerationForecastSummaryClient(
				"http://reports.ieso.ca/public/VGForecastSummary/PUB_VGForecastSummary.xml",
				"ca.ieso.reports.schema.vgforecastsummary");
	}

	/**
	 * Variable Generation Tie-Breaking Rankings
	 * 
	 * @return
	 */
	@Bean
	public static VariableGenerationTieBreakingRankingsClient variableGenerationTieBreakingRankingsClient() {
		return new VariableGenerationTieBreakingRankingsClient(
				"http://reports.ieso.ca/public/VGTieBreakingRankings/PUB_VGTieBreakingRankings.xml",
				"ca.ieso.reports.schema.vgtiebreakingrankings");
	}
}
