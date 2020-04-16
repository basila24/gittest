package Base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.imageio.ImageIO;
//import io.cucumber.core.api.Scenario;

/**
 * Created by Karthik on 21/09/2019.
 */


public class ExtentReportUtil extends BaseUtil {
	
	

    String fileName = reportLocation + "extentreport.html";
   
    


    public void ExtentReport() {
        //First is to create Extent Reports
        extent = new ExtentReports();

        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setDocumentTitle("Test report for Selenium Basic");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName("Test report");

        extent.attachReporter(htmlReporter);

    }

    public void ExtentReportScreenshot() throws IOException, ClassNotFoundException {

      File scr = ((TakesScreenshot)Driver).getScreenshotAs(OutputType.FILE);
        Files.copy(scr.toPath(), new File(reportLocation +scenarioDef.createNode(new GherkinKeyword("And"), "I enter username and password")+ ".png").toPath());
        scenarioDef.fail("details").addScreenCaptureFromPath(reportLocation + scenarioDef.createNode(new GherkinKeyword("And"), "I enter username and password")+ ".png");
    	
    	
    }


    public void FlushReport(){
        extent.flush();
    }




}
