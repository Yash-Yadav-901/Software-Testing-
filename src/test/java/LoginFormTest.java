import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.Assert;

import org.openqa.selenium.By;


public class LoginFormTest {

@Test
public void logintesting(){
WebDriver driver = new ChromeDriver();

driver.get("https://the-internet.herokuapp.com/login");

String text = driver.findElement(By.tagName("h2")).getText();
// assert text.equals("Login Page");
Assert.assertTrue(text.equals("Login Page"),"Page not loaded yet.");

boolean userNameVisible = driver.findElement(By.id("username")).isDisplayed();
Assert.assertTrue(userNameVisible, "user name input is not displayed");

boolean passInputVisible = driver.findElement(By.id("password")).isDisplayed();
Assert.assertTrue(passInputVisible, "password input is not displayed");

boolean buttonPresent = driver.findElement(By.xpath("//button/i")).isDisplayed();
Assert.assertTrue(buttonPresent, "Button is not visible");

driver.quit();
}
}