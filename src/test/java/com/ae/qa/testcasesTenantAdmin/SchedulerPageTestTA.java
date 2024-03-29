package com.ae.qa.testcasesTenantAdmin;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pagesTenantAdmin.CredentialsPageTA;
import com.ae.qa.pagesTenantAdmin.SchedulerPageTA;
import com.ae.qa.pagesTenantAdmin.TenantUsersPageTA;
import com.ae.qa.pagesTenantAdmin.WorkflowListPageTA;
import com.ae.qa.util.ExcelHandler;

public class SchedulerPageTestTA extends TestBase {
	SchedulerPageTA schedulerpageta;

	public SchedulerPageTestTA() {
		super();
	}

	@Test(priority=81,alwaysRun=true)
	public void validateDailyScheduleTest(Method method) throws Exception {
		extentTest = extent.createTest("validateDailyScheduleTest", "TC_185: Verify user can create daily schedule for a day and only at once");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		schedulerpageta = new SchedulerPageTA();
		schedulerpageta.validateDailySchedule(TestDataInMap.get("wfName"),TestDataInMap.get("ScheduleName"),TestDataInMap.get("ScheduleDesc"),TestDataInMap.get("startMonth"),TestDataInMap.get("startYear"),
				TestDataInMap.get("startDate"),TestDataInMap.get("endMonth"),TestDataInMap.get("endYear"),TestDataInMap.get("endDate"),
				TestDataInMap.get("ScheduleType"),TestDataInMap.get("TimeZone"),TestDataInMap.get("ScheduleExecHH"),TestDataInMap.get("ScheduleExecMM"));
		extentTest.log(extentTest.getStatus(), "User created daily schedule successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}
	@Test(priority=82,alwaysRun=true)
	public void validateEditDailyScheduleTest(Method method) throws Exception {
		extentTest = extent.createTest("validateEditDailySchedule", "TC_188: Verify user can edit end date of above scheduled");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		schedulerpageta = new SchedulerPageTA();
		schedulerpageta.validateEditDailySchedule(TestDataInMap.get("ScheduleName"),
				TestDataInMap.get("endMonth"),TestDataInMap.get("endYear"),TestDataInMap.get("endDate"));
		extentTest.log(extentTest.getStatus(), "User edited daily schedule successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}

	@Test(priority=83, alwaysRun=true)
	public void validateWeeklyScheduleTest(Method method) throws Exception {
		extentTest = extent.createTest("validateWeeklyScheduleTest", "TC_191: Verify user can create weekly schedule with repeatation after every 15 min");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		schedulerpageta = new SchedulerPageTA();
		schedulerpageta.validateWeeklySchedule(TestDataInMap.get("wfName"),TestDataInMap.get("ScheduleName"),TestDataInMap.get("ScheduleDesc"),TestDataInMap.get("startMonth"),TestDataInMap.get("startYear"),
				TestDataInMap.get("startDate"),TestDataInMap.get("endMonth"),TestDataInMap.get("endYear"),TestDataInMap.get("endDate"),
				TestDataInMap.get("ScheduleType"),TestDataInMap.get("TimeZone"),TestDataInMap.get("ScheduleExecHH"),TestDataInMap.get("ScheduleExecMM"),TestDataInMap.get("ScheduleDay"),
				TestDataInMap.get("RepeatAfter"),TestDataInMap.get("RepeatPeriod"),TestDataInMap.get("EndTimeHR"),TestDataInMap.get("EndTimeMinute"));
		extentTest.log(extentTest.getStatus(), "User created weekly schedule successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}
	@Test(priority=1039,alwaysRun=true)
	public void validateEditWeeklyScheduleTest(Method method) throws Exception {
		extentTest = extent.createTest("validateEditWeeklyScheduleTest", "TC_203:To Verfiy Edit weekly schedule");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		schedulerpageta = new SchedulerPageTA();
		schedulerpageta.validateEditWeeklySchedule(TestDataInMap.get("ScheduleName"),TestDataInMap.get("ScheduleDay"),TestDataInMap.get("RepeatAfter"),TestDataInMap.get("RepeatPeriod"));
		extentTest.log(extentTest.getStatus(), "Weekly schedule is edited successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=84,alwaysRun=true)
	public void validateMonthlyScheduleTest(Method method) throws Exception {
		extentTest = extent.createTest("validateMonthlyScheduleTest", "TC_193: Verify user can create monthly schedule with repeatation after every 15 min");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		schedulerpageta = new SchedulerPageTA();
		schedulerpageta.validateMonthlySchedule(TestDataInMap.get("wfName"),TestDataInMap.get("ScheduleName"),TestDataInMap.get("ScheduleDesc"),TestDataInMap.get("startMonth"),TestDataInMap.get("startYear"),
				TestDataInMap.get("startDate"),TestDataInMap.get("endMonth"),TestDataInMap.get("endYear"),TestDataInMap.get("endDate"),
				TestDataInMap.get("ScheduleType"),TestDataInMap.get("TimeZone"),TestDataInMap.get("SchedStartTime"),TestDataInMap.get("SchedMonth"),TestDataInMap.get("SchedDayOfMonth"),
				TestDataInMap.get("RepeatAfter"),TestDataInMap.get("RepeatPeriod"),TestDataInMap.get("EndTimeHR"));
		extentTest.log(extentTest.getStatus(), "User created monthly schedule successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}
	@Test(priority=1040,alwaysRun=true)
	public void validateEditMonthlyScheduleTest(Method method) throws Exception {
		extentTest = extent.createTest("validateEditMonthlyScheduleTest", "TC_205:To verify edit monthly schedule");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		schedulerpageta = new SchedulerPageTA();
		schedulerpageta.validateEditMonthlySchedule(TestDataInMap.get("ScheduleName"),TestDataInMap.get("SchedStartTime"),TestDataInMap.get("SchedMonth"));
		extentTest.log(extentTest.getStatus(), "Monthly schedule is edited successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
    @Test(priority=85,alwaysRun=true)
	public void validateInfineScheduleTest(Method method) throws Exception {
		extentTest = extent.createTest("validateInfineScheduleTest", "TC_195: Verify user can create infinite schedule with repeat intervals");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		schedulerpageta = new SchedulerPageTA();
		schedulerpageta.validateInfineSchedule(TestDataInMap.get("wfName"),TestDataInMap.get("ScheduleName"),TestDataInMap.get("ScheduleDesc"),TestDataInMap.get("startMonth"),TestDataInMap.get("startYear"),
				TestDataInMap.get("startDate"),TestDataInMap.get("ScheduleType"),TestDataInMap.get("TimeZone"),TestDataInMap.get("ScheduleExecHH"),TestDataInMap.get("ScheduleExecMM"),TestDataInMap.get("ScheduleDay"),
				TestDataInMap.get("RepeatAfter"),TestDataInMap.get("RepeatPeriod"),TestDataInMap.get("EndTimeHR"),TestDataInMap.get("EndTimeMinute"));
		extentTest.log(extentTest.getStatus(), "User created infinite schedule with repeated interval successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	} 
	@Test(priority=1041,alwaysRun=true)
	public void validateEditInfineScheduleTest(Method method) throws Exception {
		extentTest = extent.createTest("validateEditInfineScheduleTest", "TC_207: Edit Infinite schedule");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		schedulerpageta = new SchedulerPageTA();
		schedulerpageta.validateEditInfineSchedule(TestDataInMap.get("ScheduleName"),TestDataInMap.get("ScheduleType"),TestDataInMap.get("ScheduleDay"),TestDataInMap.get("ScheduleExecMM"));
		extentTest.log(extentTest.getStatus(), "Infinte schedule is edited successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=999,alwaysRun=true)
	public void validateDeleteScheduleTest(Method method) throws Exception {
		extentTest = extent.createTest("validateDeleteScheduleTest", "TC_197: Verify user can delete schedule");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		schedulerpageta = new SchedulerPageTA();
		schedulerpageta.validateDeleteSchedule(TestDataInMap.get("ScheduleName"),TestDataInMap.get("ScheduleDesc"));
		extentTest.log(extentTest.getStatus(), "User deleted schedule successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}
	@Test(priority=87,alwaysRun=true)
	public void validateTransferScheduleTest(Method method) throws Exception {
		extentTest = extent.createTest("validateTransferScheduleTest", "TC_xxx: Verify user can transfer schedule");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		schedulerpageta = new SchedulerPageTA();
		schedulerpageta.validateTransferSchedule(TestDataInMap.get("TransferFromOwner"),TestDataInMap.get("TransferTo"),
				TestDataInMap.get("ScheduleName"));
		extentTest.log(extentTest.getStatus(), "User can transfer schedule successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}
	@Test(priority=174,alwaysRun=true)
	public void validateSchedulerPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateSchedulerPageTATest", "TC_Additional:Verify Clicking Scheduler tab and checking that appropiate page is loaded");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		schedulerpageta = new SchedulerPageTA();
		schedulerpageta.validateSchedulerPageTA(TestDataInMap.get("PageTitle"));
		extentTest.log(extentTest.getStatus(), "Scheduler Page loading validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	/*@Test(priority=1042)
	public void validateDeleteUserScheduleTransferTest(Method method) throws Exception {
		extentTest = extent.createTest("validateDeleteUserScheduleTransferTest", "TC_213: To Verify not able to delete user who has active schedule");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		schedulerpageta = new SchedulerPageTA();
		schedulerpageta.validateDeleteUserScheduleTransfer(TestDataInMap.get("PageSize"),TestDataInMap.get("UserName"));
		extentTest.log(extentTest.getStatus(), "Not able to delete user who has active schedule is verified successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}*/
		//For Schedule Name
	@Test(priority = 3172)
	public void validateAdvSearchForScheduleNameEqualToSchedulerPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForScheduleNameEqualToSchedulerPageTATest", "TC_009: To Verfiy Advance search for schedule name with equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		schedulerpageta = new SchedulerPageTA();
		schedulerpageta.validateAdvSearchForScheduleNameEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Schedule Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3173)
	public void validateAdvSearchForScheduleNameNotEqualToSchedulerPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForScheduleNameNotEqualToSchedulerPageTATest", "TC_009: To Verfiy Advance search for schedule name with not equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		schedulerpageta = new SchedulerPageTA();
		schedulerpageta.validateAdvSearchForScheduleNameNotEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Schedule Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3174)
	public void validateAdvSearchForScheduleNameIsLikeSchedulerPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForScheduleNameIsLikeSchedulerPageTATest", "TC_009: To Verfiy Advance search for schedule name with Is like criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		schedulerpageta = new SchedulerPageTA();
		schedulerpageta.validateAdvSearchForScheduleNameIsLike(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Schedule Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3175)
	public void validateAdvSearchForScheduleNameBeginsWithSchedulerPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForScheduleNameBeginsWithSchedulerPageTATest", "TC_009: To Verfiy Advance search for schedule name with begins with criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		schedulerpageta = new SchedulerPageTA();
		schedulerpageta.validateAdvSearchForScheduleNameBeginsWith(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Schedule Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3176)
	public void validateAdvSearchForScheduleNameEndsWithSchedulerPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForScheduleNameEndsWithSchedulerPageTATest", "TC_009: To Verfiy Advance search for schedule name with ends with criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		schedulerpageta = new SchedulerPageTA();
		schedulerpageta.validateAdvSearchForScheduleNameEndsWith(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Schedule Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	// For Schedule Status 
	@Test(priority = 3177)
	public void validateStatusDropdownEqualToSchedulerPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateStatusDropdownEqualToSchedulerPageTATest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		schedulerpageta = new SchedulerPageTA();
		schedulerpageta.validateStatusDropdownEqualTo("Status", "equal to","Active","50");
		extentTest.log(extentTest.getStatus(), "Advance search for Last Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3178)
	public void validateStatusDropdownNotEqualToSchedulerPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateStatusDropdownNotEqualToSchedulerPageTATest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		schedulerpageta = new SchedulerPageTA();
		schedulerpageta.validateStatusDropdownNotEqualTo("Status", "not equal to","Active","50");
		extentTest.log(extentTest.getStatus(), "Advance search for Last Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
}
