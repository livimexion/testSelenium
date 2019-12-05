
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class SeleniumTest {

    public SeleniumTest() throws InterruptedException{
         test1();
    }

    public static void main(String[] args) throws InterruptedException{
        new SeleniumTest();
    }

    public void test1() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "D:\\DevOps\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8090/Xarmat/");
        driver.manage().window().maximize();
        //Thread.sleep(5000);


        WebElement sbb = driver.findElement(By.id("account-menu"));
        sbb.click();
        //Thread.sleep(5000);


        WebElement sbl = driver.findElement(By.id("login"));
        sbl.click();


        WebElement searchname = driver.findElement(By.id("username"));
        searchname.sendKeys("admin");
        //Thread.sleep(5000);

        WebElement searchpwd = driver.findElement(By.id("password"));
        searchpwd.sendKeys("admin");


        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(source, new File("TestSE1/screenshot/screen.png"));

        }catch (IOException e){
            e.printStackTrace();
        }
        WebElement searchIcon = driver.findElement(By.xpath("//button[@jhitranslate='login.form.button']"));
        searchIcon.click();
        Thread.sleep(5000);
        //driver.quit();



    }
}
