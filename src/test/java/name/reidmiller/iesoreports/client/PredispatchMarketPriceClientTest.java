package name.reidmiller.iesoreports.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import name.reidmiller.iesoreports.IesoPublicReportBindingsConfig;

import org.junit.Before;
import org.junit.Test;

import ca.ieso.reports.schema.predispmktprice.Document;

public class PredispatchMarketPriceClientTest {
	private PredispatchMarketPriceClient predispatchMarketPriceClient;

	@Before
	public void setUp() throws Exception {
		predispatchMarketPriceClient = IesoPublicReportBindingsConfig
				.predispatchMarketPriceClient();
	}

	@Test
	public void testUnmarshal() {
		try {
			assertTrue(
					"Could not unmaral a ca.ieso.reports.schema.predispmktprice.Document",
					predispatchMarketPriceClient.unmarshal() instanceof Document);
		} catch (ClassCastException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetDocHeader() {
		assertNotNull(
				"ca.ieso.reports.schema.predispmktprice.DocHeader could not be retrieved from XML",
				predispatchMarketPriceClient.getDocHeader());
	}

	@Test
	public void testGetDocBody() {
		assertNotNull(
				"ca.ieso.reports.schema.predispmktprice.DocBody could not be retrieved from XML",
				predispatchMarketPriceClient.getDocBody());
	}
}
