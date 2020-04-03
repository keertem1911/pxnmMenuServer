
package com.example.demo.freeInterface;

import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for invoiceInfoResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="invoiceInfoResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accounting_date" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
 *         &lt;element name="bill_id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bill_no" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="biz_desc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="biz_end_date" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="biz_start_date" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="biz_type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="business_types" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="company_id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="create_date" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="creater_by" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dept_id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="distribution" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tax" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="the_tax_code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="vendor_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="write_off" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ywlwxz" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "invoiceInfoResponse", propOrder = {
    "accountingDate",
    "amount",
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
    "billId",
    "billNo",
    "bizDesc",
    "bizEndDate",
    "bizStartDate",
    "bizType",
    "businessTypes",
    "companyId",
    "createDate",
    "createrBy",
    "deptId",
    "distribution",
    "status",
    "tax",
    "theTaxCode",
    "vendorId",
    "writeOff",
    "ywlwxz"
})
@Data
@ToString
public class InvoiceInfoResponse {

    @XmlElement(name = "accounting_date")
    private String accountingDate;
    private String amount;
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
    @XmlElement(name = "bill_id")
    private String billId;
    @XmlElement(name = "bill_no")
    private String billNo;
    @XmlElement(name = "biz_desc")
    private String bizDesc;
    @XmlElement(name = "biz_end_date")
    private String bizEndDate;
    @XmlElement(name = "biz_start_date")
    private String bizStartDate;
    @XmlElement(name = "biz_type")
    private String bizType;
    @XmlElement(name = "business_types")
    private String businessTypes;
    @XmlElement(name = "company_id")
    private String companyId;
    @XmlElement(name = "create_date")
    private String createDate;
    @XmlElement(name = "creater_by")
    private String createrBy;
    @XmlElement(name = "dept_id")
    private String deptId;
    private String distribution;
    private String status;//状态 E 失败 S 成功
    private String tax;
    @XmlElement(name = "the_tax_code")
    private String theTaxCode;
    @XmlElement(name = "vendor_id")
    private int vendorId;
    @XmlElement(name = "write_off")
    private String writeOff;
    private String ywlwxz;

    /**
     * Gets the value of the accountingDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountingDate() {
        return accountingDate;
    }

    /**
     * Sets the value of the accountingDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountingDate(String value) {
        this.accountingDate = value;
    }

    /**
     * Gets the value of the amount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAmount(String value) {
        this.amount = value;
    }

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
     * Gets the value of the billId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBillId() {
        return billId;
    }

    /**
     * Sets the value of the billId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBillId(String value) {
        this.billId = value;
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
     * Gets the value of the bizDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBizDesc() {
        return bizDesc;
    }

    /**
     * Sets the value of the bizDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBizDesc(String value) {
        this.bizDesc = value;
    }

    /**
     * Gets the value of the bizEndDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBizEndDate() {
        return bizEndDate;
    }

    /**
     * Sets the value of the bizEndDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBizEndDate(String value) {
        this.bizEndDate = value;
    }

    /**
     * Gets the value of the bizStartDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBizStartDate() {
        return bizStartDate;
    }

    /**
     * Sets the value of the bizStartDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBizStartDate(String value) {
        this.bizStartDate = value;
    }

    /**
     * Gets the value of the bizType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBizType() {
        return bizType;
    }

    /**
     * Sets the value of the bizType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBizType(String value) {
        this.bizType = value;
    }

    /**
     * Gets the value of the businessTypes property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusinessTypes() {
        return businessTypes;
    }

    /**
     * Sets the value of the businessTypes property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusinessTypes(String value) {
        this.businessTypes = value;
    }

    /**
     * Gets the value of the companyId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompanyId() {
        return companyId;
    }

    /**
     * Sets the value of the companyId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompanyId(String value) {
        this.companyId = value;
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
     * Gets the value of the createrBy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreaterBy() {
        return createrBy;
    }

    /**
     * Sets the value of the createrBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreaterBy(String value) {
        this.createrBy = value;
    }

    /**
     * Gets the value of the deptId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeptId() {
        return deptId;
    }

    /**
     * Sets the value of the deptId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeptId(String value) {
        this.deptId = value;
    }

    /**
     * Gets the value of the distribution property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDistribution() {
        return distribution;
    }

    /**
     * Sets the value of the distribution property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDistribution(String value) {
        this.distribution = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the tax property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTax() {
        return tax;
    }

    /**
     * Sets the value of the tax property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTax(String value) {
        this.tax = value;
    }

    /**
     * Gets the value of the theTaxCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTheTaxCode() {
        return theTaxCode;
    }

    /**
     * Sets the value of the theTaxCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTheTaxCode(String value) {
        this.theTaxCode = value;
    }

    /**
     * Gets the value of the vendorId property.
     * 
     */
    public int getVendorId() {
        return vendorId;
    }

    /**
     * Sets the value of the vendorId property.
     * 
     */
    public void setVendorId(int value) {
        this.vendorId = value;
    }

    /**
     * Gets the value of the writeOff property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWriteOff() {
        return writeOff;
    }

    /**
     * Sets the value of the writeOff property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWriteOff(String value) {
        this.writeOff = value;
    }

    /**
     * Gets the value of the ywlwxz property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getYwlwxz() {
        return ywlwxz;
    }

    /**
     * Sets the value of the ywlwxz property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setYwlwxz(String value) {
        this.ywlwxz = value;
    }

}
