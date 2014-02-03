package name.reidmiller.parseieso.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import ca.ieso.reports.schema.trapostauctionmcpstr1.Document;

public class TraPostAuctionMcpStRoundOneClientTest {
	private ApplicationContext appContext;
	private TraPostAuctionMcpStRoundOneClient traPostAuctionMcpStRoundOneClient;

	@Before
	public void setUp() throws Exception {
		appContext = new FileSystemXmlApplicationContext(
				"src/resources/spring/applicationContext.xml");
		traPostAuctionMcpStRoundOneClient = (TraPostAuctionMcpStRoundOneClient) appContext
				.getBean("traPostAuctionMcpStRoundOneClient");
	}

	@Test
	public void testUnmarshal() {
		try {
			assertTrue(
					"Could not unmaral a ca.ieso.reports.schema.trapostauctionmcpstr1.Document",
					traPostAuctionMcpStRoundOneClient.unmarshal() instanceof Document);
		} catch (ClassCastException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetDocHeader() {
		assertNotNull(
				"ca.ieso.reports.schema.trapostauctionmcpstr1.DocHeader could not be retrieved from XML",
				traPostAuctionMcpStRoundOneClient.getDocHeader());
	}

	@Test
	public void testGetDocBody() {
		assertNotNull(
				"ca.ieso.reports.schema.trapostauctionmcpstr1.DocBody could not be retrieved from XML",
				traPostAuctionMcpStRoundOneClient.getDocBody());
	}
}
