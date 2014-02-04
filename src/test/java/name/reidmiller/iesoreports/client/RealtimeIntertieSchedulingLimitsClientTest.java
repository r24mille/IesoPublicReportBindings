package name.reidmiller.iesoreports.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import name.reidmiller.iesoreports.client.RealtimeIntertieSchedulingLimitsClient;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import ca.ieso.reports.schema.realtimeintertieschedlimits.Document;

public class RealtimeIntertieSchedulingLimitsClientTest {
	private ApplicationContext appContext;
	private RealtimeIntertieSchedulingLimitsClient realtimeIntertieSchedulingLimitsClient;

	@Before
	public void setUp() throws Exception {
		appContext = new FileSystemXmlApplicationContext(
				"src/resources/spring/applicationContext.xml");
		realtimeIntertieSchedulingLimitsClient = (RealtimeIntertieSchedulingLimitsClient) appContext
				.getBean("realtimeIntertieSchedulingLimitsClient");
	}

	@Test
	public void testUnmarshal() {
		try {
			assertTrue(
					"Could not unmaral a ca.ieso.reports.schema.realtimeintertieschedlimits.Document",
					realtimeIntertieSchedulingLimitsClient.unmarshal() instanceof Document);
		} catch (ClassCastException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetDocHeader() {
		assertNotNull(
				"ca.ieso.reports.schema.realtimeintertieschedlimits.DocHeader could not be retrieved from XML",
				realtimeIntertieSchedulingLimitsClient.getDocHeader());
	}

	@Test
	public void testGetDocBody() {
		assertNotNull(
				"ca.ieso.reports.schema.realtimeintertieschedlimits.DocBody could not be retrieved from XML",
				realtimeIntertieSchedulingLimitsClient.getDocBody());
	}
}
