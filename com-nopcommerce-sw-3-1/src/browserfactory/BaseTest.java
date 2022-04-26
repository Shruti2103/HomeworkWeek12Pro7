package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;
    public void openBrowser(String baseUrl){

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications"); //disable browser notification
        options.addArguments("--incognito"); //open browser in private windows
        // Setting up Google Chrome browser
       System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
       driver = new ChromeDriver(options);


     //   System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
      //  driver=new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));



    }
    public void closeBrowser(){
        driver.quit();
    }

}
