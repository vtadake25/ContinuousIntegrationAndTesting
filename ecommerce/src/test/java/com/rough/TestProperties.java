package com.rough;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {

	
	public static void main(String[] args) throws IOException {
		Properties config = new Properties();
		Properties or = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\Vanita\\eclipse-workspace\\ecommerce\\src\\test\\resources\\properties\\Config.properties");
		config.load(fis);
		System.out.println(config.getProperty("browser"));
		fis=new FileInputStream("C:\\Users\\Vanita\\eclipse-workspace\\ecommerce\\src\\test\\resources\\properties\\OR.properties");
		or.load(fis);
		System.out.println(or.getProperty("loginButton"));
	}
}
