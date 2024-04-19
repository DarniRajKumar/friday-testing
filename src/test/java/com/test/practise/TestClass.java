/**
 * 
 */
package com.test.practise;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.pages.practise.XpathTestPage;

public class TestClass extends BaseClass {

	XpathTestPage xpath=null;
	
	private static final Logger logger = Logger.getLogger(TestClass.class.getName());

	@BeforeClass
	@Parameters("browserName")
	public void method1(String browserName) {

		logger.info("started iniatilizing browserName");
		BaseClass.inintBrowser("chrome");
		
		this.xpath=new XpathTestPage(driver);
		logger.info("ending iniatilizing browserName");
	}

	@Test
	public void method2() {

		
		logger.info("started method 2");
		
		sendkeys(xpath.el, "rajkumar");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);

		String path = System.getProperty("user.dir");

		String path2 = path + "/src/test/resources/";
		System.out.println(path2);
		try {
			FileUtils.copyFile(src, new File(path2 + "img.png"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("ending method 2");
	}
}
