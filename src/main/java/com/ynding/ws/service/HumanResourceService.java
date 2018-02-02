package com.ynding.ws.service;

import com.ynding.entity.HolidayRequest;
import com.ynding.entity.HolidayResponse;

public interface HumanResourceService {

	HolidayResponse bookHoliday(HolidayRequest request);

}
