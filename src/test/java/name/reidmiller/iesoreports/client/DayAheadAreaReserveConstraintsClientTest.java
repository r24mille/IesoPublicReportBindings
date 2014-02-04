package name.reidmiller.iesoreports.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import name.reidmiller.iesoreports.IesoPublicReportBindingsConfig;

import org.junit.Before;
import org.junit.Test;

import ca.ieso.reports.schema.daareareserveconst.Document;

public class DayAheadAreaReserveConstraintsClientTest {
	private DayAheadAreaReserveConstraintsClient dayAheadAreaReserveConstraintsClient;

	@Before
	public void setUp() throws Exception {
		dayAheadAreaReserveConstraintsClient = IesoPublicReportBindingsConfig
				.dayAheadAreaReserveConstraintsClient();
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
