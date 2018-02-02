package com.ynding.ws.param;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "HolidayRequest")
public class HolidayRequest {

	@XmlElement(required = true)
	protected HolidayType Holiday;

	@XmlElement(required = true)
	protected EmployeeType Employee;

	public HolidayType getHoliday() {
		return Holiday;
	}

	public void setHoliday(HolidayType holiday) {
		Holiday = holiday;
	}

	public EmployeeType getEmployee() {
		return Employee;
	}

	public void setEmployee(EmployeeType employee) {
		Employee = employee;
	}

}
