package name.reidmiller.iesoreports.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import name.reidmiller.iesoreports.client.NetInterchangeSchedulingLimitClient;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import ca.ieso.reports.schema.nislshadowprices.Document;

public class NetInterchangeSchedulingLimitClientTest {
	private ApplicationContext appContext;
	private NetInterchangeSchedulingLimitClient netInterchangeSchedulingLimitClient;

	@Before
	public void setUp() throws Exception {
		appContext = new FileSystemXmlApplicationContext(
				"src/resources/spring/applicationContext.xml");
		netInterchangeSchedulingLimitClient = (NetInterchangeSchedulingLimitClient) appContext
				.getBean("netInterchangeSchedulingLimitClient");
	}

	@Test
	public void testUnmarshal() {
		try {
			assertTrue(
					"Could not unmaral a ca.ieso.reports.schema.nislshadowprices.Document",
					netInterchangeSchedulingLimitClient.unmarshal() instanceof Document);
		} catch (ClassCastException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetDocHeader() {
		assertNotNull(
				"ca.ieso.reports.schema.nislshadowprices.DocHeader could not be retrieved from XML",
				netInterchangeSchedulingLimitClient.getDocHeader());
	}

	@Test
	public void testGetDocBody() {
		assertNotNull(
				"ca.ieso.reports.schema.nislshadowprices.DocBody could not be retrieved from XML",
				netInterchangeSchedulingLimitClient.getDocBody());
	}
}
