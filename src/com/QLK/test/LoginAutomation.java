package com.QLK.test;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoginAutomation {

	public String baseUrl = "https://ap.poly.edu.vn/login";
	String driverPath = "D:\\6. Kiem thu nang cao\\chromedriver.exe";
	public WebDriver driver;

	@BeforeTest
	public void launchBrowser() {
		System.out.println("launching chrome browser");
		System.setProperty("webdriver.chrome.driver", driverPath);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get(baseUrl);
	}

	@Test
	public void verifyHomepageTitle() {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		driver.findElement(By.id("identifierId")).sendKeys("kietltps25037@fpt.edu.vn");
		driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button")).click();

		driver.findElement(By.name("password")).sendKeys("kietlai258");
		driver.findElement(By.id("passwordNext")).click();

	}
}

