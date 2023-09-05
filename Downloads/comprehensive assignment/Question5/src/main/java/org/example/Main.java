package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Main {
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		//System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
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
	  @Parameters({"google","lucky"})
	 
	public void testButtonNames() {
		WebElement googleSearchButton = driver.findElement(By.xpath("//input[@name='btnK']"));
		WebElement feelingLuckyButton = driver.findElement(By.xpath("//input[@name='btnI']"));

		Assert.assertEquals(googleSearchButton.getAttribute("value"), "Google Search");
		Assert.assertEquals(feelingLuckyButton.getAttribute("value"), "I am feeling lucky");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	public static void main(String[] args) {
		Main m1 = new Main();
		m1.setUp();
		m1.testGoogleLogoPresence();
		m1.testSearchTextBoxPresence();
		m1.testButtonNames();
	

	}
}