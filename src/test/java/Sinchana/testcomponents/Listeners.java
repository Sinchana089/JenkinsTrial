package Sinchana.testcomponents;

import com.aventstack.extentreports.ExtentTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;

public class Listeners extends Basetest implements ITestListener  {
	ExtentTest test;
	ExtentReports extent;
	ThreadLocal<ExtentTest> local = new ThreadLocal<>();
	@Override
    public void onTestStart(ITestResult result) {
		 test=extent.createTest("testname");
		 local.set(test);                   //will assign unique thread id for the each concurrent process
		 }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test passed: " + result.getName());
        
    }

    @Override
    public void onTestFailure(ITestResult result) {
    	local.get().fail("Test failed: " + result.getName());
        String filepath=null;
        WebDriver driver;
        try {
        	 driver = (WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance()); //getTestClass --> get the class from xml || getRealClass --> get the class where method is actually there 
			 filepath=takeScreenshotOnFailure(result.getMethod().getMethodName(),driver);							//we can get field from class level only not method level
			 																				
		} catch (Exception e) {
			e.printStackTrace();
		}
        // Additional actions, e.g., taking a screenshot
        local.get().addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test skipped: " + result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Test failed but within success percentage: " + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Tests started: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Tests finished: " + context.getName());
    }
	
	
	
	
	
	
}
