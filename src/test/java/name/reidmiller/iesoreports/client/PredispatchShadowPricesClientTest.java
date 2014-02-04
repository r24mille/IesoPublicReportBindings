package name.reidmiller.iesoreports.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import name.reidmiller.iesoreports.IesoPublicReportBindingsConfig;

import org.junit.Before;
import org.junit.Test;

import ca.ieso.reports.schema.predispshadowprices.Document;

public class PredispatchShadowPricesClientTest {
	private PredispatchShadowPricesClient predispatchShadowPricesClient;

	@Before
	public void setUp() throws Exception {
		predispatchShadowPricesClient = IesoPublicReportBindingsConfig
				.predispatchShadowPricesClient();
	}

	@Test
	public void testUnmarshal() {
		try {
			assertTrue(
					"Could not unmaral a ca.ieso.reports.schema.predispshadowprices.Document",
					predispatchShadowPricesClient.unmarshal() instanceof Document);
		} catch (ClassCastException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetDocHeader() {
		assertNotNull(
				"ca.ieso.reports.schema.predispshadowprices.DocHeader could not be retrieved from XML",
				predispatchShadowPricesClient.getDocHeader());
	}

	@Test
	public void testGetDocBody() {
		assertNotNull(
				"ca.ieso.reports.schema.predispshadowprices.DocBody could not be retrieved from XML",
				predispatchShadowPricesClient.getDocBody());
	}
}
