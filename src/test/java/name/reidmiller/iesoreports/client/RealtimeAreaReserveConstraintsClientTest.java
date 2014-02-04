package name.reidmiller.iesoreports.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import name.reidmiller.iesoreports.IesoPublicReportBindingsConfig;

import org.junit.Before;
import org.junit.Test;

import ca.ieso.reports.schema.realtimeareareserveconst.Document;

public class RealtimeAreaReserveConstraintsClientTest {
	private RealtimeAreaReserveConstraintsClient realtimeAreaReserveConstraintsClient;

	@Before
	public void setUp() throws Exception {
		realtimeAreaReserveConstraintsClient = IesoPublicReportBindingsConfig
				.realtimeAreaReserveConstraintsClient();
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
