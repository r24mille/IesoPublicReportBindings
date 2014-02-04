package name.reidmiller.iesoreports.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import name.reidmiller.iesoreports.IesoPublicReportBindingsConfig;

import org.junit.Before;
import org.junit.Test;

import ca.ieso.reports.schema.trapreauctionmcpst.Document;

public class PreAuctionMcpStClientTest {
	private PreAuctionMcpStClient preAuctionMcpStClient;

	@Before
	public void setUp() throws Exception {
		preAuctionMcpStClient = IesoPublicReportBindingsConfig
				.preAuctionMcpStClient();
	}

	@Test
	public void testUnmarshal() {
		try {
			assertTrue(
					"Could not unmaral a ca.ieso.reports.schema.trapreauctionmcpst.Document",
					preAuctionMcpStClient.unmarshal() instanceof Document);
		} catch (ClassCastException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetDocHeader() {
		assertNotNull(
				"ca.ieso.reports.schema.trapreauctionmcpst.DocHeader could not be retrieved from XML",
				preAuctionMcpStClient.getDocHeader());
	}

	@Test
	public void testGetDocBody() {
		assertNotNull(
				"ca.ieso.reports.schema.trapreauctionmcpst.DocBody could not be retrieved from XML",
				preAuctionMcpStClient.getDocBody());
	}
}
