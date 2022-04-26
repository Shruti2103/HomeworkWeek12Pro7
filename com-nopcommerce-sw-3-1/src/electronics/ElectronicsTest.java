package electronics;

import com.google.common.base.Verify;
import javafx.scene.control.Tab;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Mouse;
import utilities.Utility;

public class ElectronicsTest extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);

    }

    @After
    public void tearDown() {
        closeBrowser();
    }

    @Test

    public void textvarrified() {
        //Mouse Hover on “Electronics” Tab

        mouseHooverToElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]"));// electronics

        //Mouse Hover on “Cell phones” and click
        mouseHooverToElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));// cell phone

        //Verify the text “Cell phones
        String expectedcellPhoneText = "Cell phones";
        String actualcellPhoneText = getTextFromElement(By.xpath("//h1[contains(text(),'Cell phones')]"));

        Assert.assertEquals("Customer is not on CellPhone Page", expectedcellPhoneText, actualcellPhoneText);
    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws Exception {
        //Mouse Hover on “Electronics”Tab
        mouseHooverToElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]"));//Electronics

        //Mouse Hover on “Cell phones” and click
        mouseHooverToElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));

        //Verify the text “Cell phones
        String expectedcellPhoneText = "Cell phones";
        String actualcellPhoneText = getTextFromElement(By.xpath("//h1[contains(text(),'Cell phones')]"));
        Assert.assertEquals("Customer is not on CellPhone Page", expectedcellPhoneText, actualcellPhoneText);

        // Click on List View Tab

        clickOnElement(By.xpath("//a[@class='viewmode-icon grid selected']"));

        // Click on product name “Nokia Lumia 1020” link
        clickOnElement(By.xpath("//h2[@class='product-title']//a[contains(text(),'Nokia Lumia 1020')]"));

        //Verify the text “Nokia Lumia 1020”
        String epectedName = "Nokia Lumia 1020";
        String actualName = getTextFromElement(By.xpath("//h2[@class='product-title']//a[contains(text(),'Nokia Lumia 1020')]"));
        Assert.assertEquals("User cant be on Nokia Lumbia 1020", epectedName, actualName);

        //Verify the price “$349.00”
        String expectedPrice = "349.00";
        String actualPrice = getTextFromElement(By.xpath("//span[@class='price-value-20']"));
        Assert.assertEquals("Price is not $349.00", expectedPrice, actualPrice);

        //Change quantity to 2

        sendTextToElement(By.id("//input[@value='2']"), "2");


        // Click on Add to cart
        clickOnElement(By.xpath("//button[@class='button-1 add-to-cart-button']"));// cart click

        //2.10  Verify the Message "The product has been added to your shopping cart" on Top green Bar
        String expectedMessage = "The product has been added to your shopping cart";
        String actualMessage = getTextFromElement(By.xpath("//p[@class='content']"));
        Assert.assertEquals("The Product has not been added to Shopping cart", expectedMessage, actualMessage);


        // close currunt tab
        clickOnElement(By.xpath("//p[@class='content']"));

        //2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button
        mouseHooverToElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        clickOnElement(By.xpath("//button[@class='button-1 cart-button']"));


        //click on shopping cart
        clickOnElement(By.xpath("//span[@class='cart-label']"));

        //2.12  Varify the message Shopping cart
        String expecteddisplayMessage = "Shopping cart";
        String actualdisplayMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals("User is not on Shopping page", expecteddisplayMessage, actualdisplayMessage);

        //2.13 Verify the quantity is 2
        String expectedqty = "2";
        String actualqty = getTextFromElement(By.xpath("//input[@name='itemquantity11222']"));
        Assert.assertEquals("Quantity is not 2", expectedqty, actualqty);

        // Verify the Total $698.00
        String expectedTotal = "$698.00";
        String actualTotal = getTextFromElement(By.xpath("//tr[@class='order-total']"));
        Assert.assertEquals("Total is not matching", expectedTotal, actualTotal);

        // 2.15 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@name='termsofservice']"));

        // 2.16 Click on checkout
        clickOnElement(By.xpath("//button[@class='button-1 checkout-button']"));

        //“2.17 Verify the Text “Welcome, Please Sign In!

        String expectedText = "Welcome, Please Sign In!";
        String actualText = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        Assert.assertEquals("Welcome Sign page is not display", expectedMessage, actualMessage);

        // 2.18 Click on Register tab
        clickOnElement(By.xpath("//a[contains(text(),'Register')]"));
        // 2.19 Verify the text “Register”
        String expectedRegister = "Register";
        String actualRegister = getTextFromElement(By.xpath("//a[contains(text(),'Register')]"));
        Assert.assertEquals("User is not in Registration page", expectedRegister, actualRegister);

        // 2.20 Fill the mandatory fields
        sendTextToElement(By.xpath("//input[@id='FirstName']"), "project1");
        sendTextToElement(By.id("LastName"), "test");
        sendTextToElement(By.id("Email"), "proj12@yahoo.com");
        sendTextToElement(By.id("Password"), "Abc123456");
        sendTextToElement(By.id("ConfirmPassword"), "Abc123456");

        // 2.21 Click on “REGISTER” Button
        clickOnElement(By.id("register-button"));
        //2.22 Verify the message “Your registration completed”
        String registrationdone = "Your registration completed";
        String actualregistrationDone = getTextFromElement(By.xpath("//div[text()='Your registration completed']"));
        Assert.assertEquals("Registration Is Not Completed", registrationdone, actualregistrationDone);

        // 2.23 Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[@class='button-1 register-continue-button']"));

        // 2.24 Verify the text “Shopping cart”
        String expectedCart = "Shopping cart";
        String actualcart = getTextFromElement(By.xpath("//h1[text()='Shopping cart']"));
        Assert.assertEquals("User is not in cart", expectedCart, actualcart);

        //        2.25 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("termsofservice"));

        // 2.26 Click on “CHECKOUT”
        clickOnElement(By.id("checkout"));

        // 2.27 Fill the Mandatory fields
        selectByValueFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "India");
        selectByValueFromDropDown(By.xpath("//select[@id='BillingNewAddress_StateProvinceId']"), "Others");
        selectByValueFromDropDown(By.xpath("//input[@id='BillingNewAddress_City']"), "Ahmedabad");
        sendTextToElement(By.id("BillingNewAddress_Address1"), "3,Wall Street");
        selectByValueFromDropDown(By.id("BillingNewAddress_ZipPostalCode"), "la1 2fh");
        selectByValueFromDropDown(By.id("BillingNewAddress_PhoneNumber"), "07754512");

