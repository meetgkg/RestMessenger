package org.gaurav.rest.RestMessenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.gaurav.rest.RestMessenger.model.ErrorMessage;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

	@Override
	public Response toResponse(DataNotFoundException exception) {
		
		ErrorMessage errorMessage = new ErrorMessage(exception.getMessage(), 404, "www.google.com");
		
		return Response.status(Status.NOT_FOUND).
				entity(errorMessage).build();
	}

}
