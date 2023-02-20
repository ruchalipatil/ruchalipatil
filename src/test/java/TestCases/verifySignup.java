package TestCases;

import java.io.IOException;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import PageObjectModel.LoginPageObjects;
import PageObjectModel.signupPageObjects;
import resourses.baseclass;
import resourses.commonMethods;
import resourses.constants;

public class verifySignup extends baseclass {

	@Test
	
	public void signup() throws IOException, InterruptedException {
		
	
		
		LoginPageObjects lpo=new LoginPageObjects(driver); 
		
		lpo.clickOntryforfree().click();
		
		signupPageObjects spo=new signupPageObjects(driver);
		
		Thread.sleep(5000);
		
		spo.enterFirstname().sendKeys(constants.firstname);
		
		/*
		Select s=new Select(spo.selectemployee());
		s.selectByIndex(1);
		
		Select s1=new Select(spo.selectCountry());
		s1.selectByIndex(1);
		*/
		
		commonMethods.selectDropdown(spo.selectemployee(), 1);
		
		commonMethods.selectDropdown(spo.selectCountry(), 2);
		
	}
	
	
	
	
	
	
}
