package com.xyz.calculator;

import java.util.HashSet;

import com.xyz.excercise.Exercise;
import com.xyz.excercise.ExerciseDetail;
import com.xyz.excercisedecorator.TwoHourDecorator;
import com.xyz.person.Person;
import com.xyz.util.UtilityClass;

public class CalculatorService implements ICalculatorService {

	double calorie = 0;
	
	@Override
	public void reset(){
		calorie = 0;
	}

	@Override
	public double getCalorieBurned(Person person) {
		
		HashSet<ExerciseDetail> exerciseSet = person.getExerciseSet();
		
		//Iterate for each routine associated with a person
		for (ExerciseDetail exerciseDetail : exerciseSet) {
			Exercise exercise = exerciseDetail.getExercise();
			
			//get exercise routine time in minutes
			long exerciseTime = UtilityClass.minutesDiff(
					exerciseDetail.getStartTime(), exerciseDetail.getEndTime());
			
			if(exerciseTime>120){
				exercise =new TwoHourDecorator(exercise);
			}
			
			// check is exercise routine valid
			if (exerciseValid(person.getWeight(), exerciseTime))
				calorie = calorie + exercise.getCalorie(exerciseTime);
		}
		return calorie;
	}

	public boolean exerciseValid(double weight, long exerciseTime) {
		boolean exerciseValid = true;

		// Check for weight of person less 40 and exercise time for a particular
		// routine less then 15 minutes
		if (weight < 40 && exerciseTime < 15)
			exerciseValid = false;

		return exerciseValid;
	}

}
