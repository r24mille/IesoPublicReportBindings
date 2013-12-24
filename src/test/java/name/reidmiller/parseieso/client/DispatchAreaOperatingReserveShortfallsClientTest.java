package name.reidmiller.parseieso.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ca.ieso.reports.schema.dispareaopresshortfalls.Document;

public class DispatchAreaOperatingReserveShortfallsClientTest {
	private ApplicationContext appContext;
	private DispatchAreaOperatingReserveShortfallsClient dispatchAreaOperatingReserveShortfallsClient;

	@Before
	public void setUp() throws Exception {
		appContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		dispatchAreaOperatingReserveShortfallsClient = (DispatchAreaOperatingReserveShortfallsClient) appContext
				.getBean("dispatchAreaOperatingReserveShortfallsClient");
	}

	@Test
	public void testUnmarshal() {
		try {
			assertTrue(
					"Could not unmarshal a ca.ieso.reports.schema.dispareaopresshortfalls.Document",
					dispatchAreaOperatingReserveShortfallsClient.unmarshal() instanceof Document);
		} catch (ClassCastException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetDocHeader() {
		assertNotNull(
				"ca.ieso.reports.schema.dispareaopresshortfalls.DocHeader could not be retrieved from XML",
				dispatchAreaOperatingReserveShortfallsClient.getDocHeader());
	}

	@Test
	public void testGetDocBody() {
		assertNotNull(
				"ca.ieso.reports.schema.dispareaopresshortfalls.DocBody could not be retrieved from XML",
				dispatchAreaOperatingReserveShortfallsClient.getDocBody());
	}
}
