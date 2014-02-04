package name.reidmiller.iesoreports.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import name.reidmiller.iesoreports.IesoPublicReportBindingsConfig;

import org.junit.Before;
import org.junit.Test;

import ca.ieso.reports.schema.realtimeconsttotals.Document;

public class RealtimeConstrainedTotalsClientTest {
	private RealtimeConstrainedTotalsClient realtimeConstrainedTotalsClient;

	@Before
	public void setUp() throws Exception {
		realtimeConstrainedTotalsClient = IesoPublicReportBindingsConfig
				.realtimeConstrainedTotalsClient();
	}

	@Test
	public void testUnmarshal() {
		try {
			assertTrue(
					"Could not unmaral a ca.ieso.reports.schema.realtimeconsttotals.Document",
					realtimeConstrainedTotalsClient.unmarshal() instanceof Document);
		} catch (ClassCastException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetDocHeader() {
		assertNotNull(
				"ca.ieso.reports.schema.realtimeconsttotals.DocHeader could not be retrieved from XML",
				realtimeConstrainedTotalsClient.getDocHeader());
	}

	@Test
	public void testGetDocBody() {
		assertNotNull(
				"ca.ieso.reports.schema.realtimeconsttotals.DocBody could not be retrieved from XML",
				realtimeConstrainedTotalsClient.getDocBody());
	}
}
