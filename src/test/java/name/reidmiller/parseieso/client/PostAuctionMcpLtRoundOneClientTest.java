package name.reidmiller.parseieso.client;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ca.ieso.reports.schema.trapostauctionmcpltr1.Document;

public class PostAuctionMcpLtRoundOneClientTest {
	private ApplicationContext appContext;
	private PostAuctionMcpLtRoundOneClient postAuctionMcpLtRoundOneClient;

	@Before
	public void setUp() throws Exception {
		appContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		postAuctionMcpLtRoundOneClient = (PostAuctionMcpLtRoundOneClient) appContext.getBean("postAuctionMcpLtRoundOneClient");
	}

	@Test
	public void testUnmarshal() {
		try {
			assertTrue(
					"Could not unmaral a ca.ieso.reports.schema.trapostauctionmcpltr1.Document",
					postAuctionMcpLtRoundOneClient.unmarshal() instanceof Document);
		} catch (ClassCastException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetDocHeader() {
		assertNotNull(
				"ca.ieso.reports.schema.trapostauctionmcpltr1.DocHeader could not be retrieved from XML",
				postAuctionMcpLtRoundOneClient.getDocHeader());
	}

	@Test
	public void testGetDocBody() {
		assertNotNull(
				"ca.ieso.reports.schema.trapostauctionmcpltr1.DocBody could not be retrieved from XML",
				postAuctionMcpLtRoundOneClient.getDocBody());
	}
}
