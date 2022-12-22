package com.mavenstart.mavendemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import utility.Xls_Reader;



public class excelmainclass {
	
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Xls_Reader r = new Xls_Reader("C:\\Users\\Visha\\OneDrive\\Documents\\testdata.xlsx");
		int rowcount = r.getRowCount("data2");
        String firstname[]=new String[rowcount+1];
        String secondname[]=new String[rowcount+1];
        String emailid[]=new String[rowcount+1];
        String days[]=new String[rowcount+1];
        String months[]=new String[rowcount+1];
        String years[]=new String[rowcount+1];
        String passwords[]=new String[rowcount+1];
        String pronounds[]=new String[rowcount+1];
       
      for(int i=2;i<=rowcount;i++)
        {
        	firstname[i] = r.getCellData("data2", 0, i);
        	secondname[i] = r.getCellData("data2", 1, i);
        	emailid[i] = r.getCellData("data2", 2, i);
        	days[i] = r.getCellData("data2", 3, i);
        	months[i] = r.getCellData("data2", 4, i);
        	years[i] = r.getCellData("data2", 5, i);
        	passwords[i] = r.getCellData("data2", 6, i);
        	pronounds[i] = r.getCellData("data2", 7, i);
        	
        
		
	}
		System.setProperty("webdriver.gecko.driver", "C:/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.navigate().to("https://www.facebook.com/campaign/landing.php?campaign_id=14884913640&extra_1=s%7Cc%7C550525805640%7Cb%7Cfacebook%20create%20account%7C&placement=&creative=550525805640&keyword=facebook%20create%20account&partner_id=googlesem&extra_2=campaignid%3D14884913640%26adgroupid%3D128696221432%26matchtype%3Db%26network%3Dg%26source%3Dnotmobile%26search_or_content%3Ds%26device%3Dc%26devicemodel%3D%26adposition%3D%26target%3D%26targetid%3Dkwd-12091220328%26loc_physical_ms%3D9061914%26loc_interest_ms%3D%26feeditemid%3D%26param1%3D%26param2%3D&gclid=EAIaIQobChMIt6ejjIO1-wIVgQsrCh0zigHGEAAYASAAEgKfx_D_BwE");
        WebElement fname = driver.findElement(By.name("firstname"));
        WebElement sname =driver.findElement(By.name("lastname"));
        WebElement email =driver.findElement(By.name("reg_email__"));
        WebElement pwd =driver.findElement(By.name("reg_passwd__"));
        WebElement day = driver.findElement(By.id("day"));
        WebElement month = driver.findElement(By.cssSelector("#month"));
        WebElement year = driver.findElement(By.id("year"));
        Select d1=new Select(day);
        Select d2=new Select(month);
        Select d3=new Select(year);
        WebElement sex = driver.findElement(By.cssSelector("span._5k_2:nth-child(3) > label:nth-child(1)"));
      
        WebElement sex1 =driver.findElement(By.name("preferred_pronoun"));
        Select d4=new Select(sex1);
        for(int i=2;i<=rowcount;i++)
        {
        	fname.clear();
        	fname.sendKeys(firstname[i]);
        	sname.clear();
        	sname.sendKeys(secondname[i]);
        	email.clear();
        	email.sendKeys(emailid[i]);
        	pwd.clear();
        	pwd.sendKeys(passwords[i]);
        	d1.selectByValue(days[i]);
        	d3.selectByValue(years[i]);
        	d2.selectByVisibleText("Jan");
        	d3.selectByValue(years[i]);
        	sex.click();
        	d4.selectByValue(pronounds[i]);
        	Thread.sleep(3000);
        	
        	
        }
        
	}}
