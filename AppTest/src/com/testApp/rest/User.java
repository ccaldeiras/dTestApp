package com.testApp.rest;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.testApp.dao.UserDAO;
import com.testApp.entity.UserEntity;

@Path("/user")
public class User {

	@GET
	public Response listar() {

		UserDAO user = new UserDAO();
		user.lista();

		String output = "read";

		return Response.status(200).entity(output).build();

	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Response atualizar() {

		UserDAO user = new UserDAO();

		// FAKE DATA
		UserEntity userEntity = new UserEntity();
		userEntity.setId(1);
		userEntity.setDescription("SSS");
		userEntity.setName("sss");

		user.cadastraUsuario(userEntity);

		String output = "read";

		return Response.status(200).entity(output).build();

	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deletar() {

		UserDAO user = new UserDAO();

		// FAKE DATA
		UserEntity userEntity = new UserEntity();
		userEntity.setId(1);
		userEntity.setDescription("SSS");
		userEntity.setName("sss");

		user.deletar(userEntity);

		String output = "read";

		return Response.status(200).entity(output).build();

	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response cadastrar() {

		UserDAO user = new UserDAO();

		// FAKE DATA
		UserEntity userEntity = new UserEntity();
		userEntity.setId(1);
		userEntity.setDescription("SSS");
		userEntity.setName("sss");

		user.cadastraUsuario(userEntity);

		String output = "read";

		return Response.status(200).entity(output).build();

	}

}
