package Landingpage;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class productCatalouge  {
	WebDriver d;
	public productCatalouge(WebDriver d ){
		this.d=d;
		PageFactory.initElements(d, this);
	}
	
	//Page Factory is only used for webdriver object
	//not for finding elements in particular scope
	
	
	@FindBy(xpath="//div[contains(@class,'col col-7-12')]/div[@class='_4rR01T']")
	List<WebElement> particularpdt;
	@FindBy(xpath="//li[@class=\"col col-6-12\"]/button")
	WebElement addpdt;

	
	@Test
	public void addProduct() {
		 Set<String> t = d.getWindowHandles();
		 Iterator<String> it=t.iterator();
		 String p = it.next();
		 String c = it.next(); 
		 d.switchTo().window(c);
		 addpdt.click();
	}
	 
	
	
		
	}


