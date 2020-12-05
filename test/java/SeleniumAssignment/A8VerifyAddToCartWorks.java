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

public class A8VerifyAddToCartWorks {
    WebDriver driver;

    @Before
    public void start() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\biren\\Desktop\\chromedriver_win32 (2)\\chromedriver.exe");
        driver = new ChromeDriver();
       // driver.manage().deleteAllCookies();
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php?");
        Thread.sleep(2000);
    }
@Test
    public void verifyAddToCart(){
        driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[3]/div/div[2]/div[2]/a[1]")).click();
    WebElement actual = driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a/span[1]"));

    driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[1]/span")).click();

    String quanitity = driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a/span[1]")).getText();
    System.out.println(quanitity);


    String expected = "1";

    Assert.assertEquals(quanitity,expected);{
        System.out.println("Test Pass");}
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}



