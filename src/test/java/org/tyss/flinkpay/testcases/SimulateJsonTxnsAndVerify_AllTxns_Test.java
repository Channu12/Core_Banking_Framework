package org.tyss.flinkpay.testcases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.tyss.flinkpay.genericutility.BaseClass;

@Listeners(org.tyss.flinkpay.genericutility.ListenerImplementationClass.class)
public class SimulateJsonTxnsAndVerify_AllTxns_Test extends BaseClass {
	@Test
	public void simulateJsonTxnsAndVerify() {
		
		// TRXN Creation
		String jsonFile = workflowUtility.json_Txns_Creation_Simulation_Tool("Txn_Info");
		
		// TRXN Initiation
		workflowUtility.initiateJsonTxns(jsonFile);
		
		// Verify in GUI, Database and API Layer
		workflowUtility.verifyTxnInAll3Layers();
		
	}
}
