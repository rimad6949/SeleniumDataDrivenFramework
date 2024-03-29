package testcases;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.Basetest;
import utilities.DataUtil;

public class AddCustomerTest extends Basetest{
	
	//We are using the utility class so that we can write create a static method inside a class eg:- DataUtil and the class across an application
	@Test(dataProviderClass = DataUtil.class, dataProvider="dp")
	public void addCustomer(String FirstName, String LastName, String PostCode) throws InterruptedException {
		
		click("addCustBtn_CSS");
		log.info("Clicking on the Add Customer button");
		type("firstName_CSS", FirstName);
		type("lastName_CSS", LastName);
		type("postCode_CSS", PostCode);
		click("addBtn_CSS");
		
		Alert alert = driver.switchTo().alert();
		Assert.assertTrue(alert.getText().contains("Customer added successfully"), "Customer is not added successfully");
		alert.accept();
	}

}
