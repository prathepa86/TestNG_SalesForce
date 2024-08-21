package base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import libraries.ExtentReport;
import util.ExcelReader;
import util.PropertyReader;

public class BaseClass extends ExtentReport{
public WebDriver driver;
public String fileName="environment";
public String URL=PropertyReader.readDataFromPropertyFile("sURL", fileName);
public String browserType=PropertyReader.readDataFromPropertyFile("sBrowser", fileName);
public String TestCase,Desc,nodes;
public String ExcelFileName;

@BeforeSuite
public void reportInit() {
	startReport();
}

@AfterSuite
public void reportBind() {
	endReport();
}


public void invokeBrowser() {
	
	switch(browserType.toLowerCase()) {
	case "chrome":
		System.out.println("The user option is :"+browserType+"So, invoking the chrome browser");
	    driver=new ChromeDriver();
	    break;
	case "firefox":
		System.out.println("The user option is :"+browserType+"So, invoking the edge browser");
		driver=new EdgeDriver();
		break;
		
	default:
		System.out.println("The user option is wrong."+browserType+"So, invoking default chrome browser");
		driver=new ChromeDriver();
	    break;
	}
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	driver.get(URL);
	startTestCase(TestCase,Desc);
	startTestCase(nodes);
	
		
}

@DataProvider(name="ExcelData")
public Object[][] ExcelData() {
	Object[][] data = ExcelReader.readDataFromExcel(ExcelFileName);
	return data;
}


@Override
public String takeScreenshot() {
	String sPath=System.getProperty("user.dir")+"/snap/img"+System.currentTimeMillis()+".png";
	File dest=new File(sPath);
	TakesScreenshot oShot=(TakesScreenshot)driver;
	File src = oShot.getScreenshotAs(OutputType.FILE);
	try {
		FileUtils.copyFile(src, dest);
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	return sPath;
	
}

}
