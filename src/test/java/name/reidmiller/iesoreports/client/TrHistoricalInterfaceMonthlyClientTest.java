package name.reidmiller.iesoreports.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import name.reidmiller.iesoreports.IesoPublicReportBindingsConfig;

import org.junit.Before;
import org.junit.Test;

import ca.ieso.reports.schema.trapreauctioninterfacehistorymonthly.Document;

public class TrHistoricalInterfaceMonthlyClientTest {
	private TrHistoricalInterfaceMonthlyClient trHistoricalInterfaceMonthlyClient;

	@Before
	public void setUp() throws Exception {
		trHistoricalInterfaceMonthlyClient = IesoPublicReportBindingsConfig
				.trHistoricalInterfaceMonthlyClient();
	}

	@Test
	public void testUnmarshal() {
		try {
			assertTrue(
					"Could not unmaral a ca.ieso.reports.schema.trapreauctioninterfacehistorymonthly.Document",
					trHistoricalInterfaceMonthlyClient.unmarshal() instanceof Document);
		} catch (ClassCastException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetDocHeader() {
		assertNotNull(
				"ca.ieso.reports.schema.trapreauctioninterfacehistorymonthly.DocHeader could not be retrieved from XML",
				trHistoricalInterfaceMonthlyClient.getDocHeader());
	}

	@Test
	public void testGetDocBody() {
		assertNotNull(
				"ca.ieso.reports.schema.trapreauctioninterfacehistorymonthly.DocBody could not be retrieved from XML",
				trHistoricalInterfaceMonthlyClient.getDocBody());
	}
}
