package name.reidmiller.iesoreports.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import name.reidmiller.iesoreports.IesoPublicReportBindingsConfig;

import org.junit.Before;
import org.junit.Test;

import ca.ieso.reports.schema.predispconsttotals.Document;

public class PredispatchConstrainedTotalsClientTest {
	private PredispatchConstrainedTotalsClient predispatchConstrainedTotalsClient;

	@Before
	public void setUp() throws Exception {
		predispatchConstrainedTotalsClient = IesoPublicReportBindingsConfig
				.predispatchConstrainedTotalsClient();
	}

	@Test
	public void testUnmarshal() {
		try {
			assertTrue(
					"Could not unmaral a ca.ieso.reports.schema.predispconsttotals.Document",
					predispatchConstrainedTotalsClient.unmarshal() instanceof Document);
		} catch (ClassCastException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetDocHeader() {
		assertNotNull(
				"ca.ieso.reports.schema.predispconsttotals.DocHeader could not be retrieved from XML",
				predispatchConstrainedTotalsClient.getDocHeader());
	}

	@Test
	public void testGetDocBody() {
		assertNotNull(
				"ca.ieso.reports.schema.predispconsttotals.DocBody could not be retrieved from XML",
				predispatchConstrainedTotalsClient.getDocBody());
	}
}
