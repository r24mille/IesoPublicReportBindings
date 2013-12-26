package name.reidmiller.parseieso.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ca.ieso.reports.schema.trapreauctionhzmcpmonthly.Document;

public class TraHourlyZonalPriceMonthlyClientTest {
	private ApplicationContext appContext;
	private TraHourlyZonalPriceMonthlyClient traHourlyZonalPriceMonthlyClient;

	@Before
	public void setUp() throws Exception {
		appContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		traHourlyZonalPriceMonthlyClient = (TraHourlyZonalPriceMonthlyClient) appContext
				.getBean("traHourlyZonalPriceMonthlyClient");
	}

	@Test
	public void testUnmarshal() {
		try {
			assertTrue(
					"Could not unmaral a ca.ieso.reports.schema.trapreauctionhzmcpmonthly.Document",
					traHourlyZonalPriceMonthlyClient.unmarshal() instanceof Document);
		} catch (ClassCastException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetDocHeader() {
		assertNotNull(
				"ca.ieso.reports.schema.trapreauctionhzmcpmonthly.DocHeader could not be retrieved from XML",
				traHourlyZonalPriceMonthlyClient.getDocHeader());
	}

	@Test
	public void testGetDocBody() {
		assertNotNull(
				"ca.ieso.reports.schema.trapreauctionhzmcpmonthly.DocBody could not be retrieved from XML",
				traHourlyZonalPriceMonthlyClient.getDocBody());
	}
}
