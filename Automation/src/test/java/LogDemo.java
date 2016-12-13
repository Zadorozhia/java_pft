import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Виктория on 12.12.2016.
 */
//логирование, после запуска видим найденный элемент в терминале
public class LogDemo {
  public static void main(String[] args) {
    EventFiringWebDriver driver=new EventFiringWebDriver(new FirefoxDriver());
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.register(new EventHandler());

    driver.navigate().to("http://jqueryui.com/resources/demos/droppable/default.html");
    WebElement draggable=driver.findElement(By.xpath("//div[@id='draggable']"));
    WebElement droppable=driver.findElement(By.xpath("//div[@id='droppable']"));

    Actions builder=new Actions(driver);
    builder.dragAndDrop(draggable, droppable).build().perform();
    driver.quit();

  }
}
