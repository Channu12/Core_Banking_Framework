package org.tyss.flinkpay.testcases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.tyss.flinkpay.genericutility.BaseClass;
import org.tyss.flinkpay.objectrepository.HomePage;

@Listeners(org.tyss.flinkpay.genericutility.ListenerImplementationClass.class)
public class TranferAmountToOtherBankAndVerifyTest extends BaseClass {

	@Test
	public void tranferAmountToOtherBankAndVerify() {
		// Create objects for POM Pages
		HomePage homePage = new HomePage(driver);
		
		// Go to amount transfer module
		webDriverUtility.clickOnElement(homePage.getAmountTransferLink());
		
		// Transfer amount to Bank B
		String refId = workflowUtility.transferAmount("Outbound_Data.xlsx", "Test_Data", "TC001");

		// Login as bank B and verify
		workflowUtility.verifySwiftTxnAsBank(refId);
		
	}
}
