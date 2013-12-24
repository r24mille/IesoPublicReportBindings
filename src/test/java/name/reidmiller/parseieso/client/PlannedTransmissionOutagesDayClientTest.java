package name.reidmiller.parseieso.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ca.ieso.reports.schema.iomspublicplannedoutageday.Document;

public class PlannedTransmissionOutagesDayClientTest {
	private ApplicationContext appContext;
	private PlannedTransmissionOutagesDayClient plannedTransmissionOutagesDayClient;

	@Before
	public void setUp() throws Exception {
		appContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		plannedTransmissionOutagesDayClient = (PlannedTransmissionOutagesDayClient) appContext
				.getBean("plannedTransmissionOutagesDayClient");
	}

	@Test
	public void testUnmarshal() {
		try {
			assertTrue(
					"Could not unmarshal a ca.ieso.reports.schema.iomspublicplannedoutageday.Document",
					plannedTransmissionOutagesDayClient.unmarshal() instanceof Document);
		} catch (ClassCastException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetDocHeader() {
		assertNotNull(
				"ca.ieso.reports.schema.iomspublicplannedoutageday.DocHeader could not be retrieved from XML",
				plannedTransmissionOutagesDayClient.getDocHeader());
	}

	@Test
	public void testGetDocBody() {
		assertNotNull(
				"ca.ieso.reports.schema.iomspublicplannedoutageday.DocBody could not be retrieved from XML",
				plannedTransmissionOutagesDayClient.getDocBody());
	}
}
