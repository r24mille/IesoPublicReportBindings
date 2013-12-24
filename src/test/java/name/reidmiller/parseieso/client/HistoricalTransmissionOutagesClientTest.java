package name.reidmiller.parseieso.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ca.ieso.reports.schema.iomspublichistoricoutagehour.Document;

public class HistoricalTransmissionOutagesClientTest {
	private ApplicationContext appContext;
	private HistoricalTransmissionOutagesClient historicalTransmissionOutagesClient;

	@Before
	public void setUp() throws Exception {
		appContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		historicalTransmissionOutagesClient = (HistoricalTransmissionOutagesClient) appContext
				.getBean("historicalTransmissionOutagesClient");
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
