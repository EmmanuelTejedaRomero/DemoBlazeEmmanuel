package stepsDefinition;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepsByDemoblaze {

	WebDriver driver;

	String newUser = new String();

	@Given("The user is already on principal Page")
	public void userAlreadyOnPrincipalPage() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.demoblaze.com/index.html");
	}

	@Then("The user clicks on the sign up enters the new username and password")
	public void theUserClicksOnTheSignUp() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("signin2")).click();
		Random random = new Random();
		newUser = "Emmanuel.rom" + random.nextInt();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("sign-username")).sendKeys(newUser);
		Thread.sleep(1000);
		driver.findElement(By.id("sign-password")).sendKeys("Rom920819");
	}

	@Then("user clicks on sign up button and accept alert")
	public void userClicksOnSignUpButton() throws InterruptedException {
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[3]/button[2]")).click();
		try {
		    WebDriverWait wait = new WebDriverWait(driver, 2);
		    wait.until(ExpectedConditions.alertIsPresent());
		    Alert alert = driver.switchTo().alert();
		    System.out.println(alert.getText());
		    alert.accept();
		} catch (Exception e) {
		    driver.quit();
		}
	}

	@Then("The user clicks on the log in button user enters username and password")
	public void theUserClicksOnTheLogInButton() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("login2")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("loginusername")).sendKeys(newUser);
		Thread.sleep(1000);
		driver.findElement(By.id("loginpassword")).sendKeys("Rom920819");
	}


	@Then("user clicks on login button")
	public void userClicksOnLoginButton() {
		driver.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/button[2]")).click();
		
	}

	@Then("The user clicks on LogOut boton")
	public void theUserClicksOnLogOutBoton() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.id("logout2")).click();
	}

	@Then("user cliks on laptops category")
	public void userCliksOnLaptopsCategory() {
		driver.findElement(By.id("itemc")).click();
	}

	@Then("user add laptop to cart")
	public void userAddLaptopToCart() {
		driver.findElement(By.linkText("Sony vaio i5")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/div[5]/div/div[2]/div[2]/div/a")).click();
	}

	@Then("validate that the laptop was added to the cart")
	public void validateThatTheLaptopWasAddedToTheCart() {
		driver.findElement(By.id("cartur")).click();
		Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[6]/div/div[1]/div/table/tbody/tr/td[2]")).getText(), "Sony vaio i5");
		driver.quit();
	}

}
