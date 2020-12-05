package SeleniumAssignment;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class A5VerifyTheNewsLetterSectionWorks {
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
        public void verifyTheNewsLetterSectionWithWrong(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,1000)");
        WebElement element = driver.findElement(By.id("newsletter-input"));
            element.click();
            element.sendKeys("birenramdam@gmail");
         driver.findElement(By.name("submitNewsletter")).click();
         String actual = driver.findElement(By.xpath("//*[@id=\"columns\"]/p")).getText();
         String Expected = "Newsletter : Invalid email address.";

        Assert.assertEquals(actual,Expected);
        System.out.println("Test1 pass");}

        @Test
        public void verifyTheNewsLetterSectionWithRightInfo(){
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("window.scrollBy(0,1000)");
            WebElement element = driver.findElement(By.id("newsletter-input"));
            element.click();
            element.sendKeys("birendraramdam@gmail.com");
            driver.findElement(By.name("submitNewsletter")).click();
            String actual = driver.findElement(By.xpath("//*[@id=\"columns\"]/p")).getText();
            String Expected = "Newsletter : This email address is already registered.";
            Assert.assertEquals(actual,Expected);
            System.out.println("Test2 pass");}

    @After
    public void close(){
        driver.quit();
    }

}


