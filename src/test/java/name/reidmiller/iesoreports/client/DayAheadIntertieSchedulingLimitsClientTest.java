package name.reidmiller.iesoreports.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import name.reidmiller.iesoreports.client.DayAheadIntertieSchedulingLimitsClient;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import ca.ieso.reports.schema.daintertieschedlimits.Document;

public class DayAheadIntertieSchedulingLimitsClientTest {
	private ApplicationContext appContext;
	private DayAheadIntertieSchedulingLimitsClient dayAheadIntertieSchedulingLimitsClient;

	@Before
	public void setUp() throws Exception {
		appContext = new FileSystemXmlApplicationContext(
				"src/resources/spring/applicationContext.xml");
		dayAheadIntertieSchedulingLimitsClient = (DayAheadIntertieSchedulingLimitsClient) appContext
				.getBean("dayAheadIntertieSchedulingLimitsClient");
	}

	@Test
	public void testUnmarshal() {
		try {
			assertTrue(
					"Could not unmarshal a ca.ieso.reports.schema.daintertieschedlimits.Document",
					dayAheadIntertieSchedulingLimitsClient.unmarshal() instanceof Document);
		} catch (ClassCastException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetDocHeader() {
		assertNotNull(
				"ca.ieso.reports.schema.daintertieschedlimits.DocHeader could not be retrieved from XML",
				dayAheadIntertieSchedulingLimitsClient.getDocHeader());
	}

	@Test
	public void testGetDocBody() {
		assertNotNull(
				"ca.ieso.reports.schema.daintertieschedlimits.DocBody could not be retrieved from XML",
				dayAheadIntertieSchedulingLimitsClient.getDocBody());
	}

}
