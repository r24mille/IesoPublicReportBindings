package name.reidmiller.parseieso;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ca.ieso.reports.schema.daadequacy.DocBody.System.Demands.AverageDemand;
import ca.ieso.reports.schema.daadequacy.HourlyValue;
import name.reidmiller.parseieso.client.DayAheadAdequacyClient;

public class Main {

	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		DayAheadAdequacyClient dayAheadAdequacyClient = (DayAheadAdequacyClient) appContext.getBean("dayAheadAdequacyClient");
		List<ca.ieso.reports.schema.daadequacy.DocBody.System> systems = dayAheadAdequacyClient.getDocBody().getSystem();
		for (ca.ieso.reports.schema.daadequacy.DocBody.System system : systems) {
			System.out.println("System Name: " + system.getSystemName());
			AverageDemand averageDemand = system.getDemands().getAverageDemand();
			if (averageDemand != null) {
				List<HourlyValue> avgHourlyDemands = averageDemand.getDemand();
				if (avgHourlyDemands != null) {
					for (HourlyValue hourlyValue : avgHourlyDemands) {
						System.out.println("  Hour " + hourlyValue.getDeliveryHour() + ": " + hourlyValue.getEnergyMW() + "MW");
					}
				} else {
					System.out.println("Average HourlyDemand list is null");
				}
			} else {
				System.out.println("AverageDemand is null.");
			}
		}
	}

}
