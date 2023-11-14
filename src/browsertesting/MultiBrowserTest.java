package browsertesting;
/**
 * 1. Setup chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Click on ‘Forgot your password?’ link.
 * 7. Print the current url.
 * 8. Navigate back to the login page.
 * 9. Refresh the page.
 * 10. Enter the email to email field.
 * 11. Enter the password to password field.
 * 12. Click on Login Button.
 * 13. Close the browser.
 */


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Scanner;

public class MultiBrowserTest {
    static String baseUrl = "https://opensource-demo.orangehrmlive.com/";
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        //Use scanner to get browser choice from the user
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the browser name (Chrome/Firefox/Edge): ");
        String browser = scanner.nextLine();
        //Multi browser choice
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if
        (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong Browser name");
            return;//exit the program if the browser name is incorrect
        }

        //setup Chrome browser
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        //open url

        driver.get(baseUrl);
        Thread.sleep(5000);
        //Print the title of the page
        System.out.println("Title of the page: " + driver.getTitle());
        //Print the current URL
        System.out.println("Current URL: " + driver.getCurrentUrl());
        //Print the current source
        System.out.println("Page Source: " + driver.getPageSource());
        //Click on Forgot Your password Link
        WebElement forgotPasswordLink = driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']"));
        forgotPasswordLink.click();
//Print the current URL
        System.out.println("Current URL after clicking Forgot Password: " + driver.getCurrentUrl());
        //navigate back to login page
        driver.navigate().back();
        //Navigate back to login page
        driver.navigate().refresh();
        //Enter Email to email field
        WebElement emailField = driver.findElement(By.name("username"));
        emailField.sendKeys("prime@gmail.com");
        //Enter password to password field
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("123456");
        //Click on the login button
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        //close the browser
        driver.quit();
        scanner.close();

    }
}


