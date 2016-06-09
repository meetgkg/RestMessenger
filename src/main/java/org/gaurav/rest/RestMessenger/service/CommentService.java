package org.gaurav.rest.RestMessenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.gaurav.rest.RestMessenger.database.DatabaseClass;
import org.gaurav.rest.RestMessenger.model.Comment;
import org.gaurav.rest.RestMessenger.model.ErrorMessage;
import org.gaurav.rest.RestMessenger.model.Message;

public class CommentService {
	
	private static Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public List<Comment> getAllComments(long messageId){
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return new ArrayList<Comment>(comments.values());
	}
	
	public Comment getComment(long messageId, long commentId){
		
		ErrorMessage errorMessage = new ErrorMessage("Resource Not Found", 404, "www.google.com");
		
		Response response = Response.status(Status.NOT_FOUND).
				entity(errorMessage).build();
		
		Message message = messages.get(messageId);
		if(message==null){
			//throwing a jax rs familiar exception
			//throw new WebApplicationException(Status.NOT_FOUND);
			throw new WebApplicationException(response);
		}
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		if(comments==null){
			//throwing a jax rs familiar exception
			throw new NotFoundException(response);
		}
		return comments.get(commentId);
	}
	
	public Comment addComment(long messageId, Comment comment){
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		comment.setId(comments.size()+1);
		comments.put(comment.getId(), comment);
		return comment;
	}
	
	public Comment updateComment(long messageId, Comment comment){
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		if(comment.getId() <= 0){
			return null;
		}
		comments.put(comment.getId(), comment);
		return comment;
	}
	
	public Comment removeComment(long messageId, long commentId){
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return comments.remove(commentId);
	}
}
