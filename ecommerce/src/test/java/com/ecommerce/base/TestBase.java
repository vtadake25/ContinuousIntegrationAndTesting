package com.ecommerce.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.ecommerce.base.TestBase;
import com.ecommerce.utilities.ExtentManager;
//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;


public class TestBase {
	
	
	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger(TestBase.class);
	public static String browser;
	public static WebDriverWait wait;
//	public ExtentReports repo = ExtentManager.getInstance();
//	public static ExtentTest test;

	
	@BeforeSuite
	public void setUp()
	{
		try {
			fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			config.load(fis);
			log.debug("Config file loaded !!!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			OR.load(fis);
			log.debug("OR file loaded !!!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(System.getenv("browser")!=null && !System.getenv("browser").isEmpty()){
			
			browser = System.getenv("browser");
		}else{
			
			browser = config.getProperty("browser");
			
		}
		
		config.setProperty("browser", browser);
		
		
		

		if (config.getProperty("browser").equals("firefox")) {

//			 System.setProperty("webdriver.gecko.driver", "C:\\Users\\Vanita\\eclipse-workspace\\ecommerce\\src\\test\\resources\\executables\\geckodriver.exe");
			 System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\geckodriver.exe");
//			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (config.getProperty("browser").equals("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
			
//			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			log.debug("Chrome Launched !!!");
		} else if (config.getProperty("browser").equals("ie")) {

			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();

		}

		driver.get(config.getProperty("testsiteurl"));
		log.debug("Navigated to : " + config.getProperty("testsiteurl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),
				TimeUnit.SECONDS);
//		wait = new WebDriverWait(driver, 5);
	
		
	}
	
	@AfterSuite
	private void tearDown() {
		// TODO Auto-generated method stub
		if(driver != null)
		{
			driver.quit();
		}

	}

}
