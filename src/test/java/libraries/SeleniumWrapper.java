package libraries;

import java.time.Duration;

import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import base.BaseClass;

public class SeleniumWrapper extends BaseClass{
	
	public SeleniumWrapper(WebDriver driver,ExtentTest node) {
		this.driver=driver;
		this.node=node;
		
	}
	
	public void type(WebElement ele,String data) {
		try {
			ele.clear();
			ele.sendKeys(data);
			reportStep("The data:"+data+"entered successfully in the field","PASS");
		}catch(InvalidElementStateException e) {
			reportStep("The data:"+data+"couldnt enter successfully in this field","FAIL");
		}catch(WebDriverException e) {
			e.printStackTrace();
			reportStep("Unknown exception occurred while entering the "+data+ "in the field","FAIL");
		}
	}
	
	public void click(WebElement ele) {
		String text="";
		try {
			WebDriverWait oWait=new WebDriverWait(driver,Duration.ofSeconds(10));
			oWait.until(ExpectedConditions.elementToBeClickable(ele));
			text=ele.getText();
			ele.click();
			reportStep("The element is"+text+" clicked:","PASS");
			
		}catch(InvalidElementStateException e) {
			reportStep("The element:"+text+"couldnot be clicked","FAIL");
		}catch(WebDriverException e) {
			reportStep("Unknown Exception occured while clicking in this feild","FAIL");
		}
			
		}
	
	public void click(WebElement ele,String elename) {
		try {
			WebDriverWait oWait=new WebDriverWait(driver,Duration.ofSeconds(10));
			oWait.until(ExpectedConditions.elementToBeClickable(ele));
			ele.click();
			reportStep("The element"+elename+"is clicked","PASS");
		}catch(InvalidElementStateException e) {
			reportStep("The element"+elename+"couldn't be clicked","FAIL");
		}catch(WebDriverException e) {
			reportStep("The element"+elename+"couldn't be clicked","FAIL");
		}
		
	}
	
	
	public boolean VerifyDisplayedWithReturn(WebElement ele) {
		boolean result=false;
		
		try {
			String attribute=ele.getAttribute("name");
			if(ele.isDisplayed()) {
				reportStep("The element "+attribute+"is visible","PASS");
				return true;
			}else {
				reportStep("The element"+attribute+"is not visible","FAIL");
			}
		}catch(WebDriverException e) {
			reportStep("WebDriver exception"+e.getMessage(),"FAIL");
		}
		return result;
		
	}
	
	public boolean VerifyDisplayWithReturn(WebElement ele,String element) {
		boolean result=false;
		try {
			
			if(ele.isDisplayed()) {
				reportStep("The element"+element+"is visible","PASS");
				return true;
				
			}else {
				reportStep("The element"+element+"is not visible","FAIL");
			}
		}catch(WebDriverException e) {
			reportStep("WebDriver exception"+e.getMessage(),"FAIL");
		}
		return result;
	}
	

}
