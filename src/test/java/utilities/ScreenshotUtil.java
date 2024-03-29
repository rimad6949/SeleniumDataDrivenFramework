package utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import base.Basetest;

public class ScreenshotUtil extends Basetest{
	
	public static String fileName;
	
	public static void captureScreenshot() {
		
		Date d = new Date();
		
		fileName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
		
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(screenshot, new File("/Users/rimadas/eclipse-workspace/SeleniumDataDrivenFramework/target/reports/"+ fileName));
			FileUtils.copyFile(screenshot, new File("/Users/rimadas/eclipse-workspace/SeleniumDataDrivenFramework/target/surefire-reports/html/" + fileName));
	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void captureElementScreenshot(WebElement element) {
		
		Date d = new Date();
		
		String fileName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
		
		File screenshot = ((TakesScreenshot) element).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyDirectory(screenshot, new File(System.getProperty("user.dir") + "/screenshot/" + fileName));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	}

}
