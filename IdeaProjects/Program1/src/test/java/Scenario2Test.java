import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

public class Scenario2Test {
    private WebDriver driver;
    private HomePage homePage;

    @BeforeSuite
    public void beforeSuite() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    }

    @BeforeTest
    public void beforeTest() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }

    @Test
    public void testScenario2() {
        driver.get("https://www.flipkart.com/");
        homePage = new HomePage(driver);

        // Verify that "Flipkart" is present on the page
        Assert.assertTrue(homePage.isFlipkartLogoPresent());

        // Enter "iphone 14" in the search box and perform the search
        homePage.searchForProduct("iphone 14");

        // Verify the number of items displayed and click on the first item
        int numberOfItems = homePage.getNumberOfSearchResults();
        Assert.assertTrue(numberOfItems > 0);

        // Click on the first search result
        homePage.clickOnFirstSearchResult();

        // Verify that navigated to the right page and check the title
        Assert.assertTrue(homePage.isProductDetailPage());
    }
}
