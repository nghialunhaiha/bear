package com.Account;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class TakeScreenShot {
	private static WebDriver driver;
	public static final String PROP_PROJECT_BUILD_DIR = "project.build.directory";
	public static final String TEST_PACKAGE = "test.package";
	private static Date date = new Date();
	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

	public static void init(WebDriver d) {
		driver = d;
	}

	public static File takeSnapShotPass(String methodName) throws Exception {
		try {
			String folderBaseDriver = "Pass";
			System.out.println(folderBaseDriver);
			String screenshootDir = PropertiesHelper.getKey(PROP_PROJECT_BUILD_DIR) + File.separator + "screenshots" + File.separator + simpleDateFormat.format(date) + File.separator + folderBaseDriver;
			System.out.println("screenshootDir : " + screenshootDir);
			File f = new File(screenshootDir);
			if (!f.exists() || !f.isDirectory()) {
				f.mkdirs();
			}
			File output = null;
			File file = null;
			/*
			 * if (folderBaseDriver.equalsIgnoreCase("Internet Explore")) { ScreenRegion s = new DesktopScreenRegion(); try { ImageIO.write(s.capture(), "png", file = new File(screenshootDir + File.separator + methodName + ".png")); } catch
			 * (IOException e) { e.printStackTrace(); } }else{
			 */
			output = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			file = new File(screenshootDir, methodName + ".png");
			try {
				FileUtils.copyFile(output, file);
			} catch (IOException e) {
				e.printStackTrace();
			}
			// }
			System.out.println(file.getAbsolutePath());
			return file;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public static File takeSnapShot(String methodName) throws Exception {
		try {
			String folderBaseDriver = null;
			if (driver instanceof InternetExplorerDriver) {
				folderBaseDriver = "ie";
			} else if (driver instanceof ChromeDriver) {
				folderBaseDriver = "chrome";
			} else if (driver instanceof FirefoxDriver) {
				folderBaseDriver = "firefox";
			} else if(driver instanceof SafariDriver) {
				folderBaseDriver = "safari";
			} else{
				folderBaseDriver = "app";
			}
			System.out.println(folderBaseDriver);
			String screenshootDir = PropertiesHelper.getKey(PROP_PROJECT_BUILD_DIR) + File.separator + "screenshots" + File.separator + simpleDateFormat.format(date) + File.separator + folderBaseDriver;
			System.out.println("screenshootDir : " + screenshootDir);
			File f = new File(screenshootDir);
			if (!f.exists() || !f.isDirectory()) {
				f.mkdirs();
			}
			File output = null;
			File file = null;
			/*
			 * if (folderBaseDriver.equalsIgnoreCase("Internet Explore")) { ScreenRegion s = new DesktopScreenRegion(); try { ImageIO.write(s.capture(), "png", file = new File(screenshootDir + File.separator + methodName + ".png")); } catch
			 * (IOException e) { e.printStackTrace(); } }else{
			 */
			output = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			file = new File(screenshootDir, methodName + ".png");
			try {
				FileUtils.copyFile(output, file);
			} catch (IOException e) {
				e.printStackTrace();
			}
			// }
			return file;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public static File takeSnapShot(String methodName, WebDriver driver) throws Exception {
		try {
			String folderBaseDriver = null;
			if (driver instanceof InternetExplorerDriver) {
				folderBaseDriver = "ie";
			} else if (driver instanceof ChromeDriver) {
				folderBaseDriver = "chrome";
			} else if (driver instanceof FirefoxDriver) {
				folderBaseDriver = "firefox";
			} else if(driver instanceof SafariDriver) {
				folderBaseDriver = "safari";
			} else{
				folderBaseDriver = "app";
			}
			System.out.println(folderBaseDriver);
			String screenshootDir = PropertiesHelper.getKey(PROP_PROJECT_BUILD_DIR) + File.separator + "screenshots" + File.separator + simpleDateFormat.format(date) + File.separator + folderBaseDriver;
			System.out.println("screenshootDir : " + screenshootDir);
			File f = new File(screenshootDir);
			if (!f.exists() || !f.isDirectory()) {
				f.mkdirs();
			}
			File output = null;
			File file = null;
			/*
			 * if (folderBaseDriver.equalsIgnoreCase("Internet Explore")) { ScreenRegion s = new DesktopScreenRegion(); try { ImageIO.write(s.capture(), "png", file = new File(screenshootDir + File.separator + methodName + ".png")); } catch
			 * (IOException e) { e.printStackTrace(); } }else{
			 */
			output = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			file = new File(screenshootDir, methodName + ".png");
			try {
				FileUtils.copyFile(output, file);
			} catch (IOException e) {
				e.printStackTrace();
			}
			// }
			return file;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
