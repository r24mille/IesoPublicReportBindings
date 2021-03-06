//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.12.24 at 10:53:36 AM CST 
//


package ca.ieso.reports.schema.predispmktprice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element name="DeliveryDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="IntertieZonalPrices" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="IntertieZoneName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Prices" maxOccurs="4">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="PriceType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="HourlyPrice" maxOccurs="24">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="DeliveryHour" type="{http://www.ieso.ca/schema}Hour1To24"/>
 *                                       &lt;element name="MCP" type="{http://www.ieso.ca/schema}Money"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
    "deliveryDate",
    "intertieZonalPrices"
})
@XmlRootElement(name = "DocBody")
public class DocBody {

    @XmlElement(name = "DeliveryDate", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar deliveryDate;
    @XmlElement(name = "IntertieZonalPrices", required = true)
    protected List<DocBody.IntertieZonalPrices> intertieZonalPrices;

    /**
     * Gets the value of the deliveryDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDeliveryDate() {
        return deliveryDate;
    }

    /**
     * Sets the value of the deliveryDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDeliveryDate(XMLGregorianCalendar value) {
        this.deliveryDate = value;
    }

    /**
     * Gets the value of the intertieZonalPrices property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the intertieZonalPrices property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIntertieZonalPrices().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DocBody.IntertieZonalPrices }
     * 
     * 
     */
    public List<DocBody.IntertieZonalPrices> getIntertieZonalPrices() {
        if (intertieZonalPrices == null) {
            intertieZonalPrices = new ArrayList<DocBody.IntertieZonalPrices>();
        }
        return this.intertieZonalPrices;
    }


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
     *         &lt;element name="IntertieZoneName" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Prices" maxOccurs="4">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="PriceType" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="HourlyPrice" maxOccurs="24">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="DeliveryHour" type="{http://www.ieso.ca/schema}Hour1To24"/>
     *                             &lt;element name="MCP" type="{http://www.ieso.ca/schema}Money"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
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
        "intertieZoneName",
        "prices"
    })
    public static class IntertieZonalPrices {

        @XmlElement(name = "IntertieZoneName", required = true)
        protected String intertieZoneName;
        @XmlElement(name = "Prices", required = true)
        protected List<DocBody.IntertieZonalPrices.Prices> prices;

        /**
         * Gets the value of the intertieZoneName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getIntertieZoneName() {
            return intertieZoneName;
        }

        /**
         * Sets the value of the intertieZoneName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setIntertieZoneName(String value) {
            this.intertieZoneName = value;
        }

        /**
         * Gets the value of the prices property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the prices property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getPrices().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link DocBody.IntertieZonalPrices.Prices }
         * 
         * 
         */
        public List<DocBody.IntertieZonalPrices.Prices> getPrices() {
            if (prices == null) {
                prices = new ArrayList<DocBody.IntertieZonalPrices.Prices>();
            }
            return this.prices;
        }


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
         *         &lt;element name="PriceType" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="HourlyPrice" maxOccurs="24">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="DeliveryHour" type="{http://www.ieso.ca/schema}Hour1To24"/>
         *                   &lt;element name="MCP" type="{http://www.ieso.ca/schema}Money"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
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
            "priceType",
            "hourlyPrice"
        })
        public static class Prices {

            @XmlElement(name = "PriceType", required = true)
            protected String priceType;
            @XmlElement(name = "HourlyPrice", required = true)
            protected List<DocBody.IntertieZonalPrices.Prices.HourlyPrice> hourlyPrice;

            /**
             * Gets the value of the priceType property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPriceType() {
                return priceType;
            }

            /**
             * Sets the value of the priceType property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPriceType(String value) {
                this.priceType = value;
            }

            /**
             * Gets the value of the hourlyPrice property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the hourlyPrice property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getHourlyPrice().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link DocBody.IntertieZonalPrices.Prices.HourlyPrice }
             * 
             * 
             */
            public List<DocBody.IntertieZonalPrices.Prices.HourlyPrice> getHourlyPrice() {
                if (hourlyPrice == null) {
                    hourlyPrice = new ArrayList<DocBody.IntertieZonalPrices.Prices.HourlyPrice>();
                }
                return this.hourlyPrice;
            }


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
             *         &lt;element name="DeliveryHour" type="{http://www.ieso.ca/schema}Hour1To24"/>
             *         &lt;element name="MCP" type="{http://www.ieso.ca/schema}Money"/>
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
                "deliveryHour",
                "mcp"
            })
            public static class HourlyPrice {

                @XmlElement(name = "DeliveryHour")
                protected int deliveryHour;
                @XmlElement(name = "MCP", required = true)
                protected BigDecimal mcp;

                /**
                 * Gets the value of the deliveryHour property.
                 * 
                 */
                public int getDeliveryHour() {
                    return deliveryHour;
                }

                /**
                 * Sets the value of the deliveryHour property.
                 * 
                 */
                public void setDeliveryHour(int value) {
                    this.deliveryHour = value;
                }

                /**
                 * Gets the value of the mcp property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigDecimal }
                 *     
                 */
                public BigDecimal getMCP() {
                    return mcp;
                }

                /**
                 * Sets the value of the mcp property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigDecimal }
                 *     
                 */
                public void setMCP(BigDecimal value) {
                    this.mcp = value;
                }

            }

        }

    }

}
