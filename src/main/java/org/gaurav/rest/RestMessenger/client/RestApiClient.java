package org.gaurav.rest.RestMessenger.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.gaurav.rest.RestMessenger.model.Message;


public class RestApiClient {

	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		Response response = client.target("http://localhost:8080/RestMessenger/webapi/messages/1")
				.request()
				.get();
		Message message = response.readEntity(Message.class);
		System.out.println(message.getAuthor() + ", "+message.getMessage());
		System.out.println("~~~~~~~~~~~~~~~~~~GET~~~~~~~~~~~~~~~~");
		//Second way
		Message message2 = client.target("http://localhost:8080/RestMessenger/webapi/messages/1")
				.request(MediaType.APPLICATION_JSON)
				.get(Message.class);
		System.out.println(message2.getAuthor() + ", "+message2.getMessage());
		
		//Third way
		String message3 = client.target("http://localhost:8080/RestMessenger/webapi/messages/1")
				.request(MediaType.APPLICATION_JSON)
				.get(String.class);
		System.out.println(message3);
		
		WebTarget baseTarget = client.target("http://localhost:8080/RestMessenger/webapi/");
		WebTarget messagesTarget = baseTarget.path("messages");
		WebTarget singleMessageTarget = messagesTarget.path("{messageId}");
		Message message4 = singleMessageTarget
				.resolveTemplate("messageId", 2)
				.request(MediaType.APPLICATION_JSON)
				.get(Message.class);
		System.out.println(message4.getAuthor() + ", "+message4.getMessage());
		
		System.out.println("~~~~~~~~~~~~~~~~~~POST~~~~~~~~~~~~~~~~");
		Message messagePost = new Message(3, "Hello Quincy", "Lucky");
		Response postResponse = messagesTarget
							.request()
							.post(Entity.json(messagePost));
		if(postResponse.getStatus() != 201){
			System.out.println("Error");
		}
		Message messageResponse = postResponse.readEntity(Message.class);
		System.out.println(messageResponse.getMessage());
		
	}

}
