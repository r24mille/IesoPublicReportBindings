package name.reidmiller.iesoreports.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import name.reidmiller.iesoreports.IesoPublicReportBindingsConfig;

import org.junit.Before;
import org.junit.Test;

import ca.ieso.reports.schema.dispunconshoep.IMODocument;

public class HourlyOntarioEnergyPriceReportClientTest {
	private HourlyOntarioEnergyPriceReportClient hourlyOntarioEnergyPriceReportClient;

	@Before
	public void setUp() throws Exception {
		hourlyOntarioEnergyPriceReportClient = IesoPublicReportBindingsConfig
				.hourlyOntarioEnergyPriceReportClient();
	}

	@Test
	public void testUnmarshal() {
		try {
			assertTrue(
					"GeneratorOutputCapabilityClient did not unmaral a ca.ieso.reports.schema.dispunconshoep.IMODocument",
					hourlyOntarioEnergyPriceReportClient.unmarshal() instanceof IMODocument);
		} catch (ClassCastException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetIMODocHeader() {
		assertNotNull(
				"ca.ieso.reports.schema.dispunconshoep.IMODocHeader could not be retrieved from XML",
				hourlyOntarioEnergyPriceReportClient.getIMODocHeader());
	}

	@Test
	public void testGetIMODocBody() {
		assertNotNull(
				"ca.ieso.reports.schema.dispunconshoep.IMODocBody could not be retrieved from XML",
				hourlyOntarioEnergyPriceReportClient.getIMODocBody());
	}
}
