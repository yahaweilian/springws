package com.ynding.service.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.ynding.entity.HolidayRequest;
import com.ynding.entity.HolidayResponse;
import com.ynding.service.HumanResourceService;

@Endpoint
public class HolidayEndpoint {

	private static final String NAMESPACE_URI = "http://ynding.com/hr/schemas";
	
	private HumanResourceService humanResourceService;

	@Autowired
	public HolidayEndpoint(HumanResourceService humanResourceService) {
		this.humanResourceService = humanResourceService;
	}
	
	@PayloadRoot(namespace=NAMESPACE_URI,localPart="HolidayRequest")
	@ResponsePayload
	public HolidayResponse handleHolidayRequest(@RequestPayload HolidayRequest request){
		
		HolidayResponse response = humanResourceService.bookHoliday(request);
		
		return response;
	}
}
