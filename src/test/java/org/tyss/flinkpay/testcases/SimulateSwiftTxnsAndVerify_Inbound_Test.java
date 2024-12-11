package org.tyss.flinkpay.testcases;

import java.util.List;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.tyss.flinkpay.genericutility.BaseClass;
import org.tyss.flinkpay.genericutility.IConstants;

@Listeners(org.tyss.flinkpay.genericutility.ListenerImplementationClass.class)
public class SimulateSwiftTxnsAndVerify_Inbound_Test extends BaseClass {
	@Test
	public void simulateSwiftTxnsAndVerify() {

		// TRXN creation 
		List<String> filePaths = workflowUtility.SMART_SWIFT_TRXN_Creation_Simulation_tool("Txn_Info");

		// TRXN Initiation 
		workflowUtility.initiateTrxns(filePaths);

		// Read TRXNS From Excel
		List<String> txnList = excelUtility.getColumnDataBasedOnHeader(IConstants.SWIFT_EXCEL_DATA_FILEPATH, "Txn_Info", "TXN_REF_ID_VAR");
		
		// Verify TRXN details in BANK GUI portal
		workflowUtility.verifySwiftTxnsInGUI(txnList);
		
		// Verify TRXN details in Database layer
		workflowUtility.verifySwiftTxnsInDatabase(txnList);

		// Verify TRXN details in API layer
		workflowUtility.verifySwiftTxnsInAPILayer(txnList);
		
	}
}
