package com.ae.qa.pagesTenantAdmin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.WebElements;
import com.ae.qa.util.CommonWebElements;
import com.ae.qa.util.Messages;

public class HolidayCalenderPageTA extends TestBase{
	public WebDriverWait wait = new WebDriverWait(driver, 200);
	public WebElements webelements = new WebElements();
	public LoginPageTA loginpageta = new LoginPageTA();
	public InformationPageTA informationpageta=new InformationPageTA();
	public CommonWebElements wb = new CommonWebElements();

	@FindBy(xpath = "//span[text()='Workflows']")
	WebElement workflowsTab;
	@FindBy(xpath = "//a[text()='Holiday Calendar']")
	WebElement holidayCalenderTab;
	@FindBy(xpath = "//button[@name='add-new']")
	WebElement addNewBtn;
	@FindBy(id = "name")
	WebElement nameField;
	@FindBy(id = "description")
	WebElement descrpField;
	@FindBy(id = "year")
	WebElement yearSelect;
	@FindBy(xpath = "//ae-multiselect[@id='weeklyOff']")
	WebElement weeklyOffSelect;
	@FindBy(id = "title-0")
	WebElement tagField;
	@FindBy(id="0-datepicker")
	WebElement dateField;
	@FindBy(id = "title-1")
	WebElement tagEditField;
	@FindBy(id="1-datepicker")
	WebElement dateEditField;
	@FindBy(xpath="//select[@class='ui-datepicker-month']")
	WebElement monthDrpdown;
	@FindBy(xpath="//select[@class='ui-datepicker-year']")
	WebElement yearDrpdown;
	@FindBy(xpath="//div[@id='prop-edit-div']/span")
	WebElement addHolidayBtn;
	@FindBy(xpath="//span[@class='fa fa-trash text-danger']")
	WebElement deleteBtn;
	@FindBy(xpath="//button[@id='submitBtn']")
	WebElement submitBtn;
	@FindBy(xpath = "//p[@class='alert-message-text']")
	WebElement alertMessage;
	@FindBy(id = "clonedName")
	WebElement cloneNameField;
	@FindBy(id = "clonedDescription")
	WebElement cloneDescrpField;
	@FindBy(id = "clonedYear")
	WebElement cloneYearSelect;
	@FindBy(xpath="//button[@id='cloneSubmitBtn']")
	WebElement cloneSubmitBtn;
	@FindBy(xpath="//button[@id='popup-button-ok']")
	WebElement renewSubmitBtn;
	@FindBy(xpath="//div[@class='title-div']/h2")
	WebElement pageTitle;

	public HolidayCalenderPageTA() {
		PageFactory.initElements(driver, this);
	}


