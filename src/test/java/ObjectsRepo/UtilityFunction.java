package ObjectsRepo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;

public class UtilityFunction {
	WebDriver driver;

	public UtilityFunction(WebDriver driver) {
		this.driver = driver;
	}

	public void TakesScreenshotdriver(String scnShotname) throws IOException {
		TakesScreenshot sh = (TakesScreenshot) driver;
		File SrcFile = sh.getScreenshotAs(OutputType.FILE);
		File destFile = new File(System.getProperty("user.dir") + "/" + scnShotname + ".jpeg");
		FileHandler.copy(SrcFile, destFile);
	}

	public List<Object> ReadJson(String filePath) throws IOException, ParseException {
		List<Object> str = new ArrayList<Object>();

		JSONParser parser = new JSONParser();

		try (Reader reader = new FileReader(filePath)) {

			JSONObject jsonObject = (JSONObject) parser.parse(reader);
			System.out.println(jsonObject);

			String name = (String) jsonObject.get("name");
			str.add(name);
			long age = (Long) jsonObject.get("age");
			str.add(age);

			return str;
		}

	}

	public void MoveTo(WebElement ele) {
		Actions act = new Actions(driver);
		act.moveToElement(ele);
		act.build().perform();
	}

	public void closeCurrentTab() {
		driver.close();
	}

	public void NavigateToPage(String strTitle) {
		Set<String> windows = driver.getWindowHandles();

		for (String window : windows) {
			driver.switchTo().window(window);
			if (driver.getTitle().contains(strTitle)) {
				Assert.assertTrue(true, "Page is Displayed");
				break;
			}

		}
	}
	
	public void NavigateToPage(int intIndex) {
		Set<String> windows = driver.getWindowHandles();
		int ind=0;
		for (String window : windows) {
			driver.switchTo().window(window);
			ind++;
			if (ind==intIndex) {
				Assert.assertTrue(true, "Page is Displayed");
				break;
			}

		}
	}

}
