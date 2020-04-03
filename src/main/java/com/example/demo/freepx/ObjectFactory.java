
package com.example.demo.freepx;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.demo.freepx package. 
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

    private final static QName _QueryInfo_QNAME = new QName("http://tcsinfo.services.webservice.business.pccw.com/", "queryInfo");
    private final static QName _QueryInfoResponse_QNAME = new QName("http://tcsinfo.services.webservice.business.pccw.com/", "queryInfoResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.demo.freepx
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link QueryInfo }
     * 
     */
    public QueryInfo createQueryInfo() {
        return new QueryInfo();
    }

    /**
     * Create an instance of {@link QueryInfoResponse }
     * 
     */
    public QueryInfoResponse createQueryInfoResponse() {
        return new QueryInfoResponse();
    }

    /**
     * Create an instance of {@link TcsInfoResponse }
     * 
     */
    public TcsInfoResponse createTcsInfoResponse() {
        return new TcsInfoResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tcsinfo.services.webservice.business.pccw.com/", name = "queryInfo")
    public JAXBElement<QueryInfo> createQueryInfo(QueryInfo value) {
        return new JAXBElement<QueryInfo>(_QueryInfo_QNAME, QueryInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryInfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tcsinfo.services.webservice.business.pccw.com/", name = "queryInfoResponse")
    public JAXBElement<QueryInfoResponse> createQueryInfoResponse(QueryInfoResponse value) {
        return new JAXBElement<QueryInfoResponse>(_QueryInfoResponse_QNAME, QueryInfoResponse.class, null, value);
    }

}
