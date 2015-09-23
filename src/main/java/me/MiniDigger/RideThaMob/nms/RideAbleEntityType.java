package me.MiniDigger.RideThaMob.nms;

import org.bukkit.entity.EntityType;

import me.MiniDigger.RideThaMob.nms.util.NMSUtils;
import net.minecraft.server.v1_8_R3.EntityInsentient;
import net.minecraft.server.v1_8_R3.EntitySkeleton;

public enum RideAbleEntityType {
	BAT("Bat", 65, EntityType.BAT),
	BLAZE("Blaze", 61, EntityType.BLAZE),
	CAVESPIDER("CaveSpider", 59, EntityType.CAVE_SPIDER),
	CHICKEN("Chicken", 93, EntityType.CHICKEN),
	COW("Cow", 92, EntityType.COW),
	CREEPER("Creeper", 50, EntityType.CREEPER),
	ENDERDRAGON("EnderDragon", 63, EntityType.ENDER_DRAGON),
	ENDERMAN("Enderman", 58, EntityType.ENDERMAN),
	ENDERMITE("Endermite", 67, EntityType.ENDERMITE),
	GHAST("Ghast", 56, EntityType.GHAST),
	GIANT("Giant", 53, EntityType.GIANT),
	GUARDIAN("Guardian", 68, EntityType.GUARDIAN),
	HORSE("Horse", 100, EntityType.HORSE),
	IRONGOLEM("IronGolem", 99, EntityType.IRON_GOLEM),
	MAGMACUBE("MagmaCube", 62, EntityType.MAGMA_CUBE),
	MUSHROOMCOW("MushroomCow", 96, EntityType.MUSHROOM_COW),
	OCELOT("Ocelot", 98, EntityType.OCELOT),
	PIG("Pig", 90, EntityType.PIG),
	PIGZOMBIE("PigZombie", 57, EntityType.PIG_ZOMBIE),
	RABBIT("Rabbit", 101, EntityType.RABBIT),
	SHEEP("Sheep", 91, EntityType.SHEEP),
	SILVERFISH("Silverfish", 60, EntityType.SILVERFISH),
	SKELETON("Skeleton", 51, EntityType.SKELETON),
	SLIME("Slime", 55, EntityType.SLIME),
	SNOWMAN("Snowman", 97, EntityType.SNOWMAN),
	SPIDER("Spider", 52, EntityType.SPIDER),
	SQUID("Squid", 94, EntityType.SQUID),
	VILLAGER("Villager", 120, EntityType.VILLAGER),
	WITCH("Witch", 66, EntityType.WITCH),
	WITHER("Wither", 64, EntityType.WITHER),
	WOLF("Wolf", 95, EntityType.WOLF),
	ZOMBIE("Zombie", 54, EntityType.ZOMBIE);

	public static void registerEntities() {
		for (RideAbleEntityType entity : values()) {
			NMSUtils.registerEntity(entity.getName(), entity.getID(), entity.getNMSClass(), entity.getCustomClass());
		}
	}
	private Class<? extends EntityInsentient> customClass;
	private EntityType entityType;
	private int id;
	private String name;

	private Class<? extends EntityInsentient> nmsClass;

	private RideAbleEntityType(String name, int id, EntityType entityType, Class<? extends EntityInsentient> nmsClass,
			Class<? extends EntityInsentient> customClass) {
		this.name = name;
		this.id = id;
		this.entityType = entityType;
		this.nmsClass = nmsClass;
		this.customClass = customClass;
	}

	public Class<? extends EntityInsentient> getCustomClass() {
		return this.customClass;
	}

	public EntityType getEntityType() {
		return this.entityType;
	}

	public int getID() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public Class<? extends EntityInsentient> getNMSClass() {
		return this.nmsClass;
	}

}
