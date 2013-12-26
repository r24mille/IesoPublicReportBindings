package name.reidmiller.parseieso.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ca.ieso.reports.schema.trapreauctionhzmcpmonthly.Document;

public class TrHourlyZonalPriceMonthlyClientTest {
	private ApplicationContext appContext;
	private TrHourlyZonalPriceMonthlyClient trHourlyZonalPriceMonthlyClient;

	@Before
	public void setUp() throws Exception {
		appContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		trHourlyZonalPriceMonthlyClient = (TrHourlyZonalPriceMonthlyClient) appContext
				.getBean("trHourlyZonalPriceMonthlyClient");
	}

	@Test
	public void testUnmarshal() {
		try {
			assertTrue(
					"Could not unmaral a ca.ieso.reports.schema.trapreauctionhzmcpmonthly.Document",
					trHourlyZonalPriceMonthlyClient.unmarshal() instanceof Document);
		} catch (ClassCastException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetDocHeader() {
		assertNotNull(
				"ca.ieso.reports.schema.trapreauctionhzmcpmonthly.DocHeader could not be retrieved from XML",
				trHourlyZonalPriceMonthlyClient.getDocHeader());
	}

	@Test
	public void testGetDocBody() {
		assertNotNull(
				"ca.ieso.reports.schema.trapreauctionhzmcpmonthly.DocBody could not be retrieved from XML",
				trHourlyZonalPriceMonthlyClient.getDocBody());
	}
}
