package org.example;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumTask {
    @Test
    public void testValidLogin() {
        // If you want to test it yourself don't forget to change these hardcoded values
        System.setProperty("webdriver.firefox.driver","E:\\Moo\\Chrome Downloads\\geckodriver-v0.34.0-win-aarch64\\geckodriver.exe");

        // Initialize a Web Driver with your favourite browser (Chrome didn't work for me)
        WebDriver webDriver = new FirefoxDriver();

        // Navigate to a GitHub
        webDriver.navigate().to("https://www.github.com/login");

        // Send Credentials
        webDriver.findElement(By.id("login_field")).sendKeys("japaneseyt8862@gmail.com");
        webDriver.findElement(By.id("password")).sendKeys("123456@_abcdef");

        // Login
        webDriver.findElement(By.name("commit")).click();

        // Dashboard only exists if login was successful
        String ActualValue = webDriver.findElement(By.className("AppHeader-context-item-label")).getText();
        String ExpectedValue = "Dashboard";

        Assert.assertEquals(ExpectedValue,ActualValue);

        webDriver.close();
    }
    @Test
    public void testInValidLogin() {
        // If you want to test it yourself don't forget to change these hardcoded values
        System.setProperty("webdriver.firefox.driver","E:\\Moo\\Chrome Downloads\\geckodriver-v0.34.0-win-aarch64\\geckodriver.exe");

        // Initialize a Web Driver with your favourite browser (Chrome didn't work for me)
        WebDriver webDriver = new FirefoxDriver();

        // Navigate to a GitHub
        webDriver.navigate().to("https://www.github.com/login");

        // Send Credentials
        webDriver.findElement(By.id("login_field")).sendKeys("japaneseyt8862@gmail.com");
        webDriver.findElement(By.id("password")).sendKeys("123456@_abcdeg"); // wrong password

        // Login
        webDriver.findElement(By.name("commit")).click();

        // This text doesn't appear unless login was a failure
        String ActualValue = webDriver.findElement(By.className("js-flash-alert")).getText();
        String ExpectedValue = "Incorrect username or password.";

        Assert.assertEquals(ExpectedValue,ActualValue);

        webDriver.close();
    }
}
