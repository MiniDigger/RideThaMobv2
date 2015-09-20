package me.MiniDigger.RideThaMob.nms;

import java.lang.reflect.Field;

import net.minecraft.server.v1_8_R3.EntityHorse;
import net.minecraft.server.v1_8_R3.EntityLiving;
import net.minecraft.server.v1_8_R3.EntitySkeleton;
import net.minecraft.server.v1_8_R3.GenericAttributes;
import net.minecraft.server.v1_8_R3.MathHelper;
import net.minecraft.server.v1_8_R3.MobEffectList;
import net.minecraft.server.v1_8_R3.World;

public class CustomEntitySkeleton extends EntitySkeleton {

	private float br = 0.0f;// Something todo with jumping

	public CustomEntitySkeleton(World world) {
		super(world);
	}

	@Override
	//copyied form EntiyHorse
	public void g(float sideMot, float forMot) {
		if (this.passenger != null && this.passenger instanceof EntityLiving /*&& this.cG()*/) {
			System.out.println("g");
			// adjust pitch and yaw
			final float yaw = this.passenger.yaw;
			this.yaw = yaw;
			this.lastYaw = yaw;
			this.pitch = this.passenger.pitch * 0.5f;
			this.setYawPitch(this.yaw, this.pitch);
			final float yaw2 = this.yaw;
			this.aI = yaw2;
			this.aK = yaw2;

			// adjust movement
			sideMot = ((EntityLiving) this.passenger).aZ * 0.5f;
			forMot = ((EntityLiving) this.passenger).ba;
			// backwards slower
			if (forMot <= 0.0f) {
				forMot *= 0.25f;
				// this.bN = 0; //Something related to sound -> not usefull for
				// us
			}
			if (this.onGround && this.br == 0.0f
					&& this.cz()/* && !this.bG idk */) {
				sideMot = 0.0f;
				forMot = 0.0f;
			}
			if (this.br > 0.0f && !this.cv() && this.onGround) {
				this.motY = this.getJumpStrength() * this.br;
				if (this.hasEffect(MobEffectList.JUMP)) {
					this.motY += (this.getEffect(MobEffectList.JUMP).getAmplifier() + 1) * 0.1f;
				}
				this.m(true);
				this.ai = true;
				if (forMot > 0.0f) {
					final float f2 = MathHelper.sin(this.yaw * 3.1415927f / 180.0f);
					final float f3 = MathHelper.cos(this.yaw * 3.1415927f / 180.0f);
					this.motX += -0.4f * f2 * this.br;
					this.motZ += 0.4f * f3 * this.br;
					this.makeSound("mob.horse.jump", 0.4f, 1.0f);
				}
				this.br = 0.0f;
			}
			this.S = 1.0f;
			this.aM = this.bI() * 0.1f;
			
			if (!this.world.isClientSide) {
				this.k((float) this.getAttributeInstance(GenericAttributes.MOVEMENT_SPEED).getValue());
				super.g(sideMot, forMot);
			}
			if (this.onGround) {
				this.br = 0.0f;
				this.m(false);
			}
			this.aA = this.aB;
			final double d0 = this.locX - this.lastX;
			final double d = this.locZ - this.lastZ;
			float f4 = MathHelper.sqrt(d0 * d0 + d * d) * 4.0f;
			if (f4 > 1.0f) {
				f4 = 1.0f;
			}
			this.aB += (f4 - this.aB) * 0.4f;
			this.aC += this.aB;
		} else {
			this.S = 0.5f;
			this.aM = 0.02f;
			super.g(sideMot, forMot);
		}
	}

	// Some copied helper methods

	private boolean cz() {
		return (this.datawatcher.getInt(16) & 64) != 0x0;
	}

	private boolean cG() {
		return (this.datawatcher.getInt(16) & 4) != 0x0;
	}

	private boolean cv() {
		Field bpField;
		try {
			bpField = getClass().getDeclaredField("bp");

			bpField.setAccessible(true);
			return bpField.getBoolean(this);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		return false;
	}

	private double getJumpStrength() {
		return this.getAttributeInstance(EntityHorse.attributeJumpStrength).getValue();
	}

	private void m(final boolean flag) {
		Field bpField;
		try {
			bpField = getClass().getDeclaredField("bp");

			bpField.setAccessible(true);
			bpField.setBoolean(this, flag);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}