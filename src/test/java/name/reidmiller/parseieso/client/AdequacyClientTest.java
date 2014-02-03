package name.reidmiller.parseieso.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import name.reidmiller.parseieso.IesoPublicReportBindingsClientConfig;

import org.junit.Before;
import org.junit.Test;

import ca.ieso.reports.schema.adequacy.Document;

public class AdequacyClientTest {
	private AdequacyClient adequacyClient;

	@Before
	public void setUp() throws Exception {
		adequacyClient = IesoPublicReportBindingsClientConfig.adequacyClient();
	}

	@Test
	public void testUnmarshal() {
		try {
			assertTrue(
					"Could not unmaral a ca.ieso.reports.schema.adequacy.Document",
					adequacyClient.unmarshal() instanceof Document);
		} catch (ClassCastException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetDocHeader() {
		assertNotNull(
				"ca.ieso.reports.schema.adequacy.DocHeader could not be retrieved from XML",
				adequacyClient.getDocHeader());
	}

	@Test
	public void testGetDocBody() {
		assertNotNull(
				"ca.ieso.reports.schema.adequacy.DocBody could not be retrieved from XML",
				adequacyClient.getDocBody());
	}
}
