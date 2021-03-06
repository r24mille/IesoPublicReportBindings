//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.12.25 at 10:03:57 PM CST 
//


package ca.ieso.reports.schema.trapreauctionttcst;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
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
 *       &lt;sequence maxOccurs="unbounded">
 *         &lt;element ref="{http://www.ieso.ca/schema}DocHeader"/>
 *         &lt;element name="DocBody">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="AuctionStartDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                   &lt;element name="AuctionEndDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                   &lt;element name="AuctionRoundNumber" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *                   &lt;element name="AuctionRoundStartTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *                   &lt;element name="AuctionRoundEndTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *                   &lt;element name="AuctionTimeStructure" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="TransmissionRightsPercentage" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *                   &lt;element name="InfoURL" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
 *                   &lt;element name="ZonalTransferCapabilityTransmissionRightsSummary" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="InjectionZone" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="TransferCapabilityTransmissionRightsSummary" maxOccurs="unbounded">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="PathName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="PathDescription" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="WithdrawalZone" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="TransferCapability" type="{http://www.ieso.ca/schema}MW_decimal5.1"/>
 *                                       &lt;element name="TransmissionRights" type="{http://www.ieso.ca/schema}MW_decimal5.1"/>
 *                                       &lt;element name="Notes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
 *       &lt;attribute name="docID" type="{http://www.ieso.ca/schema}docID" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "docHeaderAndDocBody"
})
@XmlRootElement(name = "Document")
public class Document {

    @XmlElements({
        @XmlElement(name = "DocHeader", required = true, type = DocHeader.class),
        @XmlElement(name = "DocBody", required = true, type = Document.DocBody.class)
    })
    protected List<Object> docHeaderAndDocBody;
    @XmlAttribute(name = "docID")
    protected String docID;

    /**
     * Gets the value of the docHeaderAndDocBody property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the docHeaderAndDocBody property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDocHeaderAndDocBody().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DocHeader }
     * {@link Document.DocBody }
     * 
     * 
     */
    public List<Object> getDocHeaderAndDocBody() {
        if (docHeaderAndDocBody == null) {
            docHeaderAndDocBody = new ArrayList<Object>();
        }
        return this.docHeaderAndDocBody;
    }

