package OpenBrowser;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Highlight {
    WebDriver d;
    @Before
    public void before() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\biren\\Desktop\\chromedriver_win32 (2)\\chromedriver.exe");
        d = new ChromeDriver();
        d.manage().deleteAllCookies();
        d.manage().window().maximize();
        d.get("https://www.w3schools.com/");
        d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

         d.get("https://www.facebook.com/");
        Thread.sleep(2000);
    }
@Test

    public void Testing() throws InterruptedException {
    WebElement ele = d.findElement(By.xpath("//*[@id='u_0_b'] "));
    drawBorder(ele, d);  // draw a border
    //File src = ((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
    //FileUtils.copyFile();
}

    public static void drawBorder( WebElement element, WebDriver d) {
        JavascriptExecutor js = ((JavascriptExecutor) d);
        js.executeScript("arguments[0].style.border = '3xp solid green'", element);
    }

    //@After
    //public void closing(){
      //  d.quit();
    //}





}
