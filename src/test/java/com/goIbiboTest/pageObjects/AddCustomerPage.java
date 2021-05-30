package com.goIbiboTest.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	WebDriver ldriver;
	public AddCustomerPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	/*
	 * @FindBy(linkText="addcustomerpage.php") WebElement lnkAddCustomer;
	 */
	@FindBy(xpath="//ul[@class='menusubnav']/li[2]")
	WebElement lnkAddCustomer;
	
	@FindBy(xpath="//input[contains(@name,'name')]")
	WebElement txtName;
	
	@FindBy(xpath="//input[contains(@name,'rad1')]")
	WebElement rdGender;
	
	@FindBy(id="dob")
	WebElement txtDOB;
	
	@FindBy(xpath="//textarea[contains(@name,'addr')]")
	WebElement txtAddress;
	
	@FindBy(name="city")
	WebElement txtCity;
	
	@FindBy(name="state")
	WebElement txtState;
	
	@FindBy(name="pinno")
	WebElement txtPin;
	
	@FindBy(name="telephoneno")
	WebElement txtTelephoneno;
	
	@FindBy(name="emailid")
	WebElement txtEmailid;
	
	@FindBy(name="password")
	WebElement txtPassword;
	
	@FindBy(name="sub")
	WebElement btnSubmit;
	
	public void clickAddNewCustomer()
	{
		lnkAddCustomer.click();
	}
	
	public void enterCustName( String cname)
	{
		txtName.sendKeys(cname);
	}
	
	public void custgender(String cgender) {
		rdGender.click();
	}

	public void custdob(String mm,String dd,String yy) {
		txtDOB.sendKeys(mm);
		txtDOB.sendKeys(dd);
		txtDOB.sendKeys(yy);
		
	}

	public void custaddress(String caddress) {
		txtAddress.sendKeys(caddress);
	}

	public void custcity(String ccity) {
		txtCity.sendKeys(ccity);
	}

	public void custstate(String cstate) {
		txtState.sendKeys(cstate);
	}

	public void custpinno(String cpinno) {
		txtPin.sendKeys(String.valueOf(cpinno));
	}

	public void custtelephoneno(String ctelephoneno) {
		txtTelephoneno.sendKeys(ctelephoneno);
	}

	public void custemailid(String cemailid) {
		txtEmailid.sendKeys(cemailid);
	}

	public void custpassword(String cpassword) {
		txtPassword.sendKeys(cpassword);
	}

	public void custsubmit() {
		btnSubmit.click();
	}
	
	
	

}
