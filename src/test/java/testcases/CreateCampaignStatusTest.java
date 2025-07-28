package testcases;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import ExcelFileUtility.ExcelUtility;
import JavaUtility.JavaUtility;
import POM.CampaignPage;
import POM.HomePage;
import POM.LoginPage;
import PropertiesFileUtility.PropertiesUtility;
import baseClass.BaseClass;
import webDriverUtility.WebDriverUtility;

public class CreateCampaignStatusTest extends BaseClass {
	
	@Test(groups = "Regression")
	public void createCampaignStatus() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		ExcelUtility eutil = new ExcelUtility();
		WebDriverUtility wutil= new WebDriverUtility();
		JavaUtility jutil = new JavaUtility();
		//Read data from excel
		String campname = eutil.getDataFromExcel("Campaign", 1, 2);
		String size = eutil.getDataFromExcel("Campaign", 1, 3);
	String status = eutil.getDataFromExcel("Campaign", 1, 4);
	//int ran = jutil.getRandomNumber();
	String CampaignName = campname;
	
		//click on create Campaign button
		HomePage hp = new HomePage(driver);
		hp.getCreatecampaign().click();
		
		//enter mandatory fields
				CampaignPage cp = new CampaignPage(driver);
				cp.getCampaignName().sendKeys(CampaignName);
				cp.getTargetsizeTF().sendKeys(size);
				cp.getCampaignstatus().sendKeys(status);
				cp.getCreatecampaignsubmitBtn().click();
				
				   //validation
				Thread.sleep(2000);
				WebElement toast = driver.findElement(By.xpath("//div[@role='alert']"));
				Thread.sleep(2000);
				
				wutil.waitforVisibilityofElement(driver, toast);
				String msg = toast.getText();
				
			
				Assert.assertEquals(msg,"Campaign "+CampaignName+" Successfully Added");
				
				Assert.assertTrue(msg.contains(campname));
				driver.findElement(By.xpath("//button[@aria-label='close']")).click();
		
			
	}

}
