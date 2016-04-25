package com.adayroi.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Custom {

	/**
	 * 
	 * @param driver
	 * @param locator
	 * @param second
	 * @return
	 */
	public static boolean waitElementDisplay(WebDriver driver, By locator, int second) {
		boolean result = false;
//		long start = System.currentTimeMillis();
//		System.out.println("Start : " + System.currentTimeMillis());
		int i = 0;
		while(i < second){
			try{
				driver.findElement(locator);
				result = true;
//				long end = System.currentTimeMillis();
//				System.out.println("End : " + System.currentTimeMillis());
//				System.out.println("Total : " + (start - end));
				break;
			} catch(Exception ex){
			}
			try {
				Thread.sleep(1000);
				i++;
			} catch (Exception e) {
			
			}
		}
		return result;
	}
}