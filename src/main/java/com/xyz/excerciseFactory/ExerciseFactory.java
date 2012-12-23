package com.xyz.excerciseFactory;

import com.xyz.excercise.Cycling;
import com.xyz.excercise.Exercise;
import com.xyz.excercise.Swimming;

public class ExerciseFactory {

	private static ExerciseFactory uniqueInstance;

	private ExerciseFactory() {
	}

	public static synchronized ExerciseFactory getExerciseFactory() {
		if (uniqueInstance == null) {
			uniqueInstance = new ExerciseFactory();
		}
		return uniqueInstance;
	}

	public Exercise getExercise(Class<? extends Exercise> classExercise) {
		Exercise exerciseObject = null;
		if (classExercise.equals(Cycling.class)) {
			exerciseObject = new Cycling();
		} else if (classExercise.equals(Swimming.class)) {
			exerciseObject = new Swimming();
		}
		return exerciseObject;
	}
}
