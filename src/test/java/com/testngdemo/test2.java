package com.testngdemo;

import java.awt.AWTException;
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
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mavenstart.mavendemo.baseclass;

import pages.login;
import utility.TestUtil;


public class test2 extends baseclass{
	
	login l;
	
	public  test2(){
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		l=new login();
			
	}
	@DataProvider
	public Iterator<Object[]> getTestData()
	{
		ArrayList<Object[]> testdata1 = TestUtil.getDataFromExcel();
		return testdata1.iterator();
	}
	
	@Test(priority=3, dataProvider="getTestData")
	public void signup(String fname,String sname,String email,String pwd,String date,String month,String year,String gender) throws InterruptedException 
	{
		l.validateexceldata( fname, sname, email, pwd, date, month, year, gender);

	} 
	
	@Test(priority=1)
	public void logoTest()
	{
		boolean b = l.validateLogo();
		Assert.assertTrue(b);
	}
	
	@Test(priority=2)
	public void buttonTest()
	{
		boolean b = l.validatelname();
		Assert.assertTrue(b);
	}
	
	@Test(priority=2, dataProvider="getTestData2", dependsOnMethods="signup", enabled=false)
	public void signup1(String sname) throws InterruptedException 
	{

	driver.findElement(By.id("lastName")).sendKeys(sname);
	Thread.sleep(2500);
	}
	@Parameters({"email"})
	@Test(priority=3, dependsOnMethods="signup",enabled=false)
	public void signup2(String email) throws InterruptedException 
	{
		Thread.sleep(2500);
	driver.findElement(By.id("username")).sendKeys(email);
	Thread.sleep(2500);
	}
		
	@AfterMethod
	public void  BrowserClose()
	{
		driver.quit();
	}
	}


