import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ExampleTwo {
    public static void main(String[] args) throws InterruptedException {
        //Создаем экземпляр WebDriver
        WebDriver driver=new FirefoxDriver();

        //Устанавливаем неявное ожидание 10сек
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        //1.Открываем главную страницу поисковой системы Bing
        driver.get("https://www.bing.com/");

        //2.1 Переходим в раздел поиска изображений
        driver.findElement(By.id("scpl1")).click();
        //2.2 Ожидаем увидеть заголовок страницы "Лента изображений Bing
        System.out.println("Page title is:"+ driver.getTitle());

        //3. Выполняем скролл страницы
        JavascriptExecutor jse=(JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)");
        jse.executeScript("window.scrollBy(0,250)");
        jse.executeScript("window.scrollBy(0,-500)");

        //4.1 Вводим в поисковую строку automatio
        driver.findElement(By.id("sb_form_q")).sendKeys("automatio");
        //4.2 Выбираем из списка automation
        driver.findElement(By.xpath("//ul[@id='sa_ul']//div[.='automation']")).click();

        //5.1 Устанавливаем фильтр Дата
        driver.findElement(By.xpath("//div[@id='ftrB']/ul/li[6]/span/span/span")).click();
        //5.2 Выбираем "В прошлом месяце"
        driver.findElement(By.linkText("В прошлом месяце")).click();


        //6. Нажать на первое изображение
        WebElement element=driver.findElement(By.xpath("//div[@id='dg_c']//a/img"));
        Thread.sleep(5000);
        element.click();
        //7.1 Переключаем на следующее изображение
       // driver.findElement(By.xpath("//a[@id='iol_navr']")).click();

        //System.out.println("Page title is:"+ driver.getTitle());


        //Закрываем браузер
        driver.quit();
    }

    }

