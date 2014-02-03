package name.reidmiller.parseieso.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import ca.ieso.reports.schema.predispintertieschedlimits.Document;

public class PredispatchIntertieSchedulingLimitsClientTest {
	private ApplicationContext appContext;
	private PredispatchIntertieSchedulingLimitsClient predispatchIntertieSchedulingLimitsClient;

	@Before
	public void setUp() throws Exception {
		appContext = new FileSystemXmlApplicationContext(
				"src/resources/spring/applicationContext.xml");
		predispatchIntertieSchedulingLimitsClient = (PredispatchIntertieSchedulingLimitsClient) appContext
				.getBean("predispatchIntertieSchedulingLimitsClient");
	}

	@Test
	public void testUnmarshal() {
		try {
			assertTrue(
					"Could not unmaral a ca.ieso.reports.schema.predispintertieschedlimits.Document",
					predispatchIntertieSchedulingLimitsClient.unmarshal() instanceof Document);
		} catch (ClassCastException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetDocHeader() {
		assertNotNull(
				"ca.ieso.reports.schema.predispintertieschedlimits.DocHeader could not be retrieved from XML",
				predispatchIntertieSchedulingLimitsClient.getDocHeader());
	}

	@Test
	public void testGetDocBody() {
		assertNotNull(
				"ca.ieso.reports.schema.predispintertieschedlimits.DocBody could not be retrieved from XML",
				predispatchIntertieSchedulingLimitsClient.getDocBody());
	}
}
