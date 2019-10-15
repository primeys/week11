import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LogInToNopCommerce {
    // WebDriver Globally declare
    private WebDriver driver;
 //   private JavascriptExecutor js;
    @Before
    public void setUpBrowser() {
        // First set up base URL Open and Driver SetUp
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void userShouldNavigateToLoginPageSuccessFully() {
        //find element for login link
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();
        String expectedText = "Welcome, Please Sign In!";
        //Actual Text from webElement via Locator
        WebElement welComeText = driver.findElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));

        //String actulText = welComeText.getText(); // Use directly with assert
        //Assert from JUnit Library
        Assert.assertEquals(expectedText, welComeText.getText());
        // Verify accepted and actual result
    }
    @Test
    public void userShoudNotLoginSuccessFully()
    {
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();

        // find elements for emailfield and type email
        WebElement emilField = driver.findElement(By.id("Email"));
        emilField.sendKeys("abc@gmail.com");

        //find elements for password field and type password
        WebElement passwordField = driver.findElement(By.id("Password"));
        passwordField.sendKeys("abc123");

        //find elements for loginbtn and click.
        WebElement loginBtn = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        loginBtn.submit();

        String expectedErrorMessage ="Welcome to our store";
        String actualErrorMessage = driver.findElement(By.xpath("//h2[contains(text(),'Welcome to our store')]")).getText();

        Assert.assertEquals(expectedErrorMessage,actualErrorMessage);

    }

    @After
        public void closeBrowser()
    {
        driver.quit();
    }

}
