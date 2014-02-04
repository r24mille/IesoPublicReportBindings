package name.reidmiller.iesoreports.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import name.reidmiller.iesoreports.client.SurplusBaseloadGenerationClient;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import ca.ieso.reports.schema.sbg.Document;

public class SurplusBaseloadGenerationClientTest {
	private ApplicationContext appContext;
	private SurplusBaseloadGenerationClient surplusBaseloadGenerationClient;

	@Before
	public void setUp() throws Exception {
		appContext = new FileSystemXmlApplicationContext(
				"src/resources/spring/applicationContext.xml");
		surplusBaseloadGenerationClient = (SurplusBaseloadGenerationClient) appContext
				.getBean("surplusBaseloadGenerationClient");
	}

	@Test
	public void testUnmarshal() {
		try {
			assertTrue(
					"Could not unmaral a ca.ieso.reports.schema.sbg.Document",
					surplusBaseloadGenerationClient.unmarshal() instanceof Document);
		} catch (ClassCastException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetDocHeader() {
		assertNotNull(
				"ca.ieso.reports.schema.sbg.DocHeader could not be retrieved from XML",
				surplusBaseloadGenerationClient.getDocHeader());
	}

	@Test
	public void testGetDocBody() {
		assertNotNull(
				"ca.ieso.reports.schema.sbg.Document.DocBody could not be retrieved from XML",
				surplusBaseloadGenerationClient.getDocBody());
	}
}
