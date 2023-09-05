import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Program4Test {

    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
    }

    @Test
    public void testSearchAndNavigate() {
        WebElement searchBox = driver.findElement(By.xpath("//input[@name='q']"));
        searchBox.sendKeys("W3Schools");
        searchBox.submit();

        WebElement firstSearchLink = driver.findElement(By.xpath("//h3[contains(text(),'W3Schools')]"));
        firstSearchLink.click();

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.w3schools.com/";

        Assert.assertEquals(actualUrl, expectedUrl, "URL did not match.");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
