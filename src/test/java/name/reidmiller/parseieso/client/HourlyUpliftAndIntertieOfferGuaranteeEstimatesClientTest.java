package name.reidmiller.parseieso.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import ca.ieso.reports.schema.uplift.Document;

public class HourlyUpliftAndIntertieOfferGuaranteeEstimatesClientTest {
	private ApplicationContext appContext;
	private HourlyUpliftAndIntertieOfferGuaranteeEstimatesClient hourlyUpliftAndIntertieOfferGuaranteeEstimatesClient;

	@Before
	public void setUp() throws Exception {
		appContext = new FileSystemXmlApplicationContext(
				"src/resources/spring/applicationContext.xml");
		hourlyUpliftAndIntertieOfferGuaranteeEstimatesClient = (HourlyUpliftAndIntertieOfferGuaranteeEstimatesClient) appContext.getBean("hourlyUpliftAndIntertieOfferGuaranteeEstimatesClient");
	}

	@Test
	public void testUnmarshal() {
		try {
			assertTrue(
					"Could not unmaral a ca.ieso.reports.schema.uplift.Document",
					hourlyUpliftAndIntertieOfferGuaranteeEstimatesClient.unmarshal() instanceof Document);
		} catch (ClassCastException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetDocHeader() {
		assertNotNull(
				"ca.ieso.reports.schema.uplift.DocHeader could not be retrieved from XML",
				hourlyUpliftAndIntertieOfferGuaranteeEstimatesClient.getDocHeader());
	}

	@Test
	public void testGetDocBody() {
		assertNotNull(
				"ca.ieso.reports.schema.uplift.DocBody could not be retrieved from XML",
				hourlyUpliftAndIntertieOfferGuaranteeEstimatesClient.getDocBody());
	}
}