//        2.28 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));

//        2.29 Click on Radio Button “2nd Day Air ($0.00)”
        clickOnElement(By.xpath("//button[@onclick='ShippingMethod.save()']"));
        clickOnElement(By.xpath("//input[@id='shippingoption_1']"));

//        2.30 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));

//        2.31 Select Radio Button “Credit Card”
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));

//        2.32 Select “Visa” From Select credit card dropdown
        selectByValueFromDropDown(By.id("CreditCardType"), "visa");

//        2.33 Fill all the details
        sendTextToElement(By.id("CardholderName"), "Ms.Jonas");
        selectByValueFromDropDown(By.id("CardNumber"), "5555555555554444");
        selectByValueFromDropDown(By.id("ExpireYear"), "202");
        sendTextToElement(By.id("CardCode"), "449");
        Thread.sleep(1000);

        //  2.34 Click on “CONTINUE”CHECKOUT”
        clickOnElement(By.xpath("//button[@onclick='PaymentInfo.save()']"));

        //Verify “Payment Method” is “Credit Card”
        String expectedpaymentCard = "Payment Method: Credit Card";
        String actualPaymentCard = getTextFromElement(By.xpath("//li[@class='payment-method']"));
        Assert.assertEquals("Shipping method is Incorrect", expectedpaymentCard, actualPaymentCard);

        //Verify “Shipping Method” is “2nd Day Air”
        String shippingexpected = "Shipping Method: 2nd Day Air";
        String shippingActual = getTextFromElement(By.xpath("//li[@class='shipping-method']"));

//        Verify Total is “$698.00”
        String totalOrder = "Total: $698.00";
        String actualTotalOrder = getTextFromElement(By.xpath("//tr[@class='order-total']"));
        Assert.assertEquals("Total order is wrong", totalOrder, actualTotalOrder);

//        2.38 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[@onclick='ConfirmOrder.save()']"));

//        2.39 Verify the Text “Thank You”
        String Thanks = "Thank you";
        String actualThanks = getTextFromElement(By.xpath("//h1[text()='Thank you']"));
        Assert.assertEquals("Thank you is not displayed ", Thanks, actualThanks);

//        2.40 Verify the message “Your order has been successfully processed!”
        String expectedProd = "Your order has been successfully processed!";
        String actualProd = getTextFromElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        Assert.assertEquals("Oeder is not confirmed", expectedProd, actualProd);

//        2.41 Click on “CONTINUE”
        clickOnElement(By.xpath("//a[@class='ico-logout']"));

//        2.42 Verify the text “Welcome to our store”
        String welcomeMsg = "Welcome to our store";
        String actualWelcome = getTextFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]"));
        Assert.assertEquals("User Is Not On Home Page", welcomeMsg, actualWelcome);

//        2.43 Click on “Logout” link

//        2.44 Verify the URL is “https://demo.nopcommerce.com
        String url = "https://demo.nopcommerce.com/";
        String actuallUrl = driver.getCurrentUrl();
        Assert.assertEquals("Wrong Url", url, actuallUrl);


    }


}


















