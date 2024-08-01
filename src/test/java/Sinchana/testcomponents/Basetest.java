package Sinchana.testcomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


import Landingpage.Landinggpage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Basetest {
	//WebDriverManager.chromedriver().setup();
	ExtentReports er = new ExtentReports();
	WebDriver d;
	Landinggpage lp;
	
	public  WebDriver initializedriver() throws IOException {
		Properties p=new Properties();
		FileInputStream f=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Sinchana\\resources\\Data.properties");
		
		//System.getProperty("user.dir") is used to get the project path till project folder
		
		System.out.println(System.getProperty("user.dir")+"\\src\\main\\java\\Sinchana\\resources\\Data.properties");
		//WebDriverManager.chromedriver().setup();
		
		p.load(f);
		String browsername=p.getProperty("Browser");
		System.out.println(browsername);
		if(browsername.contains("chrome")) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sinchana\\Downloads\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions co = new ChromeOptions(); 
		if(browsername.contains("headless")) {
		co.addArguments("--headless");}
		d = new ChromeDriver(co);
		 
    	}
		else if(browsername=="firefox") {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Sinchana\\Downloads\\geckodriver-win64\\geckodriver.exe");
			 d = new FirefoxDriver();
		}
		else if(browsername=="edge") {
			System.setProperty("webdriver.edge.driver", "C:\\Users\\Sinchana\\Downloads\\edgedriver-win64\\edgedriver.exe");
			 d = new EdgeDriver();
		}
		
		return d;
	}	
	                 // if we run group only it will skip beforeMEthod and afterMethod expecting the group name here also 
					// but can't set group specific(i.e for every group run we have to mention here also) 
					//soln: set always run true 
	//@BeforeMethod(/*alwaysRun = true*/) 
	public Landinggpage launchApplication() throws IOException {
	d = initializedriver();
    lp = new Landinggpage(d);
	lp.go();
	return lp;
}
	
	
	public void useData(Map<Object, Object> map) {
		//login(map.get("email"),map.get("password"));
	}
	
	public List<HashMap<String, String>> jsonData() throws IOException {
		//convert json to string
		String jsonToString =  FileUtils.readFileToString(new File(System.getProperty("user.dir")+"\\src\\test\\java\\Sinchana\\JsonData.java"),StandardCharsets.UTF_8);
		
		//convert string to map
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonToString, new TypeReference<List<HashMap<String, String>>>(){
			
		});
		return data;
	}
	
	
	public String takeScreenshotOnFailure(String testCase,WebDriver driver ) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir")+"\\src\\main\\java\\Sinchana\\resources"+testCase+".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir")+"\\src\\main\\java\\Sinchana\\resources"+testCase+".png";
	}
	
	public void config() {
		String path = System.getProperty("user.dir")+"\\src\\main\\java\\Sinchana\\resources\\index.html";
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);   //helper class to set some properties
		reporter.config().setReportName("Automation Test Results");
		reporter.config().setDocumentTitle("Test Results");
		
		er = new ExtentReports();   //main class actually consolidates all
		er.attachReporter(reporter);
		this.er.setSystemInfo("Tester", "Sinchana");
	}
	
	
	@DataProvider
	public Object[][] getData(){
		Map<Object,Object> map = new HashMap<Object, Object>();
		map.put("email", "ansh@gmail.com");
		map.put("password", "hell@12");
		Map<Object,Object> map2 = new HashMap<Object, Object>();
		Map<Object,Object> map3 = new HashMap<Object, Object>();

		map.put("email", "hnsa@gmail.com");
		map.put("password", "hell@12");
		return new Object[][] {{map},{map2},{map3}};
		
	}
	
	@DataProvider
	public Object[][] getJSonData() throws IOException{
		return new Object[][] {{jsonData().get(0)},{jsonData().get(1)}};
		
	}
}