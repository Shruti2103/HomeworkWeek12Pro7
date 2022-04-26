package computer;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;

import java.util.List;

public class TestSuite extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @After
    public void tearDown() {

    }

    public void testName() {
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Computers')]"));
        clickOnElement(By.xpath("//div[@class='sub-category-item']//a[contains(text(),'Desktops')]"));
        List<WebElement> listsAllDefault = ListOfWebElementList(By.xpath("//div[@class='prices']"));
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"), "Price: Low to High");
        List<WebElement> listsAllAfterShort = ListOfWebElementList(By.xpath("//div[@class='prices']"));


        if (listsAllDefault != listsAllAfterShort) {
            System.out.println("Pass");


            // varify message
            String expextedMessage = "Price: Low to High";
            WebElement actualmessage = driver.findElement(By.xpath("//select[@id='products-orderby']"));
            Assert.assertEquals("Price low to high", expextedMessage, actualmessage);


        }


    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        // click on Computer Menu
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Computers')]"));
        Thread.sleep(2000);
        //click on Desktop
        clickOnElement(By.xpath("//div[@class='sub-category-item']//a[contains(text(),'Desktops')]"));
        Thread.sleep(2000);
        //sort By Position Name A to Z
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"), "Name: A to Z");
        ////select[@id='products-orderby']
        Thread.sleep(2000);
        //varify the text
        String expectedResult = "Desktops";
        String actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Desktops')]"));

        Thread.sleep(2000);
        // Assert the actual and expected
        Assert.assertEquals("Incorrect page,", expectedResult, actualMessage);
        Thread.sleep(2000);
        //Build your own computer text select
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/h2[1]/a[1]"));
        //Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='product_attribute_1']"), "2.2 GHz Intel Pentium Dual-Core E2200");
        Thread.sleep(2000);
        //.Select "8GB [+$60.00]" using Select class.
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='product_attribute_2']"), "8GB [+$60.00]");
        Thread.sleep(2000);
        //2.8 Select HDD radio "400 GB [+$100.00]"
        clickOnElement(By.xpath("//label[@for='product_attribute_3_7']"));
        Thread.sleep(2000);
        //2.9 Select OS radio "Vista Premium [+$60.00]"
        clickOnElement(By.xpath("//label[@for='product_attribute_4_9']"));
        Thread.sleep(2000);
        //Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        clickOnElement(By.xpath("//li[@data-attr-value='12']"));
        Thread.sleep(2000);
        //Verify the price "$1,475.00"
        String expectedPrice = "$1,470.00";//$1315.00
        String realPrice = getTextFromElement(By.xpath("//span[@id='price-value-1']"));
        Assert.assertEquals("Price is not Match", expectedPrice, realPrice);

        //Click on "ADD TO CARD" Button.
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-1']"));

        //Verify the Message "The product has been added to your shopping cart" on Top green Bar
        String expectedMesage = "The product has been added to your shopping cart";
        String realCartMessage = getTextFromElement(By.xpath("//p[@class='content']"));
        Assert.assertEquals("Verify CartMessage", expectedMesage, realCartMessage);
        Thread.sleep(3000);

        //After that close the bar clicking on the cross button.
        //	2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.

        mouseHooverToElement(By.xpath("//a[@class='ico-cart']"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[text()='Go to cart']"));
        // Varify the message sgopping cart
        String expectedMessage = "Shopping cart";
        String actualmessage1 = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals("Shopping cart display", expectedMessage, actualmessage1);

        //Change the Qty to "2" and Click on "Update shopping cart"
        driver.findElements(By.xpath("//input[@value='1']")).clear();
        sendTextToElement(By.id("itemquantity11224"), "2");

        //and Click on "Update shopping cart"
        clickOnElement(By.xpath("//button[@id='updatecart']"));

        //Verify the Total"$2,950.00"
        String expectedTotalAmount = "$2,950.00";
        String actualTotalAmount = getTextFromElement(By.xpath("//tr[@class='order-total']"));
        Assert.assertEquals("Varify Price", expectedMesage, actualTotalAmount);

        //click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//label[@for='termsofservice']"));

        //Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));

        //Verify the Text “Welcome, Please Sign In!”
        String expecteddisplay = "Welcome, Please Sign In!";
        String actualdisplay = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        Assert.assertEquals("Welcome, Sign in Page", expecteddisplay, actualdisplay);

        //Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//button[@class='button-1 checkout-as-guest-button']"));

        //Fill the all mandatory field

        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"), "Shruti");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"), "Devani");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Email']"), "prime123@gmail.com");
        WebElement dropdownCountry = driver.findElement(By.xpath("//select[@id='BillingNewAddress_CountryId']"));
        selectByValueFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "India");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"), "Ahmedabad");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"), "3 Buttler Road");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"), "Ha2 4th");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"), "04578582589");
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/div[1]/button[4]"));

        //Click on Radio Button “Next Day Air($0.00)”
        clickOnElement(By.xpath("//input[@id='shippingoption_1']"));
        clickOnElement(By.xpath("//button[contains(text(),'Continue') and@class='button-1 shipping-method-next-step-button']"));

        //click on credit card
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));

        //Select “Master card” From Select credit card dropdown
        selectByValueFromDropDown(By.xpath("//select[@id='CreditCardType']"), "Master Card");
        sendTextToElement(By.xpath("//input[@id='CardholderName']"), "Ms. Smith");
        sendTextToElement(By.xpath("//input[@name='CardNumber']"), "5555555555554444]");
        selectByValueFromDropDown(By.xpath("//select[@id='ExpireMonth']"), "01");
        selectByValueFromDropDown(By.xpath("//select[@id='ExpireYear']"), "2022");
        sendTextToElement(By.xpath("//input[@id='CardCode' and @name='CardCode']"), "123");
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));

        // Verify “Payment Method” is “Credit Card”

        String expectedPaymentTxt = "Payment Method” is “Credit Card";
        String actualPaymentTxt = getTextFromElement(By.xpath("Payment Method” is “Credit Card”"));
        Assert.assertEquals("Payment Method is Credit Card", expectedPaymentTxt, actualPaymentTxt);

        //Verify “Shipping Method” is “Next Day Air”
        String expectedShippingText = "Shipping Method” is “Next Day Air";
        String actualShippingText = getTextFromElement(By.xpath("//li[@class='shipping-method']"));
        Assert.assertEquals("Shipping Method” is “Next Day Air", expectedShippingText, actualShippingText);

        //Verify Total is “$2,950.00”
        String expectedTotalresult = "Total is “$2,950.00";
        String actualTotalResult = getTextFromElement(By.xpath("//tr[@class='order-total']"));
        Assert.assertEquals("Total Amount ", expectedTotalresult, actualTotalResult);

        //click confirm
        clickOnElement(By.xpath("//button[@class='button-1 confirm-order-next-step-button']"));

        //Verify the Text “Thank You”
        String expectedText = "Thank You";
        String actualText = getTextFromElement(By.xpath("//h1[contains(text(),'Thank you')]"));
        Assert.assertEquals("Thank you", expectedMesage, actualText);

        //Verify the message “Your order has been successfully processed!”
        String expectedmsg = "Your order has been successfully processed!";
        String actualmsg = getTextFromElement(By.xpath("//strong[text()='Your order has been successfully processed!']"));
        Assert.assertEquals("Your ordrer has been sucessfully processed", expectedmsg, actualmsg);

        // Click on continue
        clickOnElement(By.xpath("//button[@class='button-1 order-completed-continue-button']"));

        // Verify the text “Welcome to our store”
        String expectedWelcomeMsg = "";
        String actualWelcomeMsg = getTextFromElement(By.xpath("//h2[text()='Welcome to our store']"));
        Assert.assertEquals("Welcome to our Store", expectedWelcomeMsg, actualWelcomeMsg);


    }


}
