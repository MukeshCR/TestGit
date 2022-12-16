package apifw.actions.raceCondition;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

import apifw.library.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateAppointment extends TestBase{

	public Response sendCreateAppointmentRequest(String name, String startTime, String endTime, String bookingSource, 
			String createDateTime, String updateDateTime, String creator, String patientEMRId, String location, 
			String emrPhysicianId, String status, String notes, String reason, String type)
	{

		RequestSpecification request = RestAssured.given().log().all();

		Map<String, Object> appointmentDetails = new HashMap<String, Object>();


		appointmentDetails.put("name", name);
		appointmentDetails.put("startTime", startTime);
		appointmentDetails.put("endTime", endTime);
		appointmentDetails.put("bookingSource", bookingSource);
		appointmentDetails.put("createDateTime", createDateTime);
		appointmentDetails.put("updateDateTime", updateDateTime);
		appointmentDetails.put("creator", creator);
		appointmentDetails.put("patientEMRId", patientEMRId);
		appointmentDetails.put("location", location);
		appointmentDetails.put("emrPhysicianId", emrPhysicianId);
		appointmentDetails.put("status", status);
		appointmentDetails.put("notes", notes);
		appointmentDetails.put("reason", reason);
		appointmentDetails.put("type", type);

		JSONObject json = new JSONObject();
		json.putAll(appointmentDetails);

		//headers
		request.header("Content-Type", "application/json");
		//request.header("x-partner-id", 32);//dev
		request.header("x-partner-id", 1);//UAT
		request.header("apikey",properties.getProperty("apiKey"));
		request.header("x-client-name",properties.getProperty("x-client-name"));
		request.header("x-client-secret",properties.getProperty("x-client-secret"));
		
		request.body(json.toJSONString());
		//Response response = request.post("https://dev.api.blockhealth.co/emr/oscar/appointment");
		Response response = request.post("https://staging-api.phelix.ai/emr/oscar/appointment");
		return response;
	}

}
