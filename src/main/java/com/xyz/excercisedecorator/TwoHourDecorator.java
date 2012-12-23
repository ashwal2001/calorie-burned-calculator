package com.xyz.excercisedecorator;

import com.xyz.excercise.Exercise;

public class TwoHourDecorator extends ExerciseDecorator {

	private double extraPercent = 5;

	/**
	 * @param exercise
	 */
	public TwoHourDecorator(Exercise exercise) {
		super(exercise);
	}

	/**
	 * @param exercise
	 * @param extraPercent
	 */
	public TwoHourDecorator(Exercise exercise, double extraPercent) {
		super(exercise);
		this.extraPercent = extraPercent;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xyz.excercisedecorator.ExerciseDecorator#getCalorie(long)
	 */
	@Override
	public double getCalorie(long exercisetime) {
		double calorie = super.getCalorie(exercisetime);
		return (extraPercent * calorie / 100)+calorie;
	}

	/**
	 * @return the extraPercent
	 */
	public double getExtraPercent() {
		return extraPercent;
	}

	/**
	 * @param extraPercent
	 *            the extraPercent to set
	 */
	public void setExtraPercent(double extraPercent) {
		this.extraPercent = extraPercent;
	}

}
