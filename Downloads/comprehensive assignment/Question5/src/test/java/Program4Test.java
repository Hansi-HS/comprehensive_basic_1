import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Program4Test { 
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
    }

    @Test
    public void testSearchW3Schools() {
        WebElement searchBox = driver.findElement(By.xpath("//input[@name='q']"));
        searchBox.sendKeys("W3Schools");

        WebElement searchButton = driver.findElement(By.xpath("//input[@name='btnK']"));
        searchButton.click();
    }

    @Test(dependsOnMethods = "testSearchW3Schools")
    public void testW3SchoolsLink() {
        WebElement w3schoolsLink = driver.findElement(By.xpath("//h3[contains(text(),'W3Schools')]"));
        w3schoolsLink.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.w3schools.com/");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
