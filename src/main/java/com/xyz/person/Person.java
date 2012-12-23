package com.xyz.person;

import java.util.HashSet;

import com.xyz.excercise.ExerciseDetail;

public class Person {

	private String name;
	private double weight;
	private HashSet<ExerciseDetail> exerciseSet;

	/**
	 * @param name
	 * @param weight
	 * @param exerciseSet
	 */
	public Person(String name, double weight,
			HashSet<ExerciseDetail> exerciseSet) {
		super();
		this.name = name;
		this.weight = weight;
		this.exerciseSet = exerciseSet;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the weight
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * @param weight
	 *            the weight to set
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}

	/**
	 * @return the exerciseSet
	 */
	public HashSet<ExerciseDetail> getExerciseSet() {
		return exerciseSet;
	}

	/**
	 * @param exerciseSet
	 *            the exerciseSet to set
	 */
	public void setExerciseSet(HashSet<ExerciseDetail> exerciseSet) {
		this.exerciseSet = exerciseSet;
	}
	
}
