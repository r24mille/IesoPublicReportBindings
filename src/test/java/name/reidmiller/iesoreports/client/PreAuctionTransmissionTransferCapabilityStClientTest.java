package name.reidmiller.iesoreports.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import name.reidmiller.iesoreports.IesoPublicReportBindingsConfig;

import org.junit.Before;
import org.junit.Test;

import ca.ieso.reports.schema.trapreauctionttcst.Document;

public class PreAuctionTransmissionTransferCapabilityStClientTest {
	private PreAuctionTransmissionTransferCapabilityStClient preAuctionTransmissionTransferCapabilityStClient;

	@Before
	public void setUp() throws Exception {
		preAuctionTransmissionTransferCapabilityStClient = IesoPublicReportBindingsConfig
				.preAuctionTransmissionTransferCapabilityStClient();
	}

	@Test
	public void testUnmarshal() {
		try {
			assertTrue(
					"Could not unmaral a ca.ieso.reports.schema.trapreauctionttcst.Document",
					preAuctionTransmissionTransferCapabilityStClient
							.unmarshal() instanceof Document);
		} catch (ClassCastException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetDocHeader() {
		assertNotNull(
				"ca.ieso.reports.schema.trapreauctionttcst.DocHeader could not be retrieved from XML",
				preAuctionTransmissionTransferCapabilityStClient.getDocHeader());
	}

	@Test
	public void testGetDocBody() {
		assertNotNull(
				"ca.ieso.reports.schema.trapreauctionttcst.DocBody could not be retrieved from XML",
				preAuctionTransmissionTransferCapabilityStClient.getDocBody());
	}
}
