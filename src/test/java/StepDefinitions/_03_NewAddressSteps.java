package StepDefinitions;

import Pages.DialogContent;
import Utilities.GWD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class _03_NewAddressSteps {

    DialogContent dc = new DialogContent();

    SoftAssert _softAssert = new SoftAssert();

    @Then("User should verify add a new address message")
    public void userShouldVerifyAddAnewAddressesMessage() {
        dc.verifyContainsText(dc.addAnewAddressMessage, "Add a new address");
    }

    @Then("User should verify fill out form message")
    public void userShouldVerifyFillOutFormMessage() {
        dc.verifyContainsText(dc.fillOutFormMessage, "please fill out the form below.");
    }

    @Then("User gets address error message")
    public void userGetsAddressErrorMessage() {
        dc.verifyContainsText(dc.addressErrorMessage, "error");
    }

    @And("Select state for address in the DialogContent")
    public void selectStateForAddressInTheDialogContent() {
        Select state = new Select(dc.state);
        state.selectByIndex(1);
    }
}
