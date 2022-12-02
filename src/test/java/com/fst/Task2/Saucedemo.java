package com.fst.Task2;


import java.util.concurrent.TimeUnit;
import org.apache.commons.logging.Log;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
public class Saucedemo {
    
    WebDriver driver;
    @Before
    public void browser_launch() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
    }
    @After
    public void browser_close() {
        driver.quit();
    }
    
    @Test
    public void test() {
        
        driver.get("https://www.saucedemo.com/");
        WebElement drop=driver.findElement(By.id("login-button"));
        WebDriverWait wait=new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOf(drop));
        String Expected_page_title = "Swag Labs";
        String actual_page_title = driver.getTitle();
        
        if(Expected_page_title.equals(actual_page_title)) {
            System.out.println("Title Verified");
        }
        else {
            System.out.println("Title Verification Failed");
        }
        Assert.assertEquals(Expected_page_title,actual_page_title);
        driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        
        Select drpdwn = new Select((driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/div[2]/span/select"))));
        WebElement opt=drpdwn.getFirstSelectedOption();
        String actual_value = opt.getText();
        System.out.println(actual_value);
        String expected_value="Name (A to Z)";
        Assert.assertEquals(expected_value,actual_value);
       
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
        
        String actual_cart = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]/a")).getText();
        String expected_cart = "1";
        try {
            Assert.assertEquals(expected_cart,actual_cart);
        }
        catch (Exception e) {
             Log error;
        }
        
        driver.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)")).click();
        String sec_actual_cart = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]/a")).getText();
        String sec_expected_cart = "2";
        Assert.assertEquals(sec_expected_cart,sec_actual_cart);
        
        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]/a")).click();
        driver.findElement(By.id("remove-sauce-labs-backpack")).click();
        driver.findElement(By.name("continue-shopping")).click();
        
        String After_removal = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]/a/span")).getText();
        Assert.assertEquals(expected_cart,After_removal);
        
        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]/a")).click();
        
        String cart_product = driver.findElement(By.cssSelector(".cart_quantity")).getText();
        if(cart_product.contains("1")) {
            System.out.println("Added Product is available");
        }
        else {
            System.out.println("Added Product is not available");
        }
        
        driver.findElement(By.name("continue-shopping")).click();
       
        Select drp = new Select((driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/div[2]/span/select"))));
        drp.selectByVisibleText("Price (low to high)");

        Select drp2 = new Select((driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/div[2]/span/select"))));
        WebElement opt2 = drp2.getFirstSelectedOption();
        String price_low_exp = "Price (low to high)";
        String price_low_act = opt2.getText();
        System.out.println(price_low_act);
        Assert.assertEquals(price_low_exp,price_low_act);       
        
    }
}
