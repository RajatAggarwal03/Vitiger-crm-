package extra;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class AdvanceReports {

    @Test
    public void generateAdReport() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss");
        String time = now.format(dtf);

        ExtentSparkReporter spark = new ExtentSparkReporter("D:\\Rajat\\vtiger-crm-framework-m16\\AdvanceReports\\" + time + ".html");
        spark.config().setDocumentTitle("vtiger-crm-automation-framework");
        spark.config().setReportName("Beginning");
        spark.config().setTheme(Theme.DARK);

        ExtentReports reports = new ExtentReports();
        reports.attachReporter(spark);
        reports.setSystemInfo("O.S.", "Windows");
        reports.setSystemInfo("VersionOS", "11");
        reports.setSystemInfo("Browser", "Chrome");

        ExtentTest test = reports.createTest("generateAdReport");
        test.log(Status.INFO, "This is info...");
        test.log(Status.SKIP, "This is skip...");
        test.log(Status.WARNING, "This is warning...");
        test.log(Status.PASS, "This is passed...");
        test.log(Status.FAIL, "This is failed...");
        
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        TakesScreenshot tks = (TakesScreenshot) driver;
        String ss = tks.getScreenshotAs(OutputType.BASE64);
        
        test.addScreenCaptureFromBase64String(ss);
    
        driver.close();
        reports.flush();
    }
}
    

   

        

       
    

