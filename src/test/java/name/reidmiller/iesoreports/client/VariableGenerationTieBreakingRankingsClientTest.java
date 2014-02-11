package name.reidmiller.iesoreports.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.net.MalformedURLException;

import name.reidmiller.iesoreports.IesoPublicReportBindingsConfig;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import ca.ieso.reports.schema.vgtiebreakingrankings.DocBody;
import ca.ieso.reports.schema.vgtiebreakingrankings.DocHeader;
import ca.ieso.reports.schema.vgtiebreakingrankings.Document;

public class VariableGenerationTieBreakingRankingsClientTest {
	private Logger logger = LogManager.getLogger(this.getClass());
	private VariableGenerationTieBreakingRankingsClient variableGenerationTieBreakingRankingsClient;

	@Before
	public void setUp() throws Exception {
		variableGenerationTieBreakingRankingsClient = IesoPublicReportBindingsConfig
				.variableGenerationTieBreakingRankingsClient();
	}

	@Test
	public void testGetDefaultDocument() {
		try {
			assertNotNull(Document.class.getName()
					+ " could not be retrieved from XML",
					variableGenerationTieBreakingRankingsClient.getDefaultDocument());
		} catch (MalformedURLException e) {
			fail(e.getMessage());
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetDefaultDocHeader() {
		try {
			assertNotNull(DocHeader.class.getName()
					+ " could not be retrieved from XML",
					variableGenerationTieBreakingRankingsClient.getDefaultDocHeader());
		} catch (MalformedURLException e) {
			fail(e.getMessage());
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetDefaultDocBody() {
		try {
			assertNotNull(DocBody.class.getName()
					+ " could not be retrieved from XML",
					variableGenerationTieBreakingRankingsClient.getDefaultDocBody());
		} catch (MalformedURLException e) {
			fail(e.getMessage());
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}
}