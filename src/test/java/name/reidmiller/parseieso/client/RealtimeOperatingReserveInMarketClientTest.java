package name.reidmiller.parseieso.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import ca.ieso.reports.schema.realtimeorim.Document;

public class RealtimeOperatingReserveInMarketClientTest {
	private ApplicationContext appContext;
	private RealtimeOperatingReserveInMarketClient realtimeOperatingReserveInMarketClient;

	@Before
	public void setUp() throws Exception {
		appContext = new FileSystemXmlApplicationContext(
				"src/resources/spring/applicationContext.xml");
		realtimeOperatingReserveInMarketClient = (RealtimeOperatingReserveInMarketClient) appContext
				.getBean("realtimeOperatingReserveInMarketClient");
	}

	@Test
	public void testUnmarshal() {
		try {
			assertTrue(
					"Could not unmaral a ca.ieso.reports.schema.realtimeorim.Document",
					realtimeOperatingReserveInMarketClient.unmarshal() instanceof Document);
		} catch (ClassCastException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetDocHeader() {
		assertNotNull(
				"ca.ieso.reports.schema.realtimeorim.DocHeader could not be retrieved from XML",
				realtimeOperatingReserveInMarketClient.getDocHeader());
	}

	@Test
	public void testGetDocBody() {
		assertNotNull(
				"ca.ieso.reports.schema.realtimeorim.DocBody could not be retrieved from XML",
				realtimeOperatingReserveInMarketClient.getDocBody());
	}
}
