package com.Account;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * DOCME
 * 
 * @Creator Hai Lu
 * @author $Author$
 * @version $Revision$
 * @Last changed: $LastChangedDate$
 */

public class PropertiesHelper {
	public static final String DEFAULT_PROPERTIES = "system.properties";

	private static Properties prod;

	
	public static Properties getProperties() {
		if (prod == null) {
			prod = new Properties();
			try {
//				prod.load(PropertiesHelper.class.getClassLoader().getResourceAsStream(DEFAULT_PROPERTIES));
				prod.load(new FileInputStream(System.getProperty("user.dir") + File.separator + "config" + File.separator + DEFAULT_PROPERTIES));
			} catch (IOException e) {
				//
			}
		}
		return prod;
	}

	public static String getKey(String key) {
		String value = "";
		try {
			Object obj = getProperties().get(key);
			if (obj != null) {
				value = obj.toString();
			}
		} catch (Exception e) {

		}
		return value;
	}
}
