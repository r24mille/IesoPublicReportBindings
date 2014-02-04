package name.reidmiller.iesoreports.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import name.reidmiller.iesoreports.IesoPublicReportBindingsConfig;

import org.junit.Before;
import org.junit.Test;

import ca.ieso.reports.schema.dispareaopresandenergycalled.Document;

public class DispatchAreaOperatingReserveTotalScheduledAndTotalEnergyCalledClientTest {
	private DispatchAreaOperatingReserveTotalScheduledAndTotalEnergyCalledClient dispatchAreaOperatingReserveTotalScheduledAndTotalEnergyCalledClient;

	@Before
	public void setUp() throws Exception {
		dispatchAreaOperatingReserveTotalScheduledAndTotalEnergyCalledClient = IesoPublicReportBindingsConfig
				.dispatchAreaOperatingReserveTotalScheduledAndTotalEnergyCalledClient();
	}

	@Test
	public void testUnmarshal() {
		try {
			assertTrue(
					"Could not unmarshal a ca.ieso.reports.schema.dispareaopresandenergycalled.Document",
					dispatchAreaOperatingReserveTotalScheduledAndTotalEnergyCalledClient
							.unmarshal() instanceof Document);
		} catch (ClassCastException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetDocHeader() {
		assertNotNull(
				"ca.ieso.reports.schema.dispareaopresandenergycalled.DocHeader could not be retrieved from XML",
				dispatchAreaOperatingReserveTotalScheduledAndTotalEnergyCalledClient
						.getDocHeader());
	}

	@Test
	public void testGetDocBody() {
		assertNotNull(
				"ca.ieso.reports.schema.dispareaopresandenergycalled.DocBody could not be retrieved from XML",
				dispatchAreaOperatingReserveTotalScheduledAndTotalEnergyCalledClient
						.getDocBody());
	}
}
