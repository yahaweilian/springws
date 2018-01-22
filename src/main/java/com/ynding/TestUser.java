package com.ynding;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;

public class TestUser {

	public static void main(String[] args) {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setClassesToBeBound(User.class);
		WebServiceTemplate template = new WebServiceTemplate(marshaller);
		User user = new User(1, "chenzhouce");
		User returnUser = (User) template.marshalSendAndReceive("http://localhost:8888/springws/userService/user.wsdl", user);
		System.out.println(returnUser);
	}
}
