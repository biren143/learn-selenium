package SeleniumAssignment;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class A7ImageHandling {
    WebDriver driver;

    @Before
    public void start() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\biren\\Desktop\\chromedriver_win32 (2)\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php?");
        Thread.sleep(2000);
    }
@Test
    public void imageHandeling() throws InterruptedException {
        driver.findElement(By.linkText("DRESSES")).click();
        driver.findElement(By.xpath("//*[@id=\"list\"]/a/i")).click();

    WebElement element = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[4]/div/div/div[1]/div/a[1]/img"));
    JavascriptExecutor js = (JavascriptExecutor)driver;
    js.executeScript("arguments[0].scrollIntoView",element);

    element.click();
    Thread.sleep(5000);
    driver.findElement(By.id("bigpic")).click();
    Thread.sleep(5000);
   WebElement next = driver.findElement(By.xpath("//*[@id=\"product\"]/div[2]/div/div[1]/a[2]"));
   next.click();
   driver.findElement(By.xpath("//*[@id=\"product\"]/div[2]/div/div/div[1]/a[2]")).click();
    driver.findElement(By.xpath("//*[@id=\"product\"]/div[2]/div/div/div[1]/a[2]")).click();
    driver.findElement(By.xpath("//*[@id=\"product\"]/div[2]/div/div/a")).click();
   String actual = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div/div[3]/h1")).getText();
    System.out.println(actual);
   String expected = "Printed Summer Dress";

    Assert.assertEquals(actual,expected);
    System.out.println("Test pass");
    }
   @After
    public void close(){
        driver.quit();
    }

}
