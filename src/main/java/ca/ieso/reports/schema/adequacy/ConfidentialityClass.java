//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.12.21 at 09:18:52 AM CST 
//


package ca.ieso.reports.schema.adequacy;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ConfidentialityClass.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ConfidentialityClass">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PUB"/>
 *     &lt;enumeration value="CNF"/>
 *     &lt;enumeration value="HCNF"/>
 *     &lt;enumeration value="INT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ConfidentialityClass")
@XmlEnum
public enum ConfidentialityClass {

    PUB,
    CNF,
    HCNF,
    INT;

    public String value() {
        return name();
    }

    public static ConfidentialityClass fromValue(String v) {
        return valueOf(v);
    }

}
