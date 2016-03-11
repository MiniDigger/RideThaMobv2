package me.MiniDigger.RideThaMob.lang;

import java.util.ArrayList;
import java.util.List;

import me.MiniDigger.Foundation.handler.lang.LangKey;
import me.MiniDigger.Foundation.handler.lang.LangKeyProvider;

public class RTMLangKey extends LangKeyProvider {
	public static final String NAME = "foundation";

	public static final LangKey START = new LangKey(NAME, "start", "RideThaMob %0% by MiniDigger enabled.");
	public static final LangKey LANG_LOADED = new LangKey(NAME, "lang_loaded",
			"%0% lang keys where loaded form the lang file, %1% could not be found and where replaced with the default values");
	public static final LangKey LANG_LOADED_DEFAULTS = new LangKey(NAME, "lang_loaded_defaults",
			"Successfully imported the default language (en_US)");
	public static final LangKey LANG_NOT_LOADED = new LangKey(NAME, "lang_not_loaded",
			"Could not load msgs.properties, trying to create new file");
	public static final LangKey LANG_DEFAULTS_NOT_LOADED = new LangKey(NAME, "lang_defaults_not_loaded",
			"Could not import default language file: %0%");
	public static final LangKey LANG_DEFAULTS_NOT_CREATED = new LangKey(NAME, "lang_defaults_not_created",
			"Could not create default language file: %0%");
	public static final LangKey RIDE = new LangKey(NAME, "ride", "You are now riding %0%");
	public static final LangKey CONFIG_RELOADED = new LangKey(NAME, "config_reloaded", "Config reloaded!");
	public static final LangKey NO_NEAR = new LangKey(NAME, "no_near", "There are no mobs that you can ride near you");

	public List<LangKey> values() {
		final List<LangKey> result = new ArrayList<LangKey>();

		result.add(START);
		result.add(LANG_LOADED);
		result.add(LANG_LOADED_DEFAULTS);
		result.add(LANG_NOT_LOADED);
		result.add(LANG_DEFAULTS_NOT_LOADED);
		result.add(LANG_DEFAULTS_NOT_CREATED);
		result.add(RIDE);
		result.add(CONFIG_RELOADED);
		result.add(NO_NEAR);

		return result;
	}
}
