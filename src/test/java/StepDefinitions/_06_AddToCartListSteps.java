package StepDefinitions;

import Pages.DialogContent;
import Utilities.GWD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _06_AddToCartListSteps {

    DialogContent dc = new DialogContent();

    SoftAssert _softAssert = new SoftAssert();

    public List hoveredDressesList = new ArrayList<>();

    @And("User randomly mouseover three of the products and clicks add to cart button")
    public void userRandomlyMouseoverThreeOfTheProductsAndClicksAddToCartButton() {
        // random �retilen say�lar� bu dizide tutaca��z
        int[] bulunanSayilar = new int[3];

        // dizide olmayan bir say� �retildi�inde bu de�eri 1 art�raca��z
        int uretilenSayiAdeti = 0;

        // 3 tane say� �retilmedi�i s�rece d�ng� �al��s�n
        while (uretilenSayiAdeti < 3) {
            // sayinin dizide olup olmad���n� kontrol etmek i�in
            // varsay�lan bir degisken olu�turduk
            boolean randSayiDizideVarmi = false;

            int randSayi = (int) (Math.random() * dc.summerDressesList.size());

            // bulunanSayilar dizisini d�ng�ye ald�k
            // dizinin elemanlar�n� tek tek �retti�imiz say� ile kar��la�t�r�yoruz
            for (int i = 0; i < 3; i++) {
                // �retti�imiz say� dizideki elemanlardan birine e�itse tekrar say� �retmeliyiz
                if (bulunanSayilar[i] == randSayi) {
                    // rand say� dizide oldu�u i�in varsay�lan de�eri de�i�tirdik
                    randSayiDizideVarmi = true;
                }
            }

            // e�er varsay�lan de�er de�i�mediyse
            // yani �retilen say� dizide yoksa
            // diziye bu say�y� ekledik ve
            // �retilenSayiAdetini 1 art�rd�k
            if (!randSayiDizideVarmi) {
                bulunanSayilar[uretilenSayiAdeti] = randSayi;
                uretilenSayiAdeti++;
            }
        }

        System.out.println(Arrays.toString(bulunanSayilar));


        for (int i = 0; i < bulunanSayilar.length; i++) {
            new Actions(GWD.getDriver()).moveToElement(dc.dressesProductList.get(bulunanSayilar[i])).build().perform();
            String hoveredDress = dc.dressesProductList.get(bulunanSayilar[i]).getText();
            //System.out.println("a= "+hoveredDress);
            hoveredDressesList.add(hoveredDress);
            dc.myJsClick(dc.addToCartButton.get(bulunanSayilar[i]));
            dc.myJsClick(dc.continueShoppingButton);
        }
    }

    @Then("User verifies cart page")
    public void userVerifiesCartPage() {
        dc.verifyContainsText(dc.cartSummaryMessage, "SHOPPING-CART SUMMARY");
    }

    @And("User verifies cart")
    public void userVerifiesCart() {
        for (int i = 0; i < dc.dressesInCart.size(); i++) {
            List<WebElement> dressesInCart = dc.dressesInCart;
            //System.out.println("e= " + dressesInCart.get(i).getText());
            _softAssert.assertTrue(hoveredDressesList.get(i).equals(dressesInCart.get(i).getText()));
            _softAssert.assertAll();
        }
    }

    @And("User verifies product amount in the cart list")
    public void userVerifiesProductAmountInTheCartList() {
        //There are 3 products.
        String message = dc.dressesInCartNumberMessage.getText();
        String[] splittedMessage = message.trim().split(" ");
        int number = Integer.parseInt(splittedMessage[0]);
        _softAssert.assertEquals(number, 3);
        _softAssert.assertAll();
    }
}


