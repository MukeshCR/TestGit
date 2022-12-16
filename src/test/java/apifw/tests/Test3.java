package apifw.tests;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import apifw.library.TestBase;

public class Test3 extends TestBase{
	
	@BeforeClass
	public void initialize() throws IOException {
		init();
	}
	
	@Test
	public void test3PrintId() throws IOException
	{
		int id = Integer.valueOf(properties.getProperty("startingPartnerID"));
		System.out.println("Test 3 : "+id);
		if(id == Integer.valueOf(properties.getProperty("startingPartnerID")))
		{
			updateProperty("startingPartnerID", String.valueOf(++id));
		}
	}

}
