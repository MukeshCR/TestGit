package apifw.actions;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

import apifw.library.ResourceURI;
import apifw.library.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetUserAuthentication extends TestBase{
	
	
	
	public Response sendGetUserAuthenticationRequest(String username, String password, String action, 
			String appName, String appUserID, String patientID, String param1,
			String param2, String param3, String param4, String param5, String param6, String data)
	{
	
	GetAccessToken getToken = new GetAccessToken();
	
	String authToken = getToken.fetchAccessToken(getToken.sendGetAccessTokenRequest(username, password));
	
	RequestSpecification request = RestAssured.given().log().all();
	
	Map<String, String> bodyParam = new HashMap<String, String>();
	
	bodyParam.put("Action", action);
	bodyParam.put("Appname", appName);
	bodyParam.put("AppUserID", appUserID);
	bodyParam.put("PatientID", "");
	bodyParam.put("Token", authToken);
	bodyParam.put("Parameter1", "");
	bodyParam.put("Parameter2", "");
	bodyParam.put("Parameter3", "");
	bodyParam.put("Parameter4", "");
	bodyParam.put("Parameter5", "");
	bodyParam.put("Parameter6", "");
	bodyParam.put("Data", "");
	
	JSONObject json = new JSONObject();
	json.putAll(bodyParam);
	
	request.body(json.toJSONString());
	request.header("Content-Type","application/json");
	Response response = request.post(properties.getProperty("baseURL")+ResourceURI.GET_USER_AUTHENTICATION.getUri());
	
	return response;
	
	}
	

}
