package com.zin;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Added a comment for commit to happen-4
 * @author Asad.Ali
 *
 */
@Path("/")
public class RSWS {
	private static List<User> listUsers = new ArrayList<User>();
	
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/ping")
	public Response ping()
	{
		String output = "Webservice is working11";
		return Response.status(200).entity(output).build();
	}
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/addUser")
	public Response addUser(User user)
	{
		String output = "";
		///check if user already exists
		boolean alreadyExists = listUsers.contains(user);
		
		if(alreadyExists){
			output = "User Already exists";
			return Response.status(200).entity(output).build();
			
		}else{
			boolean added = listUsers.add(user);
			output = "User Successfully Added";
			return Response.status(200).entity(output).build();
		}
		
	}
	
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/removeUser")
	public Response removeUser(User user)
	{
		String output = "";
		///check if user already exists
		boolean alreadyExists = listUsers.contains(user);
		if(alreadyExists){
			boolean removed = listUsers.remove(user);
			if(removed){
				output = "User Successfully Removed";
				return Response.status(200).entity(output).build();
			}else{
				output = "User not removed please check with Administrator";
				return Response.status(200).entity(output).build();
			}
		}else{
			output = "User Does not exist";
			return Response.status(200).entity(output).build();
		}
	}

}
