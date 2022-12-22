package com.testngdemo;
import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utility.TestUtil;


public class test1 {
	
	
		WebDriver driver ;
		
		
		@BeforeMethod
		public  void BrowserSetup() throws InterruptedException {
			driver	= new FirefoxDriver();
			 System.setProperty("webdriver.gecko.driver", "C:/geckodriver.exe");
		        
		        driver.navigate().to("https://www.facebook.com/campaign/landing.php?campaign_id=14884913640&extra_1=s%7Cc%7C550525805640%7Cb%7Cfb%20create%20account%7C&placement=&creative=550525805640&keyword=fb%20create%20account&partner_id=googlesem&extra_2=campaignid%3D14884913640%26adgroupid%3D128696221432%26matchtype%3Db%26network%3Dg%26source%3Dnotmobile%26search_or_content%3Ds%26device%3Dc%26devicemodel%3D%26adposition%3D%26target%3D%26targetid%3Dkwd-332264388364%26loc_physical_ms%3D1007809%26loc_interest_ms%3D%26feeditemid%3D%26param1%3D%26param2%3D&gclid=EAIaIQobChMIjcDAmpPC-wIVxH0rCh1GGgVjEAAYASAAEgJRNfD_BwE");
		        Thread.sleep(3500);


		}
		@DataProvider
		public Iterator<Object[]> getTestData()
		{
			ArrayList<Object[]> testdata = TestUtil.getDataFromExcel();
			return testdata.iterator();
		}
		@Test(priority=1, dataProvider="getTestData")
		public void signup(String fname, String sname, String mobile) throws InterruptedException 
		{
		driver.findElement(By.name("firstname")).sendKeys(fname);
		Thread.sleep(2500);
		driver.findElement(By.name("lastname")).sendKeys(sname);
		Thread.sleep(2500);
		driver.findElement(By.cssSelector("#password_step_input")).sendKeys(mobile);
	
						
		}
			
		@AfterMethod
		public void  BrowserClose()
		{
			driver.quit();
		}
		}

