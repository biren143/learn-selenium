package SeleniumAssignment;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class A2DressCodeAsSaree {
    WebDriver driver;
    @Before
    public void start() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\biren\\Desktop\\chromedriver_win32 (2)\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php?");
        Thread.sleep(2000);
    }
    @Test
    public void dressSearch(){
        WebElement element = driver.findElement(By.id("search_query_top"));
        element.sendKeys("Saree");
        driver.findElement(By.name("submit_search")).click();

        String AcctualMessage = driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1/span")).getText();
      //  System.out.println(AcctualMessage);
        String expectedMessage = "0 results have been found.";
        Assert.assertEquals(expectedMessage,AcctualMessage);
        System.out.println("Test pass");


    }
    @After
    public void close() {
        driver.quit();
    }

}

