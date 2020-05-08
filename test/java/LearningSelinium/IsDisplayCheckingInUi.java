package LearningSelinium;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class IsDisplayCheckingInUi {



    WebDriver d;

    @Test
    public  void before() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\biren\\Desktop\\chromedriver_win32 (2)\\chromedriver.exe");
        d = new ChromeDriver();
        d.manage().deleteAllCookies();
        d.manage().window().maximize();
        d.get("https://www.amazon.com/");
        d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Thread.sleep(2000);
        d.findElement(By.id("nav-link-accountList")).click();
        //isDispaly method is applied for all the web elements
        Boolean b = d.findElement(By.xpath("//*[@id=\"createAccountSubmit\"]")).isDisplayed();
        System.out.println(b);
        d.findElement(By.xpath("//*[@id=\"ap_email\"]")).sendKeys("birenramdam@gmail.com");
       d.findElement(By.id("continue")).click();

        //is selectable  method is used for select, radio button, checkbox, dropdown button
        d.findElement(By.name("rememberMe")).click();
       Boolean b1 = d.findElement(By.name("rememberMe")).isSelected();
       System.out.print(b1);  //true

        //de-select
        d.findElement(By.name("rememberMe")).click();
        Boolean b2 = d.findElement(By.name("rememberMe")).isSelected();
        System.out.println(b2);  //false

        Thread.sleep(2000);





        d.quit();
    }


}