	public void ImportHolidayCalender(String cName,String cDescrp,String cYear,String weekDay,String tagName,String startYear,
			String startMonth,String startDate) throws Exception{
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User logged in successfully",true);
		//wait.until(ExpectedConditions.visibilityOf(workflowsTab));
		Thread.sleep(2000);
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", workflowsTab);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", holidayCalenderTab);
		Reporter.log("Holiday Calender Tab is clicked",true);
		Thread.sleep(3000);
		addNewBtn.click();
		Thread.sleep(2000);
		nameField.sendKeys(cName);
		descrpField.sendKeys(cDescrp);
		Thread.sleep(2000);
		Select year_drpdown = new Select(yearSelect);
		year_drpdown.selectByVisibleText(cYear);
		Thread.sleep(3000);
		weeklyOffSelect.click();
		WebElement weekDay_Select = driver.findElement(By.xpath("//label/span[text()='"+weekDay+"']/../input/../span[2]"));
		weekDay_Select.click();
		weeklyOffSelect.click();
		Thread.sleep(2000);
		tagField.sendKeys(tagName);
		dateField.click();
		Thread.sleep(2000);
		Select start_year_picker=new Select(yearDrpdown);
		start_year_picker.selectByVisibleText(startYear);
		Select start_month_picker=new Select(monthDrpdown);
		start_month_picker.selectByVisibleText(startMonth);
		Thread.sleep(2000);
		WebElement start_day_picker=driver.findElement(By.xpath("//tbody/tr/td/a[text()='"+startDate+"']"));
		start_day_picker.click();
		Thread.sleep(5000);
		//submitBtn.click();
		}
	
	public void validateCreateHolidayCalender(String cName,String cDescrp,String cYear,String weekDay,String tagName,String startYear,
			String startMonth,String startDate) throws Exception{
		ImportHolidayCalender(cName,cDescrp,cYear,weekDay,tagName,startYear,startMonth,startDate);
		submitBtn.click();
		wait.until(ExpectedConditions.visibilityOf(alertMessage));
		String actual_SucessMessage = alertMessage.getText();
		String expected_SuccessMessage = Messages.hoildayCalenderSuccessMsg;
		System.out.println("Actual Success Msg:" + actual_SucessMessage);
		System.out.println("Expected Success Msg:" + expected_SuccessMessage);
		Assert.assertEquals(actual_SucessMessage, expected_SuccessMessage, "Holiday Calender is not created successfully");
		Thread.sleep(5000);
		String actual_Calender = driver.findElement(By.xpath("//table/tr/td[text()='"+cName+"']")).getText();
		String expected_Calender = cName;
		System.out.println("Actual Calender Name:" + actual_Calender);
		System.out.println("Expected Calender Name:" + expected_Calender);
		Assert.assertEquals(actual_Calender, expected_Calender, "Holiday Calender is not added in the list");
		Thread.sleep(2000);
		informationpageta.validateSignOut();
	}
	public void validateCreateHolidayCalenderUpcomingYear(String cName,String cDescrp,String cYear,String weekDay,String tagName,String startYear,
			String startMonth,String startDate) throws Exception{
		ImportHolidayCalender(cName,cDescrp,cYear,weekDay,tagName,startYear,startMonth,startDate);
		submitBtn.click();
		wait.until(ExpectedConditions.visibilityOf(alertMessage));
		String actual_SucessMessage = alertMessage.getText();
		String expected_SuccessMessage = Messages.hoildayCalenderSuccessMsg;
		System.out.println("Actual Success Msg:" + actual_SucessMessage);
		System.out.println("Expected Success Msg:" + expected_SuccessMessage);
		Assert.assertEquals(actual_SucessMessage, expected_SuccessMessage, "Holiday Calender is not created successfully");
		Thread.sleep(5000);
		String actual_Year = driver.findElement(By.xpath("//table/tr/td[text()='"+cName+"']/../td[2]")).getText();
		String expected_Year = cYear;
		System.out.println("Actual Calender Name:" + actual_Year);
		System.out.println("Expected Calender Name:" + expected_Year);
		Assert.assertEquals(actual_Year, expected_Year, "Holiday Calender for upcoming year is not added in the list");
		Thread.sleep(2000);
		informationpageta.validateSignOut();
	}
	public void validateEditHolidayCalender(String cName,String weekDay,String tagName,String startYear,String startMonth,String startDate) throws Exception{
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User logged in successfully",true);
		//wait.until(ExpectedConditions.visibilityOf(workflowsTab));
		Thread.sleep(2000);
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", workflowsTab);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", holidayCalenderTab);
		Reporter.log("Holiday Calender Tab is clicked",true);
		Thread.sleep(2000);
		WebElement editBtn = driver.findElement(By.xpath("//table/tr/td[text()='"+cName+"']/../td[5]/span[@title='Edit Calendar']"));
		editBtn.click();
		Thread.sleep(2000);
		weeklyOffSelect.click();
		WebElement weekDay_Select = driver.findElement(By.xpath("//label/span[text()='"+weekDay+"']/../input/../span[2]"));
		weekDay_Select.click();
		weeklyOffSelect.click();
		Thread.sleep(2000);
		for (int i = 0; i < 30; i++) {
			tagField.sendKeys(Keys.BACK_SPACE);
		}
		tagField.sendKeys(tagName);
		dateField.click();
		Thread.sleep(2000);
		Select start_year_picker=new Select(yearDrpdown);
		start_year_picker.selectByVisibleText(startYear);
		Select start_month_picker=new Select(monthDrpdown);
		start_month_picker.selectByVisibleText(startMonth);
		Thread.sleep(2000);
		WebElement start_day_picker=driver.findElement(By.xpath("//tbody/tr/td/a[text()='"+startDate+"']"));
		start_day_picker.click();
		Thread.sleep(2000);
		submitBtn.click();
		wait.until(ExpectedConditions.visibilityOf(alertMessage));
		String actual_SucessMessage = alertMessage.getText();
		String expected_SuccessMessage = Messages.holidayCalenderEditMsg;
		System.out.println("Actual Success Msg:" + actual_SucessMessage);
		System.out.println("Expected Success Msg:" + expected_SuccessMessage);
		Assert.assertEquals(actual_SucessMessage, expected_SuccessMessage, "Holiday Calender is not updated successfully");
		Thread.sleep(5000);
		informationpageta.validateSignOut();
	}
	public void validateRemoveHolidayListDates(String cName,String tagName,String startYear,String startMonth,String startDate) throws Exception{
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User logged in successfully",true);
		//wait.until(ExpectedConditions.visibilityOf(workflowsTab));
		Thread.sleep(2000);
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", workflowsTab);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", holidayCalenderTab);
		Reporter.log("Holiday Calender Tab is clicked",true);
		Thread.sleep(2000);
		WebElement editBtn = driver.findElement(By.xpath("//table/tr/td[text()='"+cName+"']/../td[5]/span[@title='Edit Calendar']"));
		editBtn.click();
		Thread.sleep(4000);
		addHolidayBtn.click();
		Thread.sleep(4000);
		tagEditField.sendKeys(tagName);
		dateEditField.click();
		Thread.sleep(2000);
		Select start_year_picker=new Select(yearDrpdown);
		start_year_picker.selectByVisibleText(startYear);
		Select start_month_picker=new Select(monthDrpdown);
		start_month_picker.selectByVisibleText(startMonth);
		Thread.sleep(2000);
		WebElement start_day_picker=driver.findElement(By.xpath("//tbody/tr/td/a[text()='"+startDate+"']"));
		start_day_picker.click();
		//Thread.sleep(2000);
		//deleteBtn.click();
		Thread.sleep(2000);
		submitBtn.click();
		Thread.sleep(5000);		WebElement EditBtn = driver.findElement(By.xpath("//table/tr/td[text()='"+cName+"']/../td[5]/span[@title='Edit Calendar']"));
		EditBtn.click();
		Thread.sleep(2000);
		deleteBtn.click();
		Thread.sleep(2000);
		submitBtn.click();
		wait.until(ExpectedConditions.visibilityOf(alertMessage));
		String actual_SucessMessage = alertMessage.getText();
		String expected_SuccessMessage = Messages.holidayCalenderEditMsg;
		System.out.println("Actual Success Msg:" + actual_SucessMessage);
		System.out.println("Expected Success Msg:" + expected_SuccessMessage);
		Assert.assertEquals(actual_SucessMessage, expected_SuccessMessage, "Holiday Calender is not updated successfully");
		Thread.sleep(5000);
		informationpageta.validateSignOut();
	}
	public void validateCreateCloneHolidayCalender(String cName,String cloneName,String cloneDescrp,String cloneYear) throws Exception{
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User logged in successfully",true);
		//wait.until(ExpectedConditions.visibilityOf(workflowsTab));
		Thread.sleep(2000);
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", workflowsTab);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", holidayCalenderTab);
		Reporter.log("Holiday Calender Tab is clicked",true);
		WebElement cloneBtn = driver.findElement(By.xpath("//table/tr/td[text()='"+cName+"']/../td[5]/span[@title='Copy Calendar']"));
		cloneBtn.click();
		Thread.sleep(2000);
		cloneNameField.sendKeys(cloneName);
		cloneDescrpField.sendKeys(cloneDescrp);
		Thread.sleep(2000);
		Select year_drpdown = new Select(cloneYearSelect);
		year_drpdown.selectByVisibleText(cloneYear);
		Thread.sleep(2000);
		cloneSubmitBtn.click();
		wait.until(ExpectedConditions.visibilityOf(alertMessage));
		String actual_SucessMessage = alertMessage.getText();
		String expected_SuccessMessage = Messages.holidayCalenderCloneMsg;
		System.out.println("Actual Success Msg:" + actual_SucessMessage);
		System.out.println("Expected Success Msg:" + expected_SuccessMessage);
		Assert.assertEquals(actual_SucessMessage, expected_SuccessMessage, "Calendar copied is not created successfully");
		Thread.sleep(5000);
		informationpageta.validateSignOut();
	}
	public void validateEditCloneHolidayCalender(String cName,String cloneWeekDay,String startYear,String startMonth,String startDate) throws Exception{
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User logged in successfully",true);
		//wait.until(ExpectedConditions.visibilityOf(workflowsTab));
		Thread.sleep(2000);
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", workflowsTab);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", holidayCalenderTab);
		Reporter.log("Holiday Calender Tab is clicked",true);
		WebElement editBtn = driver.findElement(By.xpath("//table/tr/td[text()='"+cName+"']/../td[5]/span[@title='Edit Calendar']"));
		editBtn.click();
		Thread.sleep(4000);
		weeklyOffSelect.click();
		WebElement weekDay_Select = driver.findElement(By.xpath("//label/span[text()='"+cloneWeekDay+"']/../input/../span[2]"));
		weekDay_Select.click();
		weeklyOffSelect.click();
		Thread.sleep(2000);
		dateField.click();
		Thread.sleep(2000);
		Select start_year_picker=new Select(yearDrpdown);
		start_year_picker.selectByVisibleText(startYear);
		Select start_month_picker=new Select(monthDrpdown);
		start_month_picker.selectByVisibleText(startMonth);
		Thread.sleep(2000);
		WebElement start_day_picker=driver.findElement(By.xpath("//tbody/tr/td/a[text()='"+startDate+"']"));
		start_day_picker.click();
		Thread.sleep(2000);
		submitBtn.click();
		wait.until(ExpectedConditions.visibilityOf(alertMessage));
		String actual_SucessMessage = alertMessage.getText();
		String expected_SuccessMessage = Messages.holidayCalenderEditMsg;
		System.out.println("Actual Success Msg:" + actual_SucessMessage);
		System.out.println("Expected Success Msg:" + expected_SuccessMessage);
		Assert.assertEquals(actual_SucessMessage, expected_SuccessMessage, "Holiday Calender is not updated successfully");
		Thread.sleep(5000);
		informationpageta.validateSignOut();
		
	}
	public void validateRenewHoildayCalender(String cName,String cDescrp,String cYear,String weekDay,String tagName,String startYear,
			String startMonth,String startDate) throws Exception{
		ImportHolidayCalender(cName,cDescrp,cYear,weekDay,tagName,startYear,startMonth,startDate);
		submitBtn.click();
		Thread.sleep(8000);
		WebElement renewBtn = driver.findElement(By.xpath("//table/tr/td[text()='"+cName+"']/../td[5]/span[@title='Renew Calendar']"));
		renewBtn.click();
		Thread.sleep(2000);
		renewSubmitBtn.click();
		wait.until(ExpectedConditions.visibilityOf(alertMessage));
		String actual_SucessMessage = alertMessage.getText();
		String expected_SuccessMessage = Messages.holidayCalenderRenewMsg;
		System.out.println("Actual Success Msg:" + actual_SucessMessage);
		System.out.println("Expected Success Msg:" + expected_SuccessMessage);
		Assert.assertEquals(actual_SucessMessage, expected_SuccessMessage, "Holiday Calender is not renewed successfully");
		Thread.sleep(5000);
		informationpageta.validateSignOut();
	}
	public void validateEditRenewHolidayCalender(String cName,String WeekDay,String startMonth,String startDate) throws Exception{
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User logged in successfully",true);
		//wait.until(ExpectedConditions.visibilityOf(workflowsTab));
		Thread.sleep(2000);
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", workflowsTab);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", holidayCalenderTab);
		Reporter.log("Holiday Calender Tab is clicked",true);
		Thread.sleep(2000);
		String renewYear  = driver.findElement(By.xpath("(//table/tr/td[text()='"+cName+"']/../td[2])[1]")).getText();
		Thread.sleep(2000);
		WebElement editBtn = driver.findElement(By.xpath("(//table/tr/td[text()='"+cName+"']/../td[5]/span[@title='Edit Calendar'])[1]"));
		editBtn.click();
		weeklyOffSelect.click();
		WebElement weekDay_Select = driver.findElement(By.xpath("//label/span[text()='"+WeekDay+"']/../input/../span[2]"));
		weekDay_Select.click();
		weeklyOffSelect.click();
		Thread.sleep(2000);
		dateField.click();
		Thread.sleep(2000);
		Select start_year_picker=new Select(yearDrpdown);
		start_year_picker.selectByVisibleText(renewYear);
		Select start_month_picker=new Select(monthDrpdown);
		start_month_picker.selectByVisibleText(startMonth);
		Thread.sleep(2000);
		WebElement start_day_picker=driver.findElement(By.xpath("//tbody/tr/td/a[text()='"+startDate+"']"));
		start_day_picker.click();
		Thread.sleep(2000);
		submitBtn.click();
		wait.until(ExpectedConditions.visibilityOf(alertMessage));
		String actual_SucessMessage = alertMessage.getText();
		String expected_SuccessMessage = Messages.holidayCalenderEditMsg;
		System.out.println("Actual Success Msg:" + actual_SucessMessage);
		System.out.println("Expected Success Msg:" + expected_SuccessMessage);
		Assert.assertEquals(actual_SucessMessage, expected_SuccessMessage, "Holiday Calender is not updated successfully");
		Thread.sleep(5000);
		informationpageta.validateSignOut();
	}
	public void validateRemoveHoildayDatesRenew(String cName,String tagName,String startMonth,String startDate) throws Exception{
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User logged in successfully",true);
		//wait.until(ExpectedConditions.visibilityOf(workflowsTab));
		Thread.sleep(2000);
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", workflowsTab);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", holidayCalenderTab);
		Reporter.log("Holiday Calender Tab is clicked",true);
		Thread.sleep(2000);
		String renewYear  = driver.findElement(By.xpath("(//table/tr/td[text()='"+cName+"']/../td[2])[1]")).getText();
		Thread.sleep(2000);
		WebElement editBtn = driver.findElement(By.xpath("(//table/tr/td[text()='"+cName+"']/../td[5]/span[@title='Edit Calendar'])[1]"));
		editBtn.click();
		Thread.sleep(4000);
		addHolidayBtn.click();
		Thread.sleep(4000);
		tagEditField.sendKeys(tagName);
		dateEditField.click();
		Thread.sleep(2000);
		Select start_year_picker=new Select(yearDrpdown);
		start_year_picker.selectByVisibleText(renewYear);
		Select start_month_picker=new Select(monthDrpdown);
		start_month_picker.selectByVisibleText(startMonth);
		Thread.sleep(2000);
		WebElement start_day_picker=driver.findElement(By.xpath("//tbody/tr/td/a[text()='"+startDate+"']"));
		start_day_picker.click();
		//Thread.sleep(2000);
		//deleteBtn.click();
		Thread.sleep(2000);
		submitBtn.click();
		Thread.sleep(5000);
		WebElement EditBtn = driver.findElement(By.xpath("(//table/tr/td[text()='"+cName+"']/../td[5]/span[@title='Edit Calendar'])[1]"));
		EditBtn.click();
		Thread.sleep(2000);
		deleteBtn.click();
		Thread.sleep(2000);
		submitBtn.click();
		wait.until(ExpectedConditions.visibilityOf(alertMessage));
		String actual_SucessMessage = alertMessage.getText();
		String expected_SuccessMessage = Messages.holidayCalenderEditMsg;
		System.out.println("Actual Success Msg:" + actual_SucessMessage);
		System.out.println("Expected Success Msg:" + expected_SuccessMessage);
		Assert.assertEquals(actual_SucessMessage, expected_SuccessMessage, "Holiday Calender is not updated successfully");
		Thread.sleep(5000);
		informationpageta.validateSignOut();
	}
	public void validateDeleteHolidayCalender(String cName) throws Exception{
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User logged in successfully",true);
		//wait.until(ExpectedConditions.visibilityOf(workflowsTab));
		Thread.sleep(2000);
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", workflowsTab);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", holidayCalenderTab);
		Reporter.log("Holiday Calender Tab is clicked",true);
		Thread.sleep(2000);
		String calenderYear  = driver.findElement(By.xpath("(//table/tr/td[text()='"+cName+"']/../td[2])[1]")).getText();
		Thread.sleep(2000);
		WebElement deleteBtn = driver.findElement(By.xpath("//table/tr/td[text()='"+cName+"']/../td[5]/span[@title='Delete Calendar']"));
		deleteBtn.click();
		Thread.sleep(2000);
		renewSubmitBtn.click();
		wait.until(ExpectedConditions.visibilityOf(alertMessage));
		String actual_SucessMessage = alertMessage.getText();
		String expected_SuccessMessage = "Holiday calendar ["+cName+", "+calenderYear+"] successfully deleted";
		System.out.println("Actual Success Msg:" + actual_SucessMessage);
		System.out.println("Expected Success Msg:" + expected_SuccessMessage);
		Assert.assertEquals(actual_SucessMessage, expected_SuccessMessage, "Holiday Calender is not deletedd successfully");
		Thread.sleep(5000);
		informationpageta.validateSignOut();
	}
	public void validateHolidayCalenderPage(String PageTitle) throws Exception{
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User logged in successfully",true);
		//wait.until(ExpectedConditions.visibilityOf(workflowsTab));
		Thread.sleep(2000);
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", workflowsTab);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", holidayCalenderTab);
		Thread.sleep(3000);
		//Now validate page title is same as expected
		String actual_title=pageTitle.getText();
		String expected_title=PageTitle;
		Reporter.log("Actual page title displayed on screen is: "+actual_title+ " and Expected "
				+ "page title is: "+expected_title,true);
		Assert.assertEquals(actual_title, expected_title,"Appropriate page didn't loaded properly");
		Reporter.log("Respective Page is clicked and appropriate page is loaded properly",true);
		informationpageta.validateSignOut();
	}
	public void validateAdvSearch() throws Exception {
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User log in Successfully", true);
		Thread.sleep(2000);		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", workflowsTab);
		js.executeScript("arguments[0].click();", holidayCalenderTab);
		wb.validateClickOnAdvanceSearch();
	}
