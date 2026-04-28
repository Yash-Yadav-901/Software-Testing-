import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.Assert;

import java.util.List;

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
public void wrongUserCorrPass(){
driver.get("https://the-internet.herokuapp.com/login");

boolean pre_check = preCheck(driver);
Assert.assertTrue(pre_check, " Precheck check failed");

// check if can login with correct username and password

}

@Test(groups = "corrUserPass")
public void correctUserPass(){
String user_name = "tomsmith";
String password = "SuperSecretPassword";
driver.get("https://the-internet.herokuapp.com/login");

boolean pre_check = preCheck(driver);
Assert.assertTrue(pre_check, " Precheck check failed");

// check if can login with correct username and password
WebElement user = driver.findElement(By.id("username"));
WebElement pass = driver.findElement(By.id("password"));

user.sendKeys(user_name);
pass.sendKeys(password);

// click on button
driver.findElement(By.className("radius")).click();

String flash_msg = driver.findElement(By.id("flash")).getText();
Assert.assertTrue(flash_msg.contains("You logged into a secure area!"));
driver.quit();
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

@Test(groups = "AddRemove")
public void AddRemoveEle(){
driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

// verify if the page loaded
String text = driver.findElement(By.tagName("h3")).getText();
Assert.assertEquals(text, "Add/Remove Elements", "Page noe loaded yet");

WebElement button = driver.findElement(By.xpath("//button[text()=\"Add Element\"]"));
boolean isPre = button.isDisplayed();
Assert.assertTrue(isPre,"Button is not present");

// click the button five time
for(int i=0; i<5; i++){
button.click();
}

// Verify Delete button count is 5 also
List<WebElement> deleteBtn = driver.findElements(By.className("added-manually"));
int count_DeleBtn = deleteBtn.size();
assert count_DeleBtn == 5;

for(int i=0; i<3; i++){
deleteBtn.get(i).click();
}

// Delete count button = 2
deleteBtn = driver.findElements(By.className("added-manually"));
count_DeleBtn = deleteBtn.size();
assert count_DeleBtn == 2;

}

}


