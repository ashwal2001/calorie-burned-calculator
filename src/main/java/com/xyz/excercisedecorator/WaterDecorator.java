package com.xyz.excercisedecorator;

import com.xyz.excercise.Exercise;

public class WaterDecorator extends ExerciseDecorator {

	private double extraCalorie = 5;

	/**
	 * @param exercise
	 */
	public WaterDecorator(Exercise exercise) {
		super(exercise);
	}

	/**
	 * @param exercise
	 * @param extraCalorie
	 */
	public WaterDecorator(Exercise exercise, double extraCalorie) {
		super(exercise);
		this.extraCalorie = extraCalorie;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xyz.excercise.ExerciseDecorator#getCalorie(double)
	 */
	@Override
	public double getCalorie(long exercisetime) {
		double calorie = super.getCalorie(exercisetime);
		return calorie + getExtraCalorie() ;
	}

	/**
	 * @return the extraCalorie
	 */
	public double getExtraCalorie() {
		return extraCalorie;
	}

	/**
	 * @param extraCalorie
	 *            the extraCalorie to set
	 */
	public void setExtraCalorie(double extraCalorie) {
		this.extraCalorie = extraCalorie;
	}

}
