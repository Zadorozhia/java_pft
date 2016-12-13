import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Виктория on 12.12.2016.
 */
public class Wait {
  public static void main(String[] args) throws InterruptedException {
    WebDriver driver=new FirefoxDriver();
    //неявное ожидание
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.navigate().to("https://www.google.com.ua/#q=test");
    WebElement element=driver.findElement(By.xpath("//div[@class='srg']"));
    //js код, скролл (x,y)(0,250)
    JavascriptExecutor jse=(JavascriptExecutor)driver;
    //не работает скролл до конца страницы?
    //jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    jse.executeScript("window.scrollBy(0,250)");
    Thread.sleep(5000);
    driver.quit();
  }
}
