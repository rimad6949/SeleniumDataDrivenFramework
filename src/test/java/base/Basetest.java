package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.Status;

import extentlisteners.ExtentListeners;
import utilities.ExcelReader;

public class Basetest {
	
	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static Logger log = LogManager.getLogger(Basetest.class.getName());
	public static ExcelReader excel = new ExcelReader("/Users/rimadas/git/SeleniumDataDrivenFramework/src/test/resources/excel/testdata.xlsx");
	public static ChromeOptions ops = new ChromeOptions();
    
	
	@BeforeSuite
	public void setup() {
		//driver == null - This means if browser is not open then call the properties and open the browser
		if(driver == null) {
			
			try {
				fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/properties/Config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				config.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/properties/OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				OR.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(config.getProperty("browser").equals("chrome")) {
			ops.addArguments("--disable-notifications");
			driver = new ChromeDriver(ops);
			log.info("Launching the Chrome Browser");
		}
		else if(config.getProperty("browser").equals("firefox")) {
			driver = new FirefoxDriver();
			log.info("Launching the Firefox Browser");
		}
		
		driver.get(config.getProperty("testSiteURL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	public void click(String key) {
		if(key.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(key))).click();
		}
		else if(key.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(key))).click();
		}
		else if(key.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(key))).click();
		}
		log.info("Clicking on the element : " + key);
		ExtentListeners.test.log(Status.INFO, "Clicking on the element : " + key);
			
	}
	
	public void type(String key, String value) {
		if(key.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(key))).sendKeys(value);
		}
		else if(key.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(key))).sendKeys(value);
		}
		else if(key.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(key))).sendKeys(value);
		}
		log.info("Clicking on the element : "+key+ " and entering value : "+value);
		ExtentListeners.test.log(Status.INFO, "Clicking on the element : "+key+ " and entering value : "+value);
			
	}
	
	public boolean isElementPresent(String key) {
		try {
			if(key.endsWith("_CSS")) {
				driver.findElement(By.cssSelector(OR.getProperty(key)));
			}
			else if(key.endsWith("_XPATH")) {
				driver.findElement(By.xpath(OR.getProperty(key)));
			}
			else if(key.endsWith("_ID")) {
				driver.findElement(By.id(OR.getProperty(key)));
			}
			
			log.info("Find an element : "+key);
			ExtentListeners.test.log(Status.INFO, "Finding an element : "+ key);
			
			return true;
		}
		catch(Throwable t){
			
			log.error("Error while find an element : "+key+" The error log is : "+t.getStackTrace());
			ExtentListeners.test.log(Status.INFO, "Error while find an element : "+key+" The error log is : "+t.getStackTrace());	
			
			return false;
		}		
		
	}
	
	@AfterSuite
	public void tearDown() {
		
		if(driver != null) {
			driver.quit();
			log.info("Closing the Browser");
		}
		
	}

}
