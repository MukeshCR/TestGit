package apifw.tests;

import org.testng.annotations.Test;

import apifw.library.TestBase;

public class Test4 extends TestBase{

	
	@Test
	public void testCurrentDate()
	{
		for(int i=0;i<=20;i++)
		{
		System.out.println(getCurrentTimestamp());
		}
	}
	
	
}
