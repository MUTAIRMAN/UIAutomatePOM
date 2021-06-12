package ObjectsRepo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AmazonMobileSelectionPage {

	WebDriver driver;
	
	@FindBy(xpath="(//a/span[text()='See more'])[1]")
	WebElement ObjMore;
	@FindBy(xpath="//span[text()='Redmi']")
	WebElement ObjRedmi;
	@FindBy(xpath="(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]")
	WebElement Obj4;
	@FindBy(xpath="(//i[@class='a-icon a-icon-star-small a-star-small-4 aok-align-bottom'])[1]")
	WebElement ObjFour;
	@FindBy(xpath="//a[text()='See all customer reviews']")
	WebElement ObjPopup;
	
	public AmazonMobileSelectionPage(WebDriver driver) {
		this.driver=driver;
		AjaxElementLocatorFactory al=new AjaxElementLocatorFactory(driver,20);
		PageFactory.initElements(al,this);
	}
	
	
	public void SelectionofBrand() {
		ObjRedmi.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Obj4.click();
	}
	
	public void checking4() throws InterruptedException {
		Actions act=new Actions(driver);
		act.moveToElement(ObjFour);
		act.build().perform();
		Assert.assertEquals(ObjPopup.isDisplayed(),true);
		System.out.println(ObjPopup.getText());
	}
	
}
