package com.ynding.ws.client;

import java.io.IOException;

import javax.xml.transform.Source;

import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.util.ClassUtils;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.xml.transform.ResourceSource;
import org.springframework.xml.transform.StringResult;

import com.ynding.jaxb2.JaxbUtil;
import com.ynding.ws.param2.ServiceXmlPackage;

public class CjfcjClient {

	private final WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
	
	public void setDefaultUri(String defaultUri) {
		webServiceTemplate.setDefaultUri(defaultUri);
	}
	
	// send to the configured default URI
	public void simpleSendAndReceive() throws IOException {
		Source source = new ResourceSource(new ClassPathResource("com/ynding/ws/client/ClfcjRequest.xml"));
		StringResult result = new StringResult();
		webServiceTemplate.sendSourceAndReceiveToResult(source, result);

		System.out.println("-------");
		System.out.println(JaxbUtil.converToJavaBean(result.toString(), ServiceXmlPackage.class));
		System.out.println("-------");
	}
		
	public void sendAndReceive() throws Exception{
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		//扫描请求类所在的包
		marshaller.setPackagesToScan(new String[]{ClassUtils.getPackageName(ServiceXmlPackage.class)});
		marshaller.afterPropertiesSet();
		WebServiceTemplate msbServiceTemplate = new WebServiceTemplate(marshaller);
		
		ServiceXmlPackage request = new ServiceXmlPackage();
		
		
		msbServiceTemplate.setDefaultUri("http://localhost:8888/springws/services");
		
		ServiceXmlPackage response = (ServiceXmlPackage) msbServiceTemplate.marshalSendAndReceive(request);
		
		System.out.println(response);
	}
	
	public static void main(String[] args) throws Exception {
		CjfcjClient client = new CjfcjClient();
		client.setDefaultUri("http://localhost:8888/springws/services");
//		client.sendAndReceive();
		client.simpleSendAndReceive();
	}


}
