package com.xyz.excercise;

public class ExerciseDetail {
	
	private String startTime;
	private String endTime;
	private Exercise exercise;
	
	/**
	 * @param startTime
	 * @param endTime
	 * @param exercise
	 */
	public ExerciseDetail(String startTime, String endTime, Exercise exercise) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
		this.exercise = exercise;
	}
	/**
	 * @return the startTime
	 */
	public String getStartTime() {
		return startTime;
	}
	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	/**
	 * @return the endTime
	 */
	public String getEndTime() {
		return endTime;
	}
	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	/**
	 * @return the exercise
	 */
	public Exercise getExercise() {
		return exercise;
	}
	/**
	 * @param excercise the exercise to set
	 */
	public void setExercise(Exercise exercise) {
		this.exercise = exercise;
	}
	
	

}
