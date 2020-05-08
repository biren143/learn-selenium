package OpenBrowser;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class OpenFacebook {
    WebDriver d;

   @Before
   public void Setup(){
       System.setProperty("webdriver.chrome.driver", "C:\\Users\\biren\\Desktop\\chromedriver_win32 (2)\\chromedriver.exe");
       d = new ChromeDriver();
       ChromeOptions opt = new ChromeOptions();
       opt.addArguments("disable-notifications");

       d.manage().deleteAllCookies();
       d.manage().window().maximize();
       d.get(" https://www.facebook.com/");

   }

    @Test
    public  void openFaceBookPage() throws InterruptedException {



        d.findElement(By.xpath("//*[@id='email']")).sendKeys("4695691037");
        d.findElement(By.xpath("//*[@id='pass']")).sendKeys("love@143");
        Thread.sleep(2000);
        d.findElement(By.xpath("//*[@id='u_0_b']")).click();
        d.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        d.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        Thread.sleep(3000);
        d.findElement(By.xpath("//*[@id=\"u_0_a\"]/div[1]/div[1]/div/a")).click();

      //  d.getWindowHandles();
//
    }

    }



/*
wd.findElement(By.xpath("//input[@value='Log In']")).click();
        int expectedFriendsList = 1051;
        Thread.sleep(2000);
        wd.findElement(By.xpath("//a[@title='Profile']")).click();
        Thread.sleep(2000);
        wd.findElement(By.xpath("//a[@data-tab-key='friends']")).click();
 */

