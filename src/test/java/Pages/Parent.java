package Pages;

import Utilities.GWD;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Parent {

    public WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(20));

    public void myClick(WebElement element){
        /*
        Bir butona t�klanaca�� zaman yap�lacak i�lemler;
        1- wait element to be clickable
        2- scroll to the element
        3- click
         */

        wait.until(ExpectedConditions.elementToBeClickable(element));
        scrollToElement(element);
        element.click();

    }

    public void mySendKeys(WebElement element, String yazi){
        /*
        Bir textbox'�n sa�l�kl� �al��mas� i�in yap�lacak i�lemler;
        1- wait element to be visible
        2- scroll to the element
        3- clear
        4- sendKeys
         */

        wait.until(ExpectedConditions.visibilityOf(element));
        scrollToElement(element);
        element.clear();
        element.sendKeys(yazi);

    }

    public void scrollToElement (WebElement element){

        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void verifyContainsText(WebElement element, String value){
        SoftAssert _softAssert = new SoftAssert();
        wait.until(ExpectedConditions.textToBePresentInElement(element,value));
        _softAssert.assertTrue(element.getText().toLowerCase().contains(value.toLowerCase()));
        //Program� �al��t�rd���m�zda silmede ��kan mesaj (dialog kutusu) Unable to locate element hatas� olu�turuyor.
        //Actions ile ESC ye basarak ��kan mesaj� kapatarak ��zd�k.
        new Actions(GWD.getDriver()).sendKeys(Keys.ESCAPE).build().perform();
        _softAssert.assertAll();

    }

    public void myJsClick(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        scrollToElement(element);
        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
        js.executeScript("arguments[0].click();", element);
    }

    public void mySelect(WebElement element) {

    }

    public void myMouseover(WebElement element){
        /*
        Bir butona mouseover yap�laca�� zaman yap�lacak i�lemler;
        1- wait element to be visiable
        2- scroll to the element
        3- mouseover
         */

        wait.until(ExpectedConditions.visibilityOf(element));
        scrollToElement(element);
        new Actions(GWD.getDriver()).moveToElement(element).build().perform();

    }
}
