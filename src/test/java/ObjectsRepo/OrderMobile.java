package ObjectsRepo;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocator;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderMobile {

	WebDriver driver;

	public OrderMobile(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory aj = new AjaxElementLocatorFactory(driver,20);
		PageFactory.initElements(aj, this);
	}
	
	@FindBy(xpath="//span[contains(text(),\"Back to top\")]")
	WebElement objFindBy;

	@FindBy(xpath="(//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2'])[1]")
	WebElement objPhoneName;
	
	@FindBy(xpath="//div[@id='imgTagWrapperId']")
	WebElement imgPhone;
	
	@FindBy(xpath="//div[@class=\"a-popover-inner\"]")
	WebElement popUpPhone;
	
	@FindBy(xpath="//i[@class=\"a-icon a-icon-close\"]")
	WebElement closePopup;
	
	@FindBy(xpath="//select[@name=\"quantity\"]")
	WebElement dropDownQuantity;
	
	@FindBy(id="add-to-cart-button")
	WebElement AddToCartButton;
	
	@FindBy(xpath="//a[@class=\"nav-a nav-a-2 a-popover-trigger a-declarative\"]")
	WebElement locationbtn;
	
	
	@FindBy(xpath="//input[@class=\"GLUX_Full_Width a-declarative\"]")
	WebElement enterAddres;
	
	@FindBy(xpath="//input[@aria-labelledby=\"GLUXZipUpdate-announce\"]")
	WebElement apply;
	
	
	public void verifyNewPage() {
		
		//objPhoneName.click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		UtilityFunction ut=new UtilityFunction(this.driver);
		ut.NavigateToPage(2);
		System.out.println(driver.getTitle());
		WebDriverWait wt=new WebDriverWait(driver,20);
		Assert.assertEquals(imgPhone.isDisplayed(),true);
		
		Actions act=new Actions(driver);
		act.moveToElement(imgPhone);
		act.click(imgPhone).build().perform();

		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		
		wt.until(ExpectedConditions.visibilityOf(popUpPhone));
		
		Assert.assertEquals(popUpPhone.isDisplayed(),true);
		
		System.out.println(closePopup.getAttribute("class"));
		

		Actions act1=new Actions(driver);
		act1.moveToElement(imgPhone);
		act1.click(imgPhone).build().perform();
		
		act1.moveToElement(closePopup);
		
		act1.click(closePopup).build().perform();
		
		wt.until(ExpectedConditions.elementToBeClickable(imgPhone));
	}
	
	
	public void SelectQuantity() throws AWTException, InterruptedException {
/*		Select sel=new Select(dropDownQuantity);
		sel.selectByValue("2");
		
		AddToCartButton.click();
*/
	
		Thread.sleep(2000);
		UtilityFunction ut=new UtilityFunction(driver);
		Actions act=new Actions(driver);
		act.moveToElement(locationbtn);
		act.click(locationbtn).build().perform();
		
	//	locationbtn.click();
		enterAddres.sendKeys("636006");
		apply.click();
		JavascriptExecutor jt=(JavascriptExecutor)driver;
		jt.executeScript("arguments[0]. scrollIntoView();",objFindBy);
		ut.closeCurrentTab();
		ut.NavigateToPage("Amazon.in");
	}
}
