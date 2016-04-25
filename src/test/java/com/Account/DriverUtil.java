package com.Account;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverUtil {
	public static final String PROP_PROJECT_BASE_DIR = "project.basedir";
	public static final String FOLDER_DRIVER = "resources\\driver";
	public static final String FOLDER_CONSOLE_APP = "resources\\console-app";
	private static WebDriver driverFF;
	private static WebDriver driverIE;
	private static WebDriver driverChrome;
	private static WebDriver driverSafari;
	public static RemoteWebDriver driverMobileApp;
	public static String browserRunning;

	public static WebDriver driverCurrent;

	public static String getIeDriver() {
		String path = PropertiesHelper.getKey(PROP_PROJECT_BASE_DIR) + File.separator + FOLDER_DRIVER + File.separator + "IEDriverServer-bak.exe";
		try {
			File driverIe = new File(path);
			if (driverIe.exists()) {
				return driverIe.getAbsolutePath();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}

	public static String getChromeDriver() {
		String path = PropertiesHelper.getKey(PROP_PROJECT_BASE_DIR) + File.separator + FOLDER_DRIVER + File.separator + "chromedriver.exe";
		System.out.println(path);
		try {
			File driverChrome = new File(path);
			if (driverChrome.exists()) {
				return driverChrome.getAbsolutePath();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String getChromeDriverForMAC() {
		String path = PropertiesHelper.getKey(PROP_PROJECT_BASE_DIR) + File.separator + FOLDER_DRIVER + File.separator + "chromedriver";
		try {
			File driverChrome = new File(path);
			if (driverChrome.exists()) {
				return driverChrome.getAbsolutePath();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}

	public static WebDriver getInstance(String browser) {
		Constant.currentPlatform = "web";
		if (browser.equalsIgnoreCase("firefox")) {
			try {
				driverFF = null;
				/*
				 * File pathToBinary = new File("C:\\Users\\lantb\\AppData\\Local\\Mozilla Firefox\\firefox.exe"); FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
				 */
				FirefoxProfile profile = new FirefoxProfile();
				profile.setAcceptUntrustedCertificates(true);
				profile.setPreference(FirefoxProfile.PORT_PREFERENCE, 7056);
				driverFF = new FirefoxDriver(profile);
				driverFF.manage().deleteAllCookies();
			} catch (WebDriverException e) {
			}
			driverFF.manage().timeouts().pageLoadTimeout(Constant.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			browserRunning = browser;
			driverFF.manage().window().maximize();
			TakeScreenShot.init(driverFF);
			return driverFF;
		} else if (browser.equalsIgnoreCase("chrome")) {
			driverChrome = null;
			System.setProperty("webdriver.chrome.driver", DriverUtil.getChromeDriver());
			DesiredCapabilities capability = DesiredCapabilities.chrome();
			capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			driverChrome = new ChromeDriver(capability);
			driverChrome.manage().timeouts().pageLoadTimeout(Constant.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			browserRunning = browser;
			driverChrome.manage().deleteAllCookies();
			driverChrome.manage().window().maximize();
			TakeScreenShot.init(driverChrome);
			return driverChrome;
		} else if (browser.equalsIgnoreCase("ie")) {
			driverIE = null;
			System.setProperty("webdriver.ie.driver", DriverUtil.getIeDriver());
			DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
			caps.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
			caps.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
			caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			driverIE = new InternetExplorerDriver(caps);
			driverIE.manage().deleteAllCookies();
			driverIE.manage().timeouts().pageLoadTimeout(Constant.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			browserRunning = browser;
			driverIE.manage().window().maximize();
			TakeScreenShot.init(driverIE);
			return driverIE;
		} else if (browser.equalsIgnoreCase("safari")) {
			driverSafari = new SafariDriver();
			browserRunning = browser;
			TakeScreenShot.init(driverSafari);
			return driverSafari;
		}

		return null;

	}

	public static WebDriver getInstanceForMAC(String browser) {
		Constant.currentPlatform = "web";
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", DriverUtil.getChromeDriverForMAC());
			driverChrome = new ChromeDriver();
			driverChrome.manage().timeouts().pageLoadTimeout(Constant.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			browserRunning = browser;
			driverChrome.manage().deleteAllCookies();
			driverChrome.manage().window().maximize();
			TakeScreenShot.init(driverChrome);
			return driverChrome;
		}
		if (browser.equalsIgnoreCase("safari")) {
			driverSafari = new SafariDriver();
			browserRunning = browser;
			TakeScreenShot.init(driverSafari);
			return driverSafari;
		}
		return null;
	}

	// create over-load method for initialize specific userAgent
//	public static WebDriver getInstanceMobile(String browser, String userAgent) {
//		Constant.currentPlatform = "web";
//		if (browser.equalsIgnoreCase("chrome")) {
//			ChromeOptions co = new ChromeOptions();
//			co.addArguments("--user-agent=" + userAgent);
//
//			DesiredCapabilities cap = DesiredCapabilities.chrome();
//			cap.setCapability(ChromeOptions.CAPABILITY, co);
//
//			// set executable file
//			System.setProperty("webdriver.chrome.driver", DriverUtil.getChromeDriver());
//			browserRunning = browser;
//
//			driverChrome = new ChromeDriver(cap);
//			driverChrome.manage().timeouts().pageLoadTimeout(Constant.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//			driverChrome.manage().deleteAllCookies();
//			driverChrome.manage().window().setSize(UserAgent.Iphone6Plus_Dimension);
//			TakeScreenShot.init(driverChrome);
//			return driverChrome;
//		}
//		return null;
//	}

	public static WebDriver getCurrentDriver() {
		if ("firefox".equals(browserRunning)) {
			return driverFF;
		} else if ("chrome".equals(browserRunning)) {
			return driverChrome;
		} else if ("ie".equals(browserRunning)) {
			return driverIE;
		} else if ("safari".equals(browserRunning)) {
			return driverSafari;
		} else if ("mobile_app".equals(browserRunning)) {
			return driverMobileApp;
		} else {
			return null;
		}

	}
}

