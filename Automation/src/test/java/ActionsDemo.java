import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

/**
 * Created by Виктория on 12.12.2016.
 */
public class ActionsDemo {
  public static void main(String[] args) {
    WebDriver driver=new FirefoxDriver();
    //имитируем перетягивание элемента
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.navigate().to("http://jqueryui.com/resources/demos/droppable/default.html");
    WebElement draggable=driver.findElement(By.xpath("//div[@id='draggable']"));
    WebElement droppable=driver.findElement(By.xpath("//div[@id='droppable']"));

    Actions builder=new Actions(driver);
    builder.dragAndDrop(draggable, droppable).build().perform();
    driver.quit();
  }
}
