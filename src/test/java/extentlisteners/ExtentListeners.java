package extentlisteners;

import java.util.Arrays;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;


public class ExtentListeners implements ITestListener {

	static Date d = new Date();
	static String fileName = "Extent_" + d.toString().replace(":", "_").replace(" ", "_") + ".html";
	

	//ExtentReports class is going to attach all the configuration that we need to provide eg who is the tester, build name etc
	private static ExtentReports extent = ExtentManager.createInstance("/Users/rimadas/eclipse-workspace/SeleniumDataDrivenFramework/target/reports/" +fileName);
	
	//ExtentTest class will be responsible to generate logs for the testcases
	public static ExtentTest test;


	public void onTestStart(ITestResult result) 
	{
				
		test = extent.createTest(result.getTestClass().getName()+"     @TestCase : "+result.getMethod().getMethodName());     
	}

	public void onTestSuccess(ITestResult result) 
	{
		
		String methodName=result.getMethod().getMethodName();
		String logText="<b>"+"TEST CASE:- "+ methodName.toUpperCase()+ " PASSED"+"</b>";		
		Markup m=MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		test.pass(m);	

	}

	public void onTestFailure(ITestResult result) 
	{
		String exceptionMessage=Arrays.toString(result.getThrowable().getStackTrace());
		test.fail(exceptionMessage);
		
		String methodName=result.getMethod().getMethodName();
		String logText="<b>"+"TEST CASE:- "+ methodName.toUpperCase()+ " FAILED"+"</b>";	
		
		test.fail("<b><font color=red>" + "Exception Occured:Click to see" + "</font></b>" + "</summary>" + exceptionMessage.replaceAll(",", "<br>")+"</details>"+" \n");
			
		String failureLog="TEST CASE FAILED";
		Markup m = MarkupHelper.createLabel(failureLog, ExtentColor.RED);
		test.log(Status.FAIL, m);

		

	}

	public void onTestSkipped(ITestResult result) 
	{
		String methodName=result.getMethod().getMethodName();
		String logText="<b>"+"Test Case:- "+ methodName+ " Skipped"+"</b>";		
		Markup m=MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		test.skip(m);


	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) 
	{

		

	}

	public void onFinish(ITestContext context) {

		if (extent != null) {

			extent.flush();
		}

	}

}
