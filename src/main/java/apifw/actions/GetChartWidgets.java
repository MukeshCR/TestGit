package apifw.actions;

import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetChartWidgets {
	
	public Response sendGetChartWidgetsRequest(String sessionKey)
	{
		RequestSpecification request = RestAssured.given().log().all();
		request.header("Authorization", sessionKey);
		request.header("Content-Type","application/json");
		
Response response = request.get("https://capi.qliqsoft.com/quincy_api/v1/chat_widgets");
		
		return response;
		
	}

}
