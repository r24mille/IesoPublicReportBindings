package name.reidmiller.parseieso.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ca.ieso.reports.schema.vgforecastsummary.Document;

public class VGForecastSummaryClientTest {
	private ApplicationContext appContext;
	private VGForecastSummaryClient vgForecastSummaryClient;

	@Before
	public void setUp() throws Exception {
		appContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		vgForecastSummaryClient = (VGForecastSummaryClient) appContext
				.getBean("vgForecastSummaryClient");
	}

	@Test
	public void testUnmarshal() {
		try {
			assertTrue("VGForecastSummary did not unmaral an Document",
					vgForecastSummaryClient.unmarshal() instanceof Document);
		} catch (ClassCastException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetDocHeader() {
		assertNotNull("DocHeader could not be retrieved from XML",
				vgForecastSummaryClient.getDocHeader());
	}

	@Test
	public void testGetDocBody() {
		assertNotNull("DocBody could not be retrieved from XML",
				vgForecastSummaryClient.getDocBody());
	}

}
