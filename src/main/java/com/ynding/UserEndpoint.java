package com.ynding;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class UserEndpoint {

	@PayloadRoot(localPart = "user")
	@ResponsePayload
	public User handle(@RequestPayload User user) throws Exception{
		System.out.println(user.getId());
		System.out.println(user.getName());
		user.setId(2);
		user.setName("22");
		return user;
	}
}
