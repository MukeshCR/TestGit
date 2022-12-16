package apifw.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import apifw.actions.CreateSession;
import apifw.actions.GetChartWidgets;
import apifw.library.TestBase;
import io.restassured.response.Response;

public class TestGetChartWidgets extends TestBase{

	@BeforeClass
	public void initialize() throws IOException {
		init();
	}
	
	
	@Test
	public void testGetChartWidgets()
	{
		
		CreateSession create = new CreateSession();
		
		 Response createSessionResponse = create.sendCreateSessionRequest();
		 
		 Assert.assertEquals(200, createSessionResponse.getStatusCode());
		 
		 String sessionKey = createSessionResponse.getBody().jsonPath().getString("session_key");
		 
		 GetChartWidgets getWidgets = new GetChartWidgets();
		 
		 Response widgets = getWidgets.sendGetChartWidgetsRequest(sessionKey);
		 
		 Assert.assertEquals(200, widgets.getStatusCode());
		 
		 
		 
		 
		
		
	}
	
	
	
	
}
