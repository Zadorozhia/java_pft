import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

/**
 * Created by Виктория on 12.12.2016.
 */
//создаем слушателя событий
public class EventHandler implements WebDriverEventListener {
  public void beforeNavigateTo(String s, WebDriver webDriver) {

  }

  public void afterNavigateTo(String s, WebDriver webDriver) {

  }

  public void beforeNavigateBack(WebDriver webDriver) {

  }

  public void afterNavigateBack(WebDriver webDriver) {

  }

  public void beforeNavigateForward(WebDriver webDriver) {

  }

  public void afterNavigateForward(WebDriver webDriver) {

  }

  public void beforeNavigateRefresh(WebDriver webDriver) {

  }

  public void afterNavigateRefresh(WebDriver webDriver) {

  }

  public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {
    System.out.println("looking for element"+by);
  }

  public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {
    System.out.println("found element"+by);

  }

  public void beforeClickOn(WebElement webElement, WebDriver webDriver) {

  }

  public void afterClickOn(WebElement webElement, WebDriver webDriver) {

  }

  public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver) {

  }

  public void afterChangeValueOf(WebElement webElement, WebDriver webDriver) {

  }

  public void beforeScript(String s, WebDriver webDriver) {

  }

  public void afterScript(String s, WebDriver webDriver) {

  }

  public void onException(Throwable throwable, WebDriver webDriver) {

  }
}
