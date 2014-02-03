package name.reidmiller.parseieso.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import ca.ieso.reports.schema.realtimeconsttotals.Document;

public class RealtimeConstrainedTotalsClientTest {
	private ApplicationContext appContext;
	private RealtimeConstrainedTotalsClient realtimeConstrainedTotalsClient;

	@Before
	public void setUp() throws Exception {
		appContext = new FileSystemXmlApplicationContext(
				"src/resources/spring/applicationContext.xml");
		realtimeConstrainedTotalsClient = (RealtimeConstrainedTotalsClient) appContext
				.getBean("realtimeConstrainedTotalsClient");
	}

	@Test
	public void testUnmarshal() {
		try {
			assertTrue(
					"Could not unmaral a ca.ieso.reports.schema.realtimeconsttotals.Document",
					realtimeConstrainedTotalsClient.unmarshal() instanceof Document);
		} catch (ClassCastException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetDocHeader() {
		assertNotNull(
				"ca.ieso.reports.schema.realtimeconsttotals.DocHeader could not be retrieved from XML",
				realtimeConstrainedTotalsClient.getDocHeader());
	}

	@Test
	public void testGetDocBody() {
		assertNotNull(
				"ca.ieso.reports.schema.realtimeconsttotals.DocBody could not be retrieved from XML",
				realtimeConstrainedTotalsClient.getDocBody());
	}
}
