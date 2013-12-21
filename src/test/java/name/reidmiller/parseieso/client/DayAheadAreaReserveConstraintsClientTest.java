package name.reidmiller.parseieso.client;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ca.ieso.reports.schema.daareareserveconst.Document;

public class DayAheadAreaReserveConstraintsClientTest {
	private ApplicationContext appContext;
	private DayAheadAreaReserveConstraintsClient dayAheadAreaReserveConstraintsClient;

	@Before
	public void setUp() throws Exception {
		appContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		dayAheadAreaReserveConstraintsClient = (DayAheadAreaReserveConstraintsClient) appContext.getBean("dayAheadAreaReserveConstraintsClient");
	}

	@Test
	public void testUnmarshal() {
		try {
			assertTrue(
					"AdequacyClient did not unmaral a ca.ieso.reports.schema.daareareserveconst.Document",
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
