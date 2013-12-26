package name.reidmiller.parseieso.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ca.ieso.reports.schema.trapreauctionttclt.Document;

public class PreAuctionTransmissionTransferCapabilityLtClientTest {
	private ApplicationContext appContext;
	private PreAuctionTransmissionTransferCapabilityLtClient preAuctionTransmissionTransferCapabilityLtClient;

	@Before
	public void setUp() throws Exception {
		appContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		preAuctionTransmissionTransferCapabilityLtClient = (PreAuctionTransmissionTransferCapabilityLtClient) appContext.getBean("preAuctionTransmissionTransferCapabilityLtClient");
	}

	@Test
	public void testUnmarshal() {
		try {
			assertTrue(
					"Could not unmaral a ca.ieso.reports.schema.trapreauctionttclt.Document",
					preAuctionTransmissionTransferCapabilityLtClient.unmarshal() instanceof Document);
		} catch (ClassCastException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetDocHeader() {
		assertNotNull(
				"ca.ieso.reports.schema.trapreauctionttclt.DocHeader could not be retrieved from XML",
				preAuctionTransmissionTransferCapabilityLtClient.getDocHeader());
	}

	@Test
	public void testGetDocBody() {
		assertNotNull(
				"ca.ieso.reports.schema.trapreauctionttclt.DocBody could not be retrieved from XML",
				preAuctionTransmissionTransferCapabilityLtClient.getDocBody());
	}
}
