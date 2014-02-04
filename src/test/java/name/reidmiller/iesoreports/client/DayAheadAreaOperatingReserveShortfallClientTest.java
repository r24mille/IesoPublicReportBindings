package name.reidmiller.iesoreports.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import name.reidmiller.iesoreports.IesoPublicReportBindingsConfig;

import org.junit.Before;
import org.junit.Test;

import ca.ieso.reports.schema.daareaopresshortfall.Document;

public class DayAheadAreaOperatingReserveShortfallClientTest {
	private DayAheadAreaOperatingReserveShortfallClient dayAheadAreaOperatingReserveShortfallClient;

	@Before
	public void setUp() throws Exception {
		dayAheadAreaOperatingReserveShortfallClient = IesoPublicReportBindingsConfig
				.dayAheadAreaOperatingReserveShortfallClient();
	}

	@Test
	public void testUnmarshal() {
		try {
			assertTrue(
					"Could not unmarshal a ca.ieso.reports.schema.daareaopresshortfall.Document",
					dayAheadAreaOperatingReserveShortfallClient.unmarshal() instanceof Document);
		} catch (ClassCastException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetDocHeader() {
		assertNotNull(
				"ca.ieso.reports.schema.daareaopresshortfall.DocHeader could not be retrieved from XML",
				dayAheadAreaOperatingReserveShortfallClient.getDocHeader());
	}

	@Test
	public void testGetDocBody() {
		assertNotNull(
				"ca.ieso.reports.schema.daareaopresshortfall.DocBody could not be retrieved from XML",
				dayAheadAreaOperatingReserveShortfallClient.getDocBody());
	}
}
