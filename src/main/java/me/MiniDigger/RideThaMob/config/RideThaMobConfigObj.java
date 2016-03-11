package me.MiniDigger.RideThaMob.config;

public class RideThaMobConfigObj {
	private double rideSpeed = 0.2;
	private double jumpHeight = 0.6;
	private double sideMod = 0.5;
	private double backMod = 0.25;
	private double stepHeight = 1.0;

	public double getRideSpeed() {
		return rideSpeed;
	}

	public void setRideSpeed(double rideSpeed) {
		this.rideSpeed = rideSpeed;
	}

	public double getJumpHeight() {
		return jumpHeight;
	}

	public void setJumpHeight(double jumpHeight) {
		this.jumpHeight = jumpHeight;
	}

	public double getSideMod() {
		return sideMod;
	}

	public void setSideMod(double sideMod) {
		this.sideMod = sideMod;
	}

	public double getBackMod() {
		return backMod;
	}

	public void setBackMod(double backMod) {
		this.backMod = backMod;
	}

	public double getStepHeight() {
		return stepHeight;
	}

	public void setStepHeight(double stepHeight) {
		this.stepHeight = stepHeight;
	}

}
