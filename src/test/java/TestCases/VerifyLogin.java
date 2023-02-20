package TestCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PageObjectModel.LoginPageObjects;
import resourses.baseclass;
import resourses.commonMethods;
import resourses.constants;

public class VerifyLogin extends baseclass {

	@Test(dataProvider="testData")
	public void login(String uname,String password) throws IOException {
		
		LoginPageObjects obj=new LoginPageObjects(driver);
		
		commonMethods.handleAssertions(driver.getCurrentUrl(), "https://login.salesforce.com/", "url is not matching");
		
		
		obj.enterUsername().sendKeys(uname);
		
		obj.enterpassword().sendKeys(password);
		
		obj.clickOnLogin().click();
		
		commonMethods.handleAssertions(obj.errorText().getText(),constants.expectedErrorMessage , "error message is not matching");
		}
	
	@DataProvider
	public Object[][] testData(){
		Object[][]data=new Object[2][2];
		data[0][0]=constants.username1;
		data[0][1]=constants.password1;
		data[1][0]=constants.username2;
		data[1][1]=constants.password2;
	
		
		return data;
		
	}
	
	
}
