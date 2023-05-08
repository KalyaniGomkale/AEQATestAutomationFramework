package com.ae.qa.testcases;

import java.lang.reflect.Method;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.InformationPage;
import com.ae.qa.pages.KeyManagementPage;
import com.ae.qa.pages.LoginPage;
import com.ae.qa.pages.ServerLogsPage;
import com.ae.qa.pages.SystemSettingsPage;
import com.ae.qa.pages.WebElements;
import com.ae.qa.pagesTenantAdmin.CataloguePageTA;
import com.ae.qa.pagesTenantAdmin.RequestsPageTA;
import com.ae.qa.pagesTenantAdmin.WorkflowAssignmentPageTA;
import com.ae.qa.pagesTenantAdmin.WorkflowListPageTA;
import com.ae.qa.util.CommonWebElements;
import com.ae.qa.util.TestDataHandler;

public class KeyManagmentPageTest  extends TestBase {

	LoginPage loginpage;
	WorkflowListPageTA workflowlistpageta;
	WorkflowAssignmentPageTA wfassignmentpageta;
	CataloguePageTA cataloguepageta;
	RequestsPageTA requestspageta;
	KeyManagementPage keymanagementpage;
	TestDataHandler testdata = new TestDataHandler();

	// constructor is used to initialize object of class and super to call
	// superclass objects and access the superclass methods and variables
	public KeyManagmentPageTest() {
		super();
	}
	/*	@Test(priority = 1)
	public void verifyExecOfWFHavingSecretParamTest(Method method) throws Exception {
		extentTest = extent.createTest("verifyExecOfWFHavingSecretParamTest",
				"TC_xx: Verify executaion of a workflow that uses a secret parameter using key management version 1");
	//	Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),
		//		method.getName());
		workflowlistpageta = new WorkflowListPageTA();
		workflowlistpageta.validateImportWFWithSecretConfigParamForKM("KM2","Sanity","Default","C:\\Users\\kalyanig\\Downloads\\AE_Automation_UploadFiles\\KM1dot0_v1.zip","High","20","60","3","30","Minutes","http://localhost:8080/aeui/#");
		wfassignmentpageta= new WorkflowAssignmentPageTA();
		wfassignmentpageta.validateSingleWorkflowAssignment("KM2");
		cataloguepageta= new CataloguePageTA();
		cataloguepageta.validateSubmitRequest("KM2");
		requestspageta=new RequestsPageTA();
		requestspageta.validateRequestStatus();
		//keymanagementpage.ValidateUploadPS(TestDataInMap.get("InvalidArtifactName"), TestDataInMap.get("Version"),
			//	TestDataInMap.get("ValidArtifactName"));
		extentTest.log(extentTest.getStatus(), "Workflow having secret parameter with key management 1.0 executed successfully");
	//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}*/
	@Test(priority = 2)
	public void verifyChangingKM1To2Test(Method method) throws Exception {
		extentTest = extent.createTest("verifyChangingKM1To2Test",
				"TC_xx: Verify whether sysadmin user is able to change the key management version from 1.0 to 2.0");
	//	Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),
		//		method.getName());
		keymanagementpage = new KeyManagementPage();
		keymanagementpage.verifyChangingKM1To2();
		//keymanagementpage.ValidateUploadPS(TestDataInMap.get("InvalidArtifactName"), TestDataInMap.get("Version"),
			//	TestDataInMap.get("ValidArtifactName"));
		extentTest.log(extentTest.getStatus(), "Key Management changed from 1.0 to KM 2.0 successfully");
	//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
}