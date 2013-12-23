package name.reidmiller.parseieso.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ca.ieso.reports.schema.dispunconshoep.IMODocument;

public class HourlyOntarioEnergyPriceReportClientTest {
	private ApplicationContext appContext;
	private HourlyOntarioEnergyPriceReportClient hourlyOntarioEnergyPriceReportClient;

	@Before
	public void setUp() throws Exception {
		appContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		hourlyOntarioEnergyPriceReportClient = (HourlyOntarioEnergyPriceReportClient) appContext
				.getBean("hourlyOntarioEnergyPriceReportClient");
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
