package com.rhapsody.random;
/**
 * Random test case and proof of running correctly 
 * @author Emily Hoang
 * 
 */ 

public class RandomApplication2 {
	public static void main (String[] args) throws Exception {
		String [] inputs = {"1:20", "2:21" , "3:59"};
		int[] freq = new int[inputs.length];
		float maxRun = 1000.0f;
		RandomDistributor randomDistributor = new RandomDistributor(inputs);
		int output;
		for(int i = 0; i < freq.length; i++){
			freq[i] = 0;
		}
		for(int i = 0; i< maxRun; i++) {
			output = randomDistributor.nextNumber();
			freq[output-1]++;
		}
		for(int i = 0; i < freq.length; i++){
			System.out.println((i+1) + " : " +freq[i]/maxRun*100 + " % ");
		}
	}
}
