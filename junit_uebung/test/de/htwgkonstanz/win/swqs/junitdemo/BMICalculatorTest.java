package de.htwgkonstanz.win.swqs.junitdemo;

import static org.junit.Assert.*;

import org.junit.Test;

import de.htwgkonstanz.win.swqs.junitdemo.BMICalculator;
import de.htwgkonstanz.win.swqs.junitdemo.BMICalculator.BMI_Category;

public class BMICalculatorTest {

	@Test
	public void testCalculateBMI() {
		// setup
		BMICalculator bmiCalculator = new BMICalculator(183, 80);
		
		// execute
		double bmi = bmiCalculator.calcualateBMI();
		
		// verify
		assertEquals(23.9, bmi, 0.02);
	}
	
	@Test
	public void testGetBMICategoryUnderweight() {
		// setup
		BMICalculator bmiCalculator = new BMICalculator(183, 50);
		
		// execute
		BMICalculator.BMI_Category category = bmiCalculator.getBMICategory();
		
		// verify
		assertEquals(BMI_Category.UNDERWEIGHT, category);
	}

	@Test
	public void testGetBMICategoryNormalWeight() {
		// setup
		BMICalculator bmiCalculator = new BMICalculator(183, 65);
		
		// execute
		BMICalculator.BMI_Category category = bmiCalculator.getBMICategory();
		
		// verify
		assertEquals(BMI_Category.NORMAL_WEIGHT, category);
	}
	
	@Test
	public void testGetBMICategoryOverweight() {
		// setup
		BMICalculator bmiCalculator = new BMICalculator(183, 85);
		
		// execute
		BMICalculator.BMI_Category category = bmiCalculator.getBMICategory();
		
		// verify
		assertEquals(BMI_Category.OVERWEIGHT, category);
	}
	
	@Test
	public void testGetBMICategoryObesity() {
		// setup
		BMICalculator bmiCalculator = new BMICalculator(183, 150);
		
		// execute
		BMICalculator.BMI_Category category = bmiCalculator.getBMICategory();
		
		// verify
		assertEquals(BMI_Category.OBESITY, category);
	}
}
