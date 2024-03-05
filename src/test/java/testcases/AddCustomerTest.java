package testcases;

import org.testng.annotations.Test;

import base.Basetest;
import utilities.DataUtil;

public class AddCustomerTest extends Basetest{
	
	@Test(dataProviderClass = DataUtil.class, dataProvider="dp")
	public void addCustomer(String FirstName, String LastName, String PostCode) {
		
		click("addCustBtn_CSS");
		log.info("Clicking on the Add Customer button");
		type("firstName_CSS", FirstName);
		type("lastName_CSS", LastName);
		type("postCode_CSS", PostCode);
		click("addBtn_CSS");
		driver.switchTo().alert().accept();
	}

}
