package name.reidmiller.parseieso.client;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ca.ieso.reports.schema.trapostauctionmcpstr1.Document;

public class PostAuctionMcpStRoundOneClientTest {
	private ApplicationContext appContext;
	private PostAuctionMcpStRoundOneClient postAuctionMcpStRoundOneClient;

	@Before
	public void setUp() throws Exception {
		appContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		postAuctionMcpStRoundOneClient = (PostAuctionMcpStRoundOneClient) appContext.getBean("postAuctionMcpStRoundOneClient");
	}

	@Test
	public void testUnmarshal() {
		try {
			assertTrue(
					"Could not unmaral a ca.ieso.reports.schema.trapostauctionmcpstr1.Document",
					postAuctionMcpStRoundOneClient.unmarshal() instanceof Document);
		} catch (ClassCastException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetDocHeader() {
		assertNotNull(
				"ca.ieso.reports.schema.trapostauctionmcpstr1.DocHeader could not be retrieved from XML",
				postAuctionMcpStRoundOneClient.getDocHeader());
	}

	@Test
	public void testGetDocBody() {
		assertNotNull(
				"ca.ieso.reports.schema.trapostauctionmcpstr1.DocBody could not be retrieved from XML",
				postAuctionMcpStRoundOneClient.getDocBody());
	}
}
