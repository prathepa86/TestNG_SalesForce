package libraries;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public abstract class ExtentReport {
	 
	public static ExtentSparkReporter spark;
	public static ExtentReports extent;
	public ExtentTest test,node;
	public String author,category;
	
	public void startReport() {
		spark=new ExtentSparkReporter("./reports/SalesForceHTMLReport.html");
		extent=new ExtentReports();
		extent.attachReporter(spark);
	}
	
	public void endReport() {
		extent.flush();
	}
	
	public ExtentTest startTestCase(String TestCase,String Desc) {
		test=extent.createTest(TestCase,Desc);
		test.assignAuthor(author);
		test.assignCategory(category);
		return test;
	}
	
	public ExtentTest startTestCase(String nodes) {
		node=test.createNode(nodes);
		return node;
	}
	
	public void reportStep(String desc,String status) {
		if(status.equalsIgnoreCase("pass")) {
			node.pass(desc,MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());
			}else if(status.equalsIgnoreCase("fail")) {
				node.fail(desc, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());
			}else {
				node.info(desc);
			}
	
	}
	
	public abstract String takeScreenshot();

}
