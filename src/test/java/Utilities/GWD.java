package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GWD {
    private static WebDriver driver;

    public static WebDriver getDriver() {

        Logger logger = Logger.getLogger("");
        // output yap�lan loglar� al,
        logger.setLevel(Level.SEVERE);
        // sadece ERRORLARI g�ster. Yani hata seviyesi Y�KSEK olanlar� g�ster.
        // B�ylece chrome vb browser g�ncelleme eksikliklerinin hatalar�n� run k�sm�nda g�stermeyecek.

        // extend report'un t�rk�e bilgisayarlarda �al��mamas� nedeniyle eklendi.
        Locale.setDefault(new Locale("EN"));
        System.setProperty("user.language", "EN");

        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        }
        return driver;
    }

    public static void quitDriver() {
        // test sonucunun ekranda bir miktar beklemesi i�in
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (driver != null) { // driver var ise
            driver.quit();
            driver = null;
        }
    }
}
