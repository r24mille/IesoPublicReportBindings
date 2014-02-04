package name.reidmiller.iesoreports.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import name.reidmiller.iesoreports.IesoPublicReportBindingsConfig;

import org.junit.Before;
import org.junit.Test;

import ca.ieso.reports.schema.realtimemktprice.Document;

public class RealtimeMarketPriceClientTest {
	private RealtimeMarketPriceClient realtimeMarketPriceClient;

	@Before
	public void setUp() throws Exception {
		realtimeMarketPriceClient = IesoPublicReportBindingsConfig
				.realtimeMarketPriceClient();
	}

	@Test
	public void testUnmarshal() {
		try {
			assertTrue(
					"Could not unmaral a ca.ieso.reports.schema.realtimemktprice.Document",
					realtimeMarketPriceClient.unmarshal() instanceof Document);
		} catch (ClassCastException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetDocHeader() {
		assertNotNull(
				"ca.ieso.reports.schema.realtimemktprice.DocHeader could not be retrieved from XML",
				realtimeMarketPriceClient.getDocHeader());
	}

	@Test
	public void testGetDocBody() {
		assertNotNull(
				"ca.ieso.reports.schema.realtimemktprice.DocBody could not be retrieved from XML",
				realtimeMarketPriceClient.getDocBody());
	}
}
