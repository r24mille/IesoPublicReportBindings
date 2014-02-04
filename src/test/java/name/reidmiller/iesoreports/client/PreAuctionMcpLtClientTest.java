package name.reidmiller.iesoreports.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import name.reidmiller.iesoreports.client.PreAuctionMcpLtClient;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import ca.ieso.reports.schema.trapreauctionmcplt.Document;

public class PreAuctionMcpLtClientTest {
	private ApplicationContext appContext;
	private PreAuctionMcpLtClient preAuctionMcpLtClient;

	@Before
	public void setUp() throws Exception {
		appContext = new FileSystemXmlApplicationContext(
				"src/resources/spring/applicationContext.xml");
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
