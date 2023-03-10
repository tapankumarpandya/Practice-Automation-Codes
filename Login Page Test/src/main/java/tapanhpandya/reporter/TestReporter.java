package tapanhpandya.reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestReporter {
	public static ExtentReports report;
	public static ExtentSparkReporter sparkReporter;
	
	public static ExtentReports getReportObject(String methodName) {
		String reportPath = System.getProperty("user.dir")+"//Reports//"+methodName+".html";
		sparkReporter = new ExtentSparkReporter(reportPath);
		report = new ExtentReports();
		report.attachReporter(sparkReporter);
		report.setSystemInfo("Tester", "Tapan H. Pandya");
		return report;
	}
	
	public static ExtentTest startExtentTest(String testName) {
		return report.createTest(testName);
	}
	
	public static void setReportName(String mainTestTitle) {
		sparkReporter.config().setReportName(mainTestTitle);
	}
	
	public static void setWebPageTitle(String webpageTitle) {
		sparkReporter.config().setDocumentTitle(webpageTitle);
	}
	
	public static void endExtentReport() {
		report.flush();
	}
	
}
