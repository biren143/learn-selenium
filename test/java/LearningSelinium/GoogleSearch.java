package LearningSelinium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {
    @Test
    public void google(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\biren\\Desktop\\chromedriver_win32 (2)\\chromedriver.exe");
        WebDriver d = new ChromeDriver();
        d.get(" https://freecrm.com/");
      //  d.findElement(B)
    }
}
