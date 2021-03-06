//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.12.24 at 10:52:41 AM CST 
//


package ca.ieso.reports.schema.intertiescheduleflow;

import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ca.ieso.reports.schema.intertiescheduleflow package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _DocConfGroup_QNAME = new QName("http://www.theIMO.com/schema", "DocConfGroup");
    private final static QName _DocRevision_QNAME = new QName("http://www.theIMO.com/schema", "DocRevision");
    private final static QName _Hour_QNAME = new QName("http://www.theIMO.com/schema", "Hour");
    private final static QName _Interval_QNAME = new QName("http://www.theIMO.com/schema", "Interval");
    private final static QName _CreatedAt_QNAME = new QName("http://www.theIMO.com/schema", "CreatedAt");
    private final static QName _DocTitle_QNAME = new QName("http://www.theIMO.com/schema", "DocTitle");
    private final static QName _DocConfClass_QNAME = new QName("http://www.theIMO.com/schema", "DocConfClass");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ca.ieso.reports.schema.intertiescheduleflow
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link IMODocBody }
     * 
     */
    public IMODocBody createIMODocBody() {
        return new IMODocBody();
    }

    /**
     * Create an instance of {@link IMODocBody.Totals }
     * 
     */
    public IMODocBody.Totals createIMODocBodyTotals() {
        return new IMODocBody.Totals();
    }

    /**
     * Create an instance of {@link IMODocBody.Totals.Actuals }
     * 
     */
    public IMODocBody.Totals.Actuals createIMODocBodyTotalsActuals() {
        return new IMODocBody.Totals.Actuals();
    }

    /**
     * Create an instance of {@link IMODocBody.Totals.Schedules }
     * 
     */
    public IMODocBody.Totals.Schedules createIMODocBodyTotalsSchedules() {
        return new IMODocBody.Totals.Schedules();
    }

    /**
     * Create an instance of {@link IMODocBody.IntertieZone }
     * 
     */
    public IMODocBody.IntertieZone createIMODocBodyIntertieZone() {
        return new IMODocBody.IntertieZone();
    }

    /**
     * Create an instance of {@link IMODocBody.IntertieZone.Actuals }
     * 
     */
    public IMODocBody.IntertieZone.Actuals createIMODocBodyIntertieZoneActuals() {
        return new IMODocBody.IntertieZone.Actuals();
    }

    /**
     * Create an instance of {@link IMODocBody.IntertieZone.Schedules }
     * 
     */
    public IMODocBody.IntertieZone.Schedules createIMODocBodyIntertieZoneSchedules() {
        return new IMODocBody.IntertieZone.Schedules();
    }

    /**
     * Create an instance of {@link DocConfidentiality }
     * 
     */
    public DocConfidentiality createDocConfidentiality() {
        return new DocConfidentiality();
    }

    /**
     * Create an instance of {@link DocConfGroups }
     * 
     */
    public DocConfGroups createDocConfGroups() {
        return new DocConfGroups();
    }

    /**
     * Create an instance of {@link IMODocument }
     * 
     */
    public IMODocument createIMODocument() {
        return new IMODocument();
    }

    /**
     * Create an instance of {@link IMODocHeader }
     * 
     */
    public IMODocHeader createIMODocHeader() {
        return new IMODocHeader();
    }

    /**
     * Create an instance of {@link IMODocBody.Totals.Actuals.Actual }
     * 
     */
    public IMODocBody.Totals.Actuals.Actual createIMODocBodyTotalsActualsActual() {
        return new IMODocBody.Totals.Actuals.Actual();
    }

    /**
     * Create an instance of {@link IMODocBody.Totals.Schedules.Schedule }
     * 
     */
    public IMODocBody.Totals.Schedules.Schedule createIMODocBodyTotalsSchedulesSchedule() {
        return new IMODocBody.Totals.Schedules.Schedule();
    }

    /**
     * Create an instance of {@link IMODocBody.IntertieZone.Actuals.Actual }
     * 
     */
    public IMODocBody.IntertieZone.Actuals.Actual createIMODocBodyIntertieZoneActualsActual() {
        return new IMODocBody.IntertieZone.Actuals.Actual();
    }

    /**
     * Create an instance of {@link IMODocBody.IntertieZone.Schedules.Schedule }
     * 
     */
    public IMODocBody.IntertieZone.Schedules.Schedule createIMODocBodyIntertieZoneSchedulesSchedule() {
        return new IMODocBody.IntertieZone.Schedules.Schedule();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.theIMO.com/schema", name = "DocConfGroup")
    public JAXBElement<String> createDocConfGroup(String value) {
        return new JAXBElement<String>(_DocConfGroup_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.theIMO.com/schema", name = "DocRevision")
    public JAXBElement<BigInteger> createDocRevision(BigInteger value) {
        return new JAXBElement<BigInteger>(_DocRevision_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.theIMO.com/schema", name = "Hour")
    public JAXBElement<Integer> createHour(Integer value) {
        return new JAXBElement<Integer>(_Hour_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.theIMO.com/schema", name = "Interval")
    public JAXBElement<Integer> createInterval(Integer value) {
        return new JAXBElement<Integer>(_Interval_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.theIMO.com/schema", name = "CreatedAt")
    public JAXBElement<XMLGregorianCalendar> createCreatedAt(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_CreatedAt_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.theIMO.com/schema", name = "DocTitle")
    public JAXBElement<String> createDocTitle(String value) {
        return new JAXBElement<String>(_DocTitle_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConfidentialityClass }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.theIMO.com/schema", name = "DocConfClass")
    public JAXBElement<ConfidentialityClass> createDocConfClass(ConfidentialityClass value) {
        return new JAXBElement<ConfidentialityClass>(_DocConfClass_QNAME, ConfidentialityClass.class, null, value);
    }

}
