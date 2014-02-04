package name.reidmiller.iesoreports.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import name.reidmiller.iesoreports.client.PreAuctionMcpStClient;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import ca.ieso.reports.schema.trapreauctionmcpst.Document;

public class PreAuctionMcpStClientTest {
	private ApplicationContext appContext;
	private PreAuctionMcpStClient preAuctionMcpStClient;

	@Before
	public void setUp() throws Exception {
		appContext = new FileSystemXmlApplicationContext(
				"src/resources/spring/applicationContext.xml");
		preAuctionMcpStClient = (PreAuctionMcpStClient) appContext
				.getBean("preAuctionMcpStClient");
	}

	@Test
	public void testUnmarshal() {
		try {
			assertTrue(
					"Could not unmaral a ca.ieso.reports.schema.trapreauctionmcpst.Document",
					preAuctionMcpStClient.unmarshal() instanceof Document);
		} catch (ClassCastException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetDocHeader() {
		assertNotNull(
				"ca.ieso.reports.schema.trapreauctionmcpst.DocHeader could not be retrieved from XML",
				preAuctionMcpStClient.getDocHeader());
	}

	@Test
	public void testGetDocBody() {
		assertNotNull(
				"ca.ieso.reports.schema.trapreauctionmcpst.DocBody could not be retrieved from XML",
				preAuctionMcpStClient.getDocBody());
	}
}
