package name.reidmiller.parseieso.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ca.ieso.reports.schema.genoutputcapability.IMODocument;

public class GenOutputCapabilityClientTest {
	private ApplicationContext appContext;
	private GenOutputCapabilityClient genOutputCapabilityClient;

	@Before
	public void setUp() throws Exception {
		appContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		genOutputCapabilityClient = (GenOutputCapabilityClient) appContext
				.getBean("genOutputCapabilityClient");
	}

	@Test
	public void testUnmarshal() {
		try {
			assertTrue(
					"GenOutputCapability did not unmaral an IMODocument",
					genOutputCapabilityClient.unmarshal() instanceof IMODocument);
		} catch (ClassCastException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetIMODocHeader() {
		assertNotNull("IMODocHeader could not be retrieved from XML",
				genOutputCapabilityClient.getIMODocHeader());
	}

	@Test
	public void testGetIMODocBody() {
		assertNotNull("IMODocBody could not be retrieved from XML",
				genOutputCapabilityClient.getIMODocBody());
	}
}
