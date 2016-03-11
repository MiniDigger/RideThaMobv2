package me.MiniDigger.RideThaMob.nms;

import me.MiniDigger.RideThaMob.RideThaMob;

import net.minecraft.server.v1_9_R1.Entity;
import net.minecraft.server.v1_9_R1.EntityBat;
import net.minecraft.server.v1_9_R1.EntityHuman;
import net.minecraft.server.v1_9_R1.EntityLiving;
import net.minecraft.server.v1_9_R1.World;

/**
 * This class may be generated by a bot. Gen date: 11.03.16 12:31
 */
public class RideAbleBat extends EntityBat {
	private double rideSpeed;
	@SuppressWarnings("unused")
	private boolean fly;// TODO Implement Flying
	@SuppressWarnings("unused")
	private double jumpHeight;// TODO Implement Jumping
	private double sidewaysMod;
	private double backwardsMod;
	private double stepHeight;
	private int updateVal = 0;

	public RideAbleBat(final World world) {
		super(world);

		updateStuff();
	}

	private void updateStuff() {
		rideSpeed = RideThaMob.getInstance().getConfig().getRideSpeed(getBukkitEntity().getType());
		fly = RideThaMob.getInstance().getConfig().getFly(getBukkitEntity().getType());
		jumpHeight = RideThaMob.getInstance().getConfig().getJumpHeight(getBukkitEntity().getType());
		sidewaysMod = RideThaMob.getInstance().getConfig().getSidewaysMod(getBukkitEntity().getType());
		backwardsMod = RideThaMob.getInstance().getConfig().getBackwardsMod(getBukkitEntity().getType());
		stepHeight = RideThaMob.getInstance().getConfig().getStepHeight(getBukkitEntity().getType());
	}

	@Override
	public void g(float f, float f1) {
		// stearing passagner
		EntityLiving entityliving = (EntityLiving) bt();
		if (entityliving == null) {
			// search first human passanger
			for (final Entity e : passengers) {
				if (e instanceof EntityHuman) {
					entityliving = (EntityLiving) e;
					break;
				}
			}
			if (entityliving == null) {
				P = 0.5f;
				super.g(f, f1);
				return;
			}
		}

		if (RideThaMob.getInstance().getUpdateVal() > updateVal) {
			updateVal = RideThaMob.getInstance().getUpdateVal();
			updateStuff();
		}

		final float yaw = entityliving.yaw;
		this.yaw = yaw;
		lastYaw = yaw;
		pitch = entityliving.pitch * 0.5f;
		setYawPitch(this.yaw, pitch);
		final float yaw2 = this.yaw;
		aM = yaw2;
		aO = yaw2;

		f = (float) (entityliving.bd * sidewaysMod);
		f1 = entityliving.be;
		if (f1 <= 0.0f) {
			f1 *= backwardsMod;// backwards slower
		}

		// set speed an go!
		this.l((float) rideSpeed);
		super.g(f, f1);

		P = (float) stepHeight;
	}
}
