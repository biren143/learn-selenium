package SeleniumAssignment;


import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class A11Tools {
    WebDriver driver;

    @Before
    public void start() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\biren\\Desktop\\chromedriver_win32 (2)\\chromedriver.exe");
        driver = new ChromeDriver();

        //driver.manage().window().maximize();
        // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://demoqa.com/automation-practice-form/");
        driver.manage().deleteAllCookies();
        Thread.sleep(2000);
    }

    @Test
    public void toolsqa() throws InterruptedException {


        driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/form/fieldset/div[8]/input")).sendKeys("John");
        driver.findElement(By.xpath("//*[@id=\"lastname\"]")).sendKeys("Smith");
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/form/fieldset/div[14]/label")).click();
        driver.findElement(By.id("exp-4")).click();

        driver.findElement(By.xpath("//*[@id=\"datepicker\"]")).sendKeys("5/21/2020");

        driver.findElement(By.xpath("//*[@id = 'profession-0']")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//*[@id = 'profession-1']")).click();
        Thread.sleep(4000);
        //photo upload
        driver.findElement(By.xpath("//*[@id='photo']")).sendKeys("C:\\Users\\biren\\IdeaProjects\\AutomationJava\\src\\test\\java\\SeleniumAssignment\\photo.jpg");

        driver.findElement(By.linkText("Selenium Automation Hybrid Framework")).click();
        Thread.sleep(4000);
        driver.findElement(By.linkText("Test File to Download")).click();
        //String downloadpath = "C:\Users\biren\Downloads";
        //Assert.assertTrue(downloadpath,"Test-File-to-Download.xls");

        //Automation tool selecting QTP and Selenium Webdriver
        driver.findElement(By.xpath("//*[@id = 'tool-0']")).click();
        driver.findElement((By.id("tool-2"))).click();

        //selecting the continent
        WebElement element = driver.findElement(By.xpath("//*[@id = 'continents']"));
        Select select = new Select(element);
        Thread.sleep(3000);
        select.selectByVisibleText("North America");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"continentsmultiple\"]/option[2]")).click();

        { List <String> actual = new ArrayList<>();
            List<WebElement> selenium_command = driver.findElements(By.xpath("//*[@id=\"selenium_commands\"]/option"));
            for (WebElement ele : selenium_command) {
                 actual.add(ele.getText());
            }
            System.out.println(actual); }

        // verify all 4 button are available
        Boolean b1 = driver.findElement(By.id("submit")).isDisplayed();
        Boolean b2 = driver.findElement(By.id("submit1")).isDisplayed();
        Boolean b3 = driver.findElement(By.id("submit2")).isDisplayed();
        Boolean b4 = driver.findElement(By.id("submit3")).isDisplayed();
        System.out.println("Button 1 is displayed" + b1);
        System.out.println("Button 1 is displayed" + b1);
        System.out.println("Button 1 is displayed" + b1);
        System.out.println("Button 1 is displayed" + b1);

        driver.findElement(By.id("submit2")).click();

    }
}