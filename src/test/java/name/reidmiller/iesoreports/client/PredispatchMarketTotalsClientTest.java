package name.reidmiller.iesoreports.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import name.reidmiller.iesoreports.IesoPublicReportBindingsConfig;

import org.junit.Before;
import org.junit.Test;

import ca.ieso.reports.schema.predispmkttotals.Document;

public class PredispatchMarketTotalsClientTest {
	private PredispatchMarketTotalsClient predispatchMarketTotalsClient;

	@Before
	public void setUp() throws Exception {
		predispatchMarketTotalsClient = IesoPublicReportBindingsConfig
				.predispatchMarketTotalsClient();
	}

	@Test
	public void testUnmarshal() {
		try {
			assertTrue(
					"Could not unmaral a ca.ieso.reports.schema.predispmkttotals.Document",
					predispatchMarketTotalsClient.unmarshal() instanceof Document);
		} catch (ClassCastException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetDocHeader() {
		assertNotNull(
				"ca.ieso.reports.schema.predispmkttotals.DocHeader could not be retrieved from XML",
				predispatchMarketTotalsClient.getDocHeader());
	}

	@Test
	public void testGetDocBody() {
		assertNotNull(
				"ca.ieso.reports.schema.predispmkttotals.DocBody could not be retrieved from XML",
				predispatchMarketTotalsClient.getDocBody());
	}
}
