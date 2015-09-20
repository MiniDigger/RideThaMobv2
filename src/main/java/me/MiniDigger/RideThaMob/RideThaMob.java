package me.MiniDigger.RideThaMob;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.MiniDigger.RideThaMob.lang.Lang;
import me.MiniDigger.RideThaMob.lang.LangKey;
import me.MiniDigger.RideThaMob.nms.RideAbleEntityType;

public class RideThaMob extends JavaPlugin {
	private static RideThaMob INSTANCE;

	@Override
	public void onLoad() {
		INSTANCE = this;
	}

	@Override
	public void onEnable() {
		RideAbleEntityType.registerEntities();

		getServer().getPluginManager().registerEvents(new RideThaMobListener(), this);

		Lang._(Bukkit.getConsoleSender(), LangKey.START);
	}

	public static RideThaMob getInstance() {
		return INSTANCE;
	}
}
