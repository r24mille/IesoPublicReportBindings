package name.reidmiller.iesoreports.client;

import static org.junit.Assert.*;
import name.reidmiller.iesoreports.client.PredispatchMarketPriceClient;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import ca.ieso.reports.schema.predispmktprice.Document;

public class PredispatchMarketPriceClientTest {
	private ApplicationContext appContext;
	private PredispatchMarketPriceClient predispatchMarketPriceClient;

	@Before
	public void setUp() throws Exception {
		appContext = new FileSystemXmlApplicationContext(
				"src/resources/spring/applicationContext.xml");
		predispatchMarketPriceClient = (PredispatchMarketPriceClient) appContext.getBean("predispatchMarketPriceClient");
	}

	@Test
	public void testUnmarshal() {
		try {
			assertTrue(
					"Could not unmaral a ca.ieso.reports.schema.predispmktprice.Document",
					predispatchMarketPriceClient.unmarshal() instanceof Document);
		} catch (ClassCastException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetDocHeader() {
		assertNotNull(
				"ca.ieso.reports.schema.predispmktprice.DocHeader could not be retrieved from XML",
				predispatchMarketPriceClient.getDocHeader());
	}

	@Test
	public void testGetDocBody() {
		assertNotNull(
				"ca.ieso.reports.schema.predispmktprice.DocBody could not be retrieved from XML",
				predispatchMarketPriceClient.getDocBody());
	}
}
