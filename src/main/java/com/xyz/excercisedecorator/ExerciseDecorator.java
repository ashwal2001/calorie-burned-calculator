package com.xyz.excercisedecorator;

import com.xyz.excercise.Exercise;

public abstract class ExerciseDecorator implements Exercise {

	protected Exercise exercise;

	/**
	 * @param exercise
	 */
	public ExerciseDecorator(Exercise exercise) {
		super();
		this.exercise = exercise;
	}

	public double getCalorie(long exercisetime) {
		return exercise.getCalorie(exercisetime);
	}

}
