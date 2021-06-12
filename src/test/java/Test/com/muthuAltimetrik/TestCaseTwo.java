package Test.com.muthuAltimetrik;

import org.testng.annotations.Test;

import ObjectsRepo.BooksFirstPage;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class TestCaseTwo {
	WebDriver driver;

	@Test
	public void Books() {
		BooksFirstPage bf=new BooksFirstPage(driver);
		Assert.assertTrue(bf.ValidateSubHeadersOrder());
	}

	@BeforeTest
	
	public void beforeTest() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
		driver=new ChromeDriver(options);
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
	}

	
	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
