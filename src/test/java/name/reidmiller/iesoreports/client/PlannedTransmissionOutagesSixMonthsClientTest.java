package name.reidmiller.iesoreports.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import name.reidmiller.iesoreports.IesoPublicReportBindingsConfig;

import org.junit.Before;
import org.junit.Test;

import ca.ieso.reports.schema.iomspublicplannedoutagesixmonths.Document;

public class PlannedTransmissionOutagesSixMonthsClientTest {
	private PlannedTransmissionOutagesSixMonthsClient plannedTransmissionOutagesSixMonthsClient;

	@Before
	public void setUp() throws Exception {
		plannedTransmissionOutagesSixMonthsClient = IesoPublicReportBindingsConfig
				.plannedTransmissionOutagesSixMonthsClient();
	}

	@Test
	public void testUnmarshal() {
		try {
			assertTrue(
					"Could not unmaral a ca.ieso.reports.schema.iomspublicplannedoutagesixmonths.Document",
					plannedTransmissionOutagesSixMonthsClient.unmarshal() instanceof Document);
		} catch (ClassCastException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetDocHeader() {
		assertNotNull(
				"ca.ieso.reports.schema.iomspublicplannedoutagesixmonths.DocHeader could not be retrieved from XML",
				plannedTransmissionOutagesSixMonthsClient.getDocHeader());
	}

	@Test
	public void testGetDocBody() {
		assertNotNull(
				"ca.ieso.reports.schema.iomspublicplannedoutagesixmonths.DocBody could not be retrieved from XML",
				plannedTransmissionOutagesSixMonthsClient.getDocBody());
	}
}
