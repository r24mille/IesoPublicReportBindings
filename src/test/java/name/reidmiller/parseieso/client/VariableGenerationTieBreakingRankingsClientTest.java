package name.reidmiller.parseieso.client;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ca.ieso.reports.schema.vgtiebreakingrankings.Document;

public class VariableGenerationTieBreakingRankingsClientTest {
	private ApplicationContext appContext;
	private VariableGenerationTieBreakingRankingsClient variableGenerationTieBreakingRankingsClient;

	@Before
	public void setUp() throws Exception {
		appContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		variableGenerationTieBreakingRankingsClient = (VariableGenerationTieBreakingRankingsClient) appContext.getBean("variableGenerationTieBreakingRankingsClient");
	}

	@Test
	public void testUnmarshal() {
		try {
			assertTrue(
					"Could not unmaral a ca.ieso.reports.schema.vgtiebreakingrankings.Document",
					variableGenerationTieBreakingRankingsClient.unmarshal() instanceof Document);
		} catch (ClassCastException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetDocHeader() {
		assertNotNull(
				"ca.ieso.reports.schema.vgtiebreakingrankings.DocHeader could not be retrieved from XML",
				variableGenerationTieBreakingRankingsClient.getDocHeader());
	}

	@Test
	public void testGetDocBody() {
		assertNotNull(
				"ca.ieso.reports.schema.vgtiebreakingrankings.DocBody could not be retrieved from XML",
				variableGenerationTieBreakingRankingsClient.getDocBody());
	}
}
