package Landingpage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractMethods {
    WebDriver d;
	public AbstractMethods(WebDriver d ){
		this.d=d;
		PageFactory.initElements(d, this);
	}


	public void waitForElementToAppear(By findby) {
		WebDriverWait wait =new WebDriverWait(d,Duration.ofSeconds(3000));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(findby));
	
	}


}