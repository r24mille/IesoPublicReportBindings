package name.reidmiller.iesoreports.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import name.reidmiller.iesoreports.IesoPublicReportBindingsConfig;

import org.junit.Before;
import org.junit.Test;

import ca.ieso.reports.schema.trapostauctionmcpltr1.Document;

public class TraPostAuctionMcpLtRoundOneClientTest {
	private TraPostAuctionMcpLtRoundOneClient traPostAuctionMcpLtRoundOneClient;

	@Before
	public void setUp() throws Exception {
		traPostAuctionMcpLtRoundOneClient = IesoPublicReportBindingsConfig
				.traPostAuctionMcpLtRoundOneClient();
	}

	@Test
	public void testUnmarshal() {
		try {
			assertTrue(
					"Could not unmaral a ca.ieso.reports.schema.trapostauctionmcpltr1.Document",
					traPostAuctionMcpLtRoundOneClient.unmarshal() instanceof Document);
		} catch (ClassCastException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetDocHeader() {
		assertNotNull(
				"ca.ieso.reports.schema.trapostauctionmcpltr1.DocHeader could not be retrieved from XML",
				traPostAuctionMcpLtRoundOneClient.getDocHeader());
	}

	@Test
	public void testGetDocBody() {
		assertNotNull(
				"ca.ieso.reports.schema.trapostauctionmcpltr1.DocBody could not be retrieved from XML",
				traPostAuctionMcpLtRoundOneClient.getDocBody());
	}
}
