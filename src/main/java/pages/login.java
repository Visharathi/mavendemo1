package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.mavenstart.mavendemo.baseclass;

public class login extends baseclass {
	@FindBy(css = "input[name='firstname']")
	WebElement fname;
	
	@FindBy(name="lastname")
	WebElement lname;
	
	@FindBy(name = "reg_email__")
	WebElement email;
	
	@FindBy(id = "password_step_input")
	WebElement pwd;
	
	@FindBy(id = "day")
	WebElement day;
	
	@FindBy(id = "month")
	WebElement month;
	
	@FindBy(id = "year")
	WebElement year;
	
	@FindBy(css = "input[type='radio']") 
	List<WebElement> gender;
	
	@FindBy(css = "img[alt='Facebook']") 
	WebElement logo;
	
	
	
	public login(){
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	public void validateexceldata(String fname1,String lname1,String email1,String pwd1,String date1,String month1,String year1,String gender1) throws InterruptedException{
		
		Select d1 = new Select(day);
		Select d2 = new Select(month);
		Select d3 = new Select(year);
		
		fname.sendKeys(fname1);
		Thread.sleep(2500);
		lname.sendKeys(lname1);
		Thread.sleep(2500);
		email.sendKeys(email1);
		Thread.sleep(2500);
		pwd.sendKeys(pwd1);
		Thread.sleep(2500);
		d1.selectByValue(date1);
		Thread.sleep(2500);
		d2.selectByValue(month1);
		Thread.sleep(2500);
		d3.selectByValue(year1);
		Thread.sleep(2500);
		if(gender1=="Female")
		{
			 gender.get(0).click();
	}
		else
		{
			gender.get(1).click();
		}
	}
		
		public boolean validateLogo()
		{
			return logo.isDisplayed();
		}
		
		public boolean validatelname()
		{
			return lname.isDisplayed();
		}
		
		
	}
	

