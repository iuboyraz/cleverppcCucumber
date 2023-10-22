package Pages;

import Utilities.GWD;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class DialogContent extends Parent{
    public DialogContent(){
        PageFactory.initElements(GWD.getDriver(),this);
        // Kullanýlacaðý zaman bu sayfadaki locatorlarý driver üzerinden initialize eder.
    }
    // Register Locators
    @FindBy (xpath="//*[@title='Log in to your customer account']")
    public WebElement homepageSignInButton;

    @FindBy (xpath="//*[@id='email_create']")
    public WebElement registerEmailInput;

    @FindBy (xpath="//*[@id='SubmitCreate']")
    public WebElement registerCreateButton;

    @FindBy (xpath="//*[text()='Invalid email address.']")
    public WebElement invalidEmailMessage;

    @FindBy (xpath="//*[@id='create_account_error']//li")
    public WebElement registerErrorMessage;

    @FindBy (xpath="//*[@id='noSlide']/h1")
    public WebElement authentication;

    @FindBy (xpath="//*[@id='submitAccount']")
    public WebElement registerButton;

    @FindBy (xpath="//*[@id='customer_firstname']")
    public WebElement firstnameInput;

    @FindBy (xpath="//*[@id='customer_lastname']")
    public WebElement lastnameInput;

    @FindBy (xpath="//*[@id='passwd']")
    public WebElement registerPassword;

    // Login Locators
    @FindBy (xpath="//*[@id='email']")
    public WebElement eMail;

    @FindBy (xpath="//*[@id='passwd']")
    public WebElement password;

    @FindBy (xpath="//*[@id='SubmitLogin']")
    public WebElement signInButton;

    @FindBy (xpath="(//*[@id='center_column']//p)[1]")
    public WebElement message;

    @FindBy (xpath="//*[@id='center_column']/h1")
    public WebElement txtMyAccount;

    //New address locators

    @FindBy (xpath="//*[@title='Sitemap']")
    public WebElement siteMap;

    @FindBy (xpath="//*[@title='View a list of my addresses']")
    public WebElement addresses;

    @FindBy (xpath="//*[@id='center_column']//a")
    public WebElement addAnewAddressMessage;

    @FindBy (xpath="//*[@title='Add an address']")
    public WebElement addAnewAddressButton;

    @FindBy (xpath="//*[@id='center_column']//p")
    public WebElement fillOutFormMessage;

    @FindBy (xpath="//*[@id='submitAddress']")
    public WebElement addressSaveButton;

    @FindBy (xpath="(//*[@id='center_column']//p)[2]")
    public WebElement addressErrorMessage;

    @FindBy (xpath="//*[@id='address1']")
    public WebElement address1Input;

    @FindBy (xpath="//*[@id='city']")
    public WebElement city;

    @FindBy (xpath="//*[@id='id_state']")
    public WebElement state;

    @FindBy (xpath="//*[@id='postcode']")
    public WebElement postcode;

    @FindBy (xpath="//*[@id='phone_mobile']")
    public WebElement phone_mobile;

    //AddToCart Locators

    @FindBy (xpath="(//*[@title='Women'])[1]")
    public WebElement womenButton;

    @FindBy (xpath="(//*[@id='categories_block_left']//a)[4]")
    public WebElement dressesbutton;

    @FindBy (xpath="(//*[@id='categories_block_left']//li)[3]/a")
    public WebElement summerDressesButton;

    @FindBy (xpath="(//*[@id='center_column']//span)[1]")
    public WebElement txtSummerDresses;

    @FindBy (xpath="//*[@class='replace-2x img-responsive']")
    public List<WebElement> summerDressesList;

    @FindBy (xpath="//*[@title='Add to cart']")
    public List<WebElement> addToCartButton;

    @FindBy (xpath="(//*[@id='layer_cart']//span)[2]")
    public WebElement addedToCartMessage;

    //ProductList Locators

    @FindBy (xpath="(//*[@id='block_top_menu']//a)[9]")
    public WebElement dressesButton1;

    @FindBy (xpath="(//*[@id='center_column']//span)[1]")
    public WebElement txtDresses;

    @FindBy (xpath="(//*[@id='center_column']//span)[3]")
    public WebElement dressesNumberMessage;

    @FindBy (xpath="(//*[@class='product-count'])[1]")
    public WebElement dressesCountMessage;

    @FindBy (xpath="//*[@itemprop='name']/a")
    public List<WebElement> dressesProductList;

    //AddToCartList Locators

    @FindBy (xpath="//*[@title='Continue shopping']")
    public WebElement continueShoppingButton;

    @FindBy (xpath="//*[@title='View my shopping cart']")
    public WebElement cartButton;

    @FindBy (xpath="//*[@id='cart_title']")
    public WebElement cartSummaryMessage;

    @FindBy (xpath="//*[@class='cart_description']//p/a")
    public List<WebElement> dressesInCart;

    @FindBy (xpath="//*[@id='summary_products_quantity']")
    public WebElement dressesInCartNumberMessage;

    //Checkout Locators

    @FindBy (xpath="//*[@data-title='Total']/span")
    public List<WebElement> productPricesList;

    @FindBy (xpath="//*[@id='total_product']")
    public WebElement totalProduct;

    @FindBy (xpath="//*[@id='total_shipping']")
    public WebElement totalShipping;

    @FindBy (xpath="(//*[@id='total_price_without_tax'])[1]")
    public WebElement totalPriceWithoutTax;

    @FindBy (xpath="//*[@id='total_tax']")
    public WebElement totalTax;

    @FindBy (xpath="(//*[@id='total_price_without_tax'])[2]")
    public WebElement totalPriceWithTax;

    @FindBy (xpath="(//*[@class='page-subheading'])[1]")
    public WebElement deliveryAddress;

    @FindBy (xpath="(//*[@class='page-subheading'])[2]")
    public WebElement invoiceAddress;

    @FindBy (xpath="(//*[@class='cart_navigation clearfix']/a)[1]")
    public WebElement checkoutButton1;

    @FindBy (xpath="//*[@name='processAddress']")
    public WebElement checkoutButton2;

    @FindBy (xpath="//*[@id='delivery_option_155_0']")
    public WebElement shipmentMehod;

    @FindBy (xpath="//*[@name='processCarrier']")
    public WebElement checkoutButton3;

    @FindBy (xpath="//*[@for='cgv']")
    public WebElement termsOfServiceCheckBox;

    @FindBy (xpath="//*[@class='fancybox-error']")
    public WebElement termsOfServiceCheckBoxMessage;

    @FindBy (xpath="//*[@id='paypal-standard-btn']")
    public WebElement payPal;

    @FindBy (xpath="//*[@class='message']")
    public WebElement payPalMessage;

    @FindBy (xpath="//*[@id='ccBillForm']//a")
    public WebElement payWithCreditCard;

    @FindBy (xpath="//*[text()='Invalid request (1).']")
    public WebElement payWithCreditCardMessage;

    @FindBy (xpath="//*[@title='Pay by bank wire']")
    public WebElement payByBankWire;

    @FindBy (xpath="(//*[@class='dark'])[6]")
    public WebElement payByBankWireMessage;

    @FindBy (xpath="//*[@id='amount']")
    public WebElement bankWireTotalPayment;

    @FindBy (xpath="(//*[@type='submit'])[2]")
    public WebElement confirmMyOrderButton;

    @FindBy (xpath="(//*[@id='center_column']//p)[1]")
    public WebElement orderIsCompletedMessage;

    @FindBy (xpath="//*[@class='box']")
    public WebElement orderReferenceMessage;

    @FindBy (xpath="//*[@class='cart_navigation exclusive']//a")
    public WebElement viewYourOrderHistoryButton;

    @FindBy (xpath="//*[@class='color-myaccount']")
    public WebElement orderReference;

    //Contact Us Locators

    @FindBy (xpath="//*[@id='contact-link']")
    public WebElement contactUsButton;

    @FindBy (xpath="//*[@id='center_column']/h1")
    public WebElement contactUsMessage;

    @FindBy (xpath="//*[@id='id_contact']")
    public WebElement subjectHeadingButton;

    @FindBy (xpath="//*[@id='email']")
    public WebElement emailInput;

    @FindBy (xpath="//*[@id='id_order']")
    public WebElement orderReferenceInput;

    @FindBy (xpath="//*[@id='uniform-fileUpload']")
    public WebElement chooseFileButton;

    @FindBy (xpath="//*[@id='message']")
    public WebElement messageTextArea;

    @FindBy (xpath="//*[@id='submitMessage']")
    public WebElement sendButton;

    @FindBy (xpath="//*[@id='center_column']/p")
    public WebElement contactUsSuccessMessage;

     public WebElement getWebElement(String strElement){
        switch (strElement){
            case "homepageSignInButton": return this.homepageSignInButton;
            case "registerCreateButton": return this.registerCreateButton;
            case "registerButton": return this.registerButton;
            case "firstnameInput": return this.firstnameInput;
            case "lastnameInput": return this.lastnameInput;
            case "registerPassword": return this.registerPassword;
            case "siteMap": return this.siteMap;
            case "addresses": return this.addresses;
            case "addAnewAddressButton": return this.addAnewAddressButton;
            case "addressSaveButton": return this.addressSaveButton;
            case "address1Input": return this.address1Input;
            case "city": return this.city;
            case "postcode": return this.postcode;
            case "phone_mobile": return this.phone_mobile;
            case "womenButton": return this.womenButton;
            case "dressesbutton": return this.dressesbutton;
            case "summerDressesButton": return this.summerDressesButton;
            case "dressesButton1": return this.dressesButton1;
            case "cartButton": return this.cartButton;
            case "checkoutButton1": return this.checkoutButton1;
            case "checkoutButton2": return this.checkoutButton2;
            case "termsOfServiceCheckBox": return this.termsOfServiceCheckBox;
            case "checkoutButton3": return this.checkoutButton3;
            case "payPal": return this.payPal;
            case "payWithCreditCard": return this.payWithCreditCard;
            case "payByBankWire": return this.payByBankWire;
            case "confirmMyOrderButton": return this.confirmMyOrderButton;
            case "viewYourOrderHistoryButton": return this.viewYourOrderHistoryButton;
            case "contactUsButton": return this.contactUsButton;
            case "subjectHeadingButton": return this.subjectHeadingButton;
            case "chooseFileButton": return this.chooseFileButton;
            case "sendButton": return this.sendButton;
        }
        return null;
    }
}
