package name.reidmiller.iesoreports.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import name.reidmiller.iesoreports.IesoPublicReportBindingsConfig;

import org.junit.Before;
import org.junit.Test;

import ca.ieso.reports.schema.vgforecastsummary.Document;

public class VariableGenerationForecastSummaryClientTest {
	private VariableGenerationForecastSummaryClient variableGenerationForecastSummaryClient;

	@Before
	public void setUp() throws Exception {
		variableGenerationForecastSummaryClient = IesoPublicReportBindingsConfig
				.variableGenerationForecastSummaryClient();
	}

	@Test
	public void testUnmarshal() {
		try {
			assertTrue(
					"VariableGenerationForecastSummary did not unmaral a ca.ieso.reports.schema.vgforecastsummary.Document",
					variableGenerationForecastSummaryClient.unmarshal() instanceof Document);
		} catch (ClassCastException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetDocHeader() {
		assertNotNull(
				"ca.ieso.reports.schema.vgforecastsummary.DocHeader could not be retrieved from XML",
				variableGenerationForecastSummaryClient.getDocHeader());
	}

	@Test
	public void testGetDocBody() {
		assertNotNull(
				"ca.ieso.reports.schema.vgforecastsummary.DocBody could not be retrieved from XML",
				variableGenerationForecastSummaryClient.getDocBody());
	}

}
