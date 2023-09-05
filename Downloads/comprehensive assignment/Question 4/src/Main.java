import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

 class GoogleSearchExample {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");


        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com/");

        WebElement searchBox = driver.findElement(By.xpath("//input[@name='q']"));
        searchBox.sendKeys("W3Schools");

        searchBox.submit();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement firstResult = driver.findElement(By.xpath("//div[@class='g']//h3"));
        firstResult.click();

        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.equals("https://www.w3schools.com/")) {
            System.out.println("Successfully navigated to W3Schools.");
        } else {
            System.out.println("Navigation to W3Schools failed.");
        }


        driver.quit();
    }
}
