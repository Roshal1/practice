package testcases;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ExcelFileUtility.ExcelUtility;
import JavaUtility.JavaUtility;
import POM.CampaignPage;
import POM.HomePage;
import POM.LoginPage;
import PropertiesFileUtility.PropertiesUtility;
import baseClass.BaseClass;
import webDriverUtility.WebDriverUtility;
@Listeners(listenersUtility.ListenersImplementation.class)
public class createDateTest extends BaseClass {
	@Test(groups = "Smoke")
	public  void  createDate()throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		ExcelUtility eutil = new ExcelUtility();
		WebDriverUtility wutil= new WebDriverUtility();
		JavaUtility jutil = new JavaUtility();
		//Read data from excel
		String campname = eutil.getDataFromExcel("Campaign", 1, 2);
		String size = eutil.getDataFromExcel("Campaign", 1, 3);
	
		String expectedate = jutil.togetRequired(30);
	
		//click on create Campaign button
		HomePage hp = new HomePage(driver);
		hp.getCreatecampaign().click();
		
		//enter mandatory fields
				CampaignPage cp = new CampaignPage(driver);
				cp.getCampaignName().sendKeys(campname);
				cp.getTargetsizeTF().sendKeys(size);
			
				wutil.passinput(driver, cp.getExpectedclosedate(), jutil.togetRequired(30));
				
				cp.getCreatecampaignsubmitBtn().click();
				
				   //validation
				Thread.sleep(2000);
				WebElement toast = driver.findElement(By.xpath("//div[@role='alert']"));
				Thread.sleep(2000);
				
				wutil.waitforVisibilityofElement(driver, toast);
				String msg = toast.getText();
			
				Assert.assertTrue(msg.contains(campname));
				driver.findElement(By.xpath("//button[@aria-label='close']")).click();
				
	}

}
