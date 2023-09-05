import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Program3Test {

    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
    }

    @Test
    public void testGoogleElements() {
        WebElement logo = driver.findElement(By.xpath("//img[@alt='Google']"));
        WebElement searchBox = driver.findElement(By.xpath("//input[@name='q']"));
        WebElement googleSearchButton = driver.findElement(By.xpath("//input[@name='btnK']"));
        WebElement feelingLuckyButton = driver.findElement(By.xpath("//input[@name='btnI']"));

        Assert.assertTrue(logo.isDisplayed(), "Google logo is not present.");
        Assert.assertTrue(searchBox.isDisplayed(), "Search text box is not present.");
        Assert.assertEquals(googleSearchButton.getAttribute("value"), "Google Search", "Google Search button name is incorrect.");
        Assert.assertEquals(feelingLuckyButton.getAttribute("value"), "I'm Feeling Lucky", "I'm Feeling Lucky button name is incorrect.");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
