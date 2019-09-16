package com.mt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.mt.config.Config;

public class Loginpage 
{
	//do nt put ; at the end of line, nd if @findby is givin any error then first write pagefactory
	@FindBy(how=How.XPATH,using="//input[@name='userName']")
	WebElement objusername;
	
	@FindBy(how=How.XPATH,using="//input[@name='password']")
	WebElement objpassword;
	
	@FindBy(how=How.XPATH,using="//input[@name='login']")
	WebElement objLogin;
	
	
	//imp h ye method
	public void loadLoginPage()
	{
		System.out.println("loadloginpage");
		//arg(webdriver drivere,object) ,pagefactory is a type whr all the locator are store
		PageFactory.initElements(Config.driver, this);
	}

}
