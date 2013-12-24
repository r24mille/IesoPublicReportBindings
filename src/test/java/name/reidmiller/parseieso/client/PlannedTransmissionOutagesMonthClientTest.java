package name.reidmiller.parseieso.client;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ca.ieso.reports.schema.iomspublicplanneodutagemonth.Document;

public class PlannedTransmissionOutagesMonthClientTest {
	private ApplicationContext appContext;
	private PlannedTransmissionOutagesMonthClient plannedTransmissionOutagesMonthClient;

	@Before
	public void setUp() throws Exception {
		appContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		plannedTransmissionOutagesMonthClient = (PlannedTransmissionOutagesMonthClient) appContext
				.getBean("plannedTransmissionOutagesMonthClient");
	}

	@Test
	public void testUnmarshal() {
		try {
			assertTrue(
					"AdequacyClient did not unmaral a ca.ieso.reports.schema.iomspublicplanneodutagemonth.Document",
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
