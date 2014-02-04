package name.reidmiller.iesoreports.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import name.reidmiller.iesoreports.IesoPublicReportBindingsConfig;

import org.junit.Before;
import org.junit.Test;

import ca.ieso.reports.schema.trapreauctionmcplt.Document;

public class PreAuctionMcpLtClientTest {
	private PreAuctionMcpLtClient preAuctionMcpLtClient;

	@Before
	public void setUp() throws Exception {
		preAuctionMcpLtClient = IesoPublicReportBindingsConfig
				.preAuctionMcpLtClient();
	}

	@Test
	public void testUnmarshal() {
		try {
			assertTrue(
					"Could not unmaral a ca.ieso.reports.schema.trapreauctionmcplt.Document",
					preAuctionMcpLtClient.unmarshal() instanceof Document);
		} catch (ClassCastException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetDocHeader() {
		assertNotNull(
				"ca.ieso.reports.schema.trapreauctionmcplt.DocHeader could not be retrieved from XML",
				preAuctionMcpLtClient.getDocHeader());
	}

	@Test
	public void testGetDocBody() {
		assertNotNull(
				"ca.ieso.reports.schema.trapreauctionmcplt.DocBody could not be retrieved from XML",
				preAuctionMcpLtClient.getDocBody());
	}
}
