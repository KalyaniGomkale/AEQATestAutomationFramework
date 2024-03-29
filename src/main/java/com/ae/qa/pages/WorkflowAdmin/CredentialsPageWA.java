package com.ae.qa.pages.WorkflowAdmin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.ae.qa.base.TestBase;
import com.ae.qa.pagesTenantAdmin.InformationPageTA;
import com.ae.qa.pagesTenantAdmin.LoginPageTA;
import com.ae.qa.util.Messages;

public class CredentialsPageWA extends TestBase{
	public LoginPageTA loginpage = new LoginPageTA();
	public static WebDriverWait wait = new WebDriverWait(driver, 300);
	public InformationPageTA Info = new InformationPageTA();

	@FindBy(xpath="//span[text()='Workflows']")
	WebElement workflowTab;
	@FindBy(xpath="//a[text()='Credentials']")
	WebElement credentialsTab;
	@FindBy(name="add-cred")
	WebElement addNewBtn;
	@FindBy(id="credentialName")
	WebElement credName;
	@FindBy(id="credentialDescription")
	WebElement credDescp;
	@FindBy(id="userName")
	WebElement userName;
	@FindBy(id="password")
	WebElement password;
	@FindBy(id="option1")
	WebElement param1;
	@FindBy(id="option2")
	WebElement param2;
	@FindBy(id="enc1")
	WebElement encParam1;
	@FindBy(id="enc2")
	WebElement encParam2;
	@FindBy(id="new-credPool-btn")
	WebElement createBtn;
	@FindBy(xpath="//div/p[@class='alert-message-text']")
	WebElement successMsgBox;
	@FindBy(id="expiryDate-datepicker")
	WebElement expiryDate;
	@FindBy(xpath="//div/select[@class='ui-datepicker-year']")
	WebElement year;
	@FindBy(xpath="//div/select[@class='ui-datepicker-month']")
	WebElement month;
	@FindBy(xpath="//div/select[@class='ui-datepicker-month']")
	WebElement date;
	@FindBy(name="dropdown-selector")
	WebElement addDrpdown;
	@FindBy(name="new-pool")
	WebElement credPoolBtn;
	@FindBy(id="CredPoolName")
	WebElement credPoolName;
	@FindBy(id="CredPoolDescription")
	WebElement credPoolDescp;
	@FindBy(id="new-cred-btn")
	WebElement createPoolBtn;
	@FindBy(xpath="//select[@name='wfs']")
	WebElement credPool_drpdown;
	@FindBy(name="move")
	WebElement moveBtn;
	@FindBy(id="popup-button-ok")
	WebElement delete_popup;
	@FindBy(xpath="//div[@class='title-div']/h2")
	WebElement pageTitle;

