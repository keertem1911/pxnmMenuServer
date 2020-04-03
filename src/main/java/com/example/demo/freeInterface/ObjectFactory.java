
package com.example.demo.freeInterface;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.cn.phone package. 
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

    private final static QName _ImportInvoices_QNAME = new QName("http://invoice.services.webservice.business.pccw.com/", "import_Invoices");
    private final static QName _ImportInvoicesResponse_QNAME = new QName("http://invoice.services.webservice.business.pccw.com/", "import_InvoicesResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.cn.phone
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ImportInvoicesResponse }
     * 
     */
    public ImportInvoicesResponse createImportInvoicesResponse() {
        return new ImportInvoicesResponse();
    }

    /**
     * Create an instance of {@link ImportInvoices }
     * 
     */
    public ImportInvoices createImportInvoices() {
        return new ImportInvoices();
    }

    /**
     * Create an instance of {@link InvoiceInfo }
     * 
     */
    public InvoiceInfo createInvoiceInfo() {
        return new InvoiceInfo();
    }

    /**
     * Create an instance of {@link InvoiceInfoResponse }
     * 
     */
    public InvoiceInfoResponse createInvoiceInfoResponse() {
        return new InvoiceInfoResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ImportInvoices }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://invoice.services.webservice.business.pccw.com/", name = "import_Invoices")
    public JAXBElement<ImportInvoices> createImportInvoices(ImportInvoices value) {
        return new JAXBElement<ImportInvoices>(_ImportInvoices_QNAME, ImportInvoices.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ImportInvoicesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://invoice.services.webservice.business.pccw.com/", name = "import_InvoicesResponse")
    public JAXBElement<ImportInvoicesResponse> createImportInvoicesResponse(ImportInvoicesResponse value) {
        return new JAXBElement<ImportInvoicesResponse>(_ImportInvoicesResponse_QNAME, ImportInvoicesResponse.class, null, value);
    }

}
