package ObjectsRepo;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocator;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class easyupload {
	WebDriver driver;
	
	@FindBy(xpath="//button[@class='dz-button']")
	WebElement uploadSection;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement passwordText;
	
	public easyupload(WebDriver driver) {
		this.driver=driver;
		AjaxElementLocatorFactory aj=new AjaxElementLocatorFactory(this.driver, 20);
		PageFactory.initElements(aj, this);
	}
	
	public void ClickUploadSection() throws IOException, InterruptedException {
		uploadSection.click();
		Thread.sleep(7000);
		Runtime.getRuntime().exec("C:\\Users\\Muthukumar\\Documents\\Code\\MuthuFirstAutoIT.exe");
	}
	
	public void verifyPwd() {
		WebDriverWait wt=new WebDriverWait(driver, 20);
		wt.until(ExpectedConditions.elementToBeClickable(passwordText));
		Assert.assertEquals(true, passwordText.isDisplayed());
		
		
	}
	
}
