package com.github.rodolfoba.apiexample.backend.rest.api;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import com.github.rodolfoba.apiexample.backend.rest.model.Pet;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;

@Path("/api")
@Api(value = "pet")
public interface PetApi  {
   
    @POST
    @Consumes({ "application/json", "application/xml" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Add a new pet to the store", notes = "", response = Void.class, tags={ "pet", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 405, message = "Invalid input", response = Void.class) })
    public Response addPet(@ApiParam(value = "Pet object that needs to be added to the store" ,required=true) Pet body,@Context SecurityContext securityContext);
    @DELETE
    @Path("/{petId}")
    
    @Produces({ "application/xml", "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Deletes a pet", notes = "", response = Void.class, tags={ "pet", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid ID supplied", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Pet not found", response = Void.class) })
    public Response deletePet( @PathParam("petId") Long petId,@ApiParam(value = "" )@HeaderParam("api_key") String apiKey,@Context SecurityContext securityContext);
    @GET
    @Path("/findByStatus")
    
    @Produces({ "application/xml", "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Finds Pets by status", notes = "Multiple status values can be provided with comma separated strings", response = Pet.class, responseContainer = "List", tags={ "pet", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = Pet.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid status value", response = Pet.class, responseContainer = "List") })
    public Response findPetsByStatus( @NotNull @QueryParam("status") List<String> status,@Context SecurityContext securityContext);
    @GET
    @Path("/findByTags")
    
    @Produces({ "application/xml", "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Finds Pets by tags", notes = "Muliple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.", response = Pet.class, responseContainer = "List", tags={ "pet", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = Pet.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid tag value", response = Pet.class, responseContainer = "List") })
    public Response findPetsByTags( @NotNull @QueryParam("tags") List<String> tags,@Context SecurityContext securityContext);
    @GET
    @Path("/{petId}")
    
    @Produces({ "application/xml", "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Find pet by ID", notes = "Returns a single pet", response = Pet.class, tags={ "pet", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = Pet.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid ID supplied", response = Pet.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Pet not found", response = Pet.class) })
    public Response getPetById( @PathParam("petId") Long petId,@Context SecurityContext securityContext);
    @PUT
    
    @Consumes({ "application/json", "application/xml" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update an existing pet", notes = "", response = Void.class, tags={ "pet", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid ID supplied", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Pet not found", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 405, message = "Validation exception", response = Void.class) })
    public Response updatePet(@ApiParam(value = "Pet object that needs to be added to the store" ,required=true) Pet body,@Context SecurityContext securityContext);
    @POST
    @Path("/{petId}")
    @Consumes({ "application/x-www-form-urlencoded" })
    @Produces({ "application/xml", "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Updates a pet in the store with form data", notes = "", response = Void.class, tags={ "pet", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 405, message = "Invalid input", response = Void.class) })
    public Response updatePetWithForm( @PathParam("petId") Long petId,@ApiParam(value = "Updated name of the pet")@FormParam("name")  String name,@ApiParam(value = "Updated status of the pet")@FormParam("status")  String status,@Context SecurityContext securityContext);
    
}
