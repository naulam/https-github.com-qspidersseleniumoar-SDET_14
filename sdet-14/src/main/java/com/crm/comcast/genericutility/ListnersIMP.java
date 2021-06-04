package com.crm.comcast.genericutility;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
/**
 * 
 * @author Nitheesha
 *
 */
public class ListnersIMP implements ITestListener{
	ExtentReports reports;
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		//Behaves like @Test
	 test=reports.createTest(result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		//write log for passed methods
		test.log(Status.PASS, result.getMethod().getMethodName()+" is Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, result.getMethod().getMethodName()+" is failed");
		test.log(Status.FAIL, result.getThrowable());
		try {
			WebDriverUtility theWebdriverUtility = new WebDriverUtility();
			String screenshotName=result.getMethod().getMethodName()+JavaUtility.getSystemDate();
			String path = theWebdriverUtility.takeScreenshot(BaseClass.staticDriver, screenshotName);
			test.addScreenCaptureFromPath(path);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName()+" is skipped");
		test.log(Status.SKIP, result.getThrowable());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	@Override
	public void onStart(ITestContext context) {
		//BeforeSuite:- configuration steps for sparkreporter and extentreporter
		ExtentSparkReporter htmlReporter=new ExtentSparkReporter(IPathConstant.EXTENTREPORT);
		//Title of the page
		htmlReporter.config().setDocumentTitle("VTiger Comcast Project");
		//Set report name
		htmlReporter.config().setReportName("SmokeTest");
		//Set theme color
		htmlReporter.config().setTheme(Theme.DARK);
		
	
		//Create a object of extent reports to attach above configuration
		 reports=new ExtentReports();
		//attach spark configuration
		reports.attachReporter(htmlReporter);
		//write some System info
		PropertyFileUtility prop = new PropertyFileUtility();
		reports.setSystemInfo("OS", "Windows");
		reports.setSystemInfo("Platform", "Windows 10 Pro");
		try {
			reports.setSystemInfo("Test Url", prop.readDataFromPropertyFfile("url"));
			reports.setSystemInfo("Browser", prop.readDataFromPropertyFfile("browser"));
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void onFinish(ITestContext context) {
		//@AfterSuite
		reports.flush();
		
	}

}
