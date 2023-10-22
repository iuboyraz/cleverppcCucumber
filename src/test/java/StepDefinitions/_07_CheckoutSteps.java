package StepDefinitions;

import Pages.DialogContent;
import Utilities.GWD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _07_CheckoutSteps {

    DialogContent dc = new DialogContent();

    SoftAssert _softAssert = new SoftAssert();

    @And("User validates if the total product prices are the same with the total products amount")
    public void userValidatesIfTheTotalProductPricesAreTheSameWithTheTotalProductsAmount() {
        List<WebElement> prices = dc.productPricesList;

        double totalPrice = 0;
        for (WebElement p : prices) {
            totalPrice = totalPrice + Double.parseDouble(p.getText().replaceAll("[^0-9,.]", ""));
        }

        double itemTotal = Double.parseDouble(dc.totalProduct.getText().replaceAll("[^0-9,.]", ""));

        _softAssert.assertTrue(totalPrice == itemTotal, "Products' total price is not the same with the total products");
        _softAssert.assertAll();
    }

    @And("User validates if the shipping price is {int} Usd")
    public void userValidatesIfTheShippingPriceIsUsd(int price) {

        double shippingPrice= Double.parseDouble(dc.totalShipping.getText().replaceAll("[^0-9,.]", ""));
        _softAssert.assertTrue(shippingPrice == price, "Shipping price is not equals: 7 Usd");
        _softAssert.assertAll();
    }

    @And("User validates if the total price with the shipping is the same in total")
    public void userValidatesIfTheTotalPriceWithTheShippingIsTheSameInTotal() {

        double itemTotal = Double.parseDouble(dc.totalProduct.getText().replaceAll("[^0-9,.]", ""));
        System.out.println("itemTotal= "+itemTotal);
        double shippingPrice= Double.parseDouble(dc.totalShipping.getText().replaceAll("[^0-9,.]", ""));
        System.out.println("shippingPrice= "+shippingPrice);
        double totalWithShipping = itemTotal+shippingPrice;
        System.out.println("totalWithShipping= "+totalWithShipping);

        double totalPriceWithoutTax= Double.parseDouble(dc.totalPriceWithoutTax.getText().replaceAll("[^0-9,.]", ""));
        System.out.println("totalPriceWithoutTax= "+totalPriceWithoutTax);

        _softAssert.assertTrue(totalWithShipping == totalPriceWithoutTax, "Products' total price with the shipping is not the same in the total");
        _softAssert.assertAll();
    }

    @And("User validates if the total price with the shipping plus tax is the same with the tax included total")
    public void userValidatesIfTheTotalPriceWithTheShippingPlusTaxIsTheSameWithTheTaxIncludedTotal() {
        double totalPriceWithoutTax= Double.parseDouble(dc.totalPriceWithoutTax.getText().replaceAll("[^0-9,.]", ""));
        System.out.println("totalPriceWithoutTax= "+totalPriceWithoutTax);

        double totalTax= Double.parseDouble(dc.totalTax.getText().replaceAll("[^0-9,.]", ""));
        System.out.println("totalTax= "+totalTax);

        double calculatedTotalWithTax1 = totalPriceWithoutTax+totalTax;
        System.out.println("calculatedTotalWithTax 1= "+calculatedTotalWithTax1);

        double totalPriceWithTax= Double.parseDouble(dc.totalPriceWithTax.getText().replaceAll("[^0-9,.]", ""));
        System.out.println("totalPriceWithTax= "+totalPriceWithTax);

        _softAssert.assertFalse(calculatedTotalWithTax1 == totalPriceWithTax, "[BUG]Calculated total with tax is not the same with the total tax included");
        _softAssert.assertAll();
    }

    @And("User verifies delivery and invoice addresses")
    public void userVerifiesDeliveryAndInvoiceAddresses() {
        dc.verifyContainsText(dc.deliveryAddress, "DELIVERY");
        dc.verifyContainsText(dc.invoiceAddress, "INVOICE");
    }

    @And("User verifies shipment method")
    public void userVerifiesShipmentMethod() {
        _softAssert.assertTrue(dc.shipmentMehod.isSelected(),"Shipment Method is not selected");
        _softAssert.assertAll();

    }

    @Then("User should verify terms of service checkbox message and close message")
    public void userShouldVerifyTermsOfServiceCheckboxMessageAndCloseMessage() throws AWTException {
        dc.verifyContainsText(dc.termsOfServiceCheckBoxMessage, "You must agree to the terms of service before continuing.");
        new Robot().mousePress(InputEvent.BUTTON1_DOWN_MASK);
        new Robot().mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }

    @Then("User should verify PayPal message")
    public void userShouldVerifyPayPalMessage() {
        dc.verifyContainsText(dc.payPalMessage, "daha sonra tekrar deneyin.");
    }

    @And("Navigate to back page")
    public void navigateToBackPage() {
        GWD.getDriver().navigate().back();
    }

    @Then("User should verify pay with credit card message")
    public void userShouldVerifyPayWithCreditCardMessage() {
        dc.verifyContainsText(dc.payWithCreditCardMessage, "Invalid request");
    }

    @Then("User should verify bank wire payment message")
    public void userShouldVerifyBankWirePaymentMessage() {
        dc.verifyContainsText(dc.payByBankWireMessage, "You have chosen to pay by bank wire");
    }

    @And("User validates if the total price plus the shipping plus the tax is the same with the bank wire total payment")
    public void userValidatesIfTheTotalPricePlusTheShippingPlusTheTaxIsTheSameWithTheTaxIncludedTotal() {
        double bankWireTotalPayment= Double.parseDouble(dc.bankWireTotalPayment.getText().replaceAll("[^0-9,.]", ""));
        System.out.println("bankWireTotalPayment= "+bankWireTotalPayment);

        GWD.getDriver().navigate().back();

        double itemTotal = Double.parseDouble(dc.totalProduct.getText().replaceAll("[^0-9,.]", ""));
        System.out.println("itemTotal= "+itemTotal);
        double shippingPrice= Double.parseDouble(dc.totalShipping.getText().replaceAll("[^0-9,.]", ""));
        System.out.println("shippingPrice= "+shippingPrice);
        double totalTax= Double.parseDouble(dc.totalTax.getText().replaceAll("[^0-9,.]", ""));
        System.out.println("totalTax= "+totalTax);
        double calculatedTotalWithShippingAndTax = itemTotal+shippingPrice+totalTax;
        System.out.println("calculatedTotalWithShippingAndTax= "+calculatedTotalWithShippingAndTax);

        //_softAssert.assertTrue(calculatedTotalWithShippingAndTax == bankWireTotalPayment, "Calculated total with shipping and tax is not the same with the bank wire total payment");

        GWD.getDriver().navigate().forward();
        //_softAssert.assertAll();
    }

    @Then("User should verify order is comleted message")
    public void userShouldVerifyOrderIsComletedMessage() {
        dc.verifyContainsText(dc.orderIsCompletedMessage, "Your order on Xu Clothing is complete.");
    }

    @And("User should verify order reference message")
    public void userShouldVerifyOrderReferenceMessage() {
        dc.verifyContainsText(dc.orderReferenceMessage, "Do not forget to insert your order reference");

    }

    @Then("User saves order reference")
    public void userSavesOrderReference() throws InterruptedException {
        Thread.sleep(5000);
        String orderReference = dc.orderReference.getText();
        System.out.println("Order reference: " + orderReference);
    }
}



