package com.ynding.ws.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.ynding.ws.param2.LthAipRequest;
import com.ynding.ws.param2.LthAipResponse;
import com.ynding.ws.param2.ServiceXmlPackage;
import com.ynding.ws.service.LthAipWebService;
import com.ynding.ws.service.LthAipWebService2;

@Endpoint
public class ClfcjEndpoint2 {

	private static final String NAMESPACE_URI = "http://ynding.com/hr/schemas";
	private LthAipWebService2 lthAipWebService;
	
	@Autowired
	public ClfcjEndpoint2(LthAipWebService2 lthAipWebService) {
		this.lthAipWebService = lthAipWebService;
	}
	
	@PayloadRoot(namespace=NAMESPACE_URI,localPart="LthAipRequest")
	@ResponsePayload
	public LthAipResponse handleHolidayRequest(@RequestPayload LthAipRequest request){
		
		LthAipResponse response = lthAipWebService.clfxxcjtj(request);
		
		return response;
	}

}
