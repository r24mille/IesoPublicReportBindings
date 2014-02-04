package name.reidmiller.iesoreports.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import name.reidmiller.iesoreports.IesoPublicReportBindingsConfig;

import org.junit.Before;
import org.junit.Test;

import ca.ieso.reports.schema.predispareaopresshortfalls.Document;

public class PredispatchAreaOperatingReserveShortfallsClientTest {
	private PredispatchAreaOperatingReserveShortfallsClient predispatchAreaOperatingReserveShortfallsClient;

	@Before
	public void setUp() throws Exception {
		predispatchAreaOperatingReserveShortfallsClient = IesoPublicReportBindingsConfig
				.predispatchAreaOperatingReserveShortfallsClient();
	}

	@Test
	public void testUnmarshal() {
		try {
			assertTrue(
					"Could not unmaral a ca.ieso.reports.schema.predispareaopresshortfalls.Document",
					predispatchAreaOperatingReserveShortfallsClient.unmarshal() instanceof Document);
		} catch (ClassCastException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetDocHeader() {
		assertNotNull(
				"ca.ieso.reports.schema.predispareaopresshortfalls.DocHeader could not be retrieved from XML",
				predispatchAreaOperatingReserveShortfallsClient.getDocHeader());
	}

	@Test
	public void testGetDocBody() {
		assertNotNull(
				"ca.ieso.reports.schema.predispareaopresshortfalls.DocBody could not be retrieved from XML",
				predispatchAreaOperatingReserveShortfallsClient.getDocBody());
	}
}
