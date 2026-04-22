import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


public class ABTest{
    @Test
    public void ABTesting(){
    WebDriver driver = new ChromeDriver();
    driver.get("https://the-internet.herokuapp.com/abtest");
    String title = driver.getTitle();
    if(title.equals("The Internet")){
    System.out.println("Hey! Its working");
    }else{
    System.out.println("Link is not working");
    }

    // check if text is present there or not ?
    WebElement webEle = driver.findElement(By.tagName("h3"));
    String value = webEle.getText();
    if(value.equals("A/B Test Variation 1")){
    System.out.println("Page is loaded");
    }else{
    System.out.println(value);
    System.out.println("Page not loaded yet.");
}
        driver.quit();
}


}