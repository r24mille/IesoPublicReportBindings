package name.reidmiller.iesoreports.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import name.reidmiller.iesoreports.IesoPublicReportBindingsConfig;

import org.junit.Before;
import org.junit.Test;

import ca.ieso.reports.schema.genoutputcapability.IMODocument;

public class GeneratorOutputCapabilityClientTest {
	private GeneratorOutputCapabilityClient generatorOutputCapabilityClient;

	@Before
	public void setUp() throws Exception {
		generatorOutputCapabilityClient = IesoPublicReportBindingsConfig
				.generatorOutputCapabilityClient();
	}

	@Test
	public void testUnmarshal() {
		try {
			assertTrue(
					"Could not unmaral a ca.ieso.reports.schema.genoutputcapability.IMODocument",
					generatorOutputCapabilityClient.unmarshal() instanceof IMODocument);
		} catch (ClassCastException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetIMODocHeader() {
		assertNotNull(
				"ca.ieso.reports.schema.genoutputcapability.IMODocHeader could not be retrieved from XML",
				generatorOutputCapabilityClient.getIMODocHeader());
	}

	@Test
	public void testGetIMODocBody() {
		assertNotNull(
				"ca.ieso.reports.schema.genoutputcapability.IMODocBody could not be retrieved from XML",
				generatorOutputCapabilityClient.getIMODocBody());
	}
}
