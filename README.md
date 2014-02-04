IESO Public Report Bindings
===========================

Java libraries for parsing public XML reports from Ontario's Independent Electricity System Operator (IESO). The reports are styled nicely for the web and viewable at http://reports.ieso.ca/public/ 

I've now set up a poor-man's Maven repository that I am using for my projects which reference these libraries. To add these libraries as a dependency to your project using maven:

```xml
<repositories>
	<repository>
		<id>IesoPublicReportBindings-mvn-repo</id>	<url>https://raw.github.com/r24mille/IesoPublicReportBindings/mvn-repo/</url>
		<snapshots>
			<enabled>true</enabled>
			<updatePolicy>always</updatePolicy>
		</snapshots>
	</repository>
</repositories>
<dependencies>
	<dependency>
		<groupId>name.reidmiller</groupId>
		<artifactId>ieso-public-report-bindings</artifactId>
		<version>0.0.3-SNAPSHOT</version>
	</dependency>
</dependencies>

This open source project was started by Reid Miller, a graduate student at the University of Waterloo. The libraries have not been reviewed or approved by the IESO. I'm just working with public data and sharing my work.
