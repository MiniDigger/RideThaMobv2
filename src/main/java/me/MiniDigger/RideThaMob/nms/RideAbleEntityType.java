package me.MiniDigger.RideThaMob.nms;

import me.MiniDigger.RideThaMob.nms.util.NMSUtils;

import org.bukkit.entity.EntityType;

import net.minecraft.server.v1_9_R1.*;

public enum RideAbleEntityType {
	BAT("Bat", 65, EntityType.BAT, EntityBat.class, RideAbleBat.class), BLAZE("Blaze", 61, EntityType.BLAZE, EntityBlaze.class,
			RideAbleBlaze.class), CAVESPIDER("CaveSpider", 59, EntityType.CAVE_SPIDER, EntityChicken.class, RideAbleCaveSpider.class), CHICKEN("Chicken", 93,
					EntityType.CHICKEN, EntityChicken.class, RideAbleChicken.class), COW("Cow", 92, EntityType.COW, EntityCow.class,
							RideAbleCow.class), CREEPER("Creeper", 50, EntityType.CREEPER, EntityCreeper.class, RideAbleCreeper.class), ENDERDRAGON(
									"EnderDragon", 63, EntityType.ENDER_DRAGON, EntityEnderDragon.class, RideAbleEnderDragon.class), ENDERMAN("Enderman", 58,
											EntityType.ENDERMAN, EntityEnderman.class, RideAbleEnderman.class), ENDERMITE("Endermite", 67, EntityType.ENDERMITE,
													EntityEndermite.class, RideAbleEndermite.class), GHAST("Ghast", 56, EntityType.GHAST, EntityGhast.class,
															RideAbleGhast.class), GIANT("Giant", 53, EntityType.GIANT, EntityGiantZombie.class,
																	RideAbleGiantZombie.class), GUARDIAN("Guardian", 68, EntityType.GUARDIAN,
																			EntityGuardian.class, RideAbleGuardian.class), HORSE("Horse", 100, EntityType.HORSE,
																					EntityHorse.class, RideAbleHorse.class), IRONGOLEM("IronGolem", 99,
																							EntityType.IRON_GOLEM, EntityIronGolem.class,
																							RideAbleIronGolem.class), MAGMACUBE("MagmaCube", 62,
																									EntityType.MAGMA_CUBE, EntityMagmaCube.class,
																									RideAbleMagmaCube.class), MUSHROOMCOW("MushroomCow", 96,
																											EntityType.MUSHROOM_COW, EntityMushroomCow.class,
																											RideAbleMushroomCow.class), OCELOT("Ocelot", 98,
																													EntityType.OCELOT, EntityOcelot.class,
																													RideAbleOcelot.class), PIG("Pig", 90,
																															EntityType.PIG, EntityPig.class,
																															RideAblePig.class), PIGZOMBIE(
																																	"PigZombie", 57,
																																	EntityType.PIG_ZOMBIE,
																																	EntityPigZombie.class,
																																	RideAblePigZombie.class),
																																	// TODO
																																	// Whats
																																	// about
																																	// players?!
																																	RABBIT("Rabbit", 101,
																																			EntityType.RABBIT,
																																			EntityRabbit.class,
																																			RideAbleRabbit.class), SHEEP(
																																					"Sheep", 91,
																																					EntityType.SHEEP,
																																					EntitySheep.class,
																																					RideAbleSheep.class), SILVERFISH(
																																							"Silverfish",
																																							60,
																																							EntityType.SILVERFISH,
																																							EntitySilverfish.class,
																																							RideAbleSilverfish.class), SKELETON(
																																									"Skeleton",
																																									51,
																																									EntityType.SKELETON,
																																									EntitySkeleton.class,
																																									RideAbleSkeleton.class), SLIME(
																																											"Slime",
																																											55,
																																											EntityType.SLIME,
																																											EntitySlime.class,
																																											RideAbleSlime.class), SNOWMAN(
																																													"Snowman",
																																													97,
																																													EntityType.SNOWMAN,
																																													EntitySnowman.class,
																																													RideAbleSnowman.class), SPIDER(
																																															"Spider",
																																															52,
																																															EntityType.SPIDER,
																																															EntitySpider.class,
																																															RideAbleSpider.class), SQUID(
																																																	"Squid",
																																																	94,
																																																	EntityType.SQUID,
																																																	EntitySquid.class,
																																																	RideAbleSquid.class), VILLAGER(
																																																			"Villager",
																																																			120,
																																																			EntityType.VILLAGER,
																																																			EntityVillager.class,
																																																			RideAbleVillager.class), WITCH(
																																																					"Witch",
																																																					66,
																																																					EntityType.WITCH,
																																																					EntityWitch.class,
																																																					RideAbleWitch.class), WITHER(
																																																							"Wither",
																																																							64,
																																																							EntityType.WITHER,
																																																							EntityWither.class,
																																																							RideAbleWither.class), WOLF(
																																																									"Wolf",
																																																									95,
																																																									EntityType.WOLF,
																																																									EntityWolf.class,
																																																									RideAbleWolf.class), ZOMBIE(
																																																											"Zombie",
																																																											54,
																																																											EntityType.ZOMBIE,
																																																											EntityZombie.class,
																																																											RideAbleZombie.class);

	private String name;
	private int id;
	private EntityType entityType;
	private Class<? extends EntityInsentient> nmsClass;
	private Class<? extends EntityInsentient> customClass;

	private RideAbleEntityType(final String name, final int id, final EntityType entityType, final Class<? extends EntityInsentient> nmsClass,
			final Class<? extends EntityInsentient> customClass) {
		this.name = name;
		this.id = id;
		this.entityType = entityType;
		this.nmsClass = nmsClass;
		this.customClass = customClass;
	}

	public String getName() {
		return name;
	}

	public int getID() {
		return id;
	}

	public EntityType getEntityType() {
		return entityType;
	}

	public Class<? extends EntityInsentient> getNMSClass() {
		return nmsClass;
	}

	public Class<? extends EntityInsentient> getCustomClass() {
		return customClass;
	}

	public static void registerEntities() {
		for (final RideAbleEntityType entity : values()) {
			NMSUtils.registerEntity(entity.getName(), entity.getID(), entity.getNMSClass(), entity.getCustomClass());
		}
	}
}
