package testcases;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseTest {
	public static ExtentTest test;
	public static ExtentReports report;
	

	@BeforeSuite
	public void reportSetup() {
		report = new ExtentReports(System.getProperty("user.dir") + "/test-output/ExtentReportResults.html");
		System.out.println(System.getProperty("user.dir") + "/test-output/ExtentReportResults.html");
		test = report.startTest("ExtentDemo");
		
		
	}

	@AfterMethod
	public void getResult(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.FAIL, result.getName() + " Test case Failed");
			test.log(LogStatus.FAIL, result.getThrowable());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(LogStatus.PASS, result.getName() + " Test case Passed");
		}

		else {
			test.log(LogStatus.SKIP, result.getName() + " Test case Skipped");
			test.log(LogStatus.SKIP, result.getThrowable());
		}
	}

	@AfterSuite
	public void reportTearDown() {
		report.flush();
	}

}
