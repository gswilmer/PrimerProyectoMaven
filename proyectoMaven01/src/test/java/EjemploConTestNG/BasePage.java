package EjemploConTestNG;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {

	public static WebDriver driver;
	private String url;

	public WebDriver getDriver() throws IOException {
		Properties prop = new Properties();
		FileInputStream data = new FileInputStream(
				"C:\\Tools\\Curso Automatizacion\\My_work-space\\MiProyecto\\src\\resources\\config.properties");
		prop.load(data);

		if (prop.getProperty("browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Tools\\Curso Automatizacion\\Dependecias\\chromedriver-win64\\chromedriver_131.exe");
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		return driver;
	}
	
	public String getUrl() throws IOException {
		Properties prop = new Properties();
		FileInputStream data = new FileInputStream(
				"C:\\Tools\\Curso Automatizacion\\My_work-space\\MiProyecto\\src\\resources\\config.properties");
		prop.load(data);
		url = prop.getProperty("url");
		return url;
	}
	

}
