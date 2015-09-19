package me.MiniDigger.RideThaMob;

import org.bukkit.plugin.java.JavaPlugin;

public class RideThaMob extends JavaPlugin {
	private static RideThaMob INSTANCE;

	@Override
	public void onLoad() {
		INSTANCE = this;
	}

	@Override
	public void onEnable() {
		
		
		getServer().getPluginManager().registerEvents(new RideThaMobListener(), this);
	}

	public static RideThaMob getInstance() {
		return INSTANCE;
	}
}
