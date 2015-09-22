package me.MiniDigger.RideThaMob;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.plugin.java.JavaPlugin;

import me.MiniDigger.RideThaMob.cmd.CoreCommandHandler;
import me.MiniDigger.RideThaMob.cmd.api.CommandHandler;
import me.MiniDigger.RideThaMob.lang.Lang;
import me.MiniDigger.RideThaMob.lang.LangKey;
import me.MiniDigger.RideThaMob.nms.RideAbleEntityType;

public class RideThaMob extends JavaPlugin {
	private static RideThaMob INSTANCE;
	CommandHandler c;

	private Map<EntityType, Double> rideSpeeds = new HashMap<>();
	private Map<EntityType, Double> jumpHeights = new HashMap<>();
	private Map<EntityType, Float> sideMods = new HashMap<>();
	private Map<EntityType, Float> backMods = new HashMap<>();
	private Map<EntityType, Float> stepHeights = new HashMap<>();

	private EntityType[] rideAbleTypes = { EntityType.BAT, EntityType.BLAZE, EntityType.CAVE_SPIDER, EntityType.CHICKEN,
			EntityType.COW, EntityType.CREEPER, EntityType.ENDER_DRAGON, EntityType.ENDERMAN, EntityType.ENDERMITE,
			EntityType.GHAST, EntityType.GIANT, EntityType.GUARDIAN, EntityType.HORSE, EntityType.IRON_GOLEM,
			EntityType.MAGMA_CUBE, EntityType.MUSHROOM_COW, EntityType.OCELOT, EntityType.PIG, EntityType.PIG_ZOMBIE,
			EntityType.RABBIT, EntityType.SHEEP, EntityType.SILVERFISH, EntityType.SNOWBALL, EntityType.SPIDER,
			EntityType.SQUID, EntityType.VILLAGER, EntityType.WITCH, EntityType.WITHER, EntityType.WOLF,
			EntityType.ZOMBIE };

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

		loadConfig();
		fixEntities();

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

	public void fixEntities() {
		// replace ALL entites in the world with rideable ones
		// only if the user enables it
	}

	public void loadConfig() {
		saveDefaultConfig();
		// defaults
		rideSpeeds.put(EntityType.UNKNOWN, 0.2);
		jumpHeights.put(EntityType.UNKNOWN, 0.6);
		sideMods.put(EntityType.UNKNOWN, 0.5F);
		backMods.put(EntityType.UNKNOWN, 0.25F);
		stepHeights.put(EntityType.UNKNOWN, 1F);

		for (EntityType e : rideAbleTypes) {
			double rideSpeed = 0.2;
			double jumpHeight = 0.6;
			float sideMod = 0.5F;
			float backMod = 0.25F;
			float stepHeight = 1F;

			//load from config
			
			rideSpeeds.put(e, rideSpeed);
			jumpHeights.put(e, jumpHeight);
			sideMods.put(e, sideMod);
			backMods.put(e, backMod);
			stepHeights.put(e, stepHeight);
		}
	}

	public double getRideSpeed(EntityType e) {
		if (rideSpeeds.containsKey(e)) {
			return rideSpeeds.get(e);
		} else {
			return rideSpeeds.get(EntityType.UNKNOWN);
		}
	}

	public double getJumpHeight(EntityType e) {
		if (jumpHeights.containsKey(e)) {
			return jumpHeights.get(e);
		} else {
			return jumpHeights.get(EntityType.UNKNOWN);
		}
	}

	public boolean getFly(EntityType e) {
		return false;
	}

	public float getSidewaysMod(EntityType e) {
		if (sideMods.containsKey(e)) {
			return sideMods.get(e);
		} else {
			return sideMods.get(EntityType.UNKNOWN);
		}
	}

	public float getBackwardsMod(EntityType e) {
		if (backMods.containsKey(e)) {
			return backMods.get(e);
		} else {
			return backMods.get(EntityType.UNKNOWN);
		}
	}

	public float getStepHeight(EntityType e) {
		if (stepHeights.containsKey(e)) {
			return stepHeights.get(e);
		} else {
			return stepHeights.get(EntityType.UNKNOWN);
		}
	}
}
