package name.reidmiller.iesoreports.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import name.reidmiller.iesoreports.IesoPublicReportBindingsConfig;

import org.junit.Before;
import org.junit.Test;

import ca.ieso.reports.schema.trapreauctionhzmcpmonthly.Document;

public class TrHourlyZonalPriceMonthlyClientTest {
	private TrHourlyZonalPriceMonthlyClient trHourlyZonalPriceMonthlyClient;

	@Before
	public void setUp() throws Exception {
		trHourlyZonalPriceMonthlyClient = IesoPublicReportBindingsConfig
				.trHourlyZonalPriceMonthlyClient();
	}

	@Test
	public void testUnmarshal() {
		try {
			assertTrue(
					"Could not unmaral a ca.ieso.reports.schema.trapreauctionhzmcpmonthly.Document",
					trHourlyZonalPriceMonthlyClient.unmarshal() instanceof Document);
		} catch (ClassCastException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetDocHeader() {
		assertNotNull(
				"ca.ieso.reports.schema.trapreauctionhzmcpmonthly.DocHeader could not be retrieved from XML",
				trHourlyZonalPriceMonthlyClient.getDocHeader());
	}

	@Test
	public void testGetDocBody() {
		assertNotNull(
				"ca.ieso.reports.schema.trapreauctionhzmcpmonthly.DocBody could not be retrieved from XML",
				trHourlyZonalPriceMonthlyClient.getDocBody());
	}
}
