package me.MiniDigger.RideThaMob;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;

import me.MiniDigger.Foundation.handler.command.CommandDescription;

public class RideThaMobCommands {
	@CommandDescription(name = "rtm", permission = "rtm", description = "Rides the nearest entity to your location", console = false)
	public void rtm(Player sender) {
		for (int i = 0; i < RideThaMob.getInstance().getConfig().getRtmRange(); i++) {
			for (Entity e : sender.getWorld().getNearbyEntities(sender.getLocation(), i, i, i)) {
				if (e.equals(sender)) {
					continue;
				}

				if (e.getType() == EntityType.PLAYER) {
					// skip for now till a proper permission system is added
					continue;
				}

				if (RideThaMob.getInstance().getConfig().isRideAble(e.getType())) {
					e.setPassenger(sender);
					Lang._(sender, LangKey.RIDE, e.getType().name());
					return;
				}
			}
		}
		Lang._(sender, LangKey.NO_NEAR);
	}

	@CommandDescription(name = "rtm.reload", permission = "rtm.reload", description = "Reloads the config")
	public void reload(CommandSender sender) {
		RideThaMob.getInstance().reloadConfig();
		RideThaMob.getInstance().setShouldUpdate();
		Lang._(sender, LangKey.CONFIG_RELOADED);
	}
	// TODO add cmd to spawn and ride a mob
}
