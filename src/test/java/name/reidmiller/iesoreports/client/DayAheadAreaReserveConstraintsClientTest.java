package name.reidmiller.iesoreports.client;

import static org.junit.Assert.*;
import name.reidmiller.iesoreports.client.DayAheadAreaReserveConstraintsClient;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import ca.ieso.reports.schema.daareareserveconst.Document;

public class DayAheadAreaReserveConstraintsClientTest {
	private ApplicationContext appContext;
	private DayAheadAreaReserveConstraintsClient dayAheadAreaReserveConstraintsClient;

	@Before
	public void setUp() throws Exception {
		appContext = new FileSystemXmlApplicationContext(
				"src/resources/spring/applicationContext.xml");
		dayAheadAreaReserveConstraintsClient = (DayAheadAreaReserveConstraintsClient) appContext.getBean("dayAheadAreaReserveConstraintsClient");
	}

	@Test
	public void testUnmarshal() {
		try {
			assertTrue(
					"Could not unmarshal a ca.ieso.reports.schema.daareareserveconst.Document",
					dayAheadAreaReserveConstraintsClient.unmarshal() instanceof Document);
		} catch (ClassCastException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetDocHeader() {
		assertNotNull(
				"ca.ieso.reports.schema.daareareserveconst.DocHeader could not be retrieved from XML",
				dayAheadAreaReserveConstraintsClient.getDocHeader());
	}

	@Test
	public void testGetDocBody() {
		assertNotNull(
				"ca.ieso.reports.schema.daareareserveconst.DocBody could not be retrieved from XML",
				dayAheadAreaReserveConstraintsClient.getDocBody());
	}
}
