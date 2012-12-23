package com.xyz.excercisedecorator;

import com.xyz.excercise.Exercise;

public class MorningDecorator extends ExerciseDecorator {

	private double extraPercent = 10;

	public MorningDecorator(Exercise exercise) {
		super(exercise);
	}

	/**
	 * @param exercise
	 * @param extraPercent
	 */
	public MorningDecorator(Exercise exercise, double extraPercent) {
		super(exercise);
		this.extraPercent = extraPercent;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xyz.excercise.ExerciseDecorator#getCalorie(double)
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
