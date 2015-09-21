package me.MiniDigger.RideThaMob.lang;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

import me.MiniDigger.RideThaMob.lib.mkremins.fanciful.FancyMessage;

public class Lang {

	private static FancyMessage translate(LangKey key, String... args) {
		String json = LangHandler.getInstance().getJson(key);
		for (int i = 0; i < args.length; i++) {
			json = json.replace("%" + i + "%", args[i]);
		}
		return FancyMessage.deserialize(json);
	}

	public static void _(CommandSender s, LangKey key, String... args) {
		translate(key, args).send(s);
	}

	public static void _(LangKey key, String... args) {
		translate(key, args).send(Bukkit.getConsoleSender());
	}

}
