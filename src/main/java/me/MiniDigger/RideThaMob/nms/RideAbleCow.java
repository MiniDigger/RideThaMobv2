package me.MiniDigger.RideThaMob.nms;

import java.lang.reflect.Field;

import org.bukkit.craftbukkit.v1_9_R1.event.CraftEventFactory;
import org.bukkit.event.entity.HorseJumpEvent;

import net.minecraft.server.v1_9_R1.*;

import me.MiniDigger.RideThaMob.RideThaMob;

/**
 * This class may be generated by a bot.
 * Gen date: 07.03.16 22:59
 */
public class RideAbleCow extends EntityCow implements IJumpable {
	private static Field jumpField = null;
	private double rideSpeed;
	private boolean fly;
	private double jumpHeight;
	private float sidewaysMod;
	private float backwardsMod;
	private float stepHeight;
	private int updateVal = 0;
	
	// nms stuff
	// BX = isJumping
	private boolean bx;
	private float jumpPower = 0f;
	
	public RideAbleCow(World world) {
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
	
	private void updateStuff() {
		rideSpeed = RideThaMob.getInstance().getRideSpeed(getBukkitEntity().getType());
		fly = RideThaMob.getInstance().getFly(getBukkitEntity().getType());
		jumpHeight = RideThaMob.getInstance().getJumpHeight(getBukkitEntity().getType());
		sidewaysMod = RideThaMob.getInstance().getSidewaysMod(getBukkitEntity().getType());
		backwardsMod = RideThaMob.getInstance().getBackwardsMod(getBukkitEntity().getType());
		stepHeight = RideThaMob.getInstance().getStepHeight(getBukkitEntity().getType());
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
				this.aQ = 0.02f;
				super.g(f, f1);
				return;
			}
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
		if (this.jumpPower > 0.0f && this.onGround) {
			this.motY = this.jumpHeight * this.jumpPower;
			if (this.hasEffect(MobEffects.JUMP)) {
				this.motY += (this.getEffect(MobEffects.JUMP).getAmplifier() + 1) * 0.1f;
			}
			this.impulse = true;
			if (f1 > 0.0f) {
				final float f2 = MathHelper.sin(this.yaw * 0.017453292f);
				final float f3 = MathHelper.cos(this.yaw * 0.017453292f);
				this.motX += -0.4f * f2 * this.jumpPower;
				this.motZ += 0.4f * f3 * this.jumpPower;
				this.a(SoundEffects.cv, 0.4f, 1.0f);
			}
			this.jumpPower = 0.0f;
		}
		
		// set speed an go!
		this.l((float) rideSpeed);
		super.g(f, f1);
		
		this.P = 1.0f;
		this.aQ = this.ck() * 0.1f;
		if (this.onGround) {
			this.jumpPower = 0.0f;
		}
		this.aE = this.aF;
		final double d0 = this.locX - this.lastX;
		final double d = this.locZ - this.lastZ;
		float f4 = MathHelper.sqrt(d0 * d0 + d * d) * 4.0f;
		if (f4 > 1.0f) {
			f4 = 1.0f;
		}
		this.aF += (f4 - this.aF) * 0.4f;
		this.aG += this.aF;
	}
	
	@Override
	// can be steered
	public boolean cK() {
		return true;
	}
	
	@Override
	public void b(int i) {
		System.out.println("JUMP");
		float power;
		if (i >= 90) {
			power = 1.0f;
		} else {
			power = 0.4f + 0.4f * i / 90.0f;
		}
		final HorseJumpEvent event = CraftEventFactory.callHorseJumpEvent(this, power);
		if (event.isCancelled()) {
			return;
		}
	}
	
	@Override
	public void r_() {
		// empty for whatever reason
	}
	
	@Override
	// can jump
	public boolean b() {
		return true;
	}
}
