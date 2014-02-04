package name.reidmiller.iesoreports.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import name.reidmiller.iesoreports.client.TraPostAuctionMcpLtRoundOneClient;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import ca.ieso.reports.schema.trapostauctionmcpltr1.Document;

public class TraPostAuctionMcpLtRoundOneClientTest {
	private ApplicationContext appContext;
	private TraPostAuctionMcpLtRoundOneClient traPostAuctionMcpLtRoundOneClient;

	@Before
	public void setUp() throws Exception {
		appContext = new FileSystemXmlApplicationContext(
				"src/resources/spring/applicationContext.xml");
		traPostAuctionMcpLtRoundOneClient = (TraPostAuctionMcpLtRoundOneClient) appContext
				.getBean("traPostAuctionMcpLtRoundOneClient");
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
