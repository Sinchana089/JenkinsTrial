package Sinchana;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig.ExtentSparkReporterConfigBuilder;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportss {

	ExtentReports er;
	
	
	
	@BeforeTest
	public void config() {
		String path = System.getProperty("user.dir")+"\\src\\main\\java\\Sinchana\\resources\\index.html";
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);   //helper class to set some properties
		reporter.config().setReportName("Automation Test Results");
		reporter.config().setDocumentTitle("Test Results");
		
		 this.er = new ExtentReports();   //main class actually consolidates all
		this.er.attachReporter(reporter);
		this.er.setSystemInfo("Tester", "Sinchana");
	}
	
	@Test
	public void initializeDriver() {
		ExtentTest test=this.er.createTest("testname");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println("practising");
		test.fail("this is not correct");
		this.er.flush();
	}
}
