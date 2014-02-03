package name.reidmiller.parseieso.client;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import ca.ieso.reports.schema.realtimemkttotals.Document;

public class RealtimeMarketTotalsClientTest {
	private ApplicationContext appContext;
	private RealtimeMarketTotalsClient realtimeMarketTotalsClient;

	@Before
	public void setUp() throws Exception {
		appContext = new FileSystemXmlApplicationContext(
				"src/resources/spring/applicationContext.xml");
		realtimeMarketTotalsClient = (RealtimeMarketTotalsClient) appContext.getBean("realtimeMarketTotalsClient");
	}

	@Test
	public void testUnmarshal() {
		try {
			assertTrue(
					"Could not unmaral a ca.ieso.reports.schema.realtimemkttotals.Document",
					realtimeMarketTotalsClient.unmarshal() instanceof Document);
		} catch (ClassCastException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetDocHeader() {
		assertNotNull(
				"ca.ieso.reports.schema.realtimemkttotals.DocHeader could not be retrieved from XML",
				realtimeMarketTotalsClient.getDocHeader());
	}

	@Test
	public void testGetDocBody() {
		assertNotNull(
				"ca.ieso.reports.schema.realtimemkttotals.DocBody could not be retrieved from XML",
				realtimeMarketTotalsClient.getDocBody());
	}
}
