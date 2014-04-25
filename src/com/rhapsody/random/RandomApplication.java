package com.rhapsody.random;
/**
 * Random test case
 * @author Emily Hoang
 * 
 */ 
public class RandomApplication {
	public static void main (String[] args) throws Exception {
		String [] inputs = {"1:20", "2:21" , "3:59"};
		RandomDistributor randomDistributor = new RandomDistributor(inputs);
		int output;
		for(int i = 0; i< 10; i++) {
			output = randomDistributor.nextNumber();
			System.out.println(output);
		}
	}
}
