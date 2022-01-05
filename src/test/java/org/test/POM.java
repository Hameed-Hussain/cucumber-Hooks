package org.test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POM extends BaseClass {

	public POM() {
       PageFactory.initElements(driver, this);
	}
	@FindBy(id="email")
	private WebElement userName;
	
	@FindBy(id="pass")
	private WebElement passWord;
	
	@FindBy(name="login")
	private WebElement loginBut;
	
	public WebElement getUserName() {
		return userName;
	}
	public WebElement getPassWord() {
		return passWord;
	}
	public WebElement getLoginBut() {
		return loginBut;
	}
	
	
	
	
}
