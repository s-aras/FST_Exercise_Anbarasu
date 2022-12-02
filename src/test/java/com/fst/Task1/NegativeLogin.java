package com.fst.Task1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class NegativeLogin {
	ChromeDriver driver;
	@Before
	public void Launchbrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	}
	@After
	public void Closebrowser() {
		driver.close();
	}
	@Test
	public void loginAcc() {
		driver.get("https://dev144331.service-now.com/login");
		
		WebElement LoginBtn = driver.findElement(By.name("not_important"));
		LoginBtn.click();
		WebElement Error = driver.findElement(By.xpath("//*[text()='Invalid input in user name!']"));
		 
		if(Error.isDisplayed())
		{
		System.out.println("Element found "+ Error);
		}
		WebElement username = driver.findElement(By.name("user_name"));
		username.sendKeys("admin");
		
		WebElement LoginBtn2 = driver.findElement(By.name("not_important"));
		LoginBtn2.click();
		WebElement passerror = driver.findElement(By.xpath("//*[text()='User name or password invalid. To reset your admin password click ']"));
		 
		if(passerror.isDisplayed())
		{
		System.out.println("Element found "+ passerror);
		}

}
}
