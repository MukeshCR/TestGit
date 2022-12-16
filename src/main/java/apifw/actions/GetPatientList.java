package apifw.actions;

import apifw.library.ResourceURI;
import apifw.library.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetPatientList extends TestBase{
	
	public Response sendGetPatientListRequest(String token)
	{
		RequestSpecification request = RestAssured.given().log().all();
		request.header("Content-Type","application/json");
		request.header("Authorization","Bearer "+token);
		Response response = request.get(properties.getProperty("docsinkbaseURL")+ResourceURI.GET_PATIENT_LIST.getUri());
		return response;
	}

}
