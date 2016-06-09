package org.gaurav.rest.RestMessenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.gaurav.rest.RestMessenger.database.DatabaseClass;
import org.gaurav.rest.RestMessenger.exception.DataNotFoundException;
import org.gaurav.rest.RestMessenger.exception.IdTooBigException;
import org.gaurav.rest.RestMessenger.model.Message;

public class MessageService {
	
	private static Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public MessageService(){
		messages.put(1L, new Message(1L, "Hello Boston!!", new Date(), "Gaurav Gupta"));
		messages.put(2L, new Message(2L, "Hello Niagra!!", new Date(), "Anamika Gupta"));
	}
	
	public List<Message> getAllMessages(){
		return new ArrayList<Message>(messages.values());
	}
	
	public Message getMessage(long id){
		Message message = messages.get(id);
		if(id > 5000){
			throw new IdTooBigException("Id : " + id +" is too big !!");
		}
		if(message == null){
			throw new DataNotFoundException("Message with id : " + id +" not found !!");
		}
		return message;
	}
	
	public Message addMessage(Message message){
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message){
		if(message.getId() <= 0){
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	
	public void removeMessage(long id){
		messages.remove(id);
	}
	
	public List<Message> getAllMessagesForYear(int year){
		List<Message> messagesForYear = new ArrayList<Message>();
		Calendar calender = Calendar.getInstance();
		for(Message message : messages.values()){
			calender.setTime(message.getCreated());
			if(calender.get(Calendar.YEAR) == year){
				messagesForYear.add(message);
			}
		}
		return messagesForYear;
	}
	
	public List<Message> getAllMessagesPaginated(int start, int size){
		List<Message> messagesPaginated = new ArrayList<Message>(messages.values());
		if(start + size > messagesPaginated.size()) return new ArrayList<Message>();
		return messagesPaginated.subList(start, start + size);
	}

}
