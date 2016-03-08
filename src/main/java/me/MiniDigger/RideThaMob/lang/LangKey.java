package me.MiniDigger.RideThaMob.lang;

public enum LangKey {
	START("RideThaMob %0% by MiniDigger enabled."),
	LANG_LOADED(
			"%0% lang keys where loaded form the lang file, %1% could not be found and where replaced with the default values"),
	LANG_LOADED_DEFAULTS("Successfully imported the default language (en_US)"),
	LANG_NOT_LOADED("Could not load msgs.properties, trying to create new file"),
	LANG_DEFAULTS_NOT_LOADED("Could not import default language file: %0%"),
	LANG_DEFAULTS_NOT_CREATED("Could not create default language file: %0%"),
	RIDE("You are now riding %0%"),
	CONFIG_RELOADED("Config reloaded!"),
	NO_NEAR("There are no mobs that you can ride near you");
													
	private final String defaultValue;
	
	private LangKey(String defaultValue) {
		this.defaultValue = defaultValue;
	}
	
	public String getDefaultValue() {
		return defaultValue;
	}
}
