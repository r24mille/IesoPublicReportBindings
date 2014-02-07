package name.reidmiller.iesoreports.client;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

public class IesoPublicReportClientUtil {
	protected static Logger logger = LogManager
			.getLogger(IesoPublicReportClientUtil.class);
	
	public static Jaxb2Marshaller buildMarshaller(String contextPath) {
		Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
		jaxb2Marshaller.setContextPath(contextPath);
		return jaxb2Marshaller;
	}
}
