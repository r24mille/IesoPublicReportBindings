package name.reidmiller.iesoreports.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import name.reidmiller.iesoreports.IesoPublicReportBindingsConfig;

import org.junit.Before;
import org.junit.Test;

import ca.ieso.reports.schema.daadequacy.Document;

public class DayAheadAdequacyClientTest {
	private DayAheadAdequacyClient dayAheadAdequacyClient;

	@Before
	public void setUp() throws Exception {
		dayAheadAdequacyClient = IesoPublicReportBindingsConfig
				.dayAheadAdequacyClient();
	}

	@Test
	public void testUnmarshal() {
		try {
			assertTrue(
					"Could not unmaral a ca.ieso.reports.schema.daadequacy.Document",
					dayAheadAdequacyClient.unmarshal() instanceof Document);
		} catch (ClassCastException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetDocHeader() {
		assertNotNull(
				"ca.ieso.reports.schema.daadequacy.DocHeader could not be retrieved from XML",
				dayAheadAdequacyClient.getDocHeader());
	}

	@Test
	public void testGetDocBody() {
		assertNotNull(
				"ca.ieso.reports.schema.daadequacy.DocBody could not be retrieved from XML",
				dayAheadAdequacyClient.getDocBody());
	}
}
