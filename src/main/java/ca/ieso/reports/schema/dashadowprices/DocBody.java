//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.12.21 at 09:18:59 AM CST 
//


package ca.ieso.reports.schema.dashadowprices;

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
 *         &lt;element name="NodePrices" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="NodeName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="HourlyPrices" maxOccurs="24">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="DeliveryHour" type="{http://www.ieso.ca/schema}Hour1To24"/>
 *                             &lt;element name="Prices" maxOccurs="4">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="PriceType" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "nodePrices"
})
@XmlRootElement(name = "DocBody")
public class DocBody {

    @XmlElement(name = "DeliveryDate", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar deliveryDate;
    @XmlElement(name = "NodePrices", required = true)
    protected List<DocBody.NodePrices> nodePrices;

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
     * Gets the value of the nodePrices property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nodePrices property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNodePrices().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DocBody.NodePrices }
     * 
     * 
     */
    public List<DocBody.NodePrices> getNodePrices() {
        if (nodePrices == null) {
            nodePrices = new ArrayList<DocBody.NodePrices>();
        }
        return this.nodePrices;
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
     *         &lt;element name="NodeName" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="HourlyPrices" maxOccurs="24">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="DeliveryHour" type="{http://www.ieso.ca/schema}Hour1To24"/>
     *                   &lt;element name="Prices" maxOccurs="4">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="PriceType" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "nodeName",
        "hourlyPrices"
    })
    public static class NodePrices {

        @XmlElement(name = "NodeName", required = true)
        protected String nodeName;
        @XmlElement(name = "HourlyPrices", required = true)
        protected List<DocBody.NodePrices.HourlyPrices> hourlyPrices;

        /**
         * Gets the value of the nodeName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNodeName() {
            return nodeName;
        }

        /**
         * Sets the value of the nodeName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNodeName(String value) {
            this.nodeName = value;
        }

        /**
         * Gets the value of the hourlyPrices property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the hourlyPrices property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getHourlyPrices().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link DocBody.NodePrices.HourlyPrices }
         * 
         * 
         */
        public List<DocBody.NodePrices.HourlyPrices> getHourlyPrices() {
            if (hourlyPrices == null) {
                hourlyPrices = new ArrayList<DocBody.NodePrices.HourlyPrices>();
            }
            return this.hourlyPrices;
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
         *         &lt;element name="Prices" maxOccurs="4">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="PriceType" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
            "deliveryHour",
            "prices"
        })
        public static class HourlyPrices {

            @XmlElement(name = "DeliveryHour")
            protected int deliveryHour;
            @XmlElement(name = "Prices", required = true)
            protected List<DocBody.NodePrices.HourlyPrices.Prices> prices;

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
             * {@link DocBody.NodePrices.HourlyPrices.Prices }
             * 
             * 
             */
            public List<DocBody.NodePrices.HourlyPrices.Prices> getPrices() {
                if (prices == null) {
                    prices = new ArrayList<DocBody.NodePrices.HourlyPrices.Prices>();
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
                "priceType",
                "mcp"
            })
            public static class Prices {

                @XmlElement(name = "PriceType", required = true)
                protected String priceType;
                @XmlElement(name = "MCP", required = true)
                protected BigDecimal mcp;

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
