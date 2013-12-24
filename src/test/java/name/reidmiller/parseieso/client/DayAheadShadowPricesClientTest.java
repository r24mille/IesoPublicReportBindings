package name.reidmiller.parseieso.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ca.ieso.reports.schema.dashadowprices.Document;

public class DayAheadShadowPricesClientTest {
	private ApplicationContext appContext;
	private DayAheadShadowPricesClient dayAheadShadowPricesClient;

	@Before
	public void setUp() throws Exception {
		appContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		dayAheadShadowPricesClient = (DayAheadShadowPricesClient) appContext
				.getBean("dayAheadShadowPricesClient");
	}

	@Test
	public void testUnmarshal() {
		try {
			assertTrue(
					"Could not unmarshal a ca.ieso.reports.schema.dashadowprices.Document",
					dayAheadShadowPricesClient.unmarshal() instanceof Document);
		} catch (ClassCastException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetDocHeader() {
		assertNotNull(
				"ca.ieso.reports.schema.dashadowprices.DocHeader could not be retrieved from XML",
				dayAheadShadowPricesClient.getDocHeader());
	}

	@Test
	public void testGetDocBody() {
		assertNotNull(
				"ca.ieso.reports.schema.dashadowprices.DocBody could not be retrieved from XML",
				dayAheadShadowPricesClient.getDocBody());
	}
}
