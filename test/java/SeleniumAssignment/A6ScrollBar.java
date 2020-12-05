package SeleniumAssignment;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class A6ScrollBar {
    WebDriver driver;

    @Before
    public void start() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\biren\\Desktop\\chromedriver_win32 (2)\\chromedriver.exe");
        driver = new ChromeDriver();
       // driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php?");
        Thread.sleep(2000);
    }

    @Test
    public void scrollBarDragSliderLeft() throws InterruptedException {
        driver.findElement(By.linkText("WOMEN")).click();
        JavascriptExecutor js = (JavascriptExecutor)driver;

        WebElement elementInitial = driver.findElement(By.xpath("//*[@id='layered_price_slider']/a[1])"));
        WebElement elementFinal = driver.findElement(By.xpath("//*[@id=\"layered_price_slider\"]/a[2]"));


        WebElement ele = driver.findElement(By.xpath("//*[@id=\"ul_layered_price_0\"]"));
        js.executeScript("arguments[0].scrollIntoView();", ele);
        Actions act = new Actions(driver);
        Thread.sleep(5000);
        act.clickAndHold(elementInitial);
        act.moveToElement(elementFinal).release().build().perform();

        //act.dragAndDrop(elementInitial,elementFinal).build().perform();




    }

    @After
    public void close() {
        driver.quit();
    }
}