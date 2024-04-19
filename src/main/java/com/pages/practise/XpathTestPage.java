package com.pages.practise;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class XpathTestPage extends BasePage {

	public XpathTestPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//textarea[@title='Search']")
	public WebElement el;

	@FindBy(xpath = "//a[@role='menuitem']")
	public List<WebElement> urlEle;

}
