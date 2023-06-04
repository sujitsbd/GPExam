import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class DemoblazeTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    driver = new FirefoxDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void demoblaze() {
    driver.get("https://demoblaze.com/");
    driver.manage().window().setSize(new Dimension(1440, 813));
    driver.findElement(By.id("signin2")).click();
    driver.findElement(By.cssSelector("#signInModal .btn-secondary")).click();
    driver.findElement(By.id("signin2")).click();
    driver.findElement(By.cssSelector("#signInModal .btn-primary")).click();
    assertThat(driver.switchTo().alert().getText(), is("Please fill out Username and Password."));
    driver.findElement(By.id("sign-username")).click();
    driver.findElement(By.id("sign-username")).sendKeys("sujit");
    driver.findElement(By.id("sign-password")).click();
    driver.findElement(By.id("sign-password")).sendKeys("123456");
    driver.findElement(By.cssSelector("#signInModal .btn-primary")).click();
    assertThat(driver.switchTo().alert().getText(), is("This user already exist."));
    driver.findElement(By.id("sign-username")).click();
    driver.findElement(By.id("sign-username")).sendKeys("sujit123456");
    driver.findElement(By.cssSelector("#signInModal .btn-primary")).click();
    assertThat(driver.switchTo().alert().getText(), is("Sign up successful."));
    driver.findElement(By.id("login2")).click();
    driver.findElement(By.id("loginusername")).click();
    driver.findElement(By.id("loginusername")).sendKeys("sujit123456");
    driver.findElement(By.id("loginpassword")).click();
    driver.findElement(By.id("loginpassword")).sendKeys("123456");
    driver.findElement(By.cssSelector("#logInModal .btn-primary")).click();
    driver.findElement(By.id("next2")).click();
    driver.findElement(By.linkText("MacBook Pro")).click();
    driver.findElement(By.linkText("Add to cart")).click();
    assertThat(driver.switchTo().alert().getText(), is("Product added."));
    driver.findElement(By.id("cartur")).click();
    {
      WebElement element = driver.findElement(By.linkText("About us"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    driver.findElement(By.cssSelector(".btn-success")).click();
    {
      WebElement element = driver.findElement(By.cssSelector(".btn-success"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    driver.findElement(By.id("name")).click();
    driver.findElement(By.id("name")).sendKeys("s");
    driver.findElement(By.id("country")).click();
    driver.findElement(By.id("country")).sendKeys("s");
    driver.findElement(By.id("city")).click();
    driver.findElement(By.id("city")).sendKeys("s");
    driver.findElement(By.id("card")).click();
    driver.findElement(By.id("card")).sendKeys("s");
    driver.findElement(By.id("month")).click();
    driver.findElement(By.id("month")).sendKeys("s");
    driver.findElement(By.id("year")).click();
    driver.findElement(By.id("year")).sendKeys("s");
    driver.findElement(By.cssSelector("#orderModal .btn-primary")).click();
    driver.findElement(By.cssSelector(".confirm")).click();
    driver.findElement(By.linkText("About us")).click();
    driver.findElement(By.cssSelector("#videoModal .btn")).click();
    driver.findElement(By.linkText("Contact")).click();
    driver.findElement(By.cssSelector("#exampleModal .btn-primary")).click();
    assertThat(driver.switchTo().alert().getText(), is("Thanks for the message!!"));
    driver.findElement(By.id("itemc")).click();
    driver.findElement(By.linkText("Laptops")).click();
    driver.findElement(By.linkText("Monitors")).click();
    driver.findElement(By.cssSelector(".active > .nav-link")).click();
    driver.findElement(By.id("logout2")).click();
    driver.findElement(By.id("login2")).click();
    driver.findElement(By.cssSelector("#logInModal .btn-primary")).click();
    assertThat(driver.switchTo().alert().getText(), is("Please fill out Username and Password."));
    driver.findElement(By.id("loginusername")).click();
    driver.findElement(By.id("loginusername")).sendKeys("sujit123456qwerty");
    driver.findElement(By.id("loginpassword")).click();
    driver.findElement(By.id("loginpassword")).sendKeys("asdfghj");
    driver.findElement(By.cssSelector("#logInModal .btn-primary")).click();
    assertThat(driver.switchTo().alert().getText(), is("User does not exist."));
    driver.findElement(By.id("loginusername")).click();
    driver.findElement(By.id("loginusername")).sendKeys("sujit123456");
    driver.findElement(By.cssSelector("#logInModal .btn-primary")).click();
    assertThat(driver.switchTo().alert().getText(), is("Wrong password."));
    driver.findElement(By.id("loginpassword")).click();
    driver.findElement(By.id("loginpassword")).sendKeys("123456");
    driver.findElement(By.cssSelector("#logInModal .btn-primary")).click();
    driver.findElement(By.id("logout2")).click();
    driver.close();
  }
}
