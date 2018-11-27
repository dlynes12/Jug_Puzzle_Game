package ca.utoronto.utm.regexfsm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexFSMPractice {
	public static void main(String[] args) {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		try {
			while ((line = in.readLine()) != null) {
				if (recognizeSomethingRegex(line)) {
					System.out.println("recognizeSomethingRegex accepts " + line);
				} else {
					System.out.println("recognizeSomethingRegex rejects " + line);
				}
				if (recognizeSomethingFSM(line)) {
					System.out.println("recognizeSomethingFSM accepts " + line);
				} else {
					System.out.println("recognizeSomethingFSM rejects " + line);
				}
				if (recognizeWellFedRegex(line)) {
					System.out.println("recognizeWellFedRegex accepts " + line);
				} else {
					System.out.println("recognizeWellFedRegex rejects " + line);
				}
				if (recognizeWellFedFSM(line)) {
					System.out.println("recognizeWellFedFSM accepts " + line);
				} else {
					System.out.println("recognizeWellFedFSM rejects " + line);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Come up with some strings so that recognizeSomethingRegex returns true
	 * 
	 * YOUR ANSWER GOES HERE
	 * 
	 * Describe what this recognizes.
	 * 
	 * YOUR ANSWER GOES HERE
	 * 
	 */
	String ex1 = new String("211dj:x dog end");
	String ex2= new String("311dj:x elephant end");
	String ex3 = new String("531dj:x cat end");
	String ex4 = new String("811dj:x any word or character end");

	
	public static boolean recognizeSomethingRegex(String s) {
		Pattern p = Pattern.compile("^[0-9]+[aeiou]{3}:(x|y|z)(.*)end$");
		Matcher m = p.matcher(s);
		if (m.matches()) {
			System.out.println("Groupcount: " + m.groupCount());
			System.out.println("Group 1: "+m.group(1));
			System.out.println("Group 2: "+m.group(2));
			return true;
		} else {
			return false;
		}
	}
	/**
	 * Come up with some strings so that recognizeSomethingFSM returns true
	 * 
	 * YOUR ANSWER GOES HERE
	 * 
	 * Describe what this recognizes.
	 * 
	 * YOUR ANSWER GOES HERE
	 * 
	 */

	String FSMex1 = new String("1234567890");
	String FSMex2= new String("00000010");


	public static boolean recognizeSomethingFSM(String s) {
		char [] c=s.toCharArray();
		int len=s.length();
		// We can now access the characters of s one at a time via c[0], c[1], ..., c[len-1]
		
		boolean retVal=true;
		
		int n=0;
		int state=0; // Start out in the initial state
		while(n<len){
			switch(state){	
				case 0:
					if ('1'<=c[n] && c[n]<='9')
						state = 0;
					else if (c[n] == '0')
						state = 1;
					else 
						state=2;
					break;
				case 1:
					if (c[n] == '0') 
						state = 1;
					else if ('1'<=c[n] && c[n]<='9')
						state = 0;
					else 
						state=2;
					break;
				case 2:
					break;
			}
			n = n + 1;
		}
		if (state != 1)
			retVal=false;
		
		return retVal;
	}

	/**
	 * 
	 * A well-fed number is an integer in which 7s appear but 9s do not. (Why? Because seven eight nine.) 
	 * This means the number can be made up of any digits EXCEPT 9, and must include AT LEAST ONE 7.
	 * This recognizer uses a regular expression to determine if the string given is a well-fed number.
	 * 
	 * @param s
	 * @return whether s is the string representation of a well-fed number
	 */
	public static boolean recognizeWellFedRegex(String s) {
		
		// COMPLETE THIS METHOD

		Pattern p = Pattern.compile("^[0-8]*(7)$");
		Matcher m = p.matcher(s);
		return m.matches();
	}

	/**
	 * This recognizer uses a Finite State Machine to determine whether s
	 * represents a well-fed number (as defined above)
	 * 
	 * @param s
	 * @return whether s is the string representation of a well-fed number
	 */
	public static boolean recognizeWellFedFSM(String s) {
		// COMPLETE THIS METHOD
		
		char [] c=s.toCharArray();
		int len=s.length();
		
		boolean retVal=false;
		
		int n=0;
		int state=0; // Start out in the initial state
		while(n<len){
			switch(state){	
				case 0:
					if (c[n] >= '0' && c[n] <= '6') {
						break;
					}
					else if (c[n] == '8') {break;}
					else if (c[n] == '7') {retVal=true;}

					else {
						state=2;
						break;
					}
					break;
				case 1:
					retVal = false;
					break;
			}
			n=n+1;
		}
		return retVal;
	}
}