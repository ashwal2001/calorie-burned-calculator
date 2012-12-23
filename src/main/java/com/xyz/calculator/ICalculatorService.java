package com.xyz.calculator;

import com.xyz.person.Person;

public interface ICalculatorService {

	void reset();

	double getCalorieBurned(Person person);

}
