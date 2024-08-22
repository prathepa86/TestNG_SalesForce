package testscenarios;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class TC001_login extends BaseClass{
	
	@BeforeTest
	public void TestCaseSetUp() {
		ExcelFileName="TC_01";
		author="Prathepa";
		category="Login field";
		TestCase="Login test scenario";
		TestDesc="Login feild validation";
		nodes="login";
		
		
	}
	
	@Test(priority=1)
	public void loginFieldValidation() {
		boolean result=new LoginPage(driver,node)
		.verifyLoginElements();
		Assert.assertTrue(result);
	}
	
	@Test(priority=2,dataProvider = "ExcelData")
	public void loginWithValidCredentials(String username,String password) {
	boolean result	=new LoginPage(driver,node)
				.enterUserName(username)
				.enterPassword(password)
				.clickOnLoginBtnWithValidCredentials()
				.clickOnUserImg()
				.clickOnLogOutBtn()
				.verifyLoginElements();
				
	Assert.assertTrue(result);
		
	}
	
	@Test(priority=3)
	public void loginWithInvalidCredentials() {
		boolean result=new LoginPage(driver,node)
				.enterUserName("preethi.pasupathi@gmail.com")
				.enterPassword("prathepa@123")
				.clickOnLoginBtnWithInvalidCredentials()
				.validateErrorMessage();
		Assert.assertTrue(result);
	}

}
