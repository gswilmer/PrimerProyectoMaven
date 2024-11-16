package EjemploConTestNG;

import java.io.IOException;
import java.time.Duration;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class EjemploTestNGConBasePage extends BasePage{
	
	WebDriver driver;
	
	@BeforeSuite
	public void antesDeEjecutar() throws IOException {
		driver = getDriver();
		driver.get(getUrl());
	}

	@Parameters({"email", "password"})
	@Test
	public void signInTestStore(String email, String password) throws IOException {
		driver.findElement(By.id("_desktop_user_info")).click();
		
		//WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("input#field-email")));
		driver.findElement(By.cssSelector("input#field-email")).sendKeys(email);
		driver.findElement(By.cssSelector("input#field-password")).sendKeys(password);
		driver.findElement(By.id("submit-login")).click();
		
		WebElement userNameLogin = driver.findElement(By.cssSelector("[title] .hidden-sm-down"));
		Assert.assertEquals(userNameLogin.getText(), "Wilberto Gomez");

		WebElement productosPopulares = driver
				.findElement(By.cssSelector("#content section:nth-child(2) .products-section-title"));
		Assert.assertEquals(productosPopulares.getText(), "POPULAR PRODUCTS");
		
	}
	
	@AfterSuite
	public void finalizarPrueba() {
		driver.close();
		driver.quit();
	}

}
