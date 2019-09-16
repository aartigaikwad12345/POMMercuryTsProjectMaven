package com.mt.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.mt.config.Config;

public class LaunchApp
{
//pkg>java.util.Properties	
Properties prop=new Properties();

public void openBrowser(String browsernm) throws IOException
{
	FileInputStream fis=new FileInputStream("F:\\selenium workspace\\POMMercuryTsProjectMaven\\src\\test\\Resources\\config.properties");
	prop.load(fis);
	
	if(browsernm.equalsIgnoreCase("chrome"))
	{
		System.setProperty("webdriver.chrome.driver",prop.getProperty("chromeexepath"));
		//WebDriver driver= new...instead of this , use config.dirver
		Config.driver=new ChromeDriver();
		System.out.println("Chrome browser is opened successfully");
	}
	else if(browsernm.equalsIgnoreCase("ie"))
	{
		System.setProperty("webdriver.ie.driver",prop.getProperty("ieexepath"));
		Config.driver=new InternetExplorerDriver();
		System.out.println("IE browser is opened");
		
	}
	else
	{
		System.setProperty("webdriver.gecko.driver", prop.getProperty("firefoxexepath"));
		Config.driver=new FirefoxDriver();
		System.out.println("Firefox browser is opened successfully");
	}
}
public void enterApplUrl(String url)
{
	Config.driver.get(url);
	System.out.println("Application url is entered successfully");

}
public void maximizeBrowser()
{
	Config.driver.manage().window().maximize();
	}

public void waittillLoginpageLoaded(int timeoutseconds)
{
	Config.driver.manage().timeouts().pageLoadTimeout(timeoutseconds,TimeUnit.SECONDS);
	}

//if want to  check tat all methods are wrking properly, write main() method here

public static void main(String[] args) throws IOException {
	LaunchApp lc=new LaunchApp();
	lc.openBrowser("chrome");
	lc.enterApplUrl("http://www.newtours.demoaut.com/mercurywelcome.php");
	lc.maximizeBrowser();
	lc.waittillLoginpageLoaded(15);
}
}
