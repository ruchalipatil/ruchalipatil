package resourses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class baseclass {
	
	public WebDriver driver;
    public Properties prop;
    
	public void driverInitilize() throws IOException {
		
		//this will read the properties
	FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resourses\\data.properties");
		
		// Access the properties file
	
        prop=new Properties();
		prop.load(fis);
		
		String browserName= prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("Chrome")) {
			
			 driver=new ChromeDriver();
		}
			
		else if(browserName.equalsIgnoreCase("firefox")) {
			 driver=new FirefoxDriver();
			//firefox code
		}
		else if(browserName.equalsIgnoreCase("Edge")) {
			//firefox code
		}		
		else {
			System.out.println("please make sure you have correct browser");
		}
	}

	@BeforeMethod
	
        public void openurl() throws IOException {
	
		driverInitilize();
		//this driver have scope
		String urlName= prop.getProperty("url");
		driver.get(urlName);
	}
	@AfterMethod
	public void closeBrowser() throws IOException {
		
		driver.quit();
		
	
	}	
	
}

