package Sinchana;

import Landingpage.Landinggpage;
import Landingpage.productCatalouge;
import Sinchana.testcomponents.Basetest;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipkartTest extends Basetest {

	@Test
	public void testProduct() throws IOException, InterruptedException  {
		System.out.println("uiiiiiii");
		Landinggpage lp=launchApplication();
		//Landinggpage lp = new Landinggpage(d);
		
		
			Thread.sleep(5000);
		
		// ((JavascriptExecutor)d).executeScript("arguments[0].click();",d.findElement(By.xpath("//button[text()='✕']")));
		// class="_2KpZ6l _2doB4z"
		// d.findElement(By.xpath("//button[text()='✕']")).click();
		// d.findElement(By.cssSelector("._2KpZ6l._2doB4z")).click();

		lp.searchForElement("mobiles 5g");

		System.out.println(lp.getallproducts().get(0).getText());

		productCatalouge b = lp.selectProduct("Motorola G34 5G (Ocean Green, 128 GB)");

		b.addProduct();

	}
	
	
	

}
