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

public class A3VerifyShoppingCart {
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
    public void cartVerify(){
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a")).click();


        String ActualMessage = driver.findElement(By.xpath("//*[@id=\"center_column\"]/p")).getText();
        // if you want to see the actual message print this
        // System.out.println(AcctualMessage);
        String expectedMessage = "Your shopping cart is empty.";
        Assert.assertEquals(expectedMessage,ActualMessage);
        System.out.println("Test pass");


    }
    @After
    public void close() {
        driver.quit();
    }

}


