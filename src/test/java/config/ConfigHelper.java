package config;

import org.aeonbits.owner.ConfigFactory;


public class ConfigHelper {

	private static BrowserstackConfig getBrowserstackConfig() {
		return ConfigFactory.newInstance().create(BrowserstackConfig.class, System.getProperties());
	}

	public static String getBrowserstackUser() {
		return getBrowserstackConfig().browserstackUser();
	}

	public static String getBrowserstackKey() {
		return getBrowserstackConfig().browserstackKey();
	}
}
