package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class GooglePageVerification {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");


        WebDriver driver = new ChromeDriver();


        driver.get("https://www.google.com/");


        WebElement googleLogo = driver.findElement(By.xpath("//img[@alt='Google']"));
        if (googleLogo.isDisplayed()) {
            System.out.println("Google logo is present.");
        } else {
            System.out.println("Google logo is not present.");
        }

        WebElement searchTextBox = driver.findElement(By.xpath("//input[@name='q']"));
        if (searchTextBox.isDisplayed()) {
            System.out.println("Search Text box is present.");
        } else {
            System.out.println("Search Text box is not present.");
        }


        WebElement googleSearchButton = driver.findElement(By.xpath("//input[@name='btnK']"));
        if (googleSearchButton.getAttribute("value").equals("Google Search")) {
            System.out.println("Google Search button name is correct.");
        } else {
            System.out.println("Google Search button name is incorrect.");
        }


        WebElement feelingLuckyButton = driver.findElement(By.xpath("//input[@name='btnI']"));
        if (feelingLuckyButton.getAttribute("value").equals("I'm Feeling Lucky")) {
            System.out.println("I'm Feeling Lucky button name is correct.");
        } else {
            System.out.println("I'm Feeling Lucky button name is incorrect.");
        }

        driver.quit();
    }
}
