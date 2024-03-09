package testcases;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.Basetest;
import utilities.DataUtil;

public class OpenAccountTest extends Basetest{
	
	@Test(dataProviderClass = DataUtil.class, dataProvider="dp")
	public void openAccount(String customer, String currency) throws InterruptedException {
		
		
		log.info("Clicking on Open Account");
		click("openAccBtn_CSS");
		select("customer_CSS",customer);
		
		select("currency_CSS",currency);
		click("process_CSS");	
		
		Alert alert = driver.switchTo().alert();
		Assert.assertTrue(alert.getText().contains("Account created successfully"),"Account not created successfully");
		alert.accept();
		
		Assert.fail();
	}

}
