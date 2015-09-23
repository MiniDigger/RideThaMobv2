package me.MiniDigger.RideThaMob.nms;

import java.lang.reflect.Field;

import org.bukkit.entity.Player;

import me.MiniDigger.RideThaMob.RideThaMob;
import net.minecraft.server.v1_8_R3.EntityHuman;
import net.minecraft.server.v1_8_R3.EntityLiving;
import net.minecraft.server.v1_8_R3.EntityMushroomCow;
import net.minecraft.server.v1_8_R3.World;

/**
 * This class may be generated by a bot.
 * Gen date: 23.09.15 18:41
 */
public class RideAbleMushroomCow extends EntityMushroomCow {
	private static Field jumpField = null;
	private double rideSpeed;
	private boolean fly;
	private double jumpHeight;
	private float sidewaysMod;
	private float backwardsMod;
	private float stepHeight;
	private int updateVal = 0;

	public RideAbleMushroomCow(World world) {
		super(world);

		updateStuff();
		
		if (jumpField == null) {
			try {
				jumpField = EntityLiving.class.getDeclaredField("aY");
				jumpField.setAccessible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void updateStuff(){
		rideSpeed = RideThaMob.getInstance().getRideSpeed(getBukkitEntity().getType());
		fly = RideThaMob.getInstance().getFly(getBukkitEntity().getType());
		jumpHeight = RideThaMob.getInstance().getJumpHeight(getBukkitEntity().getType());
		sidewaysMod = RideThaMob.getInstance().getSidewaysMod(getBukkitEntity().getType());
		backwardsMod = RideThaMob.getInstance().getBackwardsMod(getBukkitEntity().getType());
		stepHeight = RideThaMob.getInstance().getStepHeight(getBukkitEntity().getType());
	}
	
	public void g(float sideMot, float forwMot) {
		if (passenger != null && passenger instanceof EntityHuman) {
			if(RideThaMob.getInstance().getUpdateVal() > updateVal){
				updateVal = RideThaMob.getInstance().getUpdateVal();
				updateStuff();
			}
			
			EntityHuman human = (EntityHuman) passenger;

			S = stepHeight;

			lastYaw = yaw = passenger.yaw;
			pitch = passenger.pitch * 0.5F;
			setYawPitch(yaw, pitch);
			aI = aG = yaw;

			sideMot = ((EntityLiving) passenger).aZ;
			sideMot *= sidewaysMod;// sideways should be slower
			sideMot *= 0.75;
			forwMot = ((EntityLiving) passenger).ba;
			if (forwMot <= 0.0F) {
				forwMot *= backwardsMod; // backwards should be slower
			}

			k((float) rideSpeed);
			super.g(sideMot, forwMot);

			if (jumpField != null) {
				if (fly) {
					try {
						if (((Player) (human.getBukkitEntity())).isFlying()) {
							((Player) (human.getBukkitEntity())).setFlying(false);
						}
						if (jumpField.getBoolean(passenger)) {
							motY = 0.5F;
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else if (onGround) {
					try {
						if (jumpField.getBoolean(passenger)) {
							motY = jumpHeight;
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		} else {
			super.g(sideMot, forwMot);
			S = 0.5F;
		}
	}
}
