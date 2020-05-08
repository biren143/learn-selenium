package OpenBrowser;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenBrowser {

    @Test
    public void openChromeBrowser() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\biren\\Desktop\\chromedriver_win32 (2)\\chromedriver.exe");
        WebDriver wd = new ChromeDriver();
        wd.get("http://www.gmail.com");
        // wd.manage().window().maximize();
        Thread.sleep(5000);

        wd.findElement(By.xpath("//*[@id='identifierId']")).sendKeys("brammdamm@gmail.com");
        Thread.sleep(2000);
        wd.findElement(By.xpath("//*[@id='identifierNext']")).click();
        Thread.sleep(2000);
        wd.findElement(By.xpath("//*[@id='password']/div[1]/div/div[1]/input")).sendKeys("Argentina100");
        Thread.sleep(2000);
        wd.findElement(By.xpath("//*[@id='passwordNext']")).click();
    }

        @Test
                public void validUserInvalidPassword() throws InterruptedException {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\biren\\Desktop\\chromedriver_win32 (2)\\chromedriver.exe");
            WebDriver wd = new ChromeDriver();
            wd.get("http://www.gmail.com");
            // wd.manage().window().maximize();
            Thread.sleep(5000);
            wd.findElement(By.xpath("//*[@id='identifierId']")).sendKeys("brammdamm@gmail.com");
            Thread.sleep(2000);
            wd.findElement(By.xpath("//*[@id='identifierNext']")).click();
            Thread.sleep(2000);
            wd.findElement(By.xpath("//*[@id='password']/div[1]/div/div[1]/input")).sendKeys("Apple100");
            Thread.sleep(2000);
            wd.findElement(By.xpath("//*[@id='passwordNext']")).click();
            WebElement Actual = wd.findElement(By.xpath("//*[@id='view_container']/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div[2]/div[2]/span"));
            String Expected = "Wrong password. Try again or click Forgot password to reset it";
            Assert.assertEquals(Actual, Expected);
            System.out.println("Assert passed");

        }





















        //wd.quit();

        /*String expectedInbox="inbox";
        WebElement elementInbox=wd.findElement(By.xpath("//a[text()='Inbox']"));
        Assert.assertEquals(expectedInbox,elementInbox.getText());

*/
    }

 /*  public void openFireFoxBrowser() throws InterruptedException {
       System.setProperty("webdriver.gecko.driver", "C:\\Users\\biren\\Desktop\\QUALITY Analyst\\drivers\\geckodriver-v0.26.0-win64\\geckodriver.exe");
       WebDriver wd1 = new FirefoxDriver();
       wd1.get("http://www.gmail.com");
        wd1.manage().window().maximize();
        Thread.sleep(5000);
       wd1.findElement(By.xpath("//*[@id='identifierId']")).sendKeys("birenramdam@gmail.com");
       wd1.findElement(By.xpath("//*[@id=\"identifierNext\"]")).click();
       wd1.findElement(By.name("Password")).sendKeys("Argentina@143");
       wd1.findElement(By.xpath("//*[@id='passwordNext']")).click();
       wd1.quit();
       }
*/




