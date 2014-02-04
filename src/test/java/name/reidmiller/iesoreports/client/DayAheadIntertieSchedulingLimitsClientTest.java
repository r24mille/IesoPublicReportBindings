package name.reidmiller.iesoreports.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import name.reidmiller.iesoreports.IesoPublicReportBindingsConfig;

import org.junit.Before;
import org.junit.Test;

import ca.ieso.reports.schema.daintertieschedlimits.Document;

public class DayAheadIntertieSchedulingLimitsClientTest {
	private DayAheadIntertieSchedulingLimitsClient dayAheadIntertieSchedulingLimitsClient;

	@Before
	public void setUp() throws Exception {
		dayAheadIntertieSchedulingLimitsClient = IesoPublicReportBindingsConfig
				.dayAheadIntertieSchedulingLimitsClient();
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
