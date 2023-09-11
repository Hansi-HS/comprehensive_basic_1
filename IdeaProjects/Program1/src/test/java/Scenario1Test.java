import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

public class Scenario1Test {
    private WebDriver driver;
    private HomePage homePage;
    private ContactPage contactPage;

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
    public void testScenario1() {
        driver.get("https://automationpanda.com/2021/12/29/want-to-practice-test-automation-try-these-demo-sites/");
        homePage = new HomePage(driver);
        contactPage = new ContactPage(driver);

        // Verify the title of the homepage
        Assert.assertEquals(driver.getTitle(), "Demo Sites for Testing Practice");

        // Click on the Contact link
        homePage.clickContactLink();

        // Verify the title of the contact page
        Assert.assertEquals(driver.getTitle(), "Contact");

        // Fill and submit the contact form
        contactPage.fillContactForm("John Doe", "john.doe@example.com", "Test message");
        Assert.assertEquals(contactPage.getMessageSentMessage(), "Message Sent");
    }
}
