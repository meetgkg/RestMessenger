package org.gaurav.rest.RestMessenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.gaurav.rest.RestMessenger.model.ErrorMessage;
//@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable>{

	@Override
	public Response toResponse(Throwable exception) {
		ErrorMessage errorMessage = new ErrorMessage(exception.getMessage(), 500, "www.google.com");
		
		return Response.status(Status.INTERNAL_SERVER_ERROR).
				entity(errorMessage).build();
	}

}
