package name.reidmiller.parseieso.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ca.ieso.reports.schema.trapreauctioninterfacehistorymonthly.Document;

public class TrHistoricalInterfaceMonthlyClientTest {
	private ApplicationContext appContext;
	private TrHistoricalInterfaceMonthlyClient trHistoricalInterfaceMonthlyClient;

	@Before
	public void setUp() throws Exception {
		appContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		trHistoricalInterfaceMonthlyClient = (TrHistoricalInterfaceMonthlyClient) appContext
				.getBean("trHistoricalInterfaceMonthlyClient");
	}

	@Test
	public void testUnmarshal() {
		try {
			assertTrue(
					"Could not unmaral a ca.ieso.reports.schema.trapreauctioninterfacehistorymonthly.Document",
					trHistoricalInterfaceMonthlyClient.unmarshal() instanceof Document);
		} catch (ClassCastException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetDocHeader() {
		assertNotNull(
				"ca.ieso.reports.schema.trapreauctioninterfacehistorymonthly.DocHeader could not be retrieved from XML",
				trHistoricalInterfaceMonthlyClient.getDocHeader());
	}

	@Test
	public void testGetDocBody() {
		assertNotNull(
				"ca.ieso.reports.schema.trapreauctioninterfacehistorymonthly.DocBody could not be retrieved from XML",
				trHistoricalInterfaceMonthlyClient.getDocBody());
	}
}
