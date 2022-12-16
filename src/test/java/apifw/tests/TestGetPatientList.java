package apifw.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import apifw.actions.GetPatientList;
import apifw.library.TestBase;
import io.restassured.response.Response;

public class TestGetPatientList extends TestBase{
	
	
	@BeforeClass
	public void initialize() throws IOException {
		init();
	}
	
	@Test
	public void testGetPatientList()
	{
		GetPatientList getList = new GetPatientList();
		Response response = getList.sendGetPatientListRequest(properties.getProperty("orgtoken"));
		response.prettyPrint();
		Assert.assertEquals(response.getStatusCode(), 200);
	}

}
