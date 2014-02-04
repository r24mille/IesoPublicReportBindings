package name.reidmiller.iesoreports.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import name.reidmiller.iesoreports.IesoPublicReportBindingsConfig;

import org.junit.Before;
import org.junit.Test;

import ca.ieso.reports.schema.predispareareserveconst.Document;

public class PredispatchAreaReserveConstraintsClientTest {
	private PredispatchAreaReserveConstraintsClient predispatchAreaReserveConstraintsClient;

	@Before
	public void setUp() throws Exception {
		predispatchAreaReserveConstraintsClient = IesoPublicReportBindingsConfig
				.predispatchAreaReserveConstraintsClient();
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
