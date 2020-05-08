package OpenBrowser;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class TableHandling {

    WebDriver d;
    WebElement actual;
    @Before
    public void before() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\biren\\Desktop\\chromedriver_win32 (2)\\chromedriver.exe");
        d = new ChromeDriver();
        d.manage().deleteAllCookies();
        d.manage().window().maximize();
        d.get("https://www.w3schools.com/");
        d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        d.findElement(By.xpath("//*[@id='mySidenav']/div/a[1]")).click();
        d.findElement(By.xpath("//*[@id='leftmenuinnerinner']/a[17]")).click();
      //  d.get("https://www.w3schools.com/html/html_tables.asp");
        Thread.sleep(2000);
    }
    @Test
    public void Testing() throws InterruptedException {

        List<String> x  = new ArrayList<>();
        List<WebElement> a = d.findElements(By.xpath("//*[@id=\"customers\"]/tbody/tr/td[3]"));
        for (WebElement actual:a){
                x.add(actual.getText());
        }
        System.out.println(x);
        Thread.sleep(2000);

        List<String> Expected = new ArrayList<>();
        Expected.add("Germany");
        Expected.add("Mexico");
        Expected.add("Austria");
        Expected.add("UK");
        Expected.add("Canada");
        Expected.add("Italy");

        Assert.assertEquals(Expected, x);
        System.out.println("Assert passed");
    }

    @After
    public void closing(){
        d.quit();
    }
}
