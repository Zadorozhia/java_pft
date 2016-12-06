import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Виктория on 05.12.2016.
 */
public class SeleniumDemo {
  public static void main(String[] args) {
   // WebDriver firefoxDriver=new FirefoxDriver();
    //By by=By.className("b_searchbox");
   // WebElement element=firefoxDriver.findElement(by);
    //System.getProperty("driver.chrome");


    String property=System.getProperty("user.dir")+"/driver/chromedriver.exe";
    System.setProperty("webdriver.chrome.driver",property);
    WebDriver driver=new ChromeDriver();
    driver.get("https://www.bing.com/");
    WebElement go=driver.findElement(By.name("go"));

    WebElement searchButton=driver.findElement(By.className("b_searchboxSubmit"));
    searchButton.sendKeys("test");
    searchButton.click();

    driver.quit();

  }
}
