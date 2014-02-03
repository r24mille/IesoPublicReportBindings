package name.reidmiller.parseieso.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import ca.ieso.reports.schema.globaladjustment.Document;

public class GlobalAdjustmentRatesClientTest {
	private ApplicationContext appContext;
	private GlobalAdjustmentRatesClient globalAdjustmentRatesClient;

	@Before
	public void setUp() throws Exception {
		appContext = new FileSystemXmlApplicationContext(
				"src/resources/spring/applicationContext.xml");
		globalAdjustmentRatesClient = (GlobalAdjustmentRatesClient) appContext
				.getBean("globalAdjustmentRatesClient");
	}

	@Test
	public void testUnmarshal() {
		try {
			assertTrue(
					"Could not unmarshal a ca.ieso.reports.schema.globaladjustment.Document",
					globalAdjustmentRatesClient.unmarshal() instanceof Document);
		} catch (ClassCastException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetDocHeader() {
		assertNotNull(
				"ca.ieso.reports.schema.globaladjustment.DocHeader could not be retrieved from XML",
				globalAdjustmentRatesClient.getDocHeader());
	}

	@Test
	public void testGetDocBody() {
		assertNotNull(
				"ca.ieso.reports.schema.globaladjustment.DocBody could not be retrieved from XML",
				globalAdjustmentRatesClient.getDocBody());
	}
}
