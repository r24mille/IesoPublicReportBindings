package name.reidmiller.iesoreports.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import name.reidmiller.iesoreports.IesoPublicReportBindingsConfig;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import ca.ieso.reports.schema.uplift.Document;
import ca.ieso.reports.schema.uplift.DocHeader;
import ca.ieso.reports.schema.uplift.DocBody;

public class HourlyUpliftAndIntertieOfferGuaranteeEstimatesClientTest {
	private Logger logger = LogManager.getLogger(this.getClass());
	private HourlyUpliftAndIntertieOfferGuaranteeEstimatesClient hourlyUpliftAndIntertieOfferGuaranteeEstimatesClient;

	@Before
	public void setUp() throws Exception {
		hourlyUpliftAndIntertieOfferGuaranteeEstimatesClient = IesoPublicReportBindingsConfig
				.hourlyUpliftAndIntertieOfferGuaranteeEstimatesClient();
	}

	@Test
	public void testGetDefaultDocument() {
		try {
			assertNotNull(Document.class.getName()
					+ " could not be retrieved from XML",
					hourlyUpliftAndIntertieOfferGuaranteeEstimatesClient.getDefaultDocument());
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
					hourlyUpliftAndIntertieOfferGuaranteeEstimatesClient.getDefaultDocHeader());
		} catch (MalformedURLException e) {
			fail(e.getMessage());
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetDocHeaderForDate() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		Date yesterday = cal.getTime();
		try {
			assertNotNull(DocHeader.class.getName()
					+ " could not be retrieved from XML",
					hourlyUpliftAndIntertieOfferGuaranteeEstimatesClient.getDocHeaderForDate(yesterday));
		} catch (MalformedURLException e) {
			fail(e.getMessage());
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetDocHeadersInDateRange() {
		Calendar calStart = Calendar.getInstance();
		calStart.add(Calendar.DATE, -3);

		try {
			List<DocHeader> docHeaders = hourlyUpliftAndIntertieOfferGuaranteeEstimatesClient
					.getDocHeadersInDateRange(calStart.getTime(), new Date());
			assertNotNull("List of " + DocHeader.class.getName()
					+ " Objects could not be retrieved from XML", docHeaders);
			assertEquals("Unexpected number of " + DocHeader.class.getName()
					+ " Objects returned.", docHeaders.size(), 4);
		} catch (MalformedURLException e) {
			fail(e.getMessage());
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetDocBodiesInDateRange() {
		Calendar calStart = Calendar.getInstance();
		calStart.add(Calendar.DATE, -3);

		try {
			List<DocBody> docBodies = hourlyUpliftAndIntertieOfferGuaranteeEstimatesClient.getDocBodiesInDateRange(
					calStart.getTime(), new Date());
			assertNotNull("List of " + DocBody.class.getName()
					+ " Objects could not be retrieved from XML", docBodies);
			assertEquals("Unexpected number of " + DocBody.class.getName()
					+ " Objects returned.", docBodies.size(), 4);
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
					hourlyUpliftAndIntertieOfferGuaranteeEstimatesClient.getDefaultDocBody());
		} catch (MalformedURLException e) {
			fail(e.getMessage());
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetDocBodyForDate() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		Date yesterday = cal.getTime();
		try {
			assertNotNull(DocBody.class.getName()
					+ " could not be retrieved from XML",
					hourlyUpliftAndIntertieOfferGuaranteeEstimatesClient.getDocBodyForDate(yesterday));
		} catch (MalformedURLException e) {
			fail(e.getMessage());
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}
}
