package com.pages.utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.invoke.ConstantBootstraps;
import java.util.Properties;

import com.pages.constants.Constants;

public class CommonUtils {
	public void loadProperties() {
		
		Properties properties= new Properties();
		try {
			properties.load(getClass().getResourceAsStream("/config.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Constants.App_URL= properties.getProperty("App_URL");
		Constants.User=properties.getProperty("User");
		Constants.Pass=properties.getProperty("Pass");
	}
}
