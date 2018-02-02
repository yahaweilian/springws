package com.ynding.ws.service;

import com.ynding.ws.param.HolidayRequest;
import com.ynding.ws.param.HolidayResponse;

public interface HumanResourceService {

	HolidayResponse bookHoliday(HolidayRequest request);

}
