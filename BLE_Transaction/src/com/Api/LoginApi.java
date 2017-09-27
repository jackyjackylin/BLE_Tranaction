package com.Api;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
  
@Path("/LoginApi")
public class LoginApi {
       
     @GET
     @Produces(MediaType.TEXT_PLAIN)
     public String getHelloWorld() {
       String response = "Hello World :)";
       return response;
     }
      
     @POST
     @Produces(MediaType.TEXT_PLAIN)
     public String postHelloWorld() { 
    	String response = "Hello World :)post";
         return response;
     }
       
     @GET
     @Path("/{getparameter}")
     @Produces(MediaType.APPLICATION_JSON)
     public String getByPathParameterAndQueryPath(
       @PathParam(value="getparameter") String getparameter,
       @QueryParam(value="q") String q) throws JSONException {
       System.out.println(getparameter);
       System.out.println(q);
       JSONObject json = new JSONObject();
       json.put("pathParameter", getparameter);
       json.put("q", q);
       return json.toString();
     }  
}

