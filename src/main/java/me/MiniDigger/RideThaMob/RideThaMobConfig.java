package me.MiniDigger.RideThaMob;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ArrayUtils;
import org.bukkit.entity.EntityType;

import me.MiniDigger.Foundation.handler.config.Config;
import me.MiniDigger.Foundation.handler.config.ConfigHandler;
import me.MiniDigger.Foundation.handler.config.ConfigList;
import me.MiniDigger.Foundation.handler.config.Storeable;
import me.MiniDigger.RideThaMob.config.RideThaMobConfigObj;

public class RideThaMobConfig extends Config {
	@Storeable
	@ConfigList(clazz = RideThaMobConfigObj.class)
	List<RideThaMobConfigObj> obj;

	private Map<EntityType, Double> rideSpeeds = new HashMap<>();
	private Map<EntityType, Double> jumpHeights = new HashMap<>();
	private Map<EntityType, Float> sideMods = new HashMap<>();
	private Map<EntityType, Float> backMods = new HashMap<>();
	private Map<EntityType, Float> stepHeights = new HashMap<>();

	private int rtmRange = 10;

	private static final EntityType[] rideAbleTypes = { EntityType.BAT, EntityType.BLAZE, EntityType.CAVE_SPIDER,
			EntityType.CHICKEN, EntityType.COW, EntityType.CREEPER, EntityType.ENDER_DRAGON, EntityType.ENDERMAN,
			EntityType.ENDERMITE, EntityType.GHAST, EntityType.GIANT, EntityType.GUARDIAN, EntityType.HORSE,
			EntityType.IRON_GOLEM, EntityType.MAGMA_CUBE, EntityType.MUSHROOM_COW, EntityType.OCELOT, EntityType.PIG,
			EntityType.PIG_ZOMBIE, EntityType.RABBIT, EntityType.SHEEP, EntityType.SILVERFISH, EntityType.SKELETON,
			EntityType.SNOWMAN, EntityType.SPIDER, EntityType.SQUID, EntityType.VILLAGER, EntityType.WITCH,
			EntityType.WITHER, EntityType.WOLF, EntityType.ZOMBIE };

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

	public int getRtmRange() {
		return rtmRange;
	}

	public boolean isRideAble(EntityType e) {
		return ArrayUtils.contains(rideAbleTypes, e);
	}

	public static RideThaMobConfig load() {
		return (RideThaMobConfig) ConfigHandler.getInstance().loadConfig(RideThaMobConfig.class,
				new File(RideThaMob.getInstance().getDataFolder(), "config.yml"));
	}

	public void defaultValues() {
		// TODO Auto-generated method stub

	}

	public void save() {
		ConfigHandler.getInstance().saveConfig(this, new File(RideThaMob.getInstance().getDataFolder(), "config.yml"));
	}
}
