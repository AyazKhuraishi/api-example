package com.github.rodolfoba.api.backend;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Api(value = "Api Example")
public class ApiResource {

	@Path("/hello")
	@GET
	@ApiOperation(value = "Hello operation", response = HelloEntity.class)
	public Response hello() {
		return Response.ok().entity(new HelloEntity()).build();
	}
	
}
