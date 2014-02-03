package name.reidmiller.parseieso.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import ca.ieso.reports.schema.realtimeareareserveconst.Document;

public class RealtimeAreaReserveConstraintsClientTest {
	private ApplicationContext appContext;
	private RealtimeAreaReserveConstraintsClient realtimeAreaReserveConstraintsClient;

	@Before
	public void setUp() throws Exception {
		appContext = new FileSystemXmlApplicationContext(
				"src/resources/spring/applicationContext.xml");
		realtimeAreaReserveConstraintsClient = (RealtimeAreaReserveConstraintsClient) appContext
				.getBean("realtimeAreaReserveConstraintsClient");
	}

	@Test
	public void testUnmarshal() {
		try {
			assertTrue(
					"Could not unmaral a ca.ieso.reports.schema.realtimeareareserveconst.Document",
					realtimeAreaReserveConstraintsClient.unmarshal() instanceof Document);
		} catch (ClassCastException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetDocHeader() {
		assertNotNull(
				"ca.ieso.reports.schema.realtimeareareserveconst.DocHeader could not be retrieved from XML",
				realtimeAreaReserveConstraintsClient.getDocHeader());
	}

	@Test
	public void testGetDocBody() {
		assertNotNull(
				"ca.ieso.reports.schema.realtimeareareserveconst.DocBody could not be retrieved from XML",
				realtimeAreaReserveConstraintsClient.getDocBody());
	}
}
