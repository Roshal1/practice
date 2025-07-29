package listenersUtility;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.logging.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import baseClass.BaseClass;

public class listeners1  implements ITestListener, ISuiteListener{

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		ISuiteListener.super.onStart(suite);
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		ISuiteListener.super.onFinish(suite);
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
	String testname = result.getMethod().getMethodName();
	Reporter.log("==="+testname+"Failure",true);
	Date d = new Date();
	String newdate = d.toString().replace(" ", "_").replace(":", "_");
	TakesScreenshot ts = (TakesScreenshot)BaseClass.sdriver;
	File temp = ts.getScreenshotAs(OutputType.FILE);
	File perm = new File("./errorShots/"+testname+""+newdate+".png");
	try {
		org.openqa.selenium.io.FileHandler.copy(temp, perm);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

}
