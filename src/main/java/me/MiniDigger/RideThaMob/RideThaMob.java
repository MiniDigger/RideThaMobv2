package me.MiniDigger.RideThaMob;

import me.MiniDigger.Foundation.api.FoundationAPI;
import me.MiniDigger.Foundation.handler.lang.Lang;
import me.MiniDigger.Foundation.handler.module.Module;
import me.MiniDigger.RideThaMob.lang.RTMLangKey;
import me.MiniDigger.RideThaMob.nms.RideAbleEntityType;

public class RideThaMob extends Module {
	private static RideThaMob INSTANCE;

	private RideThaMobConfig config;
	private int updateVal = 1;

	@Override
	public boolean onLoad() {
		INSTANCE = this;
		return super.onLoad();
	}

	@Override
	public boolean onEnable() {
		RideAbleEntityType.registerEntities();

		FoundationAPI.registerCommands(new RideThaMobCommands(), this);
		FoundationAPI.registerEvents(new RideThaMobListener(), this);
		FoundationAPI.registerLangKeys(new RTMLangKey(), this);

		reloadConfig();

		fixEntities();

		Lang.console(RTMLangKey.START, getDescription().version());

		return super.onLoad();
	}

	@Override
	public boolean onDisable() {
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

	public void reloadConfig() {
		config = RideThaMobConfig.load();
		config.defaultValues();
		config.save();
	}

	public RideThaMobConfig getConfig() {
		return config;
	}

	public void setShouldUpdate() {
		updateVal++;
	}

	public int getUpdateVal() {
		return updateVal;
	}
}
