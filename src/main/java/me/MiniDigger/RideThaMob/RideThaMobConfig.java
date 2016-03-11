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
	private Map<EntityType, Double> sideMods = new HashMap<>();
	private Map<EntityType, Double> backMods = new HashMap<>();
	private Map<EntityType, Double> stepHeights = new HashMap<>();

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

	public double getSidewaysMod(EntityType e) {
		if (sideMods.containsKey(e)) {
			return sideMods.get(e);
		} else {
			return sideMods.get(EntityType.UNKNOWN);
		}
	}

	public double getBackwardsMod(EntityType e) {
		if (backMods.containsKey(e)) {
			return backMods.get(e);
		} else {
			return backMods.get(EntityType.UNKNOWN);
		}
	}

	public double getStepHeight(EntityType e) {
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
		RideThaMobConfig c = (RideThaMobConfig) ConfigHandler.getInstance().loadConfig(RideThaMobConfig.class,
				new File(RideThaMob.getInstance().getDataFolder(), "config.yml"));
		c.loadStuff();
		return c;
	}

	public void loadStuff() {
		EntityType t = EntityType.UNKNOWN;
		rideSpeeds.put(t, 0.2);
		jumpHeights.put(t, 0.6);
		sideMods.put(t, 0.5);
		backMods.put(t, 0.25);
		stepHeights.put(t, 1.0);

		for (RideThaMobConfigObj obj : this.obj) {
			EntityType type = EntityType.valueOf(obj.getEntityType());
			rideSpeeds.put(type, obj.getRideSpeed());
			jumpHeights.put(type, obj.getJumpHeight());
			sideMods.put(type, obj.getSideMod());
			backMods.put(type, obj.getBackMod());
			stepHeights.put(type, obj.getStepHeight());
		}
	}

	public void defaultValues() {
		EntityType t = EntityType.UNKNOWN;
		rideSpeeds.put(t, 0.2);
		jumpHeights.put(t, 0.6);
		sideMods.put(t, 0.5);
		backMods.put(t, 0.25);
		stepHeights.put(t, 1.0);

		for (EntityType type : rideAbleTypes) {
			rideSpeeds.put(type, 0.2);
			jumpHeights.put(type, 0.6);
			sideMods.put(type, 0.5);
			backMods.put(type, 0.25);
			stepHeights.put(type, 1.0);
		}
	}

	public void save() {
		ConfigHandler.getInstance().saveConfig(this, new File(RideThaMob.getInstance().getDataFolder(), "config.yml"));
	}
}
