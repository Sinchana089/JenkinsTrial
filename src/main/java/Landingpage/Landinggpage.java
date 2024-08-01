package Landingpage;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class Landinggpage extends AbstractMethods {
	WebDriver driver;

	public Landinggpage(WebDriver d) {
		super(d);
		this.driver = d;
		PageFactory.initElements(d, this);
	}

	// PageFactory
	@FindBy(css = "._14Me7y")
	WebElement closingpopup; // Search for Products, Brands and More
	@FindBy(xpath = "//input[@placeholder='Search for Products, Brands and More']")
	WebElement pdtname;
	@FindBy(xpath = "//div[contains(@class,'col col-7-12')]/div[@class='KzDlHZ']")
	List<WebElement> particularpdt;

	By pdtby = By.cssSelector(".KzDlHZ");
	// By.cssSelector("._2KpZ6l._2U9uOA._3v1-ww")
    @Test
	public void searchForElement(String product) {
		pdtname.click();
		pdtname.sendKeys(product);
		pdtname.sendKeys(Keys.ENTER);
	}

	// input[@placeholder='Search for products, brands and more'];
    @Test
	public productCatalouge selectProduct(String pdt) {
		// List<WebElement> particularpdt= d.findElements(By.cssSelector("._4rR01T"));
		WebElement spec = particularpdt.stream().filter(mob -> mob.getText().equals(pdt)).findFirst().orElse(null);
		spec.click();
		productCatalouge pc = new productCatalouge(d);
		return pc;
		// return new productCatalouge(d);

	}

	public List<WebElement> getallproducts() {
		waitForElementToAppear(pdtby);
		return particularpdt;

	}

	public void go() {
		driver.get("https://www.flipkart.com/");
	}

}
