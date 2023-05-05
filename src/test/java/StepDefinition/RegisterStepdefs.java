package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class RegisterStepdefs {
    WebDriver driver;
    @Given("Base url is provided")
    public void baseUrlIsProvided() {
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();
        Map<String, Object> profile = new HashMap<String, Object>();
        Map<String, Integer> contentSettings = new HashMap<String, Integer>();

        // SET CHROME OPTIONS
        // 0 - Default, 1 - Allow, 2 - Block
        contentSettings.put("notifications", 2);
        contentSettings.put("geolocation", 2);
        profile.put("managed_default_content_settings", contentSettings);
        prefs.put("profile", profile);
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--remote-allow-origins=*");//
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);

        driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
        driver.manage().window().maximize();
        //
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);  //

    }

    @When("user {string} and {string} and {string}")
    public void userFirstNameAndLastNameAndEmail(String firstName, String lastName, String email) throws InterruptedException {
        Thread.sleep(4000);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,500)");
        Thread.sleep(4000);
        driver.findElement(By.xpath("//label[text()=\"First Name \"]/following-sibling::input[@name=\"name\"][1]")).sendKeys(firstName);
        Thread.sleep(4000);
        driver.findElement(By.xpath("//label[text()=\"Last Name\"]/following-sibling::input[@name=\"name\"]")).sendKeys(lastName);
        Thread.sleep(4000);
        driver.findElement(By.xpath("//label[text()=\"Email\"]/following-sibling::input[@type=\"text\"]")).sendKeys(email);
        Thread.sleep(4000);


    }

    @And("enter {string} and {string}")
    public void enterPasswordAndRepeatPassword(String password, String repeatPassword) throws InterruptedException {
        driver.findElement(By.xpath("//label[text()=\"Password\"]/following::input[@type=\"password\"][1]")).sendKeys(password);
        Thread.sleep(4000);
        driver.findElement(By.xpath("//label[text()=\"Repeat Password\"]/following-sibling::input[@type=\"password\"]")).sendKeys(repeatPassword);
        Thread.sleep(4000);


    }

    @And("click Register")
    public void clickRegister() {
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

    }

    @Then("user login home page")
    public void userLoginHomePage() {
    }
}
