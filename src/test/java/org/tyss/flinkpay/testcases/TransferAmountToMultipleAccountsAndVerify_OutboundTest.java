package org.tyss.flinkpay.testcases;

import java.util.List;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.tyss.flinkpay.genericutility.BaseClass;

@Listeners(org.tyss.flinkpay.genericutility.ListenerImplementationClass.class)
public class TransferAmountToMultipleAccountsAndVerify_OutboundTest extends BaseClass {

	@Test
	public void TransferAmountToMultipleAccountsViaSWIFtandVerify() {
		
		// Transfer amount to multiple accounts using data set
		List<String> refIdList = workflowUtility.transferAmountToMultipleAccounts("Outbound_Data.xlsx", "Outbound_Pack_008");
		
		// Verify TRXNS
		workflowUtility.verifySwiftMessageTxnsBulk("Outbound_Data.xlsx", "Outbound_Pack_008", refIdList);
		
	}
}
