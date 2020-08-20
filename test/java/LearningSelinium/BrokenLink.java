package LearningSelinium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BrokenLink {
    WebDriver d;


    @Before
    public void before()  {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\biren\\Desktop\\chromedriver_win32 (2)\\chromedriver.exe");
        d = new ChromeDriver();
        d.manage().deleteAllCookies();
        d.manage().window().maximize();
        d.get("http://www.bajekosekuwa.com/");
        d.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);}
        
        @Test
    public void brokenlinksFind() throws IOException, InterruptedException {
            List<WebElement> links = d.findElements(By.tagName("a"));
            System.out.println(links.size());

            for(int i = 0; i<links.size();i++){
                WebElement elements = links.get(i);
                String url = elements.getAttribute("href");

                URL link = new URL(url);


                Thread.sleep(2000);
                HttpURLConnection http = (HttpURLConnection) link.openConnection();
                http.connect();
               int code =  http.getResponseCode();




                //if response code is greater of equal 400 then it is a broken
                if(code >= 400){
                    System.out.println( url + "It is broken link");}
                else{
                    System.out.println(url + "it is valid link");
                }

            }

        }

        @After
             public void teardown(){
                    d.quit();
    }
}
