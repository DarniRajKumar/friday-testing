package com.test.practise;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	private static final Logger logger = Logger.getLogger(BaseClass.class.getName());

	Properties testDataProp = null;
	Properties expetcedProp = null;

	static WebDriver driver = null;

	
	
	public static void inintBrowser(String browserName) {

		Scanner sc = new Scanner(System.in);

		// System.out.println("Enter browser name");
		// String browserName = sc.nextLine().toLowerCase();

		logger.info("base class starting");

		switch (browserName) {

		case "chrome":

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("https://google.com");
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get("www.google.com");
			break;

		default:

			System.out.println("Invalid URl");
		}
		logger.info("base class endingh");

	}

	@BeforeSuite
	public void getPropFromSorces() {

		logger.info("starting prop files created successfully");
		if (testDataProp == null) {
			FileReader testdataRead = null;
			FileReader assertionsRead = null;

			try {
				testdataRead = new FileReader("src/main/resources/testdata.properties");
				assertionsRead = new FileReader("src/main/resources/expectedAssertions.properties");

				testDataProp = new Properties();
				expetcedProp = new Properties();

				testDataProp.load(testdataRead);
				expetcedProp.load(assertionsRead);

			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				try {
					testdataRead.close();
					assertionsRead.close();

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		logger.info("ending prop files created successfully");

	}

	public static void implicitlyWait() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

	}

	public enum WEBACTIONS {

		CLICK, VISIBLE

	}

	public void findElement(WebElement element, WEBACTIONS actions) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(0));

		switch (actions) {
		case CLICK:
			wait.until(ExpectedConditions.elementToBeClickable(element));

		default:
			System.out.println("");
		}

	}

	public void findElements() {

		List<WebElement> elms = driver.findElements(By.id(""));

		for (WebElement el : elms) {

			if (el.getText().equals("XX")) {

				System.out.println("xxx");
			}
		}

	}

	public void clickonWebElment(WebElement elemnt) {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click();", elemnt);

	}

	public void sendkeys(WebElement elemnt, String str) {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].value=arguments[1];", elemnt, str);

	}

	public void scrollBy(int scroll) {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0," + scroll + ")");

	}

	public enum Web_USER_Actions {
		CLICK, DOUBLE_CLICK, MOVETOELEMENT, DAROGADNDROP

	}

	public void actions(WebElement ele, Web_USER_Actions at) {

		Actions act = new Actions(driver);
		switch (at) {
		case CLICK:

		case DOUBLE_CLICK:
			act.doubleClick().build().perform();

		case MOVETOELEMENT:
			act.moveToElement(ele).build().perform();

		default:
			System.out.println("XXXX");

		}

	}

	public void scrollIntoview(WebElement elemnt) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", elemnt);

	}

	public static void selectOptios(WebElement element, String text) {

		Select select = new Select(element);
		select.selectByVisibleText(text);

	}

	public static void selectOptios(WebElement element, int index) {

		Select select = new Select(element);
		select.selectByIndex(index);

	}

}