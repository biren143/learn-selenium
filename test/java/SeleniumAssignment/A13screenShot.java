package SeleniumAssignment;

import cucumber.api.java.sk.Tak;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class A13screenShot {
    WebDriver driver;
    @Before
    public void start() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\biren\\Desktop\\chromedriver_win32 (2)\\chromedriver.exe");
        driver = new ChromeDriver();

        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://accounts.google.com/");
        driver.manage().deleteAllCookies();
        Thread.sleep(2000);}
    @Test
    public void screenShot() throws IOException {


        driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys("birenramdam@gmail.com");
        TakesScreenshot scrShot = (TakesScreenshot)driver;
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(SrcFile,new File("C:\\Users\\biren\\Desktop\\QUALITY Analyst\\gmail username2.png"));

        driver.findElement(By.xpath("//*[@id=\"identifierNext\"]")).click();

        driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("Nepal@143");
        TakesScreenshot screenshot1 = (TakesScreenshot)driver;
        File srFile = screenshot1.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srFile,new File("C:\\Users\\biren\\Desktop\\QUALITY Analyst\\gmail password2.png"));

        driver.findElement(By.xpath("//*[@id=\"passwordNext\"]")).click();

        TakesScreenshot screnshot2 = (TakesScreenshot)driver;
        File src1 = screenshot1.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src1,new File("C:\\Users\\biren\\Desktop\\QUALITY Analyst\\gmail home2.png"));}



    @Test
    public void screenShotFailCases() throws IOException {
        driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys("birenramdam@gmail.com");
        TakesScreenshot scrShot = (TakesScreenshot)driver;
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(SrcFile,new File("C:\\Users\\biren\\Desktop\\QUALITY Analyst\\gmail username4.png"));
        }





    @After
    public  void tearDown() throws IOException {
        driver.quit();

    //public  void takeScreenshot(){
      //      File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //    Random r  = new Random();
          //  int rand = r.nextInt(1000);

            // now copy the screenshot to disired location using copyfile //methos
            //FileUtils.copyFile(src,new File("C:\\Users\\biren\\Desktop\\QUALITY Analyst\\"+rand+"second.png"));
        }//


    //}
    }