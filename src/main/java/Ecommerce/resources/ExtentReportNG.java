package Ecommerce.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
	
	public static ExtentReports extentReport()
	{
		String reportFilePath=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(reportFilePath);
		reporter.config().setDocumentTitle("Test Results");
		reporter.config().setReportName("Web Automation Results");
		ExtentReports extent =new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Rohit");
		return extent;
	}
}
