package tapanhpandya.listeners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import tapanhpandya.reporter.TestReporter;

import org.testng.ITestContext;

public class TestListener implements ITestListener {
	WebDriver driver;
	ExtentTest test;
	ExtentReports report = TestReporter.getReportObject();
	ExtentSparkReporter sparkReporter = TestReporter.sparkReporter;
	
	@Override
	public void onTestStart(ITestResult result) {
		test = TestReporter.startExtentTest(result.getMethod().getMethodName());
		TestReporter.setReportName(result.getMethod().getMethodName());
		TestReporter.setWebPageTitle(result.getName());
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
//		test.log(Status.PASS, "Test has been passed!!!");
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"//src//main//java//tapanhpandya//screenshots//"+result.getMethod().getMethodName()+"_Success.png";
		try {
			FileUtils.copyFile(screenShot, new File(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(path, result.getMethod().getMethodName());
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
//		test.log(Status.FAIL, result.getThrowable());
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"//src//main//java//tapanhpandya//screenshots//"+result.getMethod().getMethodName()+"_Failure.png";
		try {
			FileUtils.copyFile(screenShot, new File(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(path, result.getMethod().getMethodName());
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		
	}
	
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}
	
	@Override
	public void onStart(ITestContext result) {
		
	}
	
	@Override
	public void onFinish(ITestContext result) {
		TestReporter.endExtentReport();
	}
}
