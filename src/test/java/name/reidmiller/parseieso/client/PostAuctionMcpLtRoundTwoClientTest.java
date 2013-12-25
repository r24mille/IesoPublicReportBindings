package name.reidmiller.parseieso.client;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ca.ieso.reports.schema.trapostauctionmcpltr2.Document;

public class PostAuctionMcpLtRoundTwoClientTest {
	private ApplicationContext appContext;
	private PostAuctionMcpLtRoundTwoClient postAuctionMcpLtRoundTwoClient;

	@Before
	public void setUp() throws Exception {
		appContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		postAuctionMcpLtRoundTwoClient = (PostAuctionMcpLtRoundTwoClient) appContext.getBean("postAuctionMcpLtRoundTwoClient");
	}

	@Test
	public void testUnmarshal() {
		try {
			assertTrue(
					"Could not unmaral a ca.ieso.reports.schema.trapostauctionmcpltr2.Document",
					postAuctionMcpLtRoundTwoClient.unmarshal() instanceof Document);
		} catch (ClassCastException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetDocHeader() {
		assertNotNull(
				"ca.ieso.reports.schema.trapostauctionmcpltr2.DocHeader could not be retrieved from XML",
				postAuctionMcpLtRoundTwoClient.getDocHeader());
	}

	@Test
	public void testGetDocBody() {
		assertNotNull(
				"ca.ieso.reports.schema.trapostauctionmcpltr2.DocBody could not be retrieved from XML",
				postAuctionMcpLtRoundTwoClient.getDocBody());
	}
}
