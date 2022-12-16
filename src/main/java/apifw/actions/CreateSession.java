package apifw.actions;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateSession {
	
	public Response sendCreateSessionRequest()
	{
		RequestSpecification request = RestAssured.given().log().all();
		
		request.header("Authorization", "5464546446hfgfjfhfjghgju76768jghghg");
		
		Response response = request.post("https://capi.qliqsoft.com/quincy_api/v1/session");
		
		return response;
	}

}
