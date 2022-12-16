package apifw.tests;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import apifw.actions.GetUserAuthentication;
import apifw.library.TestBase;
import io.restassured.response.Response;
import junit.framework.Assert;

public class TestGetUserAuthentication extends TestBase{
	
	@BeforeClass
	public void initialize() throws IOException {
		init();
	}
	
	@Test
	public void testGetUserAuthentication()
	{
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");
		String action = "GetUserAuthentication";
		String appName = properties.getProperty("appname");
		String appUserID = properties.getProperty("appuserid");
		String patientID = "";
		String param1 = properties.getProperty("apppassword");
		String param2 = "";
		String param3 = "";
		String param4 = "";
		String param5 = "";
		String param6 = "";
		String data = "";
		
		GetUserAuthentication authenticate = new GetUserAuthentication();
		
		Response response = authenticate.sendGetUserAuthenticationRequest(username, password, action, appName, appUserID,
				patientID, param1, param2, param3, param4, param5, param6, data);
		Assert.assertEquals(200, response.getStatusCode());
		Assert.assertTrue(response.jsonPath().get("getuserauthenticationinfo[0].product[0]").toString() != null);
		Assert.assertTrue(response.jsonPath().get("getuserauthenticationinfo[0].AppLicenseType[0]").toString() != null);
		Assert.assertTrue(response.jsonPath().get("getuserauthenticationinfo[0].AppLicenseCount[0]").toString() != null);
		Assert.assertTrue(response.jsonPath().get("getuserauthenticationinfo[0].ValidUser[0]").toString() != null);
		Assert.assertTrue(response.jsonPath().get("getuserauthenticationinfo[0].AppLicenseExpireDate[0]").toString() != null);
		Assert.assertTrue(response.jsonPath().get("getuserauthenticationinfo[0].ClientID[0]").toString().isEmpty());
		
	}

}
