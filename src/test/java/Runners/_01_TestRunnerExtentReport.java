package Runners;

import com.aventstack.extentreports.service.ExtentService;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;

@CucumberOptions(

        tags = "@Regression",
        features = {"src/test/java/FeatureFiles"},
        glue = {"StepDefinitions"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)

public class _01_TestRunnerExtentReport extends AbstractTestNGCucumberTests {
// extent report'a ek bilgiler eklemek i�in a�a��daki kod sat�r� eklendi.
//Ornek:Test Reports/TestReport 21-Eyl-23 21.49.33/test-output/SparkReport/Spark.html dosyas� tiklanarak rapor g�r�lebilir.

    @AfterClass
    public static void writeExtentReport(){
        ExtentService.getInstance().setSystemInfo("Windows User Name",System.getProperty("user.name")); // username : Umit Boyraz
        ExtentService.getInstance().setSystemInfo("Time Zone", System.getProperty("user.timezone"));
        ExtentService.getInstance().setSystemInfo("User Name", "Umit Boyraz");
        ExtentService.getInstance().setSystemInfo("Application Name", "cleverpppc.com");
        ExtentService.getInstance().setSystemInfo("Operating System Info", System.getProperty("os.name"));
        ExtentService.getInstance().setSystemInfo("Department", "QA");
        ExtentService.getInstance().setSystemInfo("Ek Sat�r", "Aciklama");
        ExtentService.getInstance().setSystemInfo("Ek Sat�r", "Aciklama");
        ExtentService.getInstance().setSystemInfo("Ek Sat�r", "Aciklama");
        ExtentService.getInstance().setSystemInfo("Ek Sat�r", "Aciklama");
    }
}
