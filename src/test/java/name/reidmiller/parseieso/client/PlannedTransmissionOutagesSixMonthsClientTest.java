package name.reidmiller.parseieso.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import ca.ieso.reports.schema.iomspublicplannedoutagesixmonths.Document;

public class PlannedTransmissionOutagesSixMonthsClientTest {
	private ApplicationContext appContext;
	private PlannedTransmissionOutagesSixMonthsClient plannedTransmissionOutagesSixMonthsClient;

	@Before
	public void setUp() throws Exception {
		appContext = new FileSystemXmlApplicationContext(
				"src/resources/spring/applicationContext.xml");
		plannedTransmissionOutagesSixMonthsClient = (PlannedTransmissionOutagesSixMonthsClient) appContext
				.getBean("plannedTransmissionOutagesSixMonthsClient");
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
