package com.ae.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.InformationPage;
import com.ae.qa.pages.LoginPage;
import com.ae.qa.pages.SystemSettingsPage;
import com.ae.qa.pages.WebElements;
import com.ae.qa.util.CommonWebElements;

public class KeyManagementPage extends TestBase { 
	//C:\Users\kalyanig\Downloads\AE_Automation_UploadFiles\KM1dot0_v1.zip
	
		public WebDriverWait wait = new WebDriverWait(driver, 150);
		public WebElements webelements = new WebElements();
		public LoginPage loginpage = new LoginPage();
		public InformationPage informationpage = new InformationPage();
		public SystemSettingsPage systemsettingspage = new SystemSettingsPage();
		public CommonWebElements wb = new CommonWebElements();
		
		@FindBy(xpath = "//span[(text()='Key Management')]")
		@CacheLookup
		WebElement keyManagementTab;
		@FindBy(xpath = "//span[(text()='Settings')]")
		WebElement settingsTab;
		@FindBy(id= "btnAssisted")
		WebElement maintenanceModeBtn;
		@FindBy(xpath="//label/input[@id='slider-maintenanceMode']/../span")
		WebElement maintenanceModeSlider;
		@FindBy(id="popup-button-ok")
		WebElement confirmationMsg;
		@FindBy(xpath = "//p[@class='alert-message-text']")
		WebElement alertMessage;
		@FindBy(xpath="//button[contains(text(),'Upgrade to v2.0')]")
		WebElement upgradeBtn;
		@FindBy(xpath="h3")
		WebElement popupHeader;
		@FindBy(xpath="//button[@class='btn btn-primary float-right']")
		WebElement upgradeToKM2Btn;
		
		public KeyManagementPage() {
			PageFactory.initElements(driver, this);
		}
		
		public void verifyChangingKM1To2() throws Exception {
			loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
			Reporter.log("User logged in successfully",true);
			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
		/*	js.executeScript("arguments[0].click();", settingsTab);
			Reporter.log("Clicked on Settings tab",true);
			maintenanceModeBtn.click();
			Reporter.log("Clicked on maintenance tab",true);
			maintenanceModeSlider.click();
			confirmationMsg.click();
			Thread.sleep(3000);
			Reporter.log("Maintenance mode on",true);
			String actual_alertMessage_maintenaceEnable=alertMessage.getText();
			Reporter.log("Message after enabling maintenance mode : "+actual_alertMessage_maintenaceEnable,true);
			String expected_agentPopup="Maintenance Mode has been enabled";
			Assert.assertEquals(actual_alertMessage_maintenaceEnable,expected_agentPopup);
			Reporter.log("Maintenance mode has not enabled successfully",true);*/
			js.executeScript("arguments[0].click();", keyManagementTab);
			Reporter.log("Clicked on key Management tab",true);
			Thread.sleep(2000);
			if(upgradeBtn.isDisplayed()) {
				Reporter.log("Upgarde To KM 2.0 button is " +upgradeBtn.isDisplayed()+ " Key Management current version is KM 1.0 and now upgrading to KM2.0 ", true);
				Thread.sleep(4000);
				upgradeBtn.click();
				Reporter.log("Upgarde to Key Management 2.0 btn is clicked",true);
				Thread.sleep(4000);
				String popUpHMessage=popupHeader.getText();
				System.out.println(popUpHMessage);
				if(popUpHMessage.contains("Enable Key Management v2.0")) {
					Thread.sleep(4000);
					upgradeToKM2Btn.click();
				}
			}
		
		}
		

}



