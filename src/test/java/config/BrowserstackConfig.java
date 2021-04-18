package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/browserstack.properties")
public interface BrowserstackConfig extends Config {

	@Config.Key("browserstack.user")
	String browserstackUser();

	@Config.Key("browserstack.key")
	String browserstackKey();
}
