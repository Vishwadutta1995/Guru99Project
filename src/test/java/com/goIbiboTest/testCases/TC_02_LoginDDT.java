package com.goIbiboTest.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.goIbiboTest.pageObjects.LoginPage;
import com.goIbiboTest.utilities.XLUtils;

public class TC_02_LoginDDT extends BaseClass {
	@Test(dataProvider="LoginData")
	public void loginDDT(String uname, String pwd)
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(uname);
		logger.info("username provided");
		lp.setPassword(pwd);
		logger.info("password provided");
		lp.clickSubmit();
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.info("Login failed");
		}
		else
		{
			Assert.assertTrue(true);
			lp.clickLogout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			logger.info("Login passed");
		}
	}
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/goIbiboTest/testData/Testdata.xlsx";
		int rownum=XLUtils.getRowCount(path, "sheet1");
		int columnCount=XLUtils.getCellCount(path, "sheet1", rownum);
		String loginData[][]=new String[rownum][columnCount];
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<columnCount;j++)
			{
				loginData[i-1][j]=XLUtils.getCellData(path, "sheet1", i, j);
			}
		}
		return loginData;
	}
	
	public boolean isAlertPresent()
	{
		try {
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
	}
	}
	

}
