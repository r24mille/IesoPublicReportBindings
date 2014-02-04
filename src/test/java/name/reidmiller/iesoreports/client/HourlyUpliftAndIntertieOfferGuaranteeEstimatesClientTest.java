package name.reidmiller.iesoreports.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import name.reidmiller.iesoreports.IesoPublicReportBindingsConfig;

import org.junit.Before;
import org.junit.Test;

import ca.ieso.reports.schema.uplift.Document;

public class HourlyUpliftAndIntertieOfferGuaranteeEstimatesClientTest {
	private HourlyUpliftAndIntertieOfferGuaranteeEstimatesClient hourlyUpliftAndIntertieOfferGuaranteeEstimatesClient;

	@Before
	public void setUp() throws Exception {
		hourlyUpliftAndIntertieOfferGuaranteeEstimatesClient = IesoPublicReportBindingsConfig
				.hourlyUpliftAndIntertieOfferGuaranteeEstimatesClient();
	}

	@Test
	public void testUnmarshal() {
		try {
			assertTrue(
					"Could not unmaral a ca.ieso.reports.schema.uplift.Document",
					hourlyUpliftAndIntertieOfferGuaranteeEstimatesClient
							.unmarshal() instanceof Document);
		} catch (ClassCastException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetDocHeader() {
		assertNotNull(
				"ca.ieso.reports.schema.uplift.DocHeader could not be retrieved from XML",
				hourlyUpliftAndIntertieOfferGuaranteeEstimatesClient
						.getDocHeader());
	}

	@Test
	public void testGetDocBody() {
		assertNotNull(
				"ca.ieso.reports.schema.uplift.DocBody could not be retrieved from XML",
				hourlyUpliftAndIntertieOfferGuaranteeEstimatesClient
						.getDocBody());
	}
}
