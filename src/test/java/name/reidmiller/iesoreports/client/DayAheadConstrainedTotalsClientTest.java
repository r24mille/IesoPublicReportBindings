package name.reidmiller.iesoreports.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import name.reidmiller.iesoreports.IesoPublicReportBindingsConfig;

import org.junit.Before;
import org.junit.Test;

import ca.ieso.reports.schema.daconsttotals.Document;

public class DayAheadConstrainedTotalsClientTest {
	private DayAheadConstrainedTotalsClient dayAheadConstrainedTotalsClient;

	@Before
	public void setUp() throws Exception {
		dayAheadConstrainedTotalsClient = IesoPublicReportBindingsConfig
				.dayAheadConstrainedTotalsClient();
	}

	@Test
	public void testUnmarshal() {
		try {
			assertTrue(
					"Could not unmarshal a ca.ieso.reports.schema.daconsttotals.Document",
					dayAheadConstrainedTotalsClient.unmarshal() instanceof Document);
		} catch (ClassCastException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetDocHeader() {
		assertNotNull(
				"ca.ieso.reports.schema.daconsttotals.DocHeader could not be retrieved from XML",
				dayAheadConstrainedTotalsClient.getDocHeader());
	}

	@Test
	public void testGetDocBody() {
		assertNotNull(
				"ca.ieso.reports.schema.daconsttotals.DocBody could not be retrieved from XML",
				dayAheadConstrainedTotalsClient.getDocBody());
	}

}
