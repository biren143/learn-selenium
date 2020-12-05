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

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class A4VerifyMyAccountFooter {
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
    public void verifyFooter() {
       //scrolling down page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");

        List<WebElement> li = driver.findElements(By.xpath("//*[@id=\"footer\"]/div/section[5]/div/ul/li/a"));
        List<String> actual = new ArrayList<>();
        for (WebElement lis : li) {
            actual.add(lis.getText());
                     }

        //System.out.println(actual);
        // adding the excepted value in list
        List<String> Expected = new ArrayList<>();
        Expected.add("My orders");
        Expected.add("My credit slips");
        Expected.add("My addresses");
        Expected.add("My personal info");

        //testing case using Assert class
        Assert.assertEquals(actual,Expected);
        System.out.println("Test Pass");
        }


        @After
        public void close(){
          driver.quit();
        }

    }
