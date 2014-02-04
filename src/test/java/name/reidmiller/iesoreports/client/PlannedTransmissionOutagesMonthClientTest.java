package name.reidmiller.iesoreports.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import name.reidmiller.iesoreports.IesoPublicReportBindingsConfig;

import org.junit.Before;
import org.junit.Test;

import ca.ieso.reports.schema.iomspublicplanneodutagemonth.Document;

public class PlannedTransmissionOutagesMonthClientTest {
	private PlannedTransmissionOutagesMonthClient plannedTransmissionOutagesMonthClient;

	@Before
	public void setUp() throws Exception {
		plannedTransmissionOutagesMonthClient = IesoPublicReportBindingsConfig
				.plannedTransmissionOutagesMonthClient();
	}

	@Test
	public void testUnmarshal() {
		try {
			assertTrue(
					"Could not unmarshal a ca.ieso.reports.schema.iomspublicplanneodutagemonth.Document",
					plannedTransmissionOutagesMonthClient.unmarshal() instanceof Document);
		} catch (ClassCastException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetDocHeader() {
		assertNotNull(
				"ca.ieso.reports.schema.iomspublicplanneodutagemonth.DocHeader could not be retrieved from XML",
				plannedTransmissionOutagesMonthClient.getDocHeader());
	}

	@Test
	public void testGetDocBody() {
		assertNotNull(
				"ca.ieso.reports.schema.iomspublicplanneodutagemonth.DocBody could not be retrieved from XML",
				plannedTransmissionOutagesMonthClient.getDocBody());
	}
}
