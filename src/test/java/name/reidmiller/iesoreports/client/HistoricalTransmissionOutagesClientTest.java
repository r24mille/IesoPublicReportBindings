package name.reidmiller.iesoreports.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.net.MalformedURLException;

import name.reidmiller.iesoreports.IesoPublicReportBindingsConfig;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import ca.ieso.reports.schema.iomspublichistoricoutagehour.DocBody;
import ca.ieso.reports.schema.iomspublichistoricoutagehour.DocHeader;
import ca.ieso.reports.schema.iomspublichistoricoutagehour.Document;

public class HistoricalTransmissionOutagesClientTest {
	private Logger logger = LogManager.getLogger(this.getClass());
	private HistoricalTransmissionOutagesClient historicalTransmissionOutagesClient;

	@Before
	public void setUp() throws Exception {
		historicalTransmissionOutagesClient = IesoPublicReportBindingsConfig
				.historicalTransmissionOutagesClient();
	}

	@Test
	public void testGetDefaultDocument() {
		try {
			assertNotNull(Document.class.getName()
					+ " could not be retrieved from XML",
					historicalTransmissionOutagesClient.getDefaultDocument());
		} catch (MalformedURLException e) {
			fail(e.getMessage());
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetDefaultDocHeader() {
		try {
			assertNotNull(DocHeader.class.getName()
					+ " could not be retrieved from XML",
					historicalTransmissionOutagesClient.getDefaultDocHeader());
		} catch (MalformedURLException e) {
			fail(e.getMessage());
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetDefaultDocBody() {
		try {
			assertNotNull(DocBody.class.getName()
					+ " could not be retrieved from XML",
					historicalTransmissionOutagesClient.getDefaultDocBody());
		} catch (MalformedURLException e) {
			fail(e.getMessage());
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}
}