package me.MiniDigger.RideThaMob;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import me.MiniDigger.RideThaMob.cmd.CoreCommandHandler;
import me.MiniDigger.RideThaMob.cmd.api.CommandHandler;
import me.MiniDigger.RideThaMob.lang.Lang;
import me.MiniDigger.RideThaMob.lang.LangKey;
import me.MiniDigger.RideThaMob.nms.RideAbleEntityType;

public class RideThaMob extends JavaPlugin {
	private static RideThaMob INSTANCE;
	CommandHandler c;

	@Override
	public void onLoad() {
		INSTANCE = this;
	}

	@Override
	public void onEnable() {
		c = new CoreCommandHandler(null);
		c.registerCommands(new RideThaMobCommands());
		c.registerHelp();

		RideAbleEntityType.registerEntities();

		getServer().getPluginManager().registerEvents(new RideThaMobListener(), this);

		Lang._(Bukkit.getConsoleSender(), LangKey.START);
	}

	@Override
	public void onDisable() {
		c.unregisterCommands(new RideThaMobCommands());
	}

	public static RideThaMob getInstance() {
		return INSTANCE;
	}

	@Override
	public boolean onCommand(final CommandSender sender, final org.bukkit.command.Command command, final String label,
			final String[] args) {
		return c.handleCommand(sender, label, command, args);
	}
}
