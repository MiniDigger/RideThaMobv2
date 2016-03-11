package me.MiniDigger.RideThaMob.lang;

import java.util.ArrayList;
import java.util.List;

import me.MiniDigger.Foundation.handler.lang.LangKey;
import me.MiniDigger.Foundation.handler.lang.LangKeyProvider;

public class RTMLangKey extends LangKeyProvider {
	public static final String NAME = "ridethamob";

	public static final LangKey RIDE = new LangKey(NAME, "ride", "You are now riding %0%");
	public static final LangKey CONFIG_RELOADED = new LangKey(NAME, "config_reloaded", "Config reloaded!");
	public static final LangKey NO_NEAR = new LangKey(NAME, "no_near", "There are no mobs that you can ride near you");

	@Override
	public List<LangKey> values() {
		final List<LangKey> result = new ArrayList<LangKey>();

		result.add(RIDE);
		result.add(CONFIG_RELOADED);
		result.add(NO_NEAR);

		return result;
	}
}
