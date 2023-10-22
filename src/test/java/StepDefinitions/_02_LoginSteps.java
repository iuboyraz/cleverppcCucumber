package StepDefinitions;

import Pages.DialogContent;
import Utilities.GWD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;

public class _02_LoginSteps {

    DialogContent dc = new DialogContent();

    SoftAssert _softAssert = new SoftAssert();

    @And("Enter e-mail as {string} and password as {string} then click sign in button")
    public void enterEMailAsAndPasswordAsAndClickSignInButton(String email, String password) {
        dc.mySendKeys(dc.eMail, email);
        dc.mySendKeys(dc.password, password);
        dc.myClick(dc.signInButton);
    }

    @Then("User fails to login")
    public void userFailsToLogin() {
        dc.verifyContainsText(dc.message, "error");
    }

    @And("Enter e-mail {string} and password {string} then click sign in button")
    public void enter_email_and_password_then_click_sign_in_button(String email, String password) {

        dc.mySendKeys(dc.eMail,email );
        dc.mySendKeys(dc.password, password);
        dc.myClick(dc.signInButton);
    }

    @Then("User should login successfully")
    public void user_should_login_successfully() {
        dc.verifyContainsText(dc.txtMyAccount, "MY ACCOUNT");
    }


}