    /**
     * Gets the value of the docID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocID() {
        return docID;
    }

    /**
     * Sets the value of the docID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocID(String value) {
        this.docID = value;
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
     *         &lt;element name="AuctionStartDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *         &lt;element name="AuctionEndDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *         &lt;element name="AuctionRoundNumber" type="{http://www.w3.org/2001/XMLSchema}integer"/>
     *         &lt;element name="AuctionRoundStartTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
     *         &lt;element name="AuctionRoundEndTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
     *         &lt;element name="AuctionTimeStructure" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="TransmissionRightsPercentage" type="{http://www.w3.org/2001/XMLSchema}integer"/>
     *         &lt;element name="InfoURL" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
     *         &lt;element name="ZonalTransferCapabilityTransmissionRightsSummary" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="InjectionZone" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="TransferCapabilityTransmissionRightsSummary" maxOccurs="unbounded">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="PathName" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="PathDescription" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="WithdrawalZone" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="TransferCapability" type="{http://www.ieso.ca/schema}MW_decimal5.1"/>
     *                             &lt;element name="TransmissionRights" type="{http://www.ieso.ca/schema}MW_decimal5.1"/>
     *                             &lt;element name="Notes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "auctionStartDate",
        "auctionEndDate",
        "auctionRoundNumber",
        "auctionRoundStartTime",
        "auctionRoundEndTime",
        "auctionTimeStructure",
        "transmissionRightsPercentage",
        "infoURL",
        "zonalTransferCapabilityTransmissionRightsSummary"
    })
    public static class DocBody {

        @XmlElement(name = "AuctionStartDate", required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar auctionStartDate;
        @XmlElement(name = "AuctionEndDate", required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar auctionEndDate;
        @XmlElement(name = "AuctionRoundNumber", required = true)
        protected BigInteger auctionRoundNumber;
        @XmlElement(name = "AuctionRoundStartTime", required = true)
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar auctionRoundStartTime;
        @XmlElement(name = "AuctionRoundEndTime", required = true)
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar auctionRoundEndTime;
        @XmlElement(name = "AuctionTimeStructure", required = true)
        protected String auctionTimeStructure;
        @XmlElement(name = "TransmissionRightsPercentage", required = true)
        protected BigInteger transmissionRightsPercentage;
        @XmlElement(name = "InfoURL", required = true)
        @XmlSchemaType(name = "anyURI")
        protected String infoURL;
        @XmlElement(name = "ZonalTransferCapabilityTransmissionRightsSummary", required = true)
        protected List<Document.DocBody.ZonalTransferCapabilityTransmissionRightsSummary> zonalTransferCapabilityTransmissionRightsSummary;

        /**
         * Gets the value of the auctionStartDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getAuctionStartDate() {
            return auctionStartDate;
        }

        /**
         * Sets the value of the auctionStartDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setAuctionStartDate(XMLGregorianCalendar value) {
            this.auctionStartDate = value;
        }

        /**
         * Gets the value of the auctionEndDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getAuctionEndDate() {
            return auctionEndDate;
        }

        /**
         * Sets the value of the auctionEndDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setAuctionEndDate(XMLGregorianCalendar value) {
            this.auctionEndDate = value;
        }

        /**
         * Gets the value of the auctionRoundNumber property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getAuctionRoundNumber() {
            return auctionRoundNumber;
        }

        /**
         * Sets the value of the auctionRoundNumber property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setAuctionRoundNumber(BigInteger value) {
            this.auctionRoundNumber = value;
        }

        /**
         * Gets the value of the auctionRoundStartTime property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getAuctionRoundStartTime() {
            return auctionRoundStartTime;
        }

        /**
         * Sets the value of the auctionRoundStartTime property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setAuctionRoundStartTime(XMLGregorianCalendar value) {
            this.auctionRoundStartTime = value;
        }

        /**
         * Gets the value of the auctionRoundEndTime property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getAuctionRoundEndTime() {
            return auctionRoundEndTime;
        }

        /**
         * Sets the value of the auctionRoundEndTime property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setAuctionRoundEndTime(XMLGregorianCalendar value) {
            this.auctionRoundEndTime = value;
        }

        /**
         * Gets the value of the auctionTimeStructure property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAuctionTimeStructure() {
            return auctionTimeStructure;
        }

        /**
         * Sets the value of the auctionTimeStructure property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAuctionTimeStructure(String value) {
            this.auctionTimeStructure = value;
        }

        /**
         * Gets the value of the transmissionRightsPercentage property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getTransmissionRightsPercentage() {
            return transmissionRightsPercentage;
        }

        /**
         * Sets the value of the transmissionRightsPercentage property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setTransmissionRightsPercentage(BigInteger value) {
            this.transmissionRightsPercentage = value;
        }

        /**
         * Gets the value of the infoURL property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getInfoURL() {
            return infoURL;
        }

        /**
         * Sets the value of the infoURL property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setInfoURL(String value) {
            this.infoURL = value;
        }

        /**
         * Gets the value of the zonalTransferCapabilityTransmissionRightsSummary property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the zonalTransferCapabilityTransmissionRightsSummary property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getZonalTransferCapabilityTransmissionRightsSummary().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Document.DocBody.ZonalTransferCapabilityTransmissionRightsSummary }
         * 
         * 
         */
        public List<Document.DocBody.ZonalTransferCapabilityTransmissionRightsSummary> getZonalTransferCapabilityTransmissionRightsSummary() {
            if (zonalTransferCapabilityTransmissionRightsSummary == null) {
                zonalTransferCapabilityTransmissionRightsSummary = new ArrayList<Document.DocBody.ZonalTransferCapabilityTransmissionRightsSummary>();
            }
            return this.zonalTransferCapabilityTransmissionRightsSummary;
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
         *         &lt;element name="InjectionZone" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="TransferCapabilityTransmissionRightsSummary" maxOccurs="unbounded">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="PathName" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="PathDescription" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="WithdrawalZone" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="TransferCapability" type="{http://www.ieso.ca/schema}MW_decimal5.1"/>
         *                   &lt;element name="TransmissionRights" type="{http://www.ieso.ca/schema}MW_decimal5.1"/>
         *                   &lt;element name="Notes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
            "injectionZone",
            "transferCapabilityTransmissionRightsSummary"
        })
        public static class ZonalTransferCapabilityTransmissionRightsSummary {

            @XmlElement(name = "InjectionZone", required = true)
            protected String injectionZone;
            @XmlElement(name = "TransferCapabilityTransmissionRightsSummary", required = true)
            protected List<Document.DocBody.ZonalTransferCapabilityTransmissionRightsSummary.TransferCapabilityTransmissionRightsSummary> transferCapabilityTransmissionRightsSummary;

            /**
             * Gets the value of the injectionZone property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getInjectionZone() {
                return injectionZone;
            }

            /**
             * Sets the value of the injectionZone property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setInjectionZone(String value) {
                this.injectionZone = value;
            }

            /**
             * Gets the value of the transferCapabilityTransmissionRightsSummary property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the transferCapabilityTransmissionRightsSummary property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getTransferCapabilityTransmissionRightsSummary().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Document.DocBody.ZonalTransferCapabilityTransmissionRightsSummary.TransferCapabilityTransmissionRightsSummary }
             * 
             * 
             */
            public List<Document.DocBody.ZonalTransferCapabilityTransmissionRightsSummary.TransferCapabilityTransmissionRightsSummary> getTransferCapabilityTransmissionRightsSummary() {
                if (transferCapabilityTransmissionRightsSummary == null) {
                    transferCapabilityTransmissionRightsSummary = new ArrayList<Document.DocBody.ZonalTransferCapabilityTransmissionRightsSummary.TransferCapabilityTransmissionRightsSummary>();
                }
                return this.transferCapabilityTransmissionRightsSummary;
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
             *         &lt;element name="PathName" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="PathDescription" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="WithdrawalZone" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="TransferCapability" type="{http://www.ieso.ca/schema}MW_decimal5.1"/>
             *         &lt;element name="TransmissionRights" type="{http://www.ieso.ca/schema}MW_decimal5.1"/>
             *         &lt;element name="Notes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
                "pathName",
                "pathDescription",
                "withdrawalZone",
                "transferCapability",
                "transmissionRights",
                "notes"
            })
            public static class TransferCapabilityTransmissionRightsSummary {

                @XmlElement(name = "PathName", required = true)
                protected String pathName;
                @XmlElement(name = "PathDescription", required = true)
                protected String pathDescription;
                @XmlElement(name = "WithdrawalZone", required = true)
                protected String withdrawalZone;
                @XmlElement(name = "TransferCapability", required = true)
                protected BigDecimal transferCapability;
                @XmlElement(name = "TransmissionRights", required = true)
                protected BigDecimal transmissionRights;
                @XmlElement(name = "Notes")
                protected String notes;

                /**
                 * Gets the value of the pathName property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getPathName() {
                    return pathName;
                }

                /**
                 * Sets the value of the pathName property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setPathName(String value) {
                    this.pathName = value;
                }

                /**
                 * Gets the value of the pathDescription property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getPathDescription() {
                    return pathDescription;
                }

                /**
                 * Sets the value of the pathDescription property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setPathDescription(String value) {
                    this.pathDescription = value;
                }

                /**
                 * Gets the value of the withdrawalZone property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getWithdrawalZone() {
                    return withdrawalZone;
                }

                /**
                 * Sets the value of the withdrawalZone property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setWithdrawalZone(String value) {
                    this.withdrawalZone = value;
                }

                /**
                 * Gets the value of the transferCapability property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigDecimal }
                 *     
                 */
                public BigDecimal getTransferCapability() {
                    return transferCapability;
                }

                /**
                 * Sets the value of the transferCapability property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigDecimal }
                 *     
                 */
                public void setTransferCapability(BigDecimal value) {
                    this.transferCapability = value;
                }

                /**
                 * Gets the value of the transmissionRights property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigDecimal }
                 *     
                 */
                public BigDecimal getTransmissionRights() {
                    return transmissionRights;
                }

                /**
                 * Sets the value of the transmissionRights property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigDecimal }
                 *     
                 */
                public void setTransmissionRights(BigDecimal value) {
                    this.transmissionRights = value;
                }

                /**
                 * Gets the value of the notes property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getNotes() {
                    return notes;
                }

                /**
                 * Sets the value of the notes property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setNotes(String value) {
                    this.notes = value;
                }

            }

        }

    }

}
