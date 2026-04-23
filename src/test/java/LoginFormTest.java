import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.Assert;

import org.openqa.selenium.By;


public class LoginFormTest {

WebDriver driver;

@BeforeMethod
public void setUp(){
driver = new ChromeDriver();
}

@AfterMethod
public void tearDown(){
if(driver != null){
driver.quit();
}
}

public boolean preCheck(WebDriver driver){
String text = driver.findElement(By.tagName("h2")).getText();
// assert text.equals("Login Page");
Assert.assertTrue(text.equals("Login Page"),"Page not loaded yet.");

// If all the required element is present ?
boolean userNameVisible = driver.findElement(By.id("username")).isDisplayed();
// Assert.assertTrue(userNameVisible, "user name input is not displayed");

boolean passInputVisible = driver.findElement(By.id("password")).isDisplayed();
// Assert.assertTrue(passInputVisible, "password input is not displayed");

boolean buttonPresent = driver.findElement(By.xpath("//button/i")).isDisplayed();
// Assert.assertTrue(buttonPresent, "Button is not visible");
return userNameVisible && passInputVisible && buttonPresent;
}

@Test
public void correctUserPass(){
driver.get("https://the-internet.herokuapp.com/login");

boolean pre_check = preCheck(driver);
Assert.assertTrue(pre_check, " Precheck check failed");

// check if can login with correct username and password

}

@Test
public void wrongUserCorrPass(){
driver.get("https://the-internet.herokuapp.com/login");

boolean pre_check = preCheck(driver);
Assert.assertTrue(pre_check, " Precheck check failed");

// check if can login with correct username and password

}

@Test
public void CorrUserWrongPass(){
driver.get("https://the-internet.herokuapp.com/login");

boolean pre_check = preCheck(driver);
Assert.assertTrue(pre_check, " Precheck check failed");

// check if can login with correct username and password

}

@Test
public void wrongUserWrongPass(){
driver.get("https://the-internet.herokuapp.com/login");

boolean pre_check = preCheck(driver);
Assert.assertTrue(pre_check, " Precheck check failed");

// check if can login with correct username and password

}

@Test
public void emptyUserPass(){
driver.get("https://the-internet.herokuapp.com/login");

boolean pre_check = preCheck(driver);
Assert.assertTrue(pre_check, " Precheck check failed");

// check if can login with correct username and password

}
}

