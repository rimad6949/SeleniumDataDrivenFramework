package testcases;

import org.testng.annotations.Test;


import base.Basetest;

public class AddCustomerTest extends Basetest{
	
	@Test
	public void addCustomer() {
		
		click("addCustBtn_CSS");
		type("firstName_CSS", "Rima");
		type("lastName_CSS", "Das");
		type("postCode_CSS", "12123");
		click("addBtn_CSS");
	}

}
