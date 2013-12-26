package name.reidmiller.parseieso.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ca.ieso.reports.schema.trapreauctionmcplt.Document;

public class PreAuctionMcpLtClientTest {
	private ApplicationContext appContext;
	private PreAuctionMcpLtClient preAuctionMcpLtClient;

	@Before
	public void setUp() throws Exception {
		appContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		preAuctionMcpLtClient = (PreAuctionMcpLtClient) appContext
				.getBean("preAuctionMcpLtClient");
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
