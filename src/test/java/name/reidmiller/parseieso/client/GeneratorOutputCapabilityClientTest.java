package name.reidmiller.parseieso.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ca.ieso.reports.schema.genoutputcapability.IMODocument;

public class GeneratorOutputCapabilityClientTest {
	private ApplicationContext appContext;
	private GeneratorOutputCapabilityClient generatorOutputCapabilityClient;

	@Before
	public void setUp() throws Exception {
		appContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		generatorOutputCapabilityClient = (GeneratorOutputCapabilityClient) appContext
				.getBean("generatorOutputCapabilityClient");
	}

	@Test
	public void testUnmarshal() {
		try {
			assertTrue(
					"Could not unmaral a ca.ieso.reports.schema.genoutputcapability.IMODocument",
					generatorOutputCapabilityClient.unmarshal() instanceof IMODocument);
		} catch (ClassCastException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetIMODocHeader() {
		assertNotNull(
				"ca.ieso.reports.schema.genoutputcapability.IMODocHeader could not be retrieved from XML",
				generatorOutputCapabilityClient.getIMODocHeader());
	}

	@Test
	public void testGetIMODocBody() {
		assertNotNull(
				"ca.ieso.reports.schema.genoutputcapability.IMODocBody could not be retrieved from XML",
				generatorOutputCapabilityClient.getIMODocBody());
	}
}
