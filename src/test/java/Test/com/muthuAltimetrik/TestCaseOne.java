package Test.com.muthuAltimetrik;
import ObjectsRepo.*;
import java.awt.AWTException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;
import java.util.Set;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import io.github.bonigarcia.wdm.WebDriverManager;
import javassist.bytecode.Descriptor.Iterator;
@Test
public class TestCaseOne {

	WebDriver driver;
	ExtentReports reports;

	@BeforeTest()
	public void LaunchDriver() throws MalformedURLException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		//options.addArguments("--headless");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		driver = new ChromeDriver(options);
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();

		

	}

	@Test(priority = 0)
	public void TestCaseOne() throws IOException, ParseException, InterruptedException, AWTException {
		// ExtentTest test = reports.startTest("TestCaseOne");
		AmazonFirstPage objFirst = new AmazonFirstPage(driver);
		objFirst.ClickMobileLink();
		AmazonMobileSelectionPage objFeatured=new AmazonMobileSelectionPage(driver);
		
		objFeatured.SelectionofBrand();
		//objFeatured.checking4();
        OrderMobile om = new OrderMobile(driver);
		om.verifyNewPage();
		//om.SelectQuantity();

		


		
		/*
		 * reports.endTest(test); reports.flush();
		 */
	}

	@Test(priority = 1)
	public void TestCaseTwo() throws InterruptedException {
		// ExtentTest test = reports.startTest("TestCaseTwo");
		AmazonFirstPage objFirst = new AmazonFirstPage(driver);
		Assert.assertEquals(objFirst.objLanButton1().isDisplayed(), true);
		// test.log(LogStatus.PASS, objFirst.objLanButton1().getText());
		objFirst.moveToLanguage();
		Assert.assertEquals(objFirst.objEnglish1().isDisplayed(), true);
		Assert.assertEquals(objFirst.objhindi1().isDisplayed(), true);
		// reports.endTest(test);
		// reports.flush();
	}

	@Test(priority = 2, enabled = false)
	public void TestCaseThree() throws IOException, InterruptedException {
		driver.get("https://easyupload.io/");
		easyupload eu = new easyupload(driver);
		eu.ClickUploadSection();
		eu.verifyPwd();

	}

	@AfterTest()
	public void QuitDriver() {
		driver.quit();
	}

}
