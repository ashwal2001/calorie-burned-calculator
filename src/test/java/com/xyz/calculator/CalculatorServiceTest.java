package com.xyz.calculator;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.xyz.excercise.Cycling;
import com.xyz.excercise.Exercise;
import com.xyz.excercise.ExerciseDetail;
import com.xyz.excercise.Swimming;
import com.xyz.excerciseFactory.ExerciseFactory;
import com.xyz.excercisedecorator.MorningDecorator;
import com.xyz.excercisedecorator.WaterDecorator;
import com.xyz.person.Person;

public class CalculatorServiceTest {

	static ICalculatorService calculatorService = null;

	@BeforeClass
	public static void setUp() throws Exception {
		// Create singleton object of calculator service using Spring IOC
		calculatorService = new CalculatorService();
	}

	@Before
	public void runBeforeEveryTest() {
		calculatorService.reset();
	}

	@After
	public void runAfterEveryTest() {
		calculatorService.reset();
	}

	@AfterClass
	public static void testCleanup() {
		calculatorService = null;
	}

	@Test
	public void testCycling() {

		HashSet<ExerciseDetail> exerciseSet = new HashSet<ExerciseDetail>();

		Exercise exercise = ExerciseFactory.getExerciseFactory().getExercise(
				Cycling.class);
		ExerciseDetail exerciseDetail = new ExerciseDetail("10:00 AM",
				"10:30 AM", exercise);
		exerciseSet.add(exerciseDetail);

		Person person = new Person("Person One", 54.0, exerciseSet);
		assertEquals(
				0,
				Double.compare(150.0,
						calculatorService.getCalorieBurned(person)));
	}

	@Test
	public void testCyclingLessThan15Mins() {

		HashSet<ExerciseDetail> exerciseSet = new HashSet<ExerciseDetail>();

		Exercise exercise = ExerciseFactory.getExerciseFactory().getExercise(
				Cycling.class);
		ExerciseDetail exerciseDetail = new ExerciseDetail("10:00 AM",
				"10:10 AM", exercise);
		exerciseSet.add(exerciseDetail);

		Person person = new Person("Person One", 54.0, exerciseSet);
		assertEquals(0, Double.compare(50.0,
				calculatorService.getCalorieBurned(person)));

	}

	@Test
	public void testCyclingLessThan40Kg() {

		HashSet<ExerciseDetail> exerciseSet = new HashSet<ExerciseDetail>();

		Exercise exercise = ExerciseFactory.getExerciseFactory().getExercise(
				Cycling.class);
		ExerciseDetail exerciseDetail = new ExerciseDetail("10:00 AM",
				"10:30 AM", exercise);
		exerciseSet.add(exerciseDetail);

		Person person = new Person("Person One", 34.0, exerciseSet);
		assertEquals(
				0,
				Double.compare(150.0,
						calculatorService.getCalorieBurned(person)));
	}

	@Test
	public void testCyclingLessThan40KgAnd15Mins() {

		HashSet<ExerciseDetail> exerciseSet = new HashSet<ExerciseDetail>();

		Exercise exercise = ExerciseFactory.getExerciseFactory().getExercise(
				Cycling.class);
		ExerciseDetail exerciseDetail = new ExerciseDetail("10:00 AM",
				"10:10 AM", exercise);
		exerciseSet.add(exerciseDetail);

		Person person = new Person("Person One", 34.0, exerciseSet);
		assertEquals(0,
				Double.compare(0.0, calculatorService.getCalorieBurned(person)));
	}

	@Test
	public void testSwimming() {

		HashSet<ExerciseDetail> exerciseSet = new HashSet<ExerciseDetail>();

		Exercise exercise = ExerciseFactory.getExerciseFactory().getExercise(
				Swimming.class);
		ExerciseDetail exerciseDetail = new ExerciseDetail("10:00 AM",
				"10:30 AM", exercise);
		exerciseSet.add(exerciseDetail);

		Person person = new Person("Person One", 54.0, exerciseSet);
		assertEquals(
				0,
				Double.compare(150.0,
						calculatorService.getCalorieBurned(person)));
	}

