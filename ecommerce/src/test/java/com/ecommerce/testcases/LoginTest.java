package com.ecommerce.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.ecommerce.base.TestBase;

public class LoginTest extends TestBase{
	
	@Test
	public void Login() throws InterruptedException {
		log.debug("inside log in test");
		driver.findElement(By.xpath(OR.getProperty("loginButton"))).click();
		Thread.sleep(3000);
		log.debug("finished successfully");
		
	}

}