	public CredentialsPageWA()
	{
		PageFactory.initElements(driver, this);
	}
	public void ValidateCreateCredentialsWA(String CredName,String CredDescp,String UserName,String Pswd)throws Exception
	{
		loginpage.login(prop.getProperty("username_WA"), prop.getProperty("password_WA"));
		Reporter.log("User LogIn Succesfully",true);
		//wait.until(ExpectedConditions.visibilityOf(workflowTab));
		Thread.sleep(2000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", workflowTab);
		System.out.println("workflowTab clicked");
		//wait.until(ExpectedConditions.visibilityOf(credentialsTab));
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", credentialsTab);
		Reporter.log("Credentials tab clicked",true);
		Thread.sleep(4000);
		addNewBtn.click();
		Reporter.log("Add new button is clicked",true);
		Thread.sleep(3000);
		credName.sendKeys(CredName);
		Thread.sleep(3000);
		credDescp.sendKeys(CredDescp);
		Thread.sleep(3000);
		userName.sendKeys(UserName);
		Thread.sleep(3000);
		password.sendKeys(Pswd);
		Thread.sleep(3000);
		createBtn.click();
		Reporter.log("Create button is clicked",true);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		String record_verify=driver.findElement(By.xpath("//div[@id='cred-container']/div/a/input/../label[@title='"+CredName+", Native']")).getText();
		String expected_cred=CredName+" (Native)";
		Assert.assertEquals(record_verify, expected_cred,"credentials record not found in table.");
		Reporter.log("Record for "+CredName+" credential found in table",true);
		Thread.sleep(3000);
		Reporter.log("Credentials created succesfully",true);
		Info.validateSignOut();	 
	}
	public void ValidateEditCredentialsWA(String CredName,String Param1,String Param2,String EncParam1,String EncParam2,
			String Year,String Month,String Date)throws Exception
	{
		loginpage.login(prop.getProperty("username_WA"), prop.getProperty("password_WA"));
		Reporter.log("User LogIn Succesfully",true);
		//wait.until(ExpectedConditions.visibilityOf(workflowTab));
		Thread.sleep(2000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", workflowTab);
		System.out.println("workflowTab clicked");
		//wait.until(ExpectedConditions.visibilityOf(credentialsTab));
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", credentialsTab);
		Reporter.log("Credentials tab clicked",true);
		Thread.sleep(4000);
		WebElement edit_Cred=driver.findElement(By.xpath("//label[@title='"+CredName+", Native']/../../div/span[@title='Edit Credential']"));
		edit_Cred.click();
		Reporter.log("Edit button corresponding to credentials clicked",true);
		Thread.sleep(3000);
		param1.sendKeys(Param1);
		Thread.sleep(3000);
		param2.sendKeys(Param2);
		Thread.sleep(3000);
		encParam1.sendKeys(EncParam1);
		Thread.sleep(3000);
		encParam2.sendKeys(EncParam2);
		Thread.sleep(3000);
		expiryDate.click();
		Thread.sleep(3000);
		//Steps for year selection
		Select select_year=new Select(year);
		select_year.selectByVisibleText(Year);
		Thread.sleep(3000);
		Reporter.log("Year selected from Calender",true);
		//Steps to choose month
		Select select_month=new Select(month);
		select_month.selectByVisibleText(Month);
		Thread.sleep(3000);
		Reporter.log("Month selected from Calender",true);
		//Steps to choose date
		WebElement expiryDate=driver.findElement(By.xpath("//td[@data-handler='selectDay']/a[text()='"+Date+"']"));
		expiryDate.click();
		Thread.sleep(3000);
		Reporter.log("Expiry Date selected from Calender",true);
		Thread.sleep(3000);
		createBtn.click();
		Reporter.log("Update button is clicked",true);
		Reporter.log("Credentials edited succesfully with all fields",true);
		Thread.sleep(4000);
		Info.validateSignOut();	 
	}
	public void ValidateCreateCredentialPoolWA(String CredPoolName,String CredPoolDescp)throws Exception
	{
		loginpage.login(prop.getProperty("username_WA"), prop.getProperty("password_WA"));
		Reporter.log("User LogIn Succesfully",true);
		//wait.until(ExpectedConditions.visibilityOf(workflowTab));
		Thread.sleep(2000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", workflowTab);
		System.out.println("workflowTab clicked");
		//wait.until(ExpectedConditions.visibilityOf(credentialsTab));
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", credentialsTab);
		Reporter.log("Credentials tab clicked",true);
		Thread.sleep(4000);
		addDrpdown.click();
		credPoolBtn.click();
		Reporter.log("Credential Pool button is clicked",true);
		Thread.sleep(3000);
		credPoolName.sendKeys(CredPoolName);
		Thread.sleep(3000);
		credPoolDescp.sendKeys(CredPoolDescp);
		Thread.sleep(3000);
		createPoolBtn.click();
		Reporter.log("Create button is clicked",true);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		String record_verify=driver.findElement(By.xpath("//div[@class='list-group']/div/b[contains(text(),'"+CredPoolName+"')]")).getText();
		String expected_credPoolName=CredPoolName;
		Assert.assertEquals(record_verify, expected_credPoolName,"credential Pool record not found in table.");
		Reporter.log("Record for "+CredPoolName+" credential Pool found in table",true);
		Thread.sleep(3000);
		Reporter.log("Credential Pool created succesfully",true);
		Info.validateSignOut();	 
	}
	public void ValidateMoveCredentialToPoolWA(String CredName,String CredPoolName,String CredPoolDescp)throws Exception
	{
		ValidateCreateCredentialPoolWA(CredPoolName,CredPoolDescp);
		loginpage.login(prop.getProperty("username_WA"), prop.getProperty("password_WA"));
		Reporter.log("User LogIn Succesfully",true);
		//wait.until(ExpectedConditions.visibilityOf(workflowTab));
		Thread.sleep(2000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", workflowTab);
		System.out.println("workflowTab clicked");
		//wait.until(ExpectedConditions.visibilityOf(credentialsTab));
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", credentialsTab);
		Reporter.log("Credentials tab clicked",true);
		Thread.sleep(4000);
		WebElement cred_Name=driver.findElement(By.xpath("//div/a/input[@id='cred-1']"));
		cred_Name.click();
		Reporter.log("Credential which needs to add in crenetial pool is selcted",true);
		Select CredPool_drpdown = new Select(credPool_drpdown);
		CredPool_drpdown.selectByVisibleText(CredPoolName);
		Reporter.log("Credential pool in which redential needs to move is selected from dropdown",true);
		Thread.sleep(2000);
		moveBtn.click();
		Reporter.log("Move Button is clicked",true);
		wait.until(ExpectedConditions.visibilityOf(successMsgBox));
		String Actual_testMsg=successMsgBox.getText();
		String Expected_testMsg=Messages.MoveCredToPool;
		Reporter.log("Actual message is :"+Actual_testMsg,true);
		Reporter.log("Expected message is :"+Expected_testMsg,true);
		Assert.assertEquals(Actual_testMsg,Expected_testMsg,"Credential moving to Cred Pool is unsuccessful");
		Thread.sleep(3000);
		Reporter.log("Credential moved to credential pool successfully",true);
		Info.validateSignOut();
	}
	public void ValidateDeleteCredentialPoolWA(String CredPoolName) throws Exception{
		loginpage.login(prop.getProperty("username_WA"), prop.getProperty("password_WA"));
		Reporter.log("User LogIn Succesfully",true);
		//wait.until(ExpectedConditions.visibilityOf(workflowTab));
		Thread.sleep(2000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", workflowTab);
		System.out.println("workflowTab clicked");
		//wait.until(ExpectedConditions.visibilityOf(credentialsTab));
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", credentialsTab);
		Reporter.log("Credentials tab clicked",true);
		Thread.sleep(4000);
		WebElement deletePool_btn=driver.findElement(By.xpath("//div/div/b[contains(text(),'"+CredPoolName+"')]/../div/span[@title='Delete Credential Pool']"));
		//js.executeScript("arguments[0].click();", deletePool_btn);
		deletePool_btn.click();
		Thread.sleep(3000);
		delete_popup.click();
		Reporter.log("Delete button on popup is confirmed",true);
		wait.until(ExpectedConditions.visibilityOf(successMsgBox));
		String Actual_testMsg=successMsgBox.getText();
		String Expected_testMsg= "Credential pool ["+CredPoolName+"] deleted successfully";
		Reporter.log("Actual message is :"+Actual_testMsg,true);
		Reporter.log("Expected message is :"+Expected_testMsg,true);
		Assert.assertEquals(Actual_testMsg,Expected_testMsg,"Credential Pool deletion unsuccessful");
		Thread.sleep(3000);
		Reporter.log("Credential pool deleted successfully",true);
		Info.validateSignOut();
	}
	public void ValidateDeleteCredentialWA(String CredName) throws Exception{
		loginpage.login(prop.getProperty("username_WA"), prop.getProperty("password_WA"));
		Reporter.log("User LogIn Succesfully",true);
		//wait.until(ExpectedConditions.visibilityOf(workflowTab));
		Thread.sleep(2000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", workflowTab);
		System.out.println("workflowTab clicked");
		//wait.until(ExpectedConditions.visibilityOf(credentialsTab));
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", credentialsTab);
		Reporter.log("Credentials tab clicked",true);
		Thread.sleep(4000);
		WebElement delete_btn=driver.findElement(By.xpath("//div/a/span[contains(text(),'"+CredName+"')]/../../div/span[@title='Delete credential']"));
		delete_btn.click();
		Thread.sleep(3000);
		delete_popup.click();
		Reporter.log("Delete button on popup is confirmed",true);
		wait.until(ExpectedConditions.visibilityOf(successMsgBox));
		String Actual_testMsg=successMsgBox.getText();
		String Expected_testMsg= "Credential ["+CredName+"] deleted successfully";
		Reporter.log("Actual message is :"+Actual_testMsg,true);
		Reporter.log("Expected message is :"+Expected_testMsg,true);
		Assert.assertEquals(Actual_testMsg,Expected_testMsg,"Credential deletion unsuccessful");
		Thread.sleep(3000);
		Reporter.log("Credential deleted successfully",true);
		Info.validateSignOut();
	}
}
