package com.test.practise;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.pages.practise.BasePage;
import com.pages.practise.XpathTestPage;

public class UrlStatusCheck extends BaseClass {
	private static final Logger logger = Logger.getLogger(UrlStatusCheck.class.getName());

	protected XpathTestPage xpath = null;

	@BeforeClass
	@Parameters("browserName")
	public void method1(String browserName) {

		logger.info("started iniatilizing browserName");
		BaseClass.inintBrowser("chrome");

		this.xpath = new XpathTestPage(driver);
		logger.info("ending iniatilizing browserName");
	}

	//@Test
	public void statusCheck() throws IOException {

		this.xpath = new XpathTestPage(driver);

		for (int i = 0; i <= xpath.urlEle.size() - 1; i++) {

			String url = xpath.urlEle.get(i).getAttribute("href");

			if (url == null || url.isEmpty()) {

				System.out.println("URL is empty");

			} else {

				URL url1 = new URL(url);

				HttpURLConnection httpconnect = (HttpURLConnection) url1.openConnection();

				httpconnect.connect();

				if (httpconnect.getResponseCode() >= 400) {

					System.out.println("invallid url " + httpconnect.getResponseCode());

				}

				else {

					System.out.println("valid  url " + url1 + httpconnect.getResponseCode());

				}

			}

		}

	}

	@Test
	public void actions() {

		/*
		 * xpath.el.sendKeys("raj");
		 * 
		 * xpath.el.sendKeys(Keys.CONTROL+"a"); xpath.el.sendKeys(Keys.CONTROL+"c");
		 * xpath.el.sendKeys(Keys.CLEAR); xpath.el.sendKeys(Keys.CONTROL+"v");
		 */
		
		Actions act = new Actions(driver);
		
		  act.moveToElement(xpath.el).sendKeys("raj").perform();
		  
		  act.moveToElement(xpath.el).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
		  act.moveToElement(xpath.el).keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
		  act.moveToElement(xpath.el).keyDown(Keys.CLEAR).perform();
		  
		  
		  act.moveToElement(xpath.el).keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();

		  
		  
		  
		  //act.moveToElement(xpath.el).sendKeys(Keys.CLEAR);
		  
		 

	}

}
