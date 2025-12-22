package com.trywill.testUtility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.trywill.testbase.Constants;

public class ReportsUtility {

	
	public static ExtentReports createReport(String reportName)
	{
		ExtentSparkReporter spark=new ExtentSparkReporter(Constants.REPORT_DIR+reportName+Constants.REPORT_FORMAT);
		
		spark.config().setDocumentTitle("Try Will Automation");
		
		spark.config().setReportName("Test Automation - Results");
		
		spark.config().setEncoding("UTF-8");
		
		spark.config().setTheme(Theme.DARK);
		
		spark.config().setTimeStampFormat("dd-MM-yyyy, hh:mm:ss- EEE");
		
		ExtentReports report=new ExtentReports();
		report.attachReporter(spark);
		
		return report;
	}
}
