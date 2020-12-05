package SeleniumAssignment;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class A10AlertBox {
    WebDriver driver;

    @Before
    public void start() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\biren\\Desktop\\chromedriver_win32 (2)\\chromedriver.exe");
        driver = new ChromeDriver();

        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.toolsqa.com/handling-alerts-using-selenium-webdriver/");
        driver.manage().deleteAllCookies();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"cookie_action_close_header\"]")).click();
    }
    @Test
    public void simpleAlert() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"content\"]/p[3]/button")).click();
        Alert alert = driver.switchTo().alert();
        Thread.sleep(6000);
        alert.accept();
       String actual =  driver.getTitle();
       // System.out.println(actual);
        String expected ="Handling Alerts using Selenium WebDriver";
        Assert.assertEquals(actual,expected);{
            System.out.println("Test 1 pass");
        }

    }
    @Test
    public void confirmPopUp() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"content\"]/p[7]/button")).click();
        Alert alert = driver.switchTo().alert();
       String actual = alert.getText();
        //System.out.println(actual);
        Thread.sleep(6000);
        alert.dismiss();
        String expected = "Confirm pop up with OK and Cancel button";
        Assert.assertEquals(actual,expected);
        System.out.println("Test 2 pass");
    }
    @Test
    public void promptAlerBox() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"content\"]/p[10]/button")).click();
        Alert alert = driver.switchTo().alert();
        String actual = alert.getText();
        Thread.sleep(6000);
        alert.sendKeys("yes");
        alert.accept();
        String expected = "Do you like toolsqa?";
        Assert.assertEquals(actual, expected);
        System.out.println("Test 3 pass");
    }

    @After
    public void tearDown(){
        driver.quit();
    }
        }


