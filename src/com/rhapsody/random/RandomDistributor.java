package com.rhapsody.random;

import java.util.Random;
/**
 * Random class to generate random number
 * Example Input "1:33", "2:33" , "3:33"
 * @author Emily Hoang
 * 
 */ 
public class RandomDistributor {
	private int[] range;
	private Random random;
	
	/**
	 * Constructor of RandomDistributor
	 * @param inputs
	 * @throws Exception
	 */
	public RandomDistributor(String [] inputs) throws Exception {
		
		if(inputs == null) throw new RuntimeException("Invalid Input");
		range = new int[inputs.length];
		for(int i = 0; i< inputs.length; i++) {
			String input = inputs[i];
			String [] items = input.split(":");
			range[i]= Integer.parseInt(items[1]);
		}
		random = new Random();
	}
	
	/**
	 * Generate next random number
	 * @return next random int in range
	 */
	public int nextNumber() {
		float randomFloat = random.nextFloat()*100;
		float sum = 0;
		for(int i = 0; i<range.length; i++ ) {
			sum += range[i];
			if(randomFloat < sum) {
				return i+1;
			}
		}
		return range.length;
	}
}