	@Test
	public void testSwimmingLessThan15Mins() {

		HashSet<ExerciseDetail> exerciseSet = new HashSet<ExerciseDetail>();

		Exercise exercise = ExerciseFactory.getExerciseFactory().getExercise(
				Swimming.class);
		ExerciseDetail exerciseDetail = new ExerciseDetail("10:00 AM",
				"10:10 AM", exercise);
		exerciseSet.add(exerciseDetail);

		Person person = new Person("Person One", 54.0, exerciseSet);
		assertEquals(0, Double.compare(50.0,
				calculatorService.getCalorieBurned(person)));
	}

	@Test
	public void testSwimmingLessThan40Kg() {

		HashSet<ExerciseDetail> exerciseSet = new HashSet<ExerciseDetail>();

		Exercise exercise = ExerciseFactory.getExerciseFactory().getExercise(
				Swimming.class);
		ExerciseDetail exerciseDetail = new ExerciseDetail("10:00 AM",
				"10:30 AM", exercise);
		exerciseSet.add(exerciseDetail);

		Person person = new Person("Person One", 34.0, exerciseSet);
		assertEquals(
				0,
				Double.compare(150.0,
						calculatorService.getCalorieBurned(person)));

	}

	@Test
	public void testSwimmingLessThan40KgAnd15Mins() {

		HashSet<ExerciseDetail> exerciseSet = new HashSet<ExerciseDetail>();

		Exercise exercise = ExerciseFactory.getExerciseFactory().getExercise(
				Swimming.class);
		ExerciseDetail exerciseDetail = new ExerciseDetail("10:00 AM",
				"10:10 AM", exercise);
		exerciseSet.add(exerciseDetail);

		Person person = new Person("Person One", 34.0, exerciseSet);
		assertEquals(0,
				Double.compare(0.0, calculatorService.getCalorieBurned(person)));
	}

	@Test
	public void testMorningDecorator() {

		HashSet<ExerciseDetail> exerciseSet = new HashSet<ExerciseDetail>();

		Exercise exerciseDecorator = new MorningDecorator(ExerciseFactory
				.getExerciseFactory().getExercise(Cycling.class));
		ExerciseDetail exerciseDetail = new ExerciseDetail("10:00 AM",
				"10:30 AM", exerciseDecorator);
		exerciseSet.add(exerciseDetail);

		Person person = new Person("Person One", 54.0, exerciseSet);
		assertEquals(
				0,
				Double.compare(165.0,
						calculatorService.getCalorieBurned(person)));
	}

	@Test
	public void testWaterDecorator() {

		HashSet<ExerciseDetail> exerciseSet = new HashSet<ExerciseDetail>();

		Exercise exerciseDecorator = new WaterDecorator(ExerciseFactory
				.getExerciseFactory().getExercise(Swimming.class));

		ExerciseDetail exerciseDetail = new ExerciseDetail("10:00 AM",
				"10:30 AM", exerciseDecorator);

		exerciseSet.add(exerciseDetail);

		Person person = new Person("Person One", 54.0, exerciseSet);
		assertEquals(
				0,
				Double.compare(155.0,
						calculatorService.getCalorieBurned(person)));
	}

	@Test
	public void testMorningWaterDecorator() {

		HashSet<ExerciseDetail> exerciseSet = new HashSet<ExerciseDetail>();

		Exercise exercise = new WaterDecorator(new MorningDecorator(
				ExerciseFactory.getExerciseFactory()
						.getExercise(Swimming.class)));

		ExerciseDetail exerciseDetail = new ExerciseDetail("10:00 AM",
				"10:30 AM", exercise);

		exerciseSet.add(exerciseDetail);

		Person person = new Person("Person One", 54.0, exerciseSet);
		assertEquals(
				0,
				Double.compare(170.0,
						calculatorService.getCalorieBurned(person)));
	}

	// If we need to apply two hour over decorated class then it wont work well.
	@Test
	public void testTwoHourDecorator() {

		HashSet<ExerciseDetail> exerciseSet = new HashSet<ExerciseDetail>();

		Exercise exerciseDecorator = ExerciseFactory.getExerciseFactory()
				.getExercise(Swimming.class);

		ExerciseDetail exerciseDetail = new ExerciseDetail("9:00 AM",
				"12:00 PM", exerciseDecorator);

		exerciseSet.add(exerciseDetail);

		Person person = new Person("Person One", 54.0, exerciseSet);
		assertEquals(
				0,
				Double.compare(945.0,
						calculatorService.getCalorieBurned(person)));
	}

}
