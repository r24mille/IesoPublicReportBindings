package name.reidmiller.parseieso.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import ca.ieso.reports.schema.predispmkttotals.Document;

public class PredispatchMarketTotalsClientTest {
	private ApplicationContext appContext;
	private PredispatchMarketTotalsClient predispatchMarketTotalsClient;

	@Before
	public void setUp() throws Exception {
		appContext = new FileSystemXmlApplicationContext(
				"src/resources/spring/applicationContext.xml");
		predispatchMarketTotalsClient = (PredispatchMarketTotalsClient) appContext
				.getBean("predispatchMarketTotalsClient");
	}

	@Test
	public void testUnmarshal() {
		try {
			assertTrue(
					"Could not unmaral a ca.ieso.reports.schema.predispmkttotals.Document",
					predispatchMarketTotalsClient.unmarshal() instanceof Document);
		} catch (ClassCastException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetDocHeader() {
		assertNotNull(
				"ca.ieso.reports.schema.predispmkttotals.DocHeader could not be retrieved from XML",
				predispatchMarketTotalsClient.getDocHeader());
	}

	@Test
	public void testGetDocBody() {
		assertNotNull(
				"ca.ieso.reports.schema.predispmkttotals.DocBody could not be retrieved from XML",
				predispatchMarketTotalsClient.getDocBody());
	}
}
