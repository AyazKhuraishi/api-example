package com.github.rodolfoba.apiexample.backend.rest;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.github.rodolfoba.apiexample.backend.rest.model.Pet;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

//@ApplicationScoped
//@Path("/api")
//@Api(value = "API Example Backend")
public class ApiBackend {

//	@POST
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.APPLICATION_JSON)
//	@ApiOperation(value = "Add a new pet to the store", notes = "", response = Void.class)
//	@ApiResponses(value = { 
//			@ApiResponse(code = 405, message = "Invalid input", response = Void.class) 
//	})
	public Response addPet(@ApiParam(value = "Pet object that needs to be added to the store", required = true) Pet body) {
		
		return Response.ok().build();
	}

}
