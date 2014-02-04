package name.reidmiller.iesoreports.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import name.reidmiller.iesoreports.IesoPublicReportBindingsConfig;

import org.junit.Before;
import org.junit.Test;

import ca.ieso.reports.schema.iomspublichistoricoutagehour.Document;

public class HistoricalTransmissionOutagesClientTest {
	private HistoricalTransmissionOutagesClient historicalTransmissionOutagesClient;

	@Before
	public void setUp() throws Exception {
		historicalTransmissionOutagesClient = IesoPublicReportBindingsConfig
				.historicalTransmissionOutagesClient();
	}

	@Test
	public void testUnmarshal() {
		try {
			assertTrue(
					"Could not unmarshal a ca.ieso.reports.schema.iomspublichistoricoutagehour.Document",
					historicalTransmissionOutagesClient.unmarshal() instanceof Document);
		} catch (ClassCastException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetDocHeader() {
		assertNotNull(
				"ca.ieso.reports.schema.iomspublichistoricoutagehour.DocHeader could not be retrieved from XML",
				historicalTransmissionOutagesClient.getDocHeader());
	}

	@Test
	public void testGetDocBody() {
		assertNotNull(
				"ca.ieso.reports.schema.iomspublichistoricoutagehour.DocBody could not be retrieved from XML",
				historicalTransmissionOutagesClient.getDocBody());
	}
}
