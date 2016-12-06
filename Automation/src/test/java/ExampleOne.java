import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by Виктория on 06.12.2016.
 */
public class ExampleOne {
  public static void main(String[] args) {
    WebDriver driver=new FirefoxDriver();
    driver.get("https://www.bing.com/");
    WebDriverWait wait=new WebDriverWait(driver,10);
    WebElement searchBox=driver.findElement(By.className("b_searchbox"));
    searchBox.sendKeys("automation");
    searchBox.submit();
    wait.until(ExpectedConditions.titleContains("automation"));
    System.out.println("Page title is:"+driver.getTitle());
    System.out.println("List results is:");
    List<WebElement> elements=driver.findElements(By.tagName("h2"));
    for(WebElement element:elements){
      String name=element.getText();
      System.out.printf("-%s%n", name);
    }

    driver.quit();
  }
}
