package name.reidmiller.iesoreports.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import name.reidmiller.iesoreports.client.RealtimeShadowPricesClient;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import ca.ieso.reports.schema.realtimeshadowprices.Document;

public class RealtimeShadowPricesClientTest {
	private ApplicationContext appContext;
	private RealtimeShadowPricesClient realtimeShadowPricesClient;

	@Before
	public void setUp() throws Exception {
		appContext = new FileSystemXmlApplicationContext(
				"src/resources/spring/applicationContext.xml");
		realtimeShadowPricesClient = (RealtimeShadowPricesClient) appContext
				.getBean("realtimeShadowPricesClient");
	}

	@Test
	public void testUnmarshal() {
		try {
			assertTrue(
					"Could not unmaral a ca.ieso.reports.schema.realtimeshadowprices.Document",
					realtimeShadowPricesClient.unmarshal() instanceof Document);
		} catch (ClassCastException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetDocHeader() {
		assertNotNull(
				"ca.ieso.reports.schema.realtimeshadowprices.DocHeader could not be retrieved from XML",
				realtimeShadowPricesClient.getDocHeader());
	}

	@Test
	public void testGetDocBody() {
		assertNotNull(
				"ca.ieso.reports.schema.realtimeshadowprices.DocBody could not be retrieved from XML",
				realtimeShadowPricesClient.getDocBody());
	}
}
