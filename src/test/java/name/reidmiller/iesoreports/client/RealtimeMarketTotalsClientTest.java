package name.reidmiller.iesoreports.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import name.reidmiller.iesoreports.IesoPublicReportBindingsConfig;

import org.junit.Before;
import org.junit.Test;

import ca.ieso.reports.schema.realtimemkttotals.Document;

public class RealtimeMarketTotalsClientTest {
	private RealtimeMarketTotalsClient realtimeMarketTotalsClient;

	@Before
	public void setUp() throws Exception {
		realtimeMarketTotalsClient = IesoPublicReportBindingsConfig
				.realtimeMarketTotalsClient();
	}

	@Test
	public void testUnmarshal() {
		try {
			assertTrue(
					"Could not unmaral a ca.ieso.reports.schema.realtimemkttotals.Document",
					realtimeMarketTotalsClient.unmarshal() instanceof Document);
		} catch (ClassCastException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetDocHeader() {
		assertNotNull(
				"ca.ieso.reports.schema.realtimemkttotals.DocHeader could not be retrieved from XML",
				realtimeMarketTotalsClient.getDocHeader());
	}

	@Test
	public void testGetDocBody() {
		assertNotNull(
				"ca.ieso.reports.schema.realtimemkttotals.DocBody could not be retrieved from XML",
				realtimeMarketTotalsClient.getDocBody());
	}
}
