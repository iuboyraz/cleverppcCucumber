package StepDefinitions;

import Pages.DialogContent;
import Utilities.GWD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en_scouse.An;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

public class _05_ProductListSteps {

    DialogContent dc = new DialogContent();

    SoftAssert _softAssert = new SoftAssert();

    @Then("User verifies dresses page")
    public void userVerifiesDressesPage() {
        dc.verifyContainsText(dc.txtDresses, "Dresses");
    }

    @And("User verifies product amount in the menu")
    public void userVerifiesProductAmountInTheMenu() {
        //There are 5 products.
        String message = dc.dressesNumberMessage.getText();
        String[] splittedMessage = message.trim().split(" ");
        int number = Integer.parseInt(splittedMessage[2]);
        _softAssert.assertEquals(number,5);
        _softAssert.assertAll();
    }

    @And("User verifies items numbers")
    public void userVerifiesItemsNumbers() {
        //Showing 1 - 5 of 5 items
        String message = dc.dressesCountMessage.getText();
        String[] splittedMessage = message.trim().split(" ");
        int number = Integer.parseInt(splittedMessage[5]);
        _softAssert.assertEquals(number,5);
        _softAssert.assertAll();
    }

    @And("User verifies number of product list of the Dresses menu")
    public void userVerifiesNumberOfProductListOfTheDressesMenu() {
        int productListNumber = dc.dressesProductList.size();

        //There are 5 products.
        String message = dc.dressesNumberMessage.getText();
        String[] splittedMessage = message.trim().split(" ");
        int number = Integer.parseInt(splittedMessage[2]);
        _softAssert.assertEquals(number,productListNumber);

        //Showing 1 - 5 of 5 items
        String message1 = dc.dressesCountMessage.getText();
        String[] splittedMessage1 = message1.trim().split(" ");
        int number1 = Integer.parseInt(splittedMessage1[5]);
        _softAssert.assertEquals(number1,productListNumber);
        _softAssert.assertAll();

    }

}
