package StepDefinitions;

import Utilities.GWD;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before // cucumber'in annotation'i
    public void before() {
        // System.out.println("Senaryo ba�lad� m�?");
    }

    @After
    public void after(Scenario scenario) {

        // runner dosyas�nda "plugin" varsa a�a��daki kod blok A�IK kals�n.
        // �r: _06_TestRunnerSmokeWithPlugin ve _07_TestRunnerExtentReport
        // di�er classlarda KAPALI kals�n. ��nk� plugin olmayaca�� i�in senaryoyu bulamaz ve hata verir.

        // extend report'a screenshot eklemek i�in bu if blok yaz�ld�.
        if (scenario.isFailed()) {
            TakesScreenshot ts = ((TakesScreenshot) GWD.getDriver());
            byte[] inMemory = ts.getScreenshotAs(OutputType.BYTES); // Ba�ka bir dosyaya ekleyebilmek i�in tip byte se�ildi.
            //https://www.programsbuzz.com/article/how-add-screenshot-cucumber-extent-report-every-step den ald�k.
            // GenericFunctions.getByteScreenshot() -> inMemory ile de�i�tirildi.
            scenario.attach(inMemory, "image/png", "screenshot name");
        }
        // System.out.println("Senaryo bitti mi?");
        // do�ru �al���rsa quitDriver()'� �a��raca��z.
        GWD.quitDriver(); // driver'� kapatt�k.
    }
}
