package ca.utoronto.utm.paint;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestParse {
	public static void main(String [] args){
		TestParse mt = new TestParse();
		try {
			mt.parserTest1();
			mt.parserTest2();
			mt.parserTest3();
			mt.parserTest4();
			mt.parserTest5();
			mt.parserTest6();
			mt.parserTest7();
			mt.parserTest8();
			mt.parserTest9();
			mt.parserTest10();
			mt.parserTest11();
			mt.parserTest12();
			mt.parserTest13();
			mt.parserTest14();
			mt.parserTest15();
			mt.parserTest16();
			mt.parserTest17();
			mt.parserTest18();
			mt.parserTest19();
		} catch (Exception e){
			System.err.println("Exception");
		}
	}

	private void assertFalse(String message, boolean value){
		assertTrue(message,!value);
	}
	private void assertTrue(String message, boolean value){
		if(value){
			System.err.println("CORRECT:"+message);
		} else {
			System.err.println("ERROR:"+message);
		}
	}
	private void assertEquals(String message, String s1, String s2){
		if(s1.equals(s2)){
			System.err.println("CORRECT:"+message);
		} else {
			System.err.println("ERROR:"+message);
		}
	}

	private Pattern pErrorMessage = Pattern.compile("^Error in line\\s+(\\d+)\\s+");
	private void doParserTestCase(String fileName, String message, String expectedErrorMessage) throws IOException {
		BufferedReader lineInput = new BufferedReader(new FileReader(fileName));
		PaintFileParser parser = new PaintFileParser();
		
		PaintModel paintModel = new PaintModel();
		boolean retVal = parser.parse(lineInput, paintModel);
		String errorMessage = parser.getErrorMessage();
		// System.err.println(fileName+" "+ errorMessage);

		if (expectedErrorMessage.equals("")) {
			assertTrue(fileName + ": Returns true for basic file with no spaces", retVal);
			assertEquals(fileName + ": No error message", "", errorMessage);
		} else {
			String reportedLine = "", expectedLine = "";

			assertFalse(fileName + ": Returns false for basic incorrect file format", retVal);
			// System.err.println(errorMessage);
			Matcher m;
			m = pErrorMessage.matcher(expectedErrorMessage);
			if (m.find())
				expectedLine = m.group(1);

			m = pErrorMessage.matcher(errorMessage);
			if (m.find())
				reportedLine = m.group(1);
			// System.err.println(expectedLine+":"+reportedLine);
			assertEquals(fileName + ": Error Message", expectedLine, reportedLine);
		}
		lineInput.close();
	}

	public void parserTest1() throws IOException {
		this.doParserTestCase("basic_nospace.txt", "Returns true for basic file with no spaces", "");
	}

	public void parserTest2() throws IOException {
		this.doParserTestCase("basic_spaces.txt", "Returns true for basic file with no spaces", "");
	}

	public void parserTest3() throws IOException {
		this.doParserTestCase("basic_multispaces.txt", "Returns true for basic file with multiple spaces", "");
	}

	public void parserTest4() throws IOException {
		this.doParserTestCase("basic_fail.txt",
				"Returns false for basic incorrect file format", 
				"Error in line 1 ");
	}

	public void parserTest5() throws IOException {
		this.doParserTestCase("circle_single.txt", "Returns true for file with one circle", "");
	}

	public void parserTest6() throws IOException {
		this.doParserTestCase("circle_multi.txt", "Returns true for file with multiple circles", "");
	}

	public void parserTest7() throws IOException {
		this.doParserTestCase("circle_fail_values.txt", "Returns false for circle with incorrect values",
				"Error in line 3 ");
	}

	public void parserTest8() throws IOException {
		this.doParserTestCase("circle_fail_wrongend.txt", "Returns false for circle with wrong end", "Error in line 7 ");
	}

	public void parserTest9() throws IOException {
		this.doParserTestCase("circle_fail_wrongorder.txt",
				"Returns false for circle with properties in wrong order", "Error in line 3 ");
	}

	public void parserTest10() throws IOException {
		this.doParserTestCase("rectangle_single.txt", "Returns true for file with one rect", "");
	}

	public void parserTest11() throws IOException {
		this.doParserTestCase("rectangle_multi.txt", "Returns true for file with multiple rect", "");
	}

	public void parserTest12() throws IOException {
		this.doParserTestCase("rectangle_wrongorder.txt",
				"Returns false for rect with properties in wrong order", "Error in line 5 ");
	}

	public void parserTest13() throws IOException {
		this.doParserTestCase("squiggle_single.txt", "Returns true for file with one squiggle", "");
	}

	public void parserTest14() throws IOException {
		this.doParserTestCase("multishapes.txt", "Returns true for file with multiple shapes", "");
	}

	public void parserTest15() throws IOException {
		this.doParserTestCase("multishapes_fail_missingend.txt",
				"Returns false for multiple shapes file with incorrect end file line", "Error in line 48 ");
	}

	public void parserTest16() throws IOException {
		this.doParserTestCase("multishapes_fail_missingendshape.txt",
				"Returns false for multiple shapes file with incorrect end shape", "Error in line 13 ");
	}
	public void parserTest17() throws IOException {
		this.doParserTestCase("circle_fail_multiattribure.txt",
				"Returns false for multiple attribute collection in circle", "Error in line 7 ");
	}
	public void parserTest18() throws IOException {
		this.doParserTestCase("multishapes_fail_repeat.txt",
				"Returns false for two files in one", "Error in line 48 ");
	}
	public void parserTest19() throws IOException {
		this.doParserTestCase("multishapes_fail_repeat2.txt",
				"Returns false for two files in one, incomplete restart", "Error in line 47 ");
	}
}

