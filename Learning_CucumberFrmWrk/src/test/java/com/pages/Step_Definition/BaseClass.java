package com.pages.Step_Definition;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.pages.constants.Constants;
import com.pages.utilities.CommonUtils;

import io.cucumber.java.Before;

public class BaseClass {
	public static WebDriver driver;
	public static WebDriver driver1;
	public String browser = "chrome";
	public static String adminUsername = "SA";
	public static String adminPass = "Mes@123";
	public static String User = "SUSER-P";
	public static String pass = "Hpms@123";

	public static String newUser = "TESTUSR3";
	public static String newPass = "Hpms@123";
	public static String ChangePassHPmsUser = "TESTUSER2";
	public static String ChangePassHpmsPass = "Bemes@123";
	public static String previewOnlyUser = "TESTUSR";
	public static String PreviewOnlypass = "Hpms@1234";
	public static String URL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

	//@Before
	public void BaseClass() {
		CommonUtils commonUtils=new CommonUtils();
		commonUtils.loadProperties();
		if (driver == null) {
			if (browser.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", "D:\\drivers(C)\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
//				Map<String, Object> prefs = new HashMap<String, Object>();
//				prefs.put("profile.default_content_setting_values.notifications", 2);
//				prefs.put("credentials_enable_service", false);
//				prefs.put("profile.password_manager_enabled", false);
				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });

				options.addArguments("--start-maximized");
				options.addArguments("--disable-web-security");
				options.addArguments("--no-proxy-server");

				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("credentials_enable_service", false);
				prefs.put("profile.password_manager_enabled", false);

				options.setExperimentalOption("prefs", prefs);

//				options.setExperimentalOption("prefs", prefs);
//				options.addArguments("start-maximized");
//				
//				options.addArguments("--disable-extensions");
//				options.addArguments("--disable-notifications");
//				

				driver = new ChromeDriver(options);
			} else if (browser.equals("firefox")) {
				System.setProperty("webdriver.gecko.driver",
						"C:\\Users\\Administrator\\eclipse-workspace\\SimpleTest\\drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
			} else if (browser.equals("edge")) {
				System.setProperty("webdriver.edge.driver",
						"C:\\Users\\Administrator\\eclipse-workspace\\SimpleTest\\drivers\\msedgedriver.exe");
				driver = new EdgeDriver();
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.get(URL);
		}
	}

}
