package ca.utoronto.utm.arraylist;

import java.util.ArrayList;

public class Odd {
	/**
	 * Return all odd numbers less than n
	 * @param n
	 * @return An array list of positive odds, less than n [1,3,5,7,...] 
	 */
	public static ArrayList<Integer> odds(int n) {
		// See https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html
		ArrayList<Integer> oddNumbers= new ArrayList<Integer>();
		for(int i=0;i<n;i++) {
			if(i%2!=0) {
				oddNumbers.add(i);
			}
		}
		return oddNumbers;
	}

	public static void main(String[] args) {
		// Print out all odd numbers less than 100
	}
}
