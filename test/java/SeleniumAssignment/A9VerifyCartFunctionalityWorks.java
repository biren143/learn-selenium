package SeleniumAssignment;

import cucumber.api.java.cs.A;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class A9VerifyCartFunctionalityWorks {
    WebDriver driver;

    @Before
    public void start() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\biren\\Desktop\\chromedriver_win32 (2)\\chromedriver.exe");
        driver = new ChromeDriver();
       // driver.manage().deleteAllCookies();
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php?");
        Thread.sleep(2000);
    }
    @Test
    public void verifyCartFunctionality() throws InterruptedException {
        driver.findElement(By.linkText("DRESSES")).click();
        driver.findElement(By.xpath("//*[@id=\"list\"]/a/i")).click();

        WebElement image = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[5]/div/div/div[1]/div/a[1]/img"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        Thread.sleep(4000);
        js.executeScript("arguments[0].scrollIntoView",image);

        //clicking on image
        image.click();
        //view larger
        Thread.sleep(4000);
        driver.findElement(By.xpath("//*[@id=\"view_full_size\"]/span")).click();
        //closing the larger view
        driver.findElement(By.xpath("//*[@id=\"product\"]/div[2]/div/a")).click();
        //quantity upto 3
        driver.findElement(By.xpath("//*[@id=\"quantity_wanted_p\"]/a[2]/span")).click();
        WebElement inc =  driver.findElement(By.xpath("//*[@id=\"quantity_wanted_p\"]/a[2]/span"));
        inc.click();

        //selecting the size (large size)
       Thread.sleep(4000);
        Select slt = new Select(driver.findElement(By.name("group_1")));
        Thread.sleep(4000);
        slt.selectByVisibleText("L");
        driver.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button/span")).click();
        Thread.sleep(4000);
        String size = driver.findElement(By.xpath("//*[@id=\"layer_cart_product_attributes\"]")).getText();
        Thread.sleep(4000);
        String quantity = driver.findElement(By.xpath("//*[@id=\"layer_cart_product_quantity\"]")).getText();
        Thread.sleep(4000);
        String total = driver.findElement(By.xpath("//*[@id=\"layer_cart_product_price\"]")).getText();

        String last = size.substring(size.lastIndexOf(',') + 1);
        System.out.println(last);
        //System.out.println(size);
        System.out.println(quantity);
        System.out.println(total);

        String actualSize = " L";
        String actualQuanitiy = "3";
        String actualTotal="$49.20";


        Assert.assertEquals(actualQuanitiy,quantity);{
        System.out.println("Quanityt pass");}

        Assert.assertEquals(actualSize,last);{
        System.out.println("size pass");}

        Assert.assertEquals(actualTotal,total);{
        System.out.println("total pass");}

    }


    @After
    public void tearDown(){
        driver.quit();
    }


}
