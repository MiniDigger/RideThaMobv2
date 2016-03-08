package me.MiniDigger.RideThaMob;

import me.MiniDigger.RideThaMob.cmd.api.*;
import me.MiniDigger.RideThaMob.lang.*;

import org.bukkit.entity.*;

public class RideThaMobCommands {
	@Command(name = "rtm", consol = false)
	public void rtm(final CommandArgs args) {
		for (int i = 0; i < RideThaMob.getInstance().getRtmRange(); i++) {
			for (Entity e : args.getPlayer().getWorld().getNearbyEntities(args.getPlayer().getLocation(), i, i, i)) {
				if (e.equals(args.getPlayer())) {
					continue;
				}
				
				if (e.getType() == EntityType.PLAYER) {
					// skip for now till a proper permission system is added
					continue;
				}
				
				if (RideThaMob.getInstance().isRideAble(e.getType())) {
					e.setPassenger(args.getPlayer());
					Lang._(args.getSender(), LangKey.RIDE, e.getType().name());
					return;
				}
			}
		}
		Lang._(args.getSender(), LangKey.NO_NEAR);
	}
	
	@Command(name = "rtm.reload", permission = "rtm.reload", description = "Reloads the config")
	public void reload(final CommandArgs args) {
		RideThaMob.getInstance().reloadConfig();
		RideThaMob.getInstance().setShouldUpdate();
		Lang._(args.getSender(), LangKey.CONFIG_RELOADED);
	}
	
	// TODO add cmd to spawn and ride a mob
}
