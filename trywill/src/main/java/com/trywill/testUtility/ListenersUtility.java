package com.trywill.testUtility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ListenersUtility implements ITestListener{
	
	ExtentReports report ;
	ExtentTest test;
	String methodName;
	
	@Override
	public void onStart(ITestContext context) {
		System.out.println("Automation Project Started Successfully");
		report = ReportsUtility.createReport("Extent");
	}

	@Override
	public void onTestStart(ITestResult result) {
		methodName = result.getName();
		System.out.println(methodName+" Method started....");
		test = report.createTest(methodName);
		test.log(Status.INFO, "Test method got started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(methodName+" Method got passed....");
		test.log(Status.PASS, "Test method got passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(methodName+" Method got failed....");
		String screenshot = DriverUtility.getInstance().captureScreenshot(methodName);
		test.log(Status.FAIL, "Test method got failed - "+result.getThrowable());
		test.addScreenCaptureFromPath(screenshot, "Failed screenshot...");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println(methodName+" Method got skipped....");
		test.log(Status.SKIP, "Test method got skipped");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Automation Project completed Successfully");
		report.flush();
	}

}
