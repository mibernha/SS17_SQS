package de.htwgkonstanz.win.swqs.junitdemo;

public class BMICalculator {

	private int height;
	private int weight;
	
	public enum BMI_Category {UNDERWEIGHT, NORMAL_WEIGHT,OVERWEIGHT, OBESITY};
	
	/**
	 * Creates a new calculator for the body mass index
	 * 
	 * @param height height in centimeters
	 * @param weight weight in kilograms
	 */
	public BMICalculator(int height, int weight) {
		this.height = height;
		this.weight = weight;
	}
	
	
	/**
	 * Get the BMI.
	 */
	public double calcualateBMI() {
		double heightInMeter = (double)height/100;
		return (weight / (heightInMeter*heightInMeter));
	}

	/**
	 * Return the BMI Category.
	 */
	public BMI_Category getBMICategory() {
		double bmi = calcualateBMI();
		if (bmi < 18.5)
			return BMI_Category.UNDERWEIGHT;
		if (bmi < 25)
			return BMI_Category.NORMAL_WEIGHT;
		if (bmi < 30)
			return BMI_Category.OVERWEIGHT;
		return BMI_Category.OBESITY;
	}
}