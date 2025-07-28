package testcases;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ExcelFileUtility.ExcelUtility;
import JavaUtility.JavaUtility;
import POM.AddProduct;
import POM.HomePage;
import POM.LoginPage;
import PropertiesFileUtility.PropertiesUtility;
import baseClass.BaseClass;
import webDriverUtility.WebDriverUtility;
@Listeners(listenersUtility.ListenersImplementation.class)

public class CreateProductTest extends BaseClass{
	@Test
	public void createProduct()throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		
		ExcelUtility eutil = new ExcelUtility();
		WebDriverUtility wutil= new WebDriverUtility();
		JavaUtility jutil = new JavaUtility();
		String pname = eutil.getDataFromExcel("Product", 1, 2);
		String psize = eutil.getDataFromExcel("Product", 1, 3);
		String pprize = eutil.getDataFromExcel("Product", 1, 4);//4
		
	            HomePage hp = new HomePage(driver);
				hp.getProducts().click();
				Thread.sleep(2000);
				hp.getGetproduct().click();
				Thread.sleep(4000);
				AddProduct ap= new AddProduct(driver);
			
					ap.getProductid();
			    ap.getProductName().sendKeys(pname+jutil.getRandomNumber());
			    ap.getQuantity().clear();
			    ap.getQuantity().sendKeys(psize);
			    ap.getPrice().clear();
			 //   ap.getQuantity().sendKeys(pprize);
			    ap.getPrice().sendKeys(pprize);
			    wutil.select(ap.getProductCategory(),2);
			    wutil.select(ap.getVendorId(), 3);
				ap.getAddprodButton().click();
				Thread.sleep(4000);
				hp.getClosemsg().click();
				
			}

		
}
