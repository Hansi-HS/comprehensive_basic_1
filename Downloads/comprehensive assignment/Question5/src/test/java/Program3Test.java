import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Program3Test {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
    }

    @Test
    public void testGoogleLogoPresence() {
        WebElement logo = driver.findElement(By.xpath("//img[@alt='Google']"));
        Assert.assertTrue(logo.isDisplayed());
    }

    @Test
    public void testSearchTextBoxPresence() {
        WebElement searchBox = driver.findElement(By.xpath("//input[@name='q']"));
        Assert.assertTrue(searchBox.isDisplayed());
    }

    @Test
    public void testButtonNames() {
        WebElement googleSearchButton = driver.findElement(By.xpath("//input[@name='btnK']"));
        WebElement feelingLuckyButton = driver.findElement(By.xpath("//input[@name='btnI']"));

        Assert.assertEquals(googleSearchButton.getAttribute("value"), "Google Search");
        Assert.assertEquals(feelingLuckyButton.getAttribute("value"), "I'm Feeling Lucky");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
