package me.MiniDigger.RideThaMob.nms;

import me.MiniDigger.RideThaMob.RideThaMob;
import net.minecraft.server.v1_9_R1.Entity;
import net.minecraft.server.v1_9_R1.EntityHuman;
import net.minecraft.server.v1_9_R1.EntityLiving;
import net.minecraft.server.v1_9_R1.EntityMagmaCube;
import net.minecraft.server.v1_9_R1.World;

/**
 * This class may be generated by a bot. Gen date: 11.03.16 09:00
 */
public class RideAbleMagmaCube extends EntityMagmaCube {
	private double rideSpeed;
	private boolean fly;
	private double jumpHeight;
	private float sidewaysMod;
	private float backwardsMod;
	private float stepHeight;
	private int updateVal = 0;

	public RideAbleMagmaCube(World world) {
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
		EntityLiving entityliving = (EntityLiving) this.bt();
		if (entityliving == null) {
			// search first human passanger
			for (Entity e : passengers) {
				if (e instanceof EntityHuman) {
					entityliving = (EntityLiving) e;
					break;
				}
			}
			if (entityliving == null) {
				this.P = 0.5f;
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
		this.lastYaw = yaw;
		this.pitch = entityliving.pitch * 0.5f;
		this.setYawPitch(this.yaw, this.pitch);
		final float yaw2 = this.yaw;
		this.aM = yaw2;
		this.aO = yaw2;

		f = entityliving.bd * sidewaysMod;
		f1 = entityliving.be;
		if (f1 <= 0.0f) {
			f1 *= backwardsMod;// backwards slower
		}

		// set speed an go!
		this.l((float) rideSpeed);
		super.g(f, f1);

		this.P = stepHeight;
	}
}
