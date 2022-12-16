package apifw.tests;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import apifw.actions.GetPatientList;
import apifw.actions.PostNewPatient;
import apifw.library.TestBase;
import io.restassured.response.Response;
import jxl.read.biff.BiffException;

public class TestPostNewPatient extends TestBase{

	
	@DataProvider(name = "getPatientData")
	public String[][] getPatientData() throws BiffException, IOException
	{
		String[][] patientData = getData(System.getProperty("user.dir")+"/src/main/java/apifw/testData/test_data_2.xls", 0);
		return patientData;
	}
	
	@BeforeClass
	public void initialize() throws IOException {
		init();
	}
	
	@Test(dataProvider = "getPatientData")
	public void testPostNewPatient(String firstName, String lastName, String email,
			String gender, String phoneNo, String doNotSMS, String active, String dob, String medRecNo,
			String admitDate, String roomNumber, String isPregnant, String updatedAt, String image,
			String locName, String rpmQualified, String language, String uuid, String doNotContact,
			String doNotContactReason, String preferredContactMethod, String noReplySMS, String createdAt,
			String phonetype, String userUuid, String address, String address2, String city, String state,
			String zip, String addressCreatedAt, String addressUpdatedAt, String execute)
	{
				
		PostNewPatient createPatient = new PostNewPatient();
		Response createPatientResponse = createPatient.sendPostNewPatientRequest(properties.getProperty("orgtoken"),
				firstName,lastName, email, gender, phoneNo, Integer.valueOf(doNotSMS), Boolean.valueOf(active), dob, medRecNo, admitDate,
				roomNumber,isPregnant, updatedAt, image, locName, Integer.valueOf(rpmQualified), language, Integer.valueOf(uuid), Integer.valueOf(doNotContact),
				doNotContactReason, preferredContactMethod, Integer.valueOf(noReplySMS), createdAt, phonetype, Integer.valueOf(userUuid),
				address, address2, city, state, zip, addressCreatedAt, addressUpdatedAt);
		Assert.assertEquals(createPatientResponse.getStatusCode(), 500);
		
		GetPatientList getList = new GetPatientList();
		Response patientListresponse = getList.sendGetPatientListRequest(properties.getProperty("orgtoken"));
		Assert.assertEquals(patientListresponse.getStatusCode(), 200);
		ArrayList<String> listOfFirstname = patientListresponse.getBody().jsonPath().get("data.firstname");
		Assert.assertTrue(listOfFirstname.contains(firstName));
		ArrayList<String> listOfLastname = patientListresponse.getBody().jsonPath().get("data.lastname");
		Assert.assertTrue(listOfLastname.contains(lastName));
		ArrayList<String> listOfEmail = patientListresponse.getBody().jsonPath().get("data.email");
		Assert.assertTrue(listOfEmail.contains(email));
	}
}
