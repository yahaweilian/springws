package com.ynding.ws.param2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.ynding.ws.param2.taxML.CLFXXCJResponse;

@XmlRootElement(name="LthAipResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class LthAipResponse extends ServiceXmlPackage{

	private Head head;
	protected CLFXXCJResponse body;
	
	public Head getHead() {
		return head;
	}
	public void setHead(Head head) {
		this.head = head;
	}
	public CLFXXCJResponse getBody() {
		return body;
	}
	public void setBody(CLFXXCJResponse body) {
		this.body = body;
	}
	
}
