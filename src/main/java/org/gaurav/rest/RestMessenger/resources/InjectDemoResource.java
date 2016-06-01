package org.gaurav.rest.RestMessenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/injectdemo")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class InjectDemoResource {
	@GET
	@Path("/annotations")
	public String getParamsUsingAnnotations(@MatrixParam("param") String param, 
												@HeaderParam("headerParam") String headerParam,
												@CookieParam("cookieName") String cookieValue){
		return "Matrix Param : "+ param + " Custom Header : "+ headerParam + " Cookie Value : "+cookieValue;
	}
}
