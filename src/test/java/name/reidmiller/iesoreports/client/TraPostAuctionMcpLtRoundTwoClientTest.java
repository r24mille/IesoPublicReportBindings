package name.reidmiller.iesoreports.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import name.reidmiller.iesoreports.IesoPublicReportBindingsConfig;

import org.junit.Before;
import org.junit.Test;

import ca.ieso.reports.schema.trapostauctionmcpltr2.Document;

public class TraPostAuctionMcpLtRoundTwoClientTest {
	private TraPostAuctionMcpLtRoundTwoClient traPostAuctionMcpLtRoundTwoClient;

	@Before
	public void setUp() throws Exception {
		traPostAuctionMcpLtRoundTwoClient = IesoPublicReportBindingsConfig
				.traPostAuctionMcpLtRoundTwoClient();
	}

	@Test
	public void testUnmarshal() {
		try {
			assertTrue(
					"Could not unmaral a ca.ieso.reports.schema.trapostauctionmcpltr2.Document",
					traPostAuctionMcpLtRoundTwoClient.unmarshal() instanceof Document);
		} catch (ClassCastException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetDocHeader() {
		assertNotNull(
				"ca.ieso.reports.schema.trapostauctionmcpltr2.DocHeader could not be retrieved from XML",
				traPostAuctionMcpLtRoundTwoClient.getDocHeader());
	}

	@Test
	public void testGetDocBody() {
		assertNotNull(
				"ca.ieso.reports.schema.trapostauctionmcpltr2.DocBody could not be retrieved from XML",
				traPostAuctionMcpLtRoundTwoClient.getDocBody());
	}
}