////////////////////////////////////For Holiday Calender Name//////////////////////////////////////////////////////////
	public void validateAdvSearchForNameEqualTo(String SearchColumn,String SearchCriteria,
			String Name,String PageSize)throws Exception {
		validateAdvSearch();
		Thread.sleep(2000);	
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria, Name);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new Holiday name record is visible in webtable", true);
		Thread.sleep(2000);	
		List<WebElement>op=driver.findElements(By.xpath("//table[@class='ae-table table table-hover table-bordered table-striped mb-0']/tr/td[1]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Holidayname record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_Name=op.get(i).getText();
			System.out.println("actual_Holiday name name present in table are: "+actual_Name);
			Assert.assertTrue(actual_Name.equals(Name));
		}
	}
	public void validateAdvSearchForNameNotEqualTo(String SearchColumn,String SearchCriteria,
			String Name,String PageSize)throws Exception {
		validateAdvSearch();
		Thread.sleep(2000);	
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria, Name);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new Holiday name record is visible in webtable", true);
		Thread.sleep(2000);	
		List<WebElement>op=driver.findElements(By.xpath("//table[@class='ae-table table table-hover table-bordered table-striped mb-0']/tr/td[1]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total workflow record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_Name=op.get(i).getText();
			System.out.println("actual_Holiday name present in table are: "+actual_Name);
			Assert.assertFalse(actual_Name.equals(Name));
		}
	}
	public void validateAdvSearchForNameIsLike(String SearchColumn,String SearchCriteria,
			String advSearchFor,String PageSize)throws Exception {
		validateAdvSearch();
		Thread.sleep(2000);
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria,advSearchFor);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new Holiday name record is visible in webtable", true);
		Thread.sleep(2000);	
		List<WebElement>op=driver.findElements(By.xpath("//table[@class='ae-table table table-hover table-bordered table-striped mb-0']/tr/td[1]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Holiday name record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_Name=op.get(i).getText();
			System.out.println("actual_Holiday name present in table are: "+actual_Name);
			Assert.assertTrue(actual_Name.contains(advSearchFor));
		}
	}
	public void validateAdvSearchForNameBeginsWith(String SearchColumn,String SearchCriteria,
			String advSearchFor,String PageSize)throws Exception {
		validateAdvSearch();
		Thread.sleep(2000);
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria,advSearchFor);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new Holiday name record is visible in webtable", true);
		Thread.sleep(2000);	
		List<WebElement>op=driver.findElements(By.xpath("//table[@class='ae-table table table-hover table-bordered table-striped mb-0']/tr/td[1]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Holiday name record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_Name=op.get(i).getText();
			//String lowercase_UserName = actual_UserName.toLowerCase();
			System.out.println("actual_Holiday name present in table are: "+actual_Name);
			Thread.sleep(3000);
			Assert.assertTrue(actual_Name.contains(advSearchFor));
		}
	}
	public void validateAdvSearchForNameEndsWith(String SearchColumn,String SearchCriteria,
			String advSearchFor,String PageSize)throws Exception {
		validateAdvSearch();
		Thread.sleep(2000);
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria,advSearchFor);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new Holiday name record is visible in webtable", true);
		Thread.sleep(2000);	
		List<WebElement>op=driver.findElements(By.xpath("//table[@class='ae-table table table-hover table-bordered table-striped mb-0']/tr/td[1]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Holiday name record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_Name=op.get(i).getText();
			System.out.println("actual_Holiday name present in table are: "+actual_Name);
			Assert.assertTrue(actual_Name.contains(advSearchFor));
		}
	}
	public void HandleEnterFieldValue(String SearchColumn,String SearchCriteria,String SearchFor,String PageSize)
			throws Exception {
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria,SearchFor);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		System.out.println("Page size changed to 50");
		Thread.sleep(2000);
	}
	/////////////////////////////////////For Year//////////////////////////////////////////////////////////////////////
	public void validateAdvSearchForYearEqualTo(String SearchColumn, String SearchCriteria, String AdvSearchFor,
			String PageSize) throws Exception {
		validateAdvSearch();
		Thread.sleep(2000);
		HandleEnterFieldValue(SearchColumn, SearchCriteria, AdvSearchFor, PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate Year : " + AdvSearchFor + " record for " + SearchCriteria
				+ " criteria is visible in webtable", true);
		Thread.sleep(2000);
		List<WebElement> op = driver
				.findElements(By.xpath("//table[@class='ae-table table table-hover table-bordered table-striped mb-0']/tr/td[2]"));
		for (int i = 0; i < op.size(); i++) {
			System.out.println("Total Matching record present in table are :" + op.size());
			Thread.sleep(1000);
			String actual_Year = op.get(i).getText();
			Reporter.log("actual_Year present in table are: " + actual_Year + " expected Year is " + AdvSearchFor, true);
			Assert.assertEquals(actual_Year, AdvSearchFor,
					"Mismatch in actual and expected Year of advance search of Holiday page");
		}
		informationpageta.validateSignOut();
	}
	public void validateAdvSearchForYearNotEqualTo(String SearchColumn, String SearchCriteria, String AdvSearchFor,
			String PageSize) throws Exception {
		validateAdvSearch();
		Thread.sleep(2000);
		HandleEnterFieldValue(SearchColumn, SearchCriteria, AdvSearchFor, PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate Year : " + AdvSearchFor + " record for " + SearchCriteria
				+ " criteria is visible in webtable", true);
		Thread.sleep(2000);
		List<WebElement> op = driver
				.findElements(By.xpath("//table[@class='ae-table table table-hover table-bordered table-striped mb-0']/tr/td[2]"));
		for (int i = 0; i < op.size(); i++) {
			System.out.println("Total Matching record present in table are :" + op.size());
			Thread.sleep(1000);
			String actual_Year = op.get(i).getText();
			Reporter.log("actual_Year present in table are: " + actual_Year + " expected Year is " + AdvSearchFor, true);
			Assert.assertFalse(actual_Year.equals(AdvSearchFor));
		}
		informationpageta.validateSignOut();
	}
	public void validateAdvSearchForYearLessThan(String SearchColumn, String SearchCriteria, String AdvSearchFor,
			String PageSize) throws Exception {
		validateAdvSearch();
		Thread.sleep(2000);
		HandleEnterFieldValue(SearchColumn, SearchCriteria, AdvSearchFor, PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate Year : " + AdvSearchFor + " record for " + SearchCriteria
				+ " criteria is visible in webtable", true);
		Thread.sleep(2000);
		List<WebElement> op = driver
				.findElements(By.xpath("//table[@class='ae-table table table-hover table-bordered table-striped mb-0']/tr/td[2]"));
		for (int i = 0; i < op.size(); i++) {
			System.out.println("Total Matching record present in table are :" + op.size());
			Thread.sleep(1000);
			String actual_Year = op.get(i).getText();
			int actualYear= Integer. parseInt(actual_Year);
			int expectedYear= Integer. parseInt(AdvSearchFor);
			Reporter.log("actual_Year present in table are: " + actual_Year + " expected Year is " + AdvSearchFor, true);
			Assert.assertTrue(actualYear < expectedYear);
		}
		informationpageta.validateSignOut();
	}
	public void validateAdvSearchForYearGreaterThan(String SearchColumn, String SearchCriteria, String AdvSearchFor,
			String PageSize) throws Exception {
		validateAdvSearch();
		Thread.sleep(2000);
		HandleEnterFieldValue(SearchColumn, SearchCriteria, AdvSearchFor, PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate Year : " + AdvSearchFor + " record for " + SearchCriteria
				+ " criteria is visible in webtable", true);
		Thread.sleep(2000);
		List<WebElement> op = driver
				.findElements(By.xpath("//table[@class='ae-table table table-hover table-bordered table-striped mb-0']/tr/td[2]"));
		for (int i = 0; i < op.size(); i++) {
			System.out.println("Total Matching record present in table are :" + op.size());
			Thread.sleep(1000);
			String actual_Year = op.get(i).getText();
			int actualYear= Integer. parseInt(actual_Year);
			int expectedYear= Integer. parseInt(AdvSearchFor);
			Reporter.log("actual_Year present in table are: " + actual_Year + " expected Year is " + AdvSearchFor, true);
			Assert.assertTrue(actualYear > expectedYear);
		}
		informationpageta.validateSignOut();
	}
	public void validateAdvSearchForYearInRange(String SearchColumn, String SearchCriteria, String SearchField1,
			String SearchField2,String PageSize) throws Exception {
		validateAdvSearch();
		Thread.sleep(2000);
		wb.validateAdvanceSearchFieldForRange(SearchColumn, SearchCriteria,SearchField1,SearchField2);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		System.out.println("Page size changed to 50");
		// Verify data in table now//2-4
		Reporter.log("Below validation is to validate Year : " + SearchCriteria
				+ " of "+SearchField1+"-"+SearchField2+" is visible in webtable or not", true);
		Thread.sleep(2000);
		List<WebElement> op = driver
				.findElements(By.xpath("//table[@class='ae-table table table-hover table-bordered table-striped mb-0']/tr/td[2]"));
		for (int i = 0; i < op.size(); i++) {
			System.out.println("Total Matching record present in table are :" + op.size());
			Thread.sleep(1000);
			String actual_Year = op.get(i).getText();//2,3,4
			int actualYear= Integer. parseInt(actual_Year);
			int expected_SearchFiledYearRange1= Integer. parseInt(SearchField1);
			int expected_SearchFiledYearRange2= Integer. parseInt(SearchField2);
			Reporter.log("actual_Year present in table are: " + actual_Year + " expected Year is in range of " + expected_SearchFiledYearRange1+"-"+expected_SearchFiledYearRange2, true);
			Assert.assertTrue(actualYear >= expected_SearchFiledYearRange1 && actualYear <= expected_SearchFiledYearRange2 );
		} 
		informationpageta.validateSignOut();
	}
	public void validateAdvSearchForYearNotInRange(String SearchColumn, String SearchCriteria, String SearchField1,
			String SearchField2, String PageSize) throws Exception {
		validateAdvSearch();
		Thread.sleep(2000);
		wb.validateAdvanceSearchFieldForRange(SearchColumn, SearchCriteria,SearchField1,SearchField2);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		System.out.println("Page size changed to 50");
		// Verify data in table now//2-4
		Reporter.log("Below validation is to validate Year : " + SearchCriteria
				+ " of "+SearchField1+"-"+SearchField2+" is visible in webtable or not", true);
		Thread.sleep(2000);
		List<WebElement> op = driver
				.findElements(By.xpath("//table[@class='ae-table table table-hover table-bordered table-striped mb-0']/tr/td[2]"));
		for (int i = 0; i < op.size(); i++) {
			System.out.println("Total Matching record present in table are :" + op.size());
			Thread.sleep(1000);
			String actual_Year = op.get(i).getText();//1,5,6,7
			int actualYear= Integer. parseInt(actual_Year);
			int expected_SearchFiledYearRange1= Integer. parseInt(SearchField1);
			int expected_SearchFiledYearRange2= Integer. parseInt(SearchField2);
			Reporter.log("actual_Year present in table are: " + actual_Year + " expected Year is in range of " + expected_SearchFiledYearRange1+"-"+expected_SearchFiledYearRange2, true);
			Assert.assertTrue(actualYear < expected_SearchFiledYearRange1 || actualYear > expected_SearchFiledYearRange2 );
		} 
		informationpageta.validateSignOut();
	}
	//For Time Zone
	public void validateTimeZoneDropdownEqualTo(String colunmValue,String comparatorType,String searchValue,String PageSize) throws Exception {
		validateAdvSearch();
		Thread.sleep(2000);
		wb.validateAdvanceSearchDropDown(colunmValue,comparatorType,searchValue);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new Time Zone record is visible in webtable", true);
		Thread.sleep(2000);
		List<WebElement>op=driver.findElements(By.xpath("//table[@class='ae-table table table-hover table-bordered table-striped mb-0']/tr/td[3]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total TimeZone record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_TimeZone=op.get(i).getText();
			String str_actual_TimeZone = actual_TimeZone.split(" ")[0];
			System.out.println("actual_TimeZone present in table are: "+str_actual_TimeZone);
			Assert.assertTrue(str_actual_TimeZone.equalsIgnoreCase(searchValue));
		}
	}
	public void validateTimeZoneDropdownNotEqualTo(String colunmValue,String comparatorType,String searchValue,String PageSize)throws Exception {
		validateAdvSearch();
		Thread.sleep(2000);
		wb.validateAdvanceSearchDropDown(colunmValue,comparatorType,searchValue);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new TimeZone record is visible in webtable", true);
		Thread.sleep(2000);
		List<WebElement>op=driver.findElements(By.xpath("//table[@class='ae-table table table-hover table-bordered table-striped mb-0']/tr/td[3]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total TimeZone record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_TimeZone=op.get(i).getText();
			String str_actual_TimeZone = actual_TimeZone.split(" ")[0];
			System.out.println("actual_TimeZone present in table are: "+str_actual_TimeZone);
			Assert.assertFalse(str_actual_TimeZone.equalsIgnoreCase(searchValue));
		}
	}
}
