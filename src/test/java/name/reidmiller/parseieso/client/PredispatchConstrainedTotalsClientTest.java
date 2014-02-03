package name.reidmiller.parseieso.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import ca.ieso.reports.schema.predispconsttotals.Document;

public class PredispatchConstrainedTotalsClientTest {
	private ApplicationContext appContext;
	private PredispatchConstrainedTotalsClient predispatchConstrainedTotalsClient;

	@Before
	public void setUp() throws Exception {
		appContext = new FileSystemXmlApplicationContext(
				"src/resources/spring/applicationContext.xml");
		predispatchConstrainedTotalsClient = (PredispatchConstrainedTotalsClient) appContext
				.getBean("predispatchConstrainedTotalsClient");
	}

	@Test
	public void testUnmarshal() {
		try {
			assertTrue(
					"Could not unmaral a ca.ieso.reports.schema.predispconsttotals.Document",
					predispatchConstrainedTotalsClient.unmarshal() instanceof Document);
		} catch (ClassCastException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetDocHeader() {
		assertNotNull(
				"ca.ieso.reports.schema.predispconsttotals.DocHeader could not be retrieved from XML",
				predispatchConstrainedTotalsClient.getDocHeader());
	}

	@Test
	public void testGetDocBody() {
		assertNotNull(
				"ca.ieso.reports.schema.predispconsttotals.DocBody could not be retrieved from XML",
				predispatchConstrainedTotalsClient.getDocBody());
	}
}
