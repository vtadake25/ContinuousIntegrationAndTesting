package com.ecommerce.utilities;


import java.io.File;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	private static ExtentReports extent;
	
	public static ExtentReports getInstance() {
		
		if(extent == null)
		{
			extent = new ExtentReports("C:\\Users\\Vanita\\eclipse-workspace\\ecommerce\\target\\report\\html\\extent.html",true, DisplayOrder.OLDEST_FIRST);
			extent.loadConfig(new File("C:\\Users\\Vanita\\eclipse-workspace\\ecommerce\\src\\test\\resources\\extentconfig\\ReportsConfig.xml"));
		}
		return extent;
	}

}
