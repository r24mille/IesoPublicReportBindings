package name.reidmiller.parseieso.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ca.ieso.reports.schema.predispsecurityconstraints.Document;

public class PredispatchSecurityConstraintsClientTest {
	private ApplicationContext appContext;
	private PredispatchSecurityConstraintsClient predispatchSecurityConstraintsClient;

	@Before
	public void setUp() throws Exception {
		appContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		predispatchSecurityConstraintsClient = (PredispatchSecurityConstraintsClient) appContext.getBean("predispatchSecurityConstraintsClient");
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
