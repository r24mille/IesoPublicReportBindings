package name.reidmiller.iesoreports.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import name.reidmiller.iesoreports.IesoPublicReportBindingsConfig;

import org.junit.Before;
import org.junit.Test;

import ca.ieso.reports.schema.realtimeshadowprices.Document;

public class RealtimeShadowPricesClientTest {
	private RealtimeShadowPricesClient realtimeShadowPricesClient;

	@Before
	public void setUp() throws Exception {
		realtimeShadowPricesClient = IesoPublicReportBindingsConfig
				.realtimeShadowPricesClient();
	}

	@Test
	public void testUnmarshal() {
		try {
			assertTrue(
					"Could not unmaral a ca.ieso.reports.schema.realtimeshadowprices.Document",
					realtimeShadowPricesClient.unmarshal() instanceof Document);
		} catch (ClassCastException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetDocHeader() {
		assertNotNull(
				"ca.ieso.reports.schema.realtimeshadowprices.DocHeader could not be retrieved from XML",
				realtimeShadowPricesClient.getDocHeader());
	}

	@Test
	public void testGetDocBody() {
		assertNotNull(
				"ca.ieso.reports.schema.realtimeshadowprices.DocBody could not be retrieved from XML",
				realtimeShadowPricesClient.getDocBody());
	}
}
