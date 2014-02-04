package name.reidmiller.iesoreports.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import name.reidmiller.iesoreports.IesoPublicReportBindingsConfig;

import org.junit.Before;
import org.junit.Test;

import ca.ieso.reports.schema.dashadowprices.Document;

public class DayAheadShadowPricesClientTest {
	private DayAheadShadowPricesClient dayAheadShadowPricesClient;

	@Before
	public void setUp() throws Exception {
		dayAheadShadowPricesClient = IesoPublicReportBindingsConfig
				.dayAheadShadowPricesClient();
	}

	@Test
	public void testUnmarshal() {
		try {
			assertTrue(
					"Could not unmarshal a ca.ieso.reports.schema.dashadowprices.Document",
					dayAheadShadowPricesClient.unmarshal() instanceof Document);
		} catch (ClassCastException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetDocHeader() {
		assertNotNull(
				"ca.ieso.reports.schema.dashadowprices.DocHeader could not be retrieved from XML",
				dayAheadShadowPricesClient.getDocHeader());
	}

	@Test
	public void testGetDocBody() {
		assertNotNull(
				"ca.ieso.reports.schema.dashadowprices.DocBody could not be retrieved from XML",
				dayAheadShadowPricesClient.getDocBody());
	}
}
