package com.example.demo.freeInterface;


import org.apache.commons.lang3.StringUtils;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FreeService {
	public static void main(String[] args) {
		ImportInvoices importInvoices=new ImportInvoices();
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
		importInvoices.arg0=new ArrayList<>();
		for (int i = 0; i < 2; i++) {
			InvoiceInfo invoiceInfo=new InvoiceInfo();
			LocalDateTime dateTime=LocalDateTime.now();
			String id="pxsystem"+System.currentTimeMillis();
			invoiceInfo.setBillId(id);
			invoiceInfo.setCompanyId("1");
			invoiceInfo.setDeptId("1");
			invoiceInfo.setBillNo(id);
			invoiceInfo.setBizType("1");
			invoiceInfo.setBusinessTypes("2");
			invoiceInfo.setAmount("200000");
			invoiceInfo.setVendorId(30007364);
			invoiceInfo.setAccountingDate(dateTime.format(formatter));
			invoiceInfo.setYwlwxz("1");
			invoiceInfo.setBizStartDate("2019-01-01");
			invoiceInfo.setBizEndDate("2019-01-12");
			invoiceInfo.setAttribute10("pxsystem");
			importInvoices.arg0.add(invoiceInfo);
			System.out.println(invoiceInfo);
		}
		List<InvoiceInfoResponse> result = getFreeList(importInvoices);
		result.forEach(System.out::print);
		System.out.println(result.get(0).getStatus());
	}
	//send
	//InvoiceInfoResponse(accountingDate=2019-12-18, amount=200000, attribute1=null, attribute10=pxsystem, attribute2=null, attribute3=null, attribute4=null, attribute5=null, attribute6=null, attribute7=null, attribute8=null, attribute9=null, billId=pxsystem1576655054147, billNo=pxsystem1576655054147, bizDesc=null, bizEndDate=2019-01-12, bizStartDate=2019-01-01, bizType=1, businessTypes=2, companyId=1, createDate=null, createrBy=null, deptId=1, distribution=null, status=S, tax=null, theTaxCode=null, vendorId=30007364, writeOff=null, ywlwxz=1)InvoiceInfoResponse(accountingDate=2019-12-18, amount=200000, attribute1=null, attribute10=pxsystem, attribute2=null, attribute3=null, attribute4=null, attribute5=null, attribute6=null, attribute7=null, attribute8=null, attribute9=null, billId=pxsystem1576655054147, billNo=pxsystem1576655054147, bizDesc=null, bizEndDate=2019-01-12, bizStartDate=2019-01-01, bizType=1, businessTypes=2, companyId=1, createDate=null, createrBy=null, deptId=1, distribution=null, status=E, tax=null, theTaxCode=null, vendorId=30007364, writeOff=null, ywlwxz=1)S
	public static List<InvoiceInfoResponse> getFreeList(ImportInvoices importInvoices){
		JaxWsProxyFactoryBean clientFactory = new JaxWsProxyFactoryBean();
		// 设置访问地址和对应的服务接口
		clientFactory.setAddress("http://10.106.10.202:7001/WebRoot/entry/services/invoiceInfoService");
		// 固化接口对象
		clientFactory.setServiceClass(InvoiceService.class);
		// 设置用户名和密码
//		clientFactory.setUsername(DataDefine.USERNAME);
		// 设置密码
//		clientFactory.setPassword(DataDefine.PASSWORD);
		// 获取接口对象
		InvoiceService ss = (InvoiceService)clientFactory.create();
		Client proxy = ClientProxy.getClient(ss);
        HTTPConduit conduit = (HTTPConduit) proxy.getConduit();
        HTTPClientPolicy httpClientPolicy =  new HTTPClientPolicy();
        httpClientPolicy.setConnectionTimeout(360000);      //连接超时时间 
        httpClientPolicy.setAllowChunking( false );     
        httpClientPolicy.setReceiveTimeout(360000);      //请求超时时间.
        conduit.setClient(httpClientPolicy);
		// 发送参数获取接口结果
		List<InvoiceInfoResponse> zsr = ss.importInvoices(importInvoices.arg0);
		return zsr;
	}

}
