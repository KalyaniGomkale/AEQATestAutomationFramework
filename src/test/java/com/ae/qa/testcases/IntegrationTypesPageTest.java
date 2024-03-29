package com.ae.qa.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.IntegrationServicesPage;
import com.ae.qa.pages.IntegrationTypesPage;
import com.ae.qa.pages.TenantUsersPage;
import com.ae.qa.util.ExcelHandler;

import java.lang.reflect.Method;
import java.util.Map;

public class IntegrationTypesPageTest extends TestBase {
	IntegrationTypesPage integrationtypespage;

	public IntegrationTypesPageTest() {
		super();
	}

	@Test(priority=142,alwaysRun=true)
	public void validateAddIntegrationTypesTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAddIntegrationTypesTest", "TC_96: Verify adding integration services");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		integrationtypespage = new IntegrationTypesPage();
		integrationtypespage.validateAddIntegrationTypes(TestDataInMap.get("IntTypeName"),TestDataInMap.get("IntTypeDescription"));
		extentTest.log(extentTest.getStatus(), "Integration Type created successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test(priority=143,alwaysRun=true)
	public void validateEditIntegrationTypesTest(Method method) throws Exception {
		extentTest = extent.createTest("validateEditIntegrationTypesTest", "TC_97: Verify editing integration services");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		integrationtypespage = new IntegrationTypesPage();
		integrationtypespage.validateEditIntegrationTypes(TestDataInMap.get("IntTypeName"),TestDataInMap.get("IntTypeDescription"));
		extentTest.log(extentTest.getStatus(), "Integration type edited successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test(priority=1380)
	public void validateDeleteIntegrationTypeTest(Method method) throws Exception {
		extentTest = extent.createTest("validateDeleteIntegrationTypeTest", "TC_92:Verify Delete Integration Type");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		integrationtypespage = new IntegrationTypesPage();
		integrationtypespage.validateDeleteIntegrationType(TestDataInMap.get("IntTypeName"));
		extentTest.log(extentTest.getStatus(), "Integration Service Status is verified successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test(priority=163,alwaysRun=true)
	public void validateIntegrationTypePageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateIntegrationTypePageTest", "TC_Additional:Verify Clicking Integration types tab and checking that appropiate page is loaded");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		integrationtypespage = new IntegrationTypesPage();
		integrationtypespage.validateIntegrationTypePage(TestDataInMap.get("PageTitle"));
		extentTest.log(extentTest.getStatus(), "Integration Types page loading validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
}
