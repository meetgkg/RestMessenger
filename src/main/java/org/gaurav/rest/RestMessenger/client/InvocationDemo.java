package org.gaurav.rest.RestMessenger.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class InvocationDemo {

	public static void main(String[] args) {
		Invocation invocation = prepareRequestForMessagebyYear(2015);
		Response response = invocation.invoke();
		System.out.println(response.getStatus());
	}

	private static Invocation prepareRequestForMessagebyYear(int i) {
		Client client = ClientBuilder.newClient();
		return client.target("http://localhost:8080/RestMessenger/webapi/")
								.path("messages")
								.queryParam("year", 2015)
								.request(MediaType.APPLICATION_JSON)
								.buildGet();		
	}

}
