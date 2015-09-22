package me.MiniDigger.RideThaMob;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

import me.MiniDigger.RideThaMob.cmd.api.Command;
import me.MiniDigger.RideThaMob.cmd.api.CommandArgs;

public class RideThaMobCommands {
	@Command(name = "rtm")
	public void rtm(final CommandArgs args) {
		for (Entity e : args.getPlayer().getWorld().getNearbyEntities(args.getPlayer().getLocation(), 10, 10, 10)) {
			if (e.getType() == EntityType.SKELETON) {
				e.setPassenger(args.getPlayer());
				break;
			}
		}
	}
}
