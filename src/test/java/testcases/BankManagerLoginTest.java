package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Basetest;

public class BankManagerLoginTest extends Basetest{
	
	@Test
	public void clickOnBMLBtn() throws InterruptedException {
		
		click("bmlBtn_CSS");
		log.info("Clicking on the Bank Manager Login Button");
		Assert.assertTrue(isElementPresent("addCustBtn_CSS"), "Not logged in as Bank Manager");
		Thread.sleep(2000);
	}

}
