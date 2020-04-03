
package com.example.demo.freepx;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "TcsInfoService", targetNamespace = "http://tcsinfo.services.webservice.business.pccw.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface TcsInfoService {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<com.demo.freepx.TcsInfoResponse>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "queryInfo", targetNamespace = "http://tcsinfo.services.webservice.business.pccw.com/", className = "com.example.demo.freepx.QueryInfo")
    @ResponseWrapper(localName = "queryInfoResponse", targetNamespace = "http://tcsinfo.services.webservice.business.pccw.com/", className = "com.example.demo.freepx.QueryInfoResponse")
    public List<TcsInfoResponse> queryInfo(
            @WebParam(name = "arg0", targetNamespace = "")
                    List<String> arg0);

}
