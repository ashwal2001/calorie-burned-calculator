package com.xyz.excercise;

public class Cycling implements Exercise {

	private double calorieRate = 5;

	/**
	 * 
	 */
	public Cycling() {
		super();
	}

	/**
	 * @param calorieRate
	 */
	public Cycling(double calorieRate) {
		super();
		this.calorieRate = calorieRate;
	}

	@Override
	public double getCalorie(long exercisetime) {
		return calorieRate * exercisetime;
	}

	/**
	 * @return the calorieRate
	 */
	public double getCalorieRate() {
		return calorieRate;
	}

	/**
	 * @param calorieRate
	 *            the calorieRate to set
	 */
	public void setCalorieRate(double calorieRate) {
		this.calorieRate = calorieRate;
	}

}
