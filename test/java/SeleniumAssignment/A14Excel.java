package SeleniumAssignment;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class A14Excel {
    WebDriver driver;
    String url;
    String user;
    String password;

    @Before
    public void start() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\biren\\Desktop\\chromedriver_win32 (2)\\chromedriver.exe");
        driver = new ChromeDriver();

        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://accounts.google.com/");
       // driver.manage().deleteAllCookies();
        Thread.sleep(2000);}
@Test
    public void readfromExcel() throws IOException {
    FileInputStream file = new FileInputStream("C:\\Users\\biren\\Desktop\\Source.xlsx");
    XSSFWorkbook workbook = new XSSFWorkbook(file);
    XSSFSheet sheet =  workbook.getSheet("Sheet1");

    url = sheet.getRow(0).getCell(1).getStringCellValue();
    user = sheet.getRow(1).getCell(1).getStringCellValue();
     password = sheet.getRow(2).getCell(1).getStringCellValue();
    //driver.get(String.valueOf(url));

    System.out.println(url);
    System.out.println(user);
    System.out.println(password);


    driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys(user);
    driver.findElement(By.xpath("//*[@id=\"identifierNext\"]")).click();
    driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys(password);
    driver.findElement(By.xpath("//*[@id=\"passwordNext\"]")).click();

    }
@After
    public void teardown(){
        driver.quit(); }
}
