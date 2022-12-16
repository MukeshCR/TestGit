package apifw.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import apifw.actions.GetAccessToken;
import apifw.library.TestBase;
import io.restassured.response.Response;


public class TestGetAccessToken extends TestBase{
	
	
	@BeforeClass
	public void initialize() throws IOException {
		init();
	}
	
	@Test
	public void testGetAccessToken()
	{	
		GetAccessToken getToken = new GetAccessToken();
		Response response = getToken.sendGetAccessTokenRequest(properties.getProperty("username"), properties.getProperty("password"));
		Assert.assertEquals(200, response.getStatusCode());
		Assert.assertTrue(response.getBody().asString() != null);
	}

}
