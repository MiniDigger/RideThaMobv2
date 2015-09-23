package me.MiniDigger.RideThaMob.nms;

import org.bukkit.entity.EntityType;

import me.MiniDigger.RideThaMob.nms.util.NMSUtils;
import net.minecraft.server.v1_8_R3.EntityBat;
import net.minecraft.server.v1_8_R3.EntityBlaze;
import net.minecraft.server.v1_8_R3.EntityChicken;
import net.minecraft.server.v1_8_R3.EntityCow;
import net.minecraft.server.v1_8_R3.EntityCreeper;
import net.minecraft.server.v1_8_R3.EntityEnderDragon;
import net.minecraft.server.v1_8_R3.EntityEnderman;
import net.minecraft.server.v1_8_R3.EntityEndermite;
import net.minecraft.server.v1_8_R3.EntityGhast;
import net.minecraft.server.v1_8_R3.EntityGiantZombie;
import net.minecraft.server.v1_8_R3.EntityGuardian;
import net.minecraft.server.v1_8_R3.EntityHorse;
import net.minecraft.server.v1_8_R3.EntityInsentient;
import net.minecraft.server.v1_8_R3.EntityIronGolem;
import net.minecraft.server.v1_8_R3.EntityMagmaCube;
import net.minecraft.server.v1_8_R3.EntityMushroomCow;
import net.minecraft.server.v1_8_R3.EntityOcelot;
import net.minecraft.server.v1_8_R3.EntityPig;
import net.minecraft.server.v1_8_R3.EntityPigZombie;
import net.minecraft.server.v1_8_R3.EntityRabbit;
import net.minecraft.server.v1_8_R3.EntitySheep;
import net.minecraft.server.v1_8_R3.EntitySilverfish;
import net.minecraft.server.v1_8_R3.EntitySkeleton;
import net.minecraft.server.v1_8_R3.EntitySlime;
import net.minecraft.server.v1_8_R3.EntitySnowman;
import net.minecraft.server.v1_8_R3.EntitySpider;
import net.minecraft.server.v1_8_R3.EntitySquid;
import net.minecraft.server.v1_8_R3.EntityVillager;
import net.minecraft.server.v1_8_R3.EntityWitch;
import net.minecraft.server.v1_8_R3.EntityWither;
import net.minecraft.server.v1_8_R3.EntityWolf;
import net.minecraft.server.v1_8_R3.EntityZombie;

public enum RideAbleEntityType {
	BAT("Bat", 65, EntityType.BAT, EntityBat.class, RideAbleBat.class),
	BLAZE("Blaze", 61, EntityType.BLAZE, EntityBlaze.class, RideAbleBlaze.class),
	CAVESPIDER("CaveSpider", 59, EntityType.CAVE_SPIDER, EntityChicken.class, RideAbleCaveSpider.class),
	CHICKEN("Chicken", 93, EntityType.CHICKEN, EntityChicken.class, RideAbleChicken.class),
	COW("Cow", 92, EntityType.COW, EntityCow.class, RideAbleCow.class),
	CREEPER("Creeper", 50, EntityType.CREEPER, EntityCreeper.class, RideAbleCreeper.class),
	ENDERDRAGON("EnderDragon", 63, EntityType.ENDER_DRAGON, EntityEnderDragon.class, RideAbleEnderDragon.class),
	ENDERMAN("Enderman", 58, EntityType.ENDERMAN, EntityEnderman.class, RideAbleEnderman.class),
	ENDERMITE("Endermite", 67, EntityType.ENDERMITE, EntityEndermite.class, RideAbleEndermite.class),
	GHAST("Ghast", 56, EntityType.GHAST, EntityGhast.class, RideAbleGhast.class),
	GIANT("Giant", 53, EntityType.GIANT, EntityGiantZombie.class, RideAbleGiantZombie.class),
	GUARDIAN("Guardian", 68, EntityType.GUARDIAN, EntityGuardian.class, RideAbleGuardian.class),
	HORSE("Horse", 100, EntityType.HORSE, EntityHorse.class, RideAbleHorse.class),
	IRONGOLEM("IronGolem", 99, EntityType.IRON_GOLEM, EntityIronGolem.class, RideAbleIronGolem.class),
	MAGMACUBE("MagmaCube", 62, EntityType.MAGMA_CUBE, EntityMagmaCube.class, RideAbleMagmaCube.class),
	MUSHROOMCOW("MushroomCow", 96, EntityType.MUSHROOM_COW, EntityMushroomCow.class, RideAbleMushroomCow.class),
	OCELOT("Ocelot", 98, EntityType.OCELOT, EntityOcelot.class, RideAbleOcelot.class),
	PIG("Pig", 90, EntityType.PIG, EntityPig.class, RideAblePig.class),
	PIGZOMBIE("PigZombie", 57, EntityType.PIG_ZOMBIE, EntityPigZombie.class, RideAblePigZombie.class),
	RABBIT("Rabbit", 101, EntityType.RABBIT, EntityRabbit.class, RideAbleRabbit.class),
	SHEEP("Sheep", 91, EntityType.SHEEP, EntitySheep.class, RideAbleSheep.class),
	SILVERFISH("Silverfish", 60, EntityType.SILVERFISH, EntitySilverfish.class, RideAbleSilverfish.class),
	SKELETON("Skeleton", 51, EntityType.SKELETON, EntitySkeleton.class, RideAbleSkeleton.class),
	SLIME("Slime", 55, EntityType.SLIME, EntitySlime.class, RideAbleSlime.class),
	SNOWMAN("Snowman", 97, EntityType.SNOWMAN, EntitySnowman.class, RideAbleSnowman.class),
	SPIDER("Spider", 52, EntityType.SPIDER, EntitySpider.class, RideAbleSpider.class),
	SQUID("Squid", 94, EntityType.SQUID, EntitySquid.class, RideAbleSquid.class),
	VILLAGER("Villager", 120, EntityType.VILLAGER, EntityVillager.class, RideAbleVillager.class),
	WITCH("Witch", 66, EntityType.WITCH, EntityWitch.class, RideAbleWitch.class),
	WITHER("Wither", 64, EntityType.WITHER, EntityWither.class, RideAbleWither.class),
	WOLF("Wolf", 95, EntityType.WOLF, EntityWolf.class, RideAbleWolf.class),
	ZOMBIE("Zombie", 54, EntityType.ZOMBIE, EntityZombie.class, RideAbleZombie.class);

	private String name;
	private int id;
	private EntityType entityType;
	private Class<? extends EntityInsentient> nmsClass;
	private Class<? extends EntityInsentient> customClass;

	private RideAbleEntityType(String name, int id, EntityType entityType, Class<? extends EntityInsentient> nmsClass,
			Class<? extends EntityInsentient> customClass) {
		this.name = name;
		this.id = id;
		this.entityType = entityType;
		this.nmsClass = nmsClass;
		this.customClass = customClass;
	}

	public String getName() {
		return this.name;
	}

	public int getID() {
		return this.id;
	}

	public EntityType getEntityType() {
		return this.entityType;
	}

	public Class<? extends EntityInsentient> getNMSClass() {
		return this.nmsClass;
	}

	public Class<? extends EntityInsentient> getCustomClass() {
		return this.customClass;
	}

	public static void registerEntities() {
		for (RideAbleEntityType entity : values()) {
			NMSUtils.registerEntity(entity.getName(), entity.getID(), entity.getNMSClass(), entity.getCustomClass());
		}
	}

}
