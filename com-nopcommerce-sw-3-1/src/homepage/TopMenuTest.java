package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

import java.util.ArrayList;
import java.util.List;

public class TopMenuTest extends Utility {
      String baseUrl="https://demo.nopcommerce.com/";

      @Before
    public void setUp(){
          openBrowser(baseUrl);
      }
     @After
    public void tearDown(){
          closeBrowser();
     }

    public void selectMenu(String menu){
         System.out.println();

        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'" + menu + "')]"));
     }
     @Test
    public void verifyPageNavigation(){
         List<String>topMenus=new ArrayList<>();

         topMenus.add("Computers");
         topMenus.add("Electronics");
         topMenus.add("Apparel");
         topMenus.add("Digital downloads");
         topMenus.add("Books");
         topMenus.add("Jewelry");
         topMenus.add("Gift Cards");

         for(int i=0;i < topMenus.size(); i++){
             selectMenu(topMenus.get(i));
             String actualMessage= getTextFromElement(By.xpath("//h1[contains(text(),'"+topMenus.get(i)+"')]"));
             Assert.assertEquals("Menu is not found",topMenus.get(i),actualMessage);
         }






     }


}
