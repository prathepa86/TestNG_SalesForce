package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import util.PropertyReader;

public class BaseClass {
public WebDriver driver;
public String fileName="environment";
public String URL=PropertyReader.readDataFromPropertyFile("sURL", fileName);
public String browserType=PropertyReader.readDataFromPropertyFile("sBrowser", fileName);



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
	
		
}

}
