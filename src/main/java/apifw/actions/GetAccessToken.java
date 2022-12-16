package apifw.actions;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

import apifw.library.ResourceURI;
import apifw.library.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetAccessToken extends TestBase{
	
	public Response sendGetAccessTokenRequest(String username, String password)
	{
		RequestSpecification request = RestAssured.given().log().all();
		Map<String, String> credentials = new HashMap<String, String>();// Map for capturing body params
		credentials.put("Username", username);
		credentials.put("Password", password);

		JSONObject json = new JSONObject();
		json.putAll(credentials);// converting Map to JSON object

		request.body(json.toJSONString());// passing JSON string to request body
		request.header("Content-Type","application/json");
		Response response = request.post(properties.getProperty("baseURL")+ResourceURI.GET_ACCESS_TOKEN.getUri());
		return response;
		
	}
	
	public String fetchAccessToken(Response response)
	{
		String token = response.getBody().asString();
		return token;
	}

}
