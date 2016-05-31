package org.gaurav.rest.RestMessenger.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.gaurav.rest.RestMessenger.model.Message;

public class MessageService {
	
		public List<Message> getAllMessages(){
			Message m1 = new Message(10001, "Hello Gaurav", new Date(), "Gaurav");
			Message m2 = new Message(10002, "Hello Anamika", new Date(), "Anamika");
			List<Message> messageList = new ArrayList<Message>();
			messageList.add(m1);
			messageList.add(m2);
			return messageList;
		}

}
