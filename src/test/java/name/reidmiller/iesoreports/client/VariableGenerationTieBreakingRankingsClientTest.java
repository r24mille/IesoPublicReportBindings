package name.reidmiller.iesoreports.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import name.reidmiller.iesoreports.IesoPublicReportBindingsConfig;

import org.junit.Before;
import org.junit.Test;

import ca.ieso.reports.schema.vgtiebreakingrankings.Document;

public class VariableGenerationTieBreakingRankingsClientTest {
	private VariableGenerationTieBreakingRankingsClient variableGenerationTieBreakingRankingsClient;

	@Before
	public void setUp() throws Exception {
		variableGenerationTieBreakingRankingsClient = IesoPublicReportBindingsConfig
				.variableGenerationTieBreakingRankingsClient();
	}

	@Test
	public void testUnmarshal() {
		try {
			assertTrue(
					"Could not unmaral a ca.ieso.reports.schema.vgtiebreakingrankings.Document",
					variableGenerationTieBreakingRankingsClient.unmarshal() instanceof Document);
		} catch (ClassCastException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetDocHeader() {
		assertNotNull(
				"ca.ieso.reports.schema.vgtiebreakingrankings.DocHeader could not be retrieved from XML",
				variableGenerationTieBreakingRankingsClient.getDocHeader());
	}

	@Test
	public void testGetDocBody() {
		assertNotNull(
				"ca.ieso.reports.schema.vgtiebreakingrankings.DocBody could not be retrieved from XML",
				variableGenerationTieBreakingRankingsClient.getDocBody());
	}
}
