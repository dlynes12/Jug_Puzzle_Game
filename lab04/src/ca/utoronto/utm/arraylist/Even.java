package ca.utoronto.utm.arraylist;
import java.util.*;

public class Even {
	/**
	 * Return all even numbers less than n
	 * @param n
	 * @return An array list of positive evens, less than n [0,2,4,...] 
	 */
	public static ArrayList<Integer> evens(int n){
		// See https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html
		ArrayList<Integer> evenNumbers = new ArrayList<Integer>();
		for(int i=0;i<n;i++) {
			if(i%2==0) {
				evenNumbers.add(i);
			}
		}
		return evenNumbers;
	}
	public static void main(String [] args) {
		ArrayList<Integer> evensLessThan100;
		evensLessThan100 = evens(100);
		System.out.println(evensLessThan100);
	}
}
