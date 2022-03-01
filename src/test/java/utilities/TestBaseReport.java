package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBaseReport {
   protected static ExtentReports extentReports;
   protected static ExtentTest extentTest;
   protected static ExtentHtmlReporter extentHtmlReporter;

   @BeforeTest(alwaysRun = true)
    public void setUpTest(){
       extentReports = new ExtentReports();

       String filepath= System.getProperty("user.dir") + "/reports/Reports.html";
       extentHtmlReporter = new ExtentHtmlReporter(filepath);
       extentReports.attachReporter(extentHtmlReporter);

       extentReports.setSystemInfo("Enviroment","QA");
       extentReports.setSystemInfo("Browser", ConfigurationReader.getProperty("browser")); // chrome, firefox
       extentReports.setSystemInfo("Automation Engineer", "İlknur");
       extentHtmlReporter.config().setDocumentTitle("AmazonPage test");
       extentHtmlReporter.config().setReportName("AmazonPage test");

   }

   @AfterTest(alwaysRun = true)
   public void tearDown (){
       extentReports.flush();
   }

}
