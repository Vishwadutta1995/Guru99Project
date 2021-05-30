package com.goIbiboTest.testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.goIbiboTest.pageObjects.AddCustomerPage;
import com.goIbiboTest.pageObjects.LoginPage;

import java.io.IOException;
import java.util.*;
public class TC_03_AddNewCustTest extends BaseClass {
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(username);
		logger.info("username is provided");
		lp.setPassword(password);
		logger.info("password is provided");
		lp.clickSubmit();
		
		
		AddCustomerPage addCust=new AddCustomerPage(driver);
		addCust.clickAddNewCustomer();
		
		logger.info("customer details are provided");
		addCust.enterCustName("SamratHulk");
		addCust.custgender("male");
		addCust.custdob("06", "18", "1995");
		Thread.sleep(3000);
		addCust.custaddress("Napit para");
		addCust.custcity("Dumka");
		addCust.custstate("Jharkhand");
		addCust.custpinno("814101");
		addCust.custtelephoneno("8861569683");
		addCust.custemailid(randomString()+"@gmail.com");
		addCust.custpassword("admin123");
		addCust.custsubmit();
		
		Thread.sleep(3000);
		
		logger.info("validation started....");
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		if(res==true) {
			Assert.assertTrue(true);
			logger.info("test case is passed");
		}else {
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
			logger.info("test case is failed");
		}
		
		
		
		
		
	}
	
	

}
