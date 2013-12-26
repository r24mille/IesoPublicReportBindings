package name.reidmiller.parseieso.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ca.ieso.reports.schema.trapostauctionmcpltr2.Document;

public class TraPostAuctionMcpLtRoundTwoClientTest {
	private ApplicationContext appContext;
	private TraPostAuctionMcpLtRoundTwoClient traPostAuctionMcpLtRoundTwoClient;

	@Before
	public void setUp() throws Exception {
		appContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		traPostAuctionMcpLtRoundTwoClient = (TraPostAuctionMcpLtRoundTwoClient) appContext
				.getBean("traPostAuctionMcpLtRoundTwoClient");
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