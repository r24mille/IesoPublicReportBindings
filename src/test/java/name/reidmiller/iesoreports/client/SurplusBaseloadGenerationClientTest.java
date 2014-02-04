package name.reidmiller.iesoreports.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import name.reidmiller.iesoreports.IesoPublicReportBindingsConfig;

import org.junit.Before;
import org.junit.Test;

import ca.ieso.reports.schema.sbg.Document;

public class SurplusBaseloadGenerationClientTest {
	private SurplusBaseloadGenerationClient surplusBaseloadGenerationClient;

	@Before
	public void setUp() throws Exception {
		surplusBaseloadGenerationClient = IesoPublicReportBindingsConfig
				.surplusBaseloadGenerationClient();
	}

	@Test
	public void testUnmarshal() {
		try {
			assertTrue(
					"Could not unmaral a ca.ieso.reports.schema.sbg.Document",
					surplusBaseloadGenerationClient.unmarshal() instanceof Document);
		} catch (ClassCastException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetDocHeader() {
		assertNotNull(
				"ca.ieso.reports.schema.sbg.DocHeader could not be retrieved from XML",
				surplusBaseloadGenerationClient.getDocHeader());
	}

	@Test
	public void testGetDocBody() {
		assertNotNull(
				"ca.ieso.reports.schema.sbg.Document.DocBody could not be retrieved from XML",
				surplusBaseloadGenerationClient.getDocBody());
	}
}
