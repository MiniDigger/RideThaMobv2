package me.MiniDigger.RideThaMob.config;

public class RideThaMobConfigObj {
	private final String entityType = "UNKNOWN";
	private double rideSpeed = 0.2;
	private double jumpHeight = 0.6;
	private double sideMod = 0.5;
	private double backMod = 0.25;
	private double stepHeight = 1.0;

	public String getEntityType() {
		return entityType;
	}

	public double getRideSpeed() {
		return rideSpeed;
	}

	public void setRideSpeed(final double rideSpeed) {
		this.rideSpeed = rideSpeed;
	}

	public double getJumpHeight() {
		return jumpHeight;
	}

	public void setJumpHeight(final double jumpHeight) {
		this.jumpHeight = jumpHeight;
	}

	public double getSideMod() {
		return sideMod;
	}

	public void setSideMod(final double sideMod) {
		this.sideMod = sideMod;
	}

	public double getBackMod() {
		return backMod;
	}

	public void setBackMod(final double backMod) {
		this.backMod = backMod;
	}

	public double getStepHeight() {
		return stepHeight;
	}

	public void setStepHeight(final double stepHeight) {
		this.stepHeight = stepHeight;
	}

}
