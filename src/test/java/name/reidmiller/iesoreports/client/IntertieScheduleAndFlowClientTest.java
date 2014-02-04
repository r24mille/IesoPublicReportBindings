package name.reidmiller.iesoreports.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import name.reidmiller.iesoreports.IesoPublicReportBindingsConfig;

import org.junit.Before;
import org.junit.Test;

import ca.ieso.reports.schema.intertiescheduleflow.IMODocument;

public class IntertieScheduleAndFlowClientTest {
	private IntertieScheduleAndFlowClient intertieScheduleAndFlowClient;

	@Before
	public void setUp() throws Exception {
		intertieScheduleAndFlowClient = IesoPublicReportBindingsConfig
				.intertieScheduleAndFlowClient();
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
