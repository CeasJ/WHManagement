package com.QLK.test;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LMSLogin {
	public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\6. Kiem thu nang cao\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://lms.poly.edu.vn/login.php?target=&client_id=fpolyhn&auth_stat=");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@value='Google Sign in']")));
        Actions act = new Actions(driver);
        act.moveToElement(signInButton).click().perform();

        driver.findElement(By.id("identifierId")).sendKeys("kietltps25037@fpt.edu.vn");

        driver.findElement(By.id("identifierNext")).click();

        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
        passwordField.sendKeys("kietlai258");
        driver.findElement(By.id("passwordNext")).click();

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("LoginInfo");
        Row row = sheet.createRow(0);
        row.createCell(0).setCellValue("Username");
        row.createCell(1).setCellValue("Password");
        Row dataRow = sheet.createRow(1);
        dataRow.createCell(0).setCellValue("kietltps25037@fpt.edu.vn");
        dataRow.createCell(1).setCellValue("kietlai258");

        try {
            FileOutputStream fileOut = new FileOutputStream("D:\\6. Kiem thu nang cao\\Projects\\ASM\\login.xlsx");
            workbook.write(fileOut);
            fileOut.close();
            System.out.println("Thông tin đăng nhập đã được ghi vào file Excel.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
