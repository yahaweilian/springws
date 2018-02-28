package com.ynding.ws.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.ynding.ws.param2.ServiceXmlPackage;
import com.ynding.ws.service.LthAipWebService;

@Endpoint
public class ClfcjEndpoint {

	private static final String NAMESPACE_URI = "http://ynding.com/hr/schemas";
	private LthAipWebService lthAipWebService;
	
	@Autowired
	public ClfcjEndpoint(LthAipWebService lthAipWebService) {
		this.lthAipWebService = lthAipWebService;
	}
	
	@PayloadRoot(namespace=NAMESPACE_URI,localPart="serviceXmlPackage")
	@ResponsePayload
	public ServiceXmlPackage handleHolidayRequest(@RequestPayload ServiceXmlPackage request){
		
		ServiceXmlPackage response = lthAipWebService.clfxxcjtj(request);
		
		return response;
	}

}
