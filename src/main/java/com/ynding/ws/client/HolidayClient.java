package com.ynding.ws.client;

import java.io.IOException;
import java.util.Date;

import javax.xml.transform.Source;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.util.ClassUtils;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.xml.transform.ResourceSource;
import org.springframework.xml.transform.StringResult;

import com.ynding.util.JaxbUtil;
import com.ynding.ws.param.EmployeeType;
import com.ynding.ws.param.HolidayRequest;
import com.ynding.ws.param.HolidayResponse;
import com.ynding.ws.param.HolidayType;


public class HolidayClient {

	private final WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
	
	public void setDefaultUri(String defaultUri) {
		webServiceTemplate.setDefaultUri(defaultUri);
	}
	
	// send to the configured default URI
	public void simpleSendAndReceive() throws IOException {
		Source source = new ResourceSource(new ClassPathResource("com/ynding/ws/client/HolidayRequest.xml"));
		StringResult result = new StringResult();
		webServiceTemplate.sendSourceAndReceiveToResult(source, result);

		System.out.println("-------");
		System.out.println(JaxbUtil.converToJavaBean(result.toString(), HolidayResponse.class));
		System.out.println("-------");
	}
		
	public void sendAndReceive() throws Exception{
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		//扫描请求类所在的包
		marshaller.setPackagesToScan(new String[]{ClassUtils.getPackageName(HolidayRequest.class)});
		marshaller.afterPropertiesSet();
		WebServiceTemplate msbServiceTemplate = new WebServiceTemplate(marshaller);
		
		HolidayRequest request = new HolidayRequest();
		EmployeeType employee = new EmployeeType();
		employee.setFirstName("yn");
		employee.setLastName("ding");
		employee.setNumber(1);
		request.setEmployee(employee);
		
		HolidayType holiday = new HolidayType();
		holiday.setEndDate(new Date());
		holiday.setStartDate(new Date());
		request.setHoliday(holiday);
		
		msbServiceTemplate.setDefaultUri("http://localhost:8888/springws/services");
		
		HolidayResponse response = (HolidayResponse) msbServiceTemplate.marshalSendAndReceive(request);
		
		System.out.println(response);
	}
	
	public static void main(String[] args) throws Exception {
		HolidayClient client = new HolidayClient();
		client.setDefaultUri("http://localhost:8888/springws/services");
		client.sendAndReceive();
		client.simpleSendAndReceive();
	}
}
