package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import base.BaseClass;
import libraries.SeleniumWrapper;


public class MenuPage extends BaseClass{
	
	private By UserImg=By.xpath("//div[@data-aura-class='forceEntityIcon']/span");
	private By logoutBtn=By.xpath("//a[text()='Log Out']");
	private WebDriver driver;
	private SeleniumWrapper oWrap;
	
	public MenuPage(WebDriver driver,ExtentTest node) {
		
		this.driver=driver;
		this.node=node;
		oWrap=new SeleniumWrapper(driver,node);
	}
	
	public MenuPage clickOnUserImg() 
	{    try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}
		oWrap.click(driver.findElement(UserImg));
		return this;
	}
	public LoginPage clickOnLogOutBtn() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		oWrap.click(driver.findElement(logoutBtn));
	    return new LoginPage(driver,node);
	}
	
	

}
