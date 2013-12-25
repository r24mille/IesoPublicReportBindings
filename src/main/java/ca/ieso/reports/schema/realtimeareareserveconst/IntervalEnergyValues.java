//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.12.25 at 12:17:45 PM CST 
//


package ca.ieso.reports.schema.realtimeareareserveconst;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IntervalEnergyValues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IntervalEnergyValues">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Interval" type="{http://www.ieso.ca/schema}Interval"/>
 *         &lt;element name="EnergyMW" type="{http://www.ieso.ca/schema}MW_decimal5.1"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IntervalEnergyValues", propOrder = {
    "interval",
    "energyMW"
})
@XmlSeeAlso({
    ca.ieso.reports.schema.realtimeareareserveconst.DocBody.RegionalAreaEnergies.IntervalEnergies.IntervalEnergy.class
})
public class IntervalEnergyValues {

    @XmlElement(name = "Interval")
    protected int interval;
    @XmlElement(name = "EnergyMW", required = true)
    protected BigDecimal energyMW;

    /**
     * Gets the value of the interval property.
     * 
     */
    public int getInterval() {
        return interval;
    }

    /**
     * Sets the value of the interval property.
     * 
     */
    public void setInterval(int value) {
        this.interval = value;
    }

    /**
     * Gets the value of the energyMW property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getEnergyMW() {
        return energyMW;
    }

    /**
     * Sets the value of the energyMW property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setEnergyMW(BigDecimal value) {
        this.energyMW = value;
    }

}
