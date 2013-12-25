//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.12.25 at 12:17:51 PM CST 
//


package ca.ieso.reports.schema.trapostauctionmcpltr1;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element ref="{http://www.ieso.ca/schema}DocTitle"/>
 *         &lt;element ref="{http://www.ieso.ca/schema}DocRevision"/>
 *         &lt;element ref="{http://www.ieso.ca/schema}DocConfidentiality"/>
 *         &lt;element ref="{http://www.ieso.ca/schema}CreatedAt"/>
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
    "docTitle",
    "docRevision",
    "docConfidentiality",
    "createdAt"
})
@XmlRootElement(name = "DocHeader")
public class DocHeader {

    @XmlElement(name = "DocTitle", required = true)
    protected String docTitle;
    @XmlElement(name = "DocRevision", required = true)
    protected BigInteger docRevision;
    @XmlElement(name = "DocConfidentiality", required = true)
    protected DocConfidentiality docConfidentiality;
    @XmlElement(name = "CreatedAt", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar createdAt;

    /**
     * Gets the value of the docTitle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocTitle() {
        return docTitle;
    }

    /**
     * Sets the value of the docTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocTitle(String value) {
        this.docTitle = value;
    }

    /**
     * Gets the value of the docRevision property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getDocRevision() {
        return docRevision;
    }

    /**
     * Sets the value of the docRevision property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setDocRevision(BigInteger value) {
        this.docRevision = value;
    }

    /**
     * Gets the value of the docConfidentiality property.
     * 
     * @return
     *     possible object is
     *     {@link DocConfidentiality }
     *     
     */
    public DocConfidentiality getDocConfidentiality() {
        return docConfidentiality;
    }

    /**
     * Sets the value of the docConfidentiality property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocConfidentiality }
     *     
     */
    public void setDocConfidentiality(DocConfidentiality value) {
        this.docConfidentiality = value;
    }

    /**
     * Gets the value of the createdAt property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets the value of the createdAt property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreatedAt(XMLGregorianCalendar value) {
        this.createdAt = value;
    }

}
