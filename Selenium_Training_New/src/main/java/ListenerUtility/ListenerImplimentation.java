
package ListenerUtility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.tek.loan_management_system.baseclass.BaseClass;

public class ListenerImplimentation implements ITestListener, ISuiteListener {

	private ExtentSparkReporter spark;
	public static ExtentReports report;
	public ExtentTest test;

	@Override
	public void onStart(ISuite suite) {
		System.out.println("Report Configuration");
		String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
		spark = new ExtentSparkReporter("./AdvanceReport/report"+time+".html");

		spark.config().setDocumentTitle("LOS Test Suite Results");
		spark.config().setReportName("LOS Report");
		spark.config().setTheme(Theme.DARK);

		report = new ExtentReports();
		report.attachReporter(spark);

		report.setSystemInfo("OS", "Windows 11");
		report.setSystemInfo("BROWSER", "Microsoft Edge");
		
	}
	
	@Override
	public void onFinish(ISuite suite) {
		System.out.println("Report Backup");

		if (report != null) {
			report.flush();
		}
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("---" + result.getMethod().getMethodName() + "---Start");

		test = report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);

		UtilityClassObject.getTest().log(Status.INFO, result.getMethod().getMethodName() + " ---> Started <---");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("---" + result.getMethod().getMethodName() + "---End");

		UtilityClassObject.getTest().log(Status.PASS, result.getMethod().getMethodName() + " ---> Completed <---");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();

		UtilityClassObject.getTest().log(Status.FAIL, testName + " ---> Failed <---");

		UtilityClassObject.getTest().log(Status.FAIL, result.getThrowable());

		WebDriver driver = BaseClass.sdriver;

		if (driver != null) {
			String screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);

			String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));

			UtilityClassObject.getTest().addScreenCaptureFromBase64String(screenshot, testName + "_" + time);
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		UtilityClassObject.getTest().log(Status.SKIP, result.getMethod().getMethodName() + " ---> Skipped <---");
	}
}
