package me.MiniDigger.RideThaMob;

import java.util.*;

import org.apache.commons.lang.ArrayUtils;

import me.MiniDigger.Foundation.handler.command.CommandHandler;
import me.MiniDigger.Foundation.handler.module.Module;
import me.MiniDigger.RideThaMob.lang.*;
import me.MiniDigger.RideThaMob.nms.RideAbleEntityType;

import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;

public class RideThaMob extends Module {
	private static RideThaMob INSTANCE;
	
	private Map<EntityType, Double> rideSpeeds = new HashMap<>();
	private Map<EntityType, Double> jumpHeights = new HashMap<>();
	private Map<EntityType, Float> sideMods = new HashMap<>();
	private Map<EntityType, Float> backMods = new HashMap<>();
	private Map<EntityType, Float> stepHeights = new HashMap<>();
	
	private int rtmRange = 10;
	private int updateVal = 1;
	
	public EntityType[] rideAbleTypes = { EntityType.BAT, EntityType.BLAZE, EntityType.CAVE_SPIDER, EntityType.CHICKEN, EntityType.COW, EntityType.CREEPER,
			EntityType.ENDER_DRAGON, EntityType.ENDERMAN, EntityType.ENDERMITE, EntityType.GHAST, EntityType.GIANT, EntityType.GUARDIAN, EntityType.HORSE,
			EntityType.IRON_GOLEM, EntityType.MAGMA_CUBE, EntityType.MUSHROOM_COW, EntityType.OCELOT, EntityType.PIG, EntityType.PIG_ZOMBIE, EntityType.RABBIT,
			EntityType.SHEEP, EntityType.SILVERFISH, EntityType.SKELETON, EntityType.SNOWMAN, EntityType.SPIDER, EntityType.SQUID, EntityType.VILLAGER,
			EntityType.WITCH, EntityType.WITHER, EntityType.WOLF, EntityType.ZOMBIE };
			
	@Override
	public boolean onLoad() {
		INSTANCE = this;
		return super.onLoad();
	}
	
	@Override
	public boolean onEnable() {
		CommandHandler.getInstance().register(new RideThaMobCommands());
		
		RideAbleEntityType.registerEntities();
		
		getServer().getPluginManager().registerEvents(new RideThaMobListener(), this);
		
		LangHandler.getInstance().load();
		
		loadConfig();
		fixEntities();
		
		Lang._(Bukkit.getConsoleSender(), LangKey.START, getDescription().getVersion());
		
		return super.onLoad();
	}
	
	@Override
	public boolean onDisable() {
		CommandHandler.getInstance().unregister(new RideThaMobCommands());
		
		return super.onLoad();
	}
	
	public static RideThaMob getInstance() {
		return INSTANCE;
	}
	
	public void fixEntities() {
		// TODO
		// replace ALL entites in the world with rideable ones
		// only if the user enables it
	}
	
	public void loadConfig() {
		rideSpeeds = new HashMap<>();
		jumpHeights = new HashMap<>();
		sideMods = new HashMap<>();
		backMods = new HashMap<>();
		stepHeights = new HashMap<>();
		
		// defaults
		saveDefaultConfig();
		
		rideSpeeds.put(EntityType.UNKNOWN, 0.2);
		jumpHeights.put(EntityType.UNKNOWN, 0.6);
		sideMods.put(EntityType.UNKNOWN, 0.5F);
		backMods.put(EntityType.UNKNOWN, 0.25F);
		stepHeights.put(EntityType.UNKNOWN, 1F);
		
		rtmRange = getConfig().getInt("rtmRange");
		
		for (EntityType e : rideAbleTypes) {
			double rideSpeed = 0.2;
			double jumpHeight = 0.6;
			float sideMod = 0.5F;
			float backMod = 0.25F;
			float stepHeight = 1F;
			
			rideSpeed = getConfig().getDouble(e.name() + ".rideSpeed");
			jumpHeight = getConfig().getDouble(e.name() + ".jumpHeight");
			sideMod = (float) getConfig().getDouble(e.name() + ".sideMod");
			backMod = (float) getConfig().getDouble(e.name() + ".backMod");
			stepHeight = (float) getConfig().getDouble(e.name() + ".stepHeight");
			
			rideSpeeds.put(e, rideSpeed);
			jumpHeights.put(e, jumpHeight);
			sideMods.put(e, sideMod);
			backMods.put(e, backMod);
			stepHeights.put(e, stepHeight);
		}
	}
	
	public boolean isRideAble(EntityType e) {
		return ArrayUtils.contains(rideAbleTypes, e);
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
	
	public void setShouldUpdate() {
		updateVal++;
	}
	
	public int getUpdateVal() {
		return updateVal;
	}
	
	public int getRtmRange() {
		return rtmRange;
	}
}
