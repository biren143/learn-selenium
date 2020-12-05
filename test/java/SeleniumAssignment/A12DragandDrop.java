package SeleniumAssignment;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class A12DragandDrop {
   WebDriver driver;
    @Before
    public void start() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\biren\\Desktop\\chromedriver_win32 (2)\\chromedriver.exe");
        driver = new ChromeDriver();

        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://demo.guru99.com/test/drag_drop.html");
        driver.manage().deleteAllCookies();
        Thread.sleep(2000);}

    @Test
    public void dragAndDrop() throws InterruptedException {
        WebElement initial = driver.findElement(By.xpath("//*[@id=\"credit2\"]/a"));
        WebElement destination = driver.findElement(By.xpath("//*[@id=\"bank\"]/li"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(initial,destination).build().perform();
        Thread.sleep(5000);

        List<WebElement> li = driver.findElements(By.xpath("//*[@id=\"bal3\"]/table/tbody/tr/td"));
        List<String> actual = new ArrayList<>();
        for(WebElement lis: li){
            actual.add(lis.getText()); }
       // System.out.println(actual);

        List<String> expected = new ArrayList<>();
        expected.add("Debit Movement");
        expected.add("0");
        expected.add("Credit Movement");
        expected.add("0");

        Assert.assertEquals(actual,expected);
        System.out.println("Test1 pass");
    }
@Test
    public void drag500(){
        WebElement initial = driver.findElement(By.xpath("//*[@id=\"fourth\"]"));
        WebElement destination = driver.findElement(By.xpath("//*[@id=\"amt7\"]/li"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(initial,destination).build().perform();
        List<WebElement> li  = driver.findElements(By.xpath("//*[@id=\"bal3\"]/table/tbody/tr/td"));
        List<String> actual = new ArrayList<>();
        for(WebElement lis: li){
            actual.add(lis.getText());
        }
    //System.out.println(actual);
    List<String> expected = new ArrayList<>();
    expected.add("Debit Movement");
    expected.add("5000");
    expected.add("Credit Movement");
    expected.add("0");

    Assert.assertEquals(actual,expected);
    System.out.println("Test2 pass");}

    @Test
    public void dragSale(){
        WebElement initaia  = driver.findElement(By.xpath("//*[@id=\"credit1\"]/a"));
        WebElement destination = driver.findElement(By.xpath("//*[@id=\"loan\"]/li"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(initaia,destination).build().perform();
        List<WebElement> li  = driver.findElements(By.xpath("//*[@id=\"bal3\"]/table/tbody/tr/td"));
        List<String> actual = new ArrayList<>();
        for(WebElement lis: li){
            actual.add(lis.getText());
        }
        //System.out.println(actual);
        List<String> expected = new ArrayList<>();
        expected.add("Debit Movement");
        expected.add("0");
        expected.add("Credit Movement");
        expected.add("0");

        Assert.assertEquals(actual,expected);
        System.out.println("Test3 pass");}


    @Test
    public void drag500CreditSide(){
        WebElement initaia  = driver.findElement(By.xpath("//*[@id=\"fourth\"]/a"));
        WebElement destination = driver.findElement(By.xpath("//*[@id=\"amt8\"]/li"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(initaia,destination).build().perform();
        List<WebElement> li  = driver.findElements(By.xpath("//*[@id=\"bal3\"]/table/tbody/tr/td"));
        List<String> actual = new ArrayList<>();
        for(WebElement lis: li){
            actual.add(lis.getText());
        }
        //System.out.println(actual);
        List<String> expected = new ArrayList<>();
        expected.add("Debit Movement");
        expected.add("0");
        expected.add("Credit Movement");
        expected.add("5000");

        Assert.assertEquals(actual,expected);
        System.out.println("Test4 pass");}

    @After
    public void close(){
        driver.quit();

    }


    }




