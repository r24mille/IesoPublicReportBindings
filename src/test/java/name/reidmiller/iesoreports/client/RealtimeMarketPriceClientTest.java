package name.reidmiller.iesoreports.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import name.reidmiller.iesoreports.client.RealtimeMarketPriceClient;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import ca.ieso.reports.schema.realtimemktprice.Document;

public class RealtimeMarketPriceClientTest {
	private ApplicationContext appContext;
	private RealtimeMarketPriceClient realtimeMarketPriceClient;

	@Before
	public void setUp() throws Exception {
		appContext = new FileSystemXmlApplicationContext(
				"src/resources/spring/applicationContext.xml");
		realtimeMarketPriceClient = (RealtimeMarketPriceClient) appContext
				.getBean("realtimeMarketPriceClient");
	}

	@Test
	public void testUnmarshal() {
		try {
			assertTrue(
					"Could not unmaral a ca.ieso.reports.schema.realtimemktprice.Document",
					realtimeMarketPriceClient.unmarshal() instanceof Document);
		} catch (ClassCastException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetDocHeader() {
		assertNotNull(
				"ca.ieso.reports.schema.realtimemktprice.DocHeader could not be retrieved from XML",
				realtimeMarketPriceClient.getDocHeader());
	}

	@Test
	public void testGetDocBody() {
		assertNotNull(
				"ca.ieso.reports.schema.realtimemktprice.DocBody could not be retrieved from XML",
				realtimeMarketPriceClient.getDocBody());
	}
}
