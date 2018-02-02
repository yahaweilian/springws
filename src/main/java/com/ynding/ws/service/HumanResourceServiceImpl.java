package com.ynding.ws.service;

import org.springframework.stereotype.Service;

import com.ynding.ws.param.HolidayRequest;
import com.ynding.ws.param.HolidayResponse;

@Service
public class HumanResourceServiceImpl implements HumanResourceService {

	@Override
	public HolidayResponse bookHoliday(HolidayRequest request) {
		HolidayResponse response = new HolidayResponse();
		response.setName(request.getEmployee().getFirstName()+"_"+request.getEmployee().getLastName());
		response.setNumber((int)(100*Math.random()));
		return response;
	}

}
