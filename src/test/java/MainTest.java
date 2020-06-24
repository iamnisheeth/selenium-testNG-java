import io.github.bonigarcia.wdm.WebDriverManager;
import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;

import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class MainTest {

    static Logger log = Logger.getLogger(MainTest.class);
    public  WebDriver driver;

    @BeforeClass
    public void setupClass() {
        BasicConfigurator.configure();
        WebDriverManager.getInstance(CHROME).setup();
        driver = new ChromeDriver();
    }

    @Test(priority = 1)
    public void loginToSite() {
        log.debug("Go to DDG site");
        driver.get("https://duckduckgo.com/");
    }
    @Test(priority = 2)
    public void searchForVideo() throws InterruptedException {
        log.debug("key-in the search keyword(s)");
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='search_form_input_homepage']"));
        searchBox.sendKeys("iamnisheeth");
        searchBox.sendKeys(Keys.ENTER);
        Thread.sleep(5000);
    }

    @AfterTest
    public void cleanUp() {
        if (driver != null) {
            driver.quit();
        }
    }
}