package name.reidmiller.iesoreports;

import java.net.MalformedURLException;
import java.net.URL;

import name.reidmiller.iesoreports.client.AdequacyClient;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class IesoPublicReportBindingsConfig {
	static Logger logger = LogManager
			.getLogger(IesoPublicReportBindingsConfig.class.getName());

	@Bean
	public static AdequacyClient adequacyClient() {
		AdequacyClient adequacyClient = null;
		try {
			adequacyClient = new AdequacyClient(
					buildURL("http://reports.ieso.ca/public/Adequacy/PUB_Adequacy.xml"),
					buildMarshaller("ca.ieso.reports.schema.adequacy"),
					buildMarshaller("ca.ieso.reports.schema.adequacy"));
		} catch (MalformedURLException e) {
			logger.error(e.getLocalizedMessage());
		}

		return adequacyClient;
	}

	private static Jaxb2Marshaller buildMarshaller(String contextPath) {
		Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
		jaxb2Marshaller.setContextPath(contextPath);
		return jaxb2Marshaller;
	}

	private static URL buildURL(String urlString) throws MalformedURLException {
		URL url = new URL(
				"http://reports.ieso.ca/public/Adequacy/PUB_Adequacy.xml");
		return url;
	}
}
