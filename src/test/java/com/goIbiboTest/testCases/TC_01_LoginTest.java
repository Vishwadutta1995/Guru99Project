package com.goIbiboTest.testCases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.goIbiboTest.pageObjects.LoginPage;

public class TC_01_LoginTest extends BaseClass {
	@Test
	public void loginTest() throws IOException {
		
		
		logger.info("URL Launched");
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(username);
		lp.setPassword(password);
		lp.clickSubmit();
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Test case passed");
		}
		else
		{
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("Test Case Failed");
		}
			
		
	}

}
