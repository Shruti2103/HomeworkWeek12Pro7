package utilities;

import browserfactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Utility extends BaseTest {
     // This method will click on element
    public void clickOnElement(By by){
        WebElement element=driver.findElement(by);
        element.click();


    }
    // This method will get text from element

    public String getTextFromElement(By by){
        return driver.findElement(by).getText();
    }
     // This method will send text on element
    public void sendTextToElement(By by, String text){
        driver.findElement(by).sendKeys(text);
    }
    public List<WebElement>ListOfWebElementList(By by){
        return  driver.findElements(by);

    }
     public void selectByVisibleTextFromDropDown(By by, String text){
        WebElement dropDown=driver.findElement(by);
        Select select=new Select(dropDown);
        select.selectByVisibleText(text);

     }
     public void mouseHooverToElement(By by){
         Actions actions=new Actions(driver);
         actions.moveToElement(driver.findElement(by)).perform();

     }
     // select by value from dropdown
      public void selectByValueFromDropDown(By by,String value){
        Select select=new Select(driver.findElement(by));
        select.selectByValue(value);
      }
}
