package apifw.actions;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

import apifw.library.ResourceURI;
import apifw.library.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostNewPatient extends TestBase{
	
	public Response sendPostNewPatientRequest(String token, String firstName, String lastName, String email,
			String gender, String phoneNo, int doNotSMS, boolean active, String dob, String medRecNo,
			String admitDate, String roomNumber, String isPregnant, String updatedAt, String image,
			String locName, int rpmQualified, String language, int uuid, int doNotContact,
			String doNotContactReason, String preferredContactMethod, int noReplySMS, String createdAt,
			String phonetype, int userUuid, String address, String address2, String city, String state,
			String zip, String addressCreatedAt, String addressUpdatedAt)
	{
		RequestSpecification request = RestAssured.given().log().all();
		request.header("Content-Type","application/json");
		request.header("Authorization","Bearer "+token);
		
		Map<String, String> patientAddressData = new HashMap<String, String>();
		
		patientAddressData.put("address", address);
		patientAddressData.put("address2", address2);
		patientAddressData.put("city", city);
		patientAddressData.put("state", state);
		patientAddressData.put("zip", zip);
		patientAddressData.put("created_at", addressCreatedAt);
		patientAddressData.put("updated_at", addressUpdatedAt);
		
		Map<String, Object> patientData = new HashMap<String, Object>();
		
		patientData.put("firstname", firstName);
		patientData.put("lastname", lastName);
		patientData.put("email", email);
		patientData.put("gender", gender);
		patientData.put("phone_no", phoneNo);
		patientData.put("do_not_sms", doNotSMS);
		patientData.put("active", active);
		patientData.put("dob", dob);
		patientData.put("med_rec_no", medRecNo);
		patientData.put("admit_date", admitDate);
		patientData.put("room_number", roomNumber);
		patientData.put("is_pregnant", isPregnant);
		patientData.put("updated_at", updatedAt);
		patientData.put("image", image);
		patientData.put("loc_name", locName);
		patientData.put("rpm_qualified", rpmQualified);
		patientData.put("language", language);
		patientData.put("uuid", uuid);
		patientData.put("do_not_contact", doNotContact);
		patientData.put("do_not_contact_reason", doNotContactReason);
		patientData.put("preferred_contact_method", preferredContactMethod);
		patientData.put("no_reply_sms", noReplySMS);
		patientData.put("created_at", createdAt);
		patientData.put("phone_type", phonetype);
		patientData.put("user_uuid", userUuid);
		patientData.put("address", patientAddressData);
		
		JSONObject json = new JSONObject();
		
		json.putAll(patientData);
		request.body(json.toJSONString());
		Response response = request.post(properties.getProperty("docsinkbaseURL")+ResourceURI.POST_NEW_PATIENT.getUri());
		
		return response;
		
	}

}
