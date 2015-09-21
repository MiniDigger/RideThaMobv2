package me.MiniDigger.RideThaMob.lang;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import me.MiniDigger.RideThaMob.RideThaMob;
import me.MiniDigger.RideThaMob.lib.mkremins.fanciful.FancyMessage;

public class LangHandler {
	private static LangHandler INSTANCE;
	private static final FancyMessage PREFIX = new FancyMessage("[").color(ChatColor.BLUE).then("RTM")
			.tooltip("Made by MiniDigger", "admin@minidigger.me").color(ChatColor.GOLD).then("] ");

	private Map<LangKey, String> loaded;

	public void load() {
		loaded = new HashMap<>();

		List<String> lines = new ArrayList<>();
		try {
			lines = Files.readAllLines(
					Paths.get(new File(RideThaMob.getInstance().getDataFolder().getAbsoluteFile(), "msgs.properties")
							.getAbsolutePath()),
					Charset.defaultCharset());
		} catch (IOException e) {
			Lang._(LangKey.LANG_NOT_LOADED);
			File f = new File(RideThaMob.getInstance().getDataFolder().getAbsoluteFile(), "msgs.properties");
			try {
				f.createNewFile();

				ClassLoader cl = this.getClass().getClassLoader();
				InputStream is = cl.getResourceAsStream("msgs.properties");

				Scanner scanner = new Scanner(is);
				PrintWriter out = new PrintWriter(f);

				while (scanner.hasNext()) {
					out.println(scanner.nextLine());
				}

				try {
					scanner.close();
					out.close();
					is.close();
				} catch (Exception ex) {

				}

				Lang._(LangKey.LANG_LOADED_DEFAULTS);

				try {
					lines = Files.readAllLines(
							Paths.get(new File(RideThaMob.getInstance().getDataFolder().getAbsoluteFile(), "lang.yml")
									.getAbsolutePath()),
							Charset.defaultCharset());
				} catch (IOException ex) {
					Lang._(LangKey.LANG_DEFAULTS_NOT_LOADED, ex.getMessage());
				}
			} catch (IOException e1) {
				Lang._(LangKey.LANG_DEFAULTS_NOT_CREATED, e1.getMessage());
			}
		}

		int keys = 0;
		int defaults = 0;
		for (LangKey key : LangKey.values()) {
			for (String s : lines) {
				if (s.contains(key.name())) {
					String r = s.replaceFirst(key.name() + " = ", "");
					r = r.replaceAll("\"", "");
					loaded.put(key, r);
					keys++;
					continue;
				}
			}
			loaded.put(key, key.getDefaultValue());
			defaults++;
		}

		Lang._(Bukkit.getConsoleSender(), LangKey.LANG_LOADED, keys + "", defaults + "");
	}

	public static LangHandler getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new LangHandler();
		}
		return INSTANCE;
	}

	public String getJson(LangKey key) {
		if (loaded.containsKey(key)) {
			return loaded.get(key);
		} else {
			return key.getDefaultValue();
		}
	}

	public FancyMessage getPrefix() {
		return PREFIX;
	}
}
