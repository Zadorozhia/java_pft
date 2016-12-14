import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;


public class ExampleTwo {

    public void main(String[] args) throws InterruptedException {
        //Создаем экземпляр WebDriver
        WebDriver driver=new FirefoxDriver();

        //Устанавливаем неявное ожидание 10сек
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        //1.Открываем главную страницу поисковой системы Bing
        driver.get("https://www.bing.com/");

        //2.1 Переходим в раздел поиска изображений
        driver.findElement(By.id("scpl1")).click();
        //2.2 Ожидаем увидеть заголовок страницы "Лента изображений Bing
        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.titleContains("Лента изображений Bing"));
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

        //С ЭТОГО МЕСТА НЕ РАБОТАЕТ
        //6. Нажать на первое изображение
        WebDriverWait driverWait = new WebDriverWait(driver, 15);
        By foundImageResult = By.cssSelector(".imgres > div");//не находит
        By iframe = By.id("OverlayIFrame");
        By slider = By.id("iol_ip");
        driverWait.withMessage("Element was not found");
        driverWait.until(new Predicate() {

            @Override
            public boolean apply(WebDriver d) {
                // начинаем с основного фрейма (открытой страницы)
                d.switchTo().defaultContent();
                // нажимаем на изображение
                d.findElement(foundImageResult).click();
                // переключаемся во фрейм
                d.switchTo().frame(d.findElement(iframe));
                // возвращаем true только тогда, когда блок слайдшоу отобразился; иначе выполняем все сначала
                return d.findElement(slider).isDisplayed(); } });



        //7.1 Переключаем на следующее изображение
       //driver.findElement(By.xpath("//a[@id='iol_navr']")).click();
        //7.2 Переключаем на предыдущее изображение
       // driver.findElement(By.xpath("//a[@id='iol_navl']")).click();



        //Закрываем браузер
        driver.quit();
    }

    }

