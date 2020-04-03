package com.example.demo.freepx;


import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;

import java.util.ArrayList;
import java.util.List;

public class FreePxService {
	public static void main(String[] args) {
		List<String> params=new ArrayList<>();
		params.add("pxsystem100001");
		List<TcsInfoResponse> result = getFreePxList(params);
		System.out.println(result);
	}
	public static List<TcsInfoResponse> getFreePxList(List<String> queryStr){
		JaxWsProxyFactoryBean clientFactory = new JaxWsProxyFactoryBean();
		// 设置访问地址和对应的服务接口
		clientFactory.setAddress("http://10.106.10.202:7001/WebRoot/entry/services/tcsInfoService");
		// 固化接口对象
		clientFactory.setServiceClass(TcsInfoService.class);
		// 设置用户名和密码
//		clientFactory.setUsername(DataDefine.USERNAME);
		// 设置密码
//		clientFactory.setPassword(DataDefine.PASSWORD);
		// 获取接口对象
		TcsInfoService ss = (TcsInfoService)clientFactory.create();
		Client proxy = ClientProxy.getClient(ss);
        HTTPConduit conduit = (HTTPConduit) proxy.getConduit();
        HTTPClientPolicy httpClientPolicy =  new HTTPClientPolicy();
        httpClientPolicy.setConnectionTimeout(360000);      //连接超时时间 
        httpClientPolicy.setAllowChunking( false );     
        httpClientPolicy.setReceiveTimeout(360000);      //请求超时时间.
        conduit.setClient(httpClientPolicy);
		// 发送参数获取接口结果
		List<TcsInfoResponse> zsr = ss.queryInfo(queryStr);
		return zsr;
	}

}
