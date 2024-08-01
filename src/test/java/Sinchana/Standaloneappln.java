package Sinchana;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Sinchana.testcomponents.Basetest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Standaloneappln extends Basetest {

	public static void main(String[] args) {
WebDriverManager.chromedriver().setup();
WebDriver d=new ChromeDriver();
d.get("https://rahulshettyacademy.com/client/");
d.findElement(By.id("userEmail")).sendKeys("framework23@gmail.com");
d.findElement(By.id("userPassword")).sendKeys("Framework23");
d.findElement(By.id("login")).click();

List<WebElement> z=d.findElements(By.className(".card"));                              //div[@class='card-body']/h5/b
//System.out.println(d.findElement(By.xpath("//div[@class='card-body']")).getText());
WebElement q=z.stream().filter(s->s.findElement(By.cssSelector(".card-body b")).getText().equals("ADIDAS ORIGINAL")).findFirst().orElse(null);

//d.findElement(By.cssSelector(".col-lg-4 button:nth-child(2)")).click();


d.findElement(By.xpath("button[contains(@class,'w-10')]")).click();


		
		
		
	//JavascriptExecutor js=((JavascriptExecutor)d).executeScript(null, args)
	
	
}
	}

