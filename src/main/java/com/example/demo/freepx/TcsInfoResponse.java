
package com.example.demo.freepx;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tcsInfoResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tcsInfoResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="attribute1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="attribute10" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="attribute2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="attribute3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="attribute4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="attribute5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="attribute6" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="attribute7" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="attribute8" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="attribute9" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bill_no" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="create_date" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="if_succeed" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="response_belnr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="response_zfimsg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="statement_no" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tcsInfoResponse", propOrder = {
    "attribute1",
    "attribute10",
    "attribute2",
    "attribute3",
    "attribute4",
    "attribute5",
    "attribute6",
    "attribute7",
    "attribute8",
    "attribute9",
    "billNo",
    "createDate",
    "ifSucceed",
    "responseBelnr",
    "responseZfimsg",
    "statementNo"
})
public class TcsInfoResponse {

    private String attribute1;
    private String attribute10;
    private String attribute2;
    private String attribute3;
    private String attribute4;
    private String attribute5;
    private String attribute6;
    private String attribute7;
    private String attribute8;
    private String attribute9;
    @XmlElement(name = "bill_no")
    private String billNo;//报账单号
    @XmlElement(name = "create_date")
    private String createDate;//单据接收时间
    @XmlElement(name = "if_succeed")
    private String ifSucceed;//是否成功
    @XmlElement(name = "response_belnr")
    private String responseBelnr;//凭证号
    @XmlElement(name = "response_zfimsg")
    private String responseZfimsg;//SAP返回消息
    @XmlElement(name = "statement_no")
    private String statementNo;//教培id

    /**
     * Gets the value of the attribute1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttribute1() {
        return attribute1;
    }

    /**
     * Sets the value of the attribute1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttribute1(String value) {
        this.attribute1 = value;
    }

    /**
     * Gets the value of the attribute10 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttribute10() {
        return attribute10;
    }

    /**
     * Sets the value of the attribute10 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttribute10(String value) {
        this.attribute10 = value;
    }

    /**
     * Gets the value of the attribute2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttribute2() {
        return attribute2;
    }

    /**
     * Sets the value of the attribute2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttribute2(String value) {
        this.attribute2 = value;
    }

    /**
     * Gets the value of the attribute3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttribute3() {
        return attribute3;
    }

    /**
     * Sets the value of the attribute3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttribute3(String value) {
        this.attribute3 = value;
    }

    /**
     * Gets the value of the attribute4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttribute4() {
        return attribute4;
    }

    /**
     * Sets the value of the attribute4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttribute4(String value) {
        this.attribute4 = value;
    }

    /**
     * Gets the value of the attribute5 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttribute5() {
        return attribute5;
    }

    /**
     * Sets the value of the attribute5 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttribute5(String value) {
        this.attribute5 = value;
    }

    /**
     * Gets the value of the attribute6 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttribute6() {
        return attribute6;
    }

    /**
     * Sets the value of the attribute6 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttribute6(String value) {
        this.attribute6 = value;
    }

    /**
     * Gets the value of the attribute7 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttribute7() {
        return attribute7;
    }

    /**
     * Sets the value of the attribute7 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttribute7(String value) {
        this.attribute7 = value;
    }

    /**
     * Gets the value of the attribute8 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttribute8() {
        return attribute8;
    }

    /**
     * Sets the value of the attribute8 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttribute8(String value) {
        this.attribute8 = value;
    }

    /**
     * Gets the value of the attribute9 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttribute9() {
        return attribute9;
    }

    /**
     * Sets the value of the attribute9 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttribute9(String value) {
        this.attribute9 = value;
    }

    /**
     * Gets the value of the billNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBillNo() {
        return billNo;
    }

    /**
     * Sets the value of the billNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBillNo(String value) {
        this.billNo = value;
    }

    /**
     * Gets the value of the createDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreateDate() {
        return createDate;
    }

    /**
     * Sets the value of the createDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreateDate(String value) {
        this.createDate = value;
    }

    /**
     * Gets the value of the ifSucceed property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIfSucceed() {
        return ifSucceed;
    }

    /**
     * Sets the value of the ifSucceed property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIfSucceed(String value) {
        this.ifSucceed = value;
    }

    /**
     * Gets the value of the responseBelnr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResponseBelnr() {
        return responseBelnr;
    }

    /**
     * Sets the value of the responseBelnr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponseBelnr(String value) {
        this.responseBelnr = value;
    }

    /**
     * Gets the value of the responseZfimsg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResponseZfimsg() {
        return responseZfimsg;
    }

    /**
     * Sets the value of the responseZfimsg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponseZfimsg(String value) {
        this.responseZfimsg = value;
    }

    /**
     * Gets the value of the statementNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatementNo() {
        return statementNo;
    }

    /**
     * Sets the value of the statementNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatementNo(String value) {
        this.statementNo = value;
    }

}
