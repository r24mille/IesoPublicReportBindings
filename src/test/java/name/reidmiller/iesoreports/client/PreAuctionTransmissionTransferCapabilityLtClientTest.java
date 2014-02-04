package name.reidmiller.iesoreports.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import name.reidmiller.iesoreports.IesoPublicReportBindingsConfig;

import org.junit.Before;
import org.junit.Test;

import ca.ieso.reports.schema.trapreauctionttclt.Document;

public class PreAuctionTransmissionTransferCapabilityLtClientTest {
	private PreAuctionTransmissionTransferCapabilityLtClient preAuctionTransmissionTransferCapabilityLtClient;

	@Before
	public void setUp() throws Exception {
		preAuctionTransmissionTransferCapabilityLtClient = IesoPublicReportBindingsConfig
				.preAuctionTransmissionTransferCapabilityLtClient();
	}

	@Test
	public void testUnmarshal() {
		try {
			assertTrue(
					"Could not unmaral a ca.ieso.reports.schema.trapreauctionttclt.Document",
					preAuctionTransmissionTransferCapabilityLtClient
							.unmarshal() instanceof Document);
		} catch (ClassCastException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetDocHeader() {
		assertNotNull(
				"ca.ieso.reports.schema.trapreauctionttclt.DocHeader could not be retrieved from XML",
				preAuctionTransmissionTransferCapabilityLtClient.getDocHeader());
	}

	@Test
	public void testGetDocBody() {
		assertNotNull(
				"ca.ieso.reports.schema.trapreauctionttclt.DocBody could not be retrieved from XML",
				preAuctionTransmissionTransferCapabilityLtClient.getDocBody());
	}
}
