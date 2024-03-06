package extentlisteners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentManager {

	private static ExtentReports extent;

	    public static ExtentReports createInstance(String fileName) {
	    	
	    	//ExtentSparkReporter class is  responsible for creating the HTML file and add basic config like theme(dark or light), doc title, report name
	        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(fileName);
	       	        
	        htmlReporter.config().setTheme(Theme.STANDARD);
	        htmlReporter.config().setDocumentTitle(fileName);
	        //This is for the html file
	        htmlReporter.config().setEncoding("utf-8");
	        htmlReporter.config().setReportName(fileName);
	        
	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	        extent.setSystemInfo("Automation Tester", "Rima Das");
	        extent.setSystemInfo("Organization", "Way2Automation");
	        extent.setSystemInfo("Build no", "W2A-1234");
	        
	        
	        return extent;
	    }

	 

	}
