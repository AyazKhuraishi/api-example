package com.github.rodolfoba.apiexample.backend.rest.api.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import com.github.rodolfoba.apiexample.backend.rest.api.PetApi;
import com.github.rodolfoba.apiexample.backend.rest.model.Pet;

@ApplicationScoped
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaResteasyEapServerCodegen", date = "2017-11-19T12:54:35.560Z")
public class PetApiServiceImpl implements PetApi {

	private Map<Long, Pet> cache = new HashMap<>();
	
	public Response addPet(Pet body, SecurityContext securityContext) {
		cache.put(body.getId(), body);
		return Response.ok().build();
	}

	public Response deletePet(Long petId, String apiKey, SecurityContext securityContext) {
		cache.remove(petId);
		return Response.ok().build();
	}

	public Response findPetsByStatus(List<String> status, SecurityContext securityContext) {
		return Response.ok().build();
	}

	public Response findPetsByTags(List<String> tags, SecurityContext securityContext) {
		return Response.ok().build();
	}

	public Response getPetById(Long petId, SecurityContext securityContext) {
		return Response.ok(cache.get(petId)).build();
	}

	public Response updatePet(Pet body, SecurityContext securityContext) {
		return Response.ok().build();
	}

	public Response updatePetWithForm(Long petId, String name, String status, SecurityContext securityContext) {
		return Response.ok().build();
	}
}
