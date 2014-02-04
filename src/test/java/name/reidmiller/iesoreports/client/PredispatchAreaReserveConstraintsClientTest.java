package name.reidmiller.iesoreports.client;

import static org.junit.Assert.*;
import name.reidmiller.iesoreports.client.PredispatchAreaReserveConstraintsClient;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import ca.ieso.reports.schema.predispareareserveconst.Document;

public class PredispatchAreaReserveConstraintsClientTest {
	private ApplicationContext appContext;
	private PredispatchAreaReserveConstraintsClient predispatchAreaReserveConstraintsClient;

	@Before
	public void setUp() throws Exception {
		appContext = new FileSystemXmlApplicationContext(
				"src/resources/spring/applicationContext.xml");
		predispatchAreaReserveConstraintsClient = (PredispatchAreaReserveConstraintsClient) appContext.getBean("predispatchAreaReserveConstraintsClient");
	}

	@Test
	public void testUnmarshal() {
		try {
			assertTrue(
					"Could not unmaral a ca.ieso.reports.schema.predispareareserveconst.Document",
					predispatchAreaReserveConstraintsClient.unmarshal() instanceof Document);
		} catch (ClassCastException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetDocHeader() {
		assertNotNull(
				"ca.ieso.reports.schema.predispareareserveconst.DocHeader could not be retrieved from XML",
				predispatchAreaReserveConstraintsClient.getDocHeader());
	}

	@Test
	public void testGetDocBody() {
		assertNotNull(
				"ca.ieso.reports.schema.predispareareserveconst.DocBody could not be retrieved from XML",
				predispatchAreaReserveConstraintsClient.getDocBody());
	}
}
