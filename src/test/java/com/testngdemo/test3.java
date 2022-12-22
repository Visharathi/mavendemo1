package com.testngdemo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class test3 {
	
	
		WebDriver driver ;
		@Parameters({"url"})
		@BeforeMethod
		public  void BrowserSetup(String url) throws InterruptedException {
			driver	= new FirefoxDriver();
			 System.setProperty("webdriver.gecko.driver", "C:/geckodriver.exe");
		        
		        driver.navigate().to(url);
		        Thread.sleep(3500);
		        //driver.findElement(By.linkText("Create free account")).click();
		}
		@Test
		@Parameters({"email","pwd"})
		public void instalaunch(String email, String pwd) throws InterruptedException
		{
		
			driver.findElement(By.cssSelector("div._ab32:nth-child(1) > div:nth-child(1) > label:nth-child(1) > input:nth-child(2)")).sendKeys(email);
			Thread.sleep(2500);
			driver.findElement(By.name("password")).sendKeys(pwd);
			Thread.sleep(2500);
		}
			
		
		@AfterMethod
		public void  BrowserClose()
		{
			driver.quit();
		}
		}






