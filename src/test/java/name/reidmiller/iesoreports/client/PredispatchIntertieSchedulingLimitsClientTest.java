package name.reidmiller.iesoreports.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import name.reidmiller.iesoreports.IesoPublicReportBindingsConfig;

import org.junit.Before;
import org.junit.Test;

import ca.ieso.reports.schema.predispintertieschedlimits.Document;

public class PredispatchIntertieSchedulingLimitsClientTest {
	private PredispatchIntertieSchedulingLimitsClient predispatchIntertieSchedulingLimitsClient;

	@Before
	public void setUp() throws Exception {
		predispatchIntertieSchedulingLimitsClient = IesoPublicReportBindingsConfig
				.predispatchIntertieSchedulingLimitsClient();
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
