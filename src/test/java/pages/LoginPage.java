package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;


import libraries.SeleniumWrapper;

public class LoginPage extends MenuPage{

	private By UsernameTxt=By.id("username");
	private By PasswordTxt=By.id("password");
	private By loginBtn=By.xpath("//input[@name='Login']");
	private By errorMsg=By.xpath("//div[@id='error']");
	private WebDriver driver;
	private SeleniumWrapper oWrap;
	
	public LoginPage(WebDriver driver,ExtentTest node) {
		super(driver,node);
		this.driver=driver;
		this.node=node;
		oWrap=new SeleniumWrapper(driver,node);
	}
	
	public LoginPage enterUserName(String username ) {
		oWrap.type(driver.findElement(UsernameTxt),username);
		return this;
	}
	
	public LoginPage enterPassword(String password) {
		oWrap.type(driver.findElement(PasswordTxt), password);
		return this;
	}
	
	public LoginPage clickOnLoginBtnWithValidCredentials() {
		oWrap.click(driver.findElement(loginBtn));
		return this;
	}
	
	public LoginPage clickOnLoginBtnWithInvalidCredentials() {
		oWrap.click(driver.findElement(loginBtn),"Login button");
		return this;
	}
	
	public boolean validateErrorMessage() {
		if(oWrap.VerifyDisplayedWithReturn(driver.findElement(errorMsg))) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public boolean verifyLoginElements() {
		if(oWrap.VerifyDisplayedWithReturn(driver.findElement(UsernameTxt))&&
				oWrap.VerifyDisplayedWithReturn(driver.findElement(PasswordTxt))&&
				oWrap.VerifyDisplayedWithReturn(driver.findElement(loginBtn))) {
			return true;
		}else {
			return false;
		}
	}

}
