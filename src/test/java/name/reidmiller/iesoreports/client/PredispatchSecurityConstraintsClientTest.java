package name.reidmiller.iesoreports.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import name.reidmiller.iesoreports.IesoPublicReportBindingsConfig;

import org.junit.Before;
import org.junit.Test;

import ca.ieso.reports.schema.predispsecurityconstraints.Document;

public class PredispatchSecurityConstraintsClientTest {
	private PredispatchSecurityConstraintsClient predispatchSecurityConstraintsClient;

	@Before
	public void setUp() throws Exception {
		predispatchSecurityConstraintsClient = IesoPublicReportBindingsConfig
				.predispatchSecurityConstraintsClient();
	}

	@Test
	public void testUnmarshal() {
		try {
			assertTrue(
					"Could not unmaral a ca.ieso.reports.schema.predispsecurityconstraints.Document",
					predispatchSecurityConstraintsClient.unmarshal() instanceof Document);
		} catch (ClassCastException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetDocHeader() {
		assertNotNull(
				"ca.ieso.reports.schema.predispsecurityconstraints.DocHeader could not be retrieved from XML",
				predispatchSecurityConstraintsClient.getDocHeader());
	}

	@Test
	public void testGetDocBody() {
		assertNotNull(
				"ca.ieso.reports.schema.predispsecurityconstraints.DocBody could not be retrieved from XML",
				predispatchSecurityConstraintsClient.getDocBody());
	}
}
