package name.reidmiller.parseieso.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import ca.ieso.reports.schema.intertiescheduleflow.IMODocument;

public class IntertieScheduleAndFlowClientTest {
	private ApplicationContext appContext;
	private IntertieScheduleAndFlowClient intertieScheduleAndFlowClient;

	@Before
	public void setUp() throws Exception {
		appContext = new FileSystemXmlApplicationContext(
				"src/resources/spring/applicationContext.xml");
		intertieScheduleAndFlowClient = (IntertieScheduleAndFlowClient) appContext
				.getBean("intertieScheduleAndFlowClient");
	}

	@Test
	public void testUnmarshal() {
		try {
			assertTrue(
					"Could not unmaral a ca.ieso.reports.schema.intertiescheduleflow.IMODocument",
					intertieScheduleAndFlowClient.unmarshal() instanceof IMODocument);
		} catch (ClassCastException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetIMODocHeader() {
		assertNotNull(
				"ca.ieso.reports.schema.intertiescheduleflow.IMODocHeader could not be retrieved from XML",
				intertieScheduleAndFlowClient.getIMODocHeader());
	}

	@Test
	public void testGetIMODocBody() {
		assertNotNull(
				"ca.ieso.reports.schema.intertiescheduleflow.IMODocBody could not be retrieved from XML",
				intertieScheduleAndFlowClient.getIMODocBody());
	}
}
