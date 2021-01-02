package extent_learning.basic;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.apache.commons.io.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManage {
	private static ExtentReports extent;
	public static String screenshotName;
	public static WebDriver driver;
	
	public static ExtentReports createInstance (String fileName) {
		ExtentSparkReporter htmlReporter= new ExtentSparkReporter(fileName);
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setDocumentTitle("Automation Report");
		   htmlReporter.config().setEncoding("utf-8");
	        htmlReporter.config().setReportName(fileName);
	        
	    extent=new ExtentReports();
	    extent.attachReporter(htmlReporter);
	    extent.setSystemInfo("Automation Tester", "Shivani Bharti");
    
	return extent;
		
		
		
	}

	public static void attachScreenShot() {
		
		File srcFile= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Date d=new Date();
		screenshotName=d.toString().replace(":", "_").replace(" ", "_")+".jpg";
		try {
			FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir")+"\\target"+screenshotName));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
}

