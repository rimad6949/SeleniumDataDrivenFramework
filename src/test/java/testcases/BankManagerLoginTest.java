package testcases;

import org.testng.annotations.Test;

import base.Basetest;

public class BankManagerLoginTest extends Basetest{
	
	@Test
	public void clickOnBMLBtn() {
		
		click("bmlBtn_CSS");
		log.info("Clicking on the Bank Manager Login Button");
		
	}

}
