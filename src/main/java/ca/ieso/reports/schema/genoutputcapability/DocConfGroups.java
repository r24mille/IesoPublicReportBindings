//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.12.21 at 09:18:50 AM CST 
//


package ca.ieso.reports.schema.genoutputcapability;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.theIMO.com/schema}DocConfGroup"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "docConfGroup"
})
@XmlRootElement(name = "DocConfGroups")
public class DocConfGroups {

    @XmlElement(name = "DocConfGroup", required = true)
    protected String docConfGroup;

    /**
     * Gets the value of the docConfGroup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocConfGroup() {
        return docConfGroup;
    }

    /**
     * Sets the value of the docConfGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocConfGroup(String value) {
        this.docConfGroup = value;
    }

}
