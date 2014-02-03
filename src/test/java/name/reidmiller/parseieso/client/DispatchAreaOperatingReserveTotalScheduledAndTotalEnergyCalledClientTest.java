package name.reidmiller.parseieso.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import ca.ieso.reports.schema.dispareaopresandenergycalled.Document;

public class DispatchAreaOperatingReserveTotalScheduledAndTotalEnergyCalledClientTest {
	private ApplicationContext appContext;
	private DispatchAreaOperatingReserveTotalScheduledAndTotalEnergyCalledClient dispatchAreaOperatingReserveTotalScheduledAndTotalEnergyCalledClient;

	@Before
	public void setUp() throws Exception {
		appContext = new FileSystemXmlApplicationContext(
				"src/resources/spring/applicationContext.xml");
		dispatchAreaOperatingReserveTotalScheduledAndTotalEnergyCalledClient = (DispatchAreaOperatingReserveTotalScheduledAndTotalEnergyCalledClient) appContext
				.getBean("dispatchAreaOperatingReserveTotalScheduledAndTotalEnergyCalledClient");
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
