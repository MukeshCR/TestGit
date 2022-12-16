package apifw.tests.phelixRaceCondition;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import apifw.actions.raceCondition.CreateAppointment;
import apifw.actions.raceCondition.UpdateAppointment;
import apifw.library.TestBase;
import io.restassured.response.Response;
import jxl.read.biff.BiffException;

public class Appointment1 extends TestBase{
	
int apptId;
String name = "automation 1 test 1";
String startTime = "2021-10-27T14:00:00.000Z";
String endTime = "2021-10-27T14:02:00.000Z";
String bookingSource = "bh";
String createDateTime = "2021-10-25T09:00:00.000Z";
String updateDateTime = "2021-10-25T09:00:00.000Z";
String creator = "bh";
String patientEMRId = "756";//automation 1 test 1
String location = "";
String emrPhysicianId = "4";//jennifer fyfe 
String status = "t";
String notes = "test notes";
String reason = "test reason";
String type = "Phone";
	
	@DataProvider(name = "updateAppointmentData", parallel = true)
	public String[][] getCreateLocationData() throws BiffException, IOException
	{
		String[][] userData = getData(System.getProperty("user.dir")+"/src/main/java/com/phelix/testData/test_data_partner_service.xls", 6);
		
		return userData;
	}
	
	@BeforeClass
	public void initialize() throws IOException
	{
		init();
	}
	
	@Test
	public void createAppointmentTest()
	{
		CreateAppointment create = new CreateAppointment();
		Response response = create.sendCreateAppointmentRequest(name, startTime, endTime, bookingSource,
				createDateTime, updateDateTime, creator, patientEMRId, location, emrPhysicianId, status,
				notes, reason, type);
		Assert.assertEquals(response.getStatusCode(), 201);
		apptId = response.getBody().jsonPath().get("return");
	}
	
	@Test(dataProvider = "updateAppointmentData", dependsOnMethods = {"createAppointmentTest"})
	public void updateAppointmentTest(String updatedLocation, String updatedStatus, String updatedNotes,
			String updatedReason, String updatedType, String execute)
	{
		
		String requestStartTime = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss.SSS").format(new Date());
		UpdateAppointment updateAppt = new UpdateAppointment();
		Response response = updateAppt.sendUpdateAppointmentRequest(apptId, name, startTime, endTime, bookingSource,
				createDateTime, updateDateTime, creator, patientEMRId, updatedLocation, emrPhysicianId,
				updatedStatus, updatedNotes, updatedReason, updatedType);
		String requestEndTime = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss.SSS").format(new Date());
		Assert.assertEquals(response.getStatusCode(), 202);
		System.out.println("==============="+requestStartTime+"==========="+requestEndTime+"==========");
		
	}

}
