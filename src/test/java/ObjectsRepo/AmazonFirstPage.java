package ObjectsRepo;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class AmazonFirstPage {
	
	@FindBy(xpath="//a[text()='Mobiles']")
	WebElement objMobiles;
	@FindBy(xpath="//a[text()='Books']")
	WebElement objBooks;
	@FindBy(xpath="//span[@class='icp-nav-link-inner']")
	WebElement objLanButton;
	@FindBy(xpath="(//span[text()='हिंदी - HI' and @class=\"nav-text\"])[1]")
	WebElement objhindi;
	@FindBy(xpath="(//span[text()='English - EN' and @class=\"nav-text\"])[1]")
	WebElement objEnglish;
	UtilityFunction ut;
	WebDriver driver;
	
	public AmazonFirstPage(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory al=new AjaxElementLocatorFactory(driver,20);
		PageFactory.initElements(al,this);
		ut=new UtilityFunction(this.driver);
	}
	
	
	public void ClickMobileLink() throws IOException {
		ut.TakesScreenshotdriver("firstScreen");
		objMobiles.click();
		
	}
	
	
	
	
	public WebElement objLanButton1() {
		return objLanButton;
	}
	
	public void moveToLanguage() {
		ut.MoveTo(objLanButton);
	}
	public WebElement objhindi1() {
		return objhindi;
	}
	public WebElement objEnglish1() {
		return objEnglish;
	}
	
	
}
