package name.reidmiller.iesoreports.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import name.reidmiller.iesoreports.client.DayAheadConstrainedTotalsClient;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import ca.ieso.reports.schema.daconsttotals.Document;

public class DayAheadConstrainedTotalsClientTest {
	private ApplicationContext appContext;
	private DayAheadConstrainedTotalsClient dayAheadConstrainedTotalsClient;

	@Before
	public void setUp() throws Exception {
		appContext = new FileSystemXmlApplicationContext(
				"src/resources/spring/applicationContext.xml");
		dayAheadConstrainedTotalsClient = (DayAheadConstrainedTotalsClient) appContext
				.getBean("dayAheadConstrainedTotalsClient");
	}

	@Test
	public void testUnmarshal() {
		try {
			assertTrue(
					"Could not unmarshal a ca.ieso.reports.schema.daconsttotals.Document",
					dayAheadConstrainedTotalsClient.unmarshal() instanceof Document);
		} catch (ClassCastException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetDocHeader() {
		assertNotNull(
				"ca.ieso.reports.schema.daconsttotals.DocHeader could not be retrieved from XML",
				dayAheadConstrainedTotalsClient.getDocHeader());
	}

	@Test
	public void testGetDocBody() {
		assertNotNull(
				"ca.ieso.reports.schema.daconsttotals.DocBody could not be retrieved from XML",
				dayAheadConstrainedTotalsClient.getDocBody());
	}

}
