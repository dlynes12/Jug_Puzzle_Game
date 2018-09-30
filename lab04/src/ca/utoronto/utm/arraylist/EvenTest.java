package ca.utoronto.utm.arraylist;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class EvenTest {

	@Test
	public void testEvens() {
		// See: https://junit.org/junit4/javadoc/latest/index.html
		// https://www.ibm.com/developerworks/java/tutorials/j-junit4/index.html
		// https://junit.org/junit4/
		// If you want to use annotations, please see...
		// https://github.com/junit-team/junit4/wiki/Test-fixtures
		
		// Run this class and look for a green bar
		// Red bar means problem!
		
		ArrayList<Integer> actual;
		ArrayList<Integer> expected = new ArrayList<Integer>();
		
		actual = Even.evens(-5);
		assertEquals("evens(-5) should be empty", expected, actual);  
		
		actual = Even.evens(-2);
		assertEquals("evens(-2) should be empty", expected, actual);  

		actual = Even.evens(-1);
		assertEquals("evens(-1) should be empty", expected, actual);  

		actual = Even.evens(0);
		assertEquals("evens(0) should be empty", expected, actual);  

		actual = Even.evens(1);
		expected.add(0);
		assertEquals("evens(1) smallest non-empty even set", expected, actual);  

		actual = Even.evens(2);
		assertEquals("evens(2) smallest non-empty even set", expected, actual);  

		actual = Even.evens(11);
		expected.add(2);
		expected.add(4);
		expected.add(6);
		expected.add(8);
		expected.add(10);
		assertEquals("evens(11) more general n", expected, actual);  

		actual = Even.evens(12);
		assertEquals("evens(12) more general n", expected, actual);  
		
		// Just to see what happens when a test case fails...
		// The test case below is not correct!!
		actual = Even.evens(20);
		assertEquals("evens(12) more general n", expected, actual); 		
	}
}
