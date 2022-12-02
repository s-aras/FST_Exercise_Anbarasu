package com.fst.Task1;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {
	ChromeDriver driver;
	@Before
	public void browserLaunch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	@After
	public void browserClose() {
		driver.close();
	}
	@Test
	public void loginAcc() throws Exception {
		driver.get("https://dev144331.service-now.com/login");
		
		WebElement username = driver.findElement(By.name("user_name"));
		username.sendKeys("admin");
		WebElement userlabel = driver.findElement(By.xpath("//*[text()='User name']"));
		 
		if(userlabel.isDisplayed())
		{
		System.out.println("USername Label found  ");
		}
	
		WebElement password = driver.findElement(By.name("user_password"));
		password.sendKeys("pIA+v+8SZ6pm");
		WebElement passlabel = driver.findElement(By.xpath("//*[text()='Password']"));
		 
		if(passlabel.isDisplayed())
		{
		System.out.println("Password Label found ");
		}
		
		WebElement fogotpasslabel = driver.findElement(By.xpath("//*[text()='Forgot Password ?']"));
		 
		if(fogotpasslabel.isDisplayed())
		{
		System.out.println("Forgot password Label found ");
		}
		
	
		WebElement LoginBtn = driver.findElement(By.name("not_important"));
		LoginBtn.click();
		
		Thread.sleep(10000);
		String servicetitle = driver.getTitle();
		String actual="ServiceNow";
		
		if(servicetitle.equals(actual));
		{
			System.out.println(actual+"Expected Title Is Equal to actual "+ servicetitle);
		}
		}
	
		
	
		
	}
	
	

