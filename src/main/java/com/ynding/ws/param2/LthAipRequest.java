package com.ynding.ws.param2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.ynding.ws.param2.taxML.CLFXXCJRequest;

@XmlRootElement(name="LthAipRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class LthAipRequest extends ServiceXmlPackage{

	private Head head;
	protected CLFXXCJRequest body;
	
	public Head getHead() {
		return head;
	}
	public void setHead(Head head) {
		this.head = head;
	}
	public CLFXXCJRequest getBody() {
		return body;
	}
	public void setBody(CLFXXCJRequest body) {
		this.body = body;
	}
	
}
