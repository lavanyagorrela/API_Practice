package api.test;
import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
public class extentReports {
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	@BeforeSuite
	public void setUp() {
		 htmlReporter= new ExtentHtmlReporter("extentReports.html");
		//create extentReports and attach reports
		 extent = new ExtentReports();
		extent.attachReporter(htmlReporter);	
	}
	@Test
	public void test1() throws Exception {

		ExtentTest test= extent.createTest("1","T");
		test.log(Status.INFO,"This step usage of log(status,details)");
		test.info("This step shows usage of info");
		test.fail("details",MediaEntityBuilder.createScreenCaptureFromPath("screenshort.png").build() );
		test.addScreenCaptureFromPath("screenshot.png");
	}

	@AfterSuite
	public void tearDown() {
extent.flush();
	}







	
		
}
