package StepDefinitions;

import Pages.DialogContent;
import Utilities.GWD;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class _01_RegisterSteps {

    DialogContent dc = new DialogContent();

    SoftAssert _softAssert = new SoftAssert();

    @Given("Navigate to Homepage")
    public void navigate_to_homepage() {
        GWD.getDriver().navigate().to("https://cleverppc.com/prestashop4/");
    }

    @When("Click on the element in the DialogContent")
    public void clickOnTheElementInDialogContent(DataTable buttons) {
        List<String> strButtonsList = buttons.asList(String.class);

        for (int i = 0; i < strButtonsList.size(); i++) {
            WebElement buttonWebElement = dc.getWebElement(strButtonsList.get(i));
            dc.myClick(buttonWebElement);
        }
    }

    @Then("User fails to register and gets invalid email address message")
    public void userFailsToRegisterAndGetsInvalidMessage() {
        dc.verifyContainsText(dc.invalidEmailMessage, "Invalid email address.");
    }

    @And("Enter e-mail {string} and click create an account button")
    public void enter_email_and_create_an_account_button(String email) {
        dc.mySendKeys(dc.registerEmailInput, email);
        dc.myClick(dc.registerCreateButton);
    }

    @Then("User fails to register and gets already message")
    public void user_fails_to_register_and_gets_already_message() {
        dc.verifyContainsText(dc.registerErrorMessage, "already been registered");
    }

    @Then("User should accesses create an account page successfully")
    public void user_should_accesses_create_an_account_page_successfully() {
        dc.verifyContainsText(dc.authentication, "create an account");
    }

    @Then("User gets error message")
    public void userGetsErrorMessage() {
        dc.verifyContainsText(dc.message, "error");
    }

    @Then("User gets account has been created message")
    public void userGetsAccountHasBeenCreatedMessage() {
        dc.verifyContainsText(dc.message, "account has been created");
    }

    @And("User sends the keys into the dialog box")
    public void userSendsTheKeysIntoTheDialogBox(DataTable data) {
        List<List<String>> items = data.asLists(String.class);

        for (int i = 0; i < items.size(); i++) {
            WebElement element = dc.getWebElement(items.get(i).get(0));
            String text = items.get(i).get(1);//Önce 1.elementin texti, daha sonra 2.elementin texti

            dc.mySendKeys(element, text);
        }
    }
}
