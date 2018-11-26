package ca.utoronto.utm.paint;

import javafx.scene.paint.Color;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Parse a file in Version 1.0 PaintSaveFile format. An instance of this class
 * understands the paint save file format, storing information about
 * its effort to parse a file. After a successful parse, an instance
 * will have an ArrayList of PaintCommand suitable for rendering.
 * If there is an error in the parse, the instance stores information
 * about the error. For more on the format of Version 1.0 of the paint 
 * save file format, see the associated documentation.
 *
 * @author
 *
 */
public class PaintFileParser {
	private int lineNumber = 0; // the current line being parsed
	private String errorMessage =""; // error encountered during parse
	private PaintModel paintModel;

	/**
	 * Below are Patterns used in parsing 
	 */
	private Pattern pFileStart=Pattern.compile("^\\s*P\\s*a\\s*i\\s*n\\s*t\\s*S\\s*a\\s*v\\s*e\\s*F\\s*i\\s*l\\s*e\\s*V\\s*e\\s*r\\s*s\\s*i\\s*o\\s*n\\s*1\\s*.\\s*0\\s*$");
	private Pattern pFileEnd=Pattern.compile("^\\s*E\\s*n\\s*d\\s*P\\s*a\\s*i\\s*n\\s*t\\s*S\\s*a\\s*v\\s*e\\s*F\\s*i\\s*l\\s*e$");
	private Pattern pCircleStart=Pattern.compile("^C\\s*i\\s*r\\s*c\\s*l\\s*e$");
	private Pattern pColor=Pattern.compile("^C\\s*o\\s*l\\s*o\\s*r\\s*:\\s*[0-9,]*$");
	private Pattern pRadius=Pattern.compile("^R\\s*a\\s*d\\s*i\\s*u\\s*s\\s*:[0-9,]$");
	private Pattern pFill=Pattern.compile("^F\\s*i\\s*l\\s*l\\s*:[0-9,]$");
	private Pattern pCircleEnd=Pattern.compile("^E\\s*n\\s*d\\s*C\\s*i\\s*r\\s*c\\s*l\\s*e\\s*$");
	private Pattern pRectangleStart=Pattern.compile("^\\s*R\\s*e\\s*c\\s*t\\s*a\\s*n\\s*g\\s*l\\s*e\\s*$");
	private Pattern pRectangleEnd=Pattern.compile("^\\s*E\\s*n\\s*d\\s*R\\s*e\\s*c\\s*t\\s*a\\s*n\\s*g\\s*l\\s*e\\s*$");
	private Pattern pSquiggle=Pattern.compile("^\\s*S\\s*q\\s*u\\s*i\\s*g\\s*g\\s*l\\s*e\\s*$");
	private Pattern pSquiggleEnd=Pattern.compile("^\\s*E\\s*n\\s*d\\s*S\\s*q\\s*u\\s*i\\s*g\\s*g\\s*l\\s*e\\s*$");



	// ADD MORE!!

	/**
	 * Store an appropriate error message in this, including
	 * lineNumber where the error occurred.
	 * @param mesg
	 */
	private void error(String mesg){
		this.errorMessage = "Error in line "+lineNumber+" "+mesg;
	}

	/**
	 *
	 * @return the error message resulting from an unsuccessful parse
	 */
	public String getErrorMessage(){
		return this.errorMessage;
	}

	/**
	 * Parse the inputStream as a Paint Save File Format file.
	 * The result of the parse is stored as an ArrayList of Paint command.
	 * If the parse was not successful, this.errorMessage is appropriately
	 * set, with a useful error message.
	 *
	 * @param inputStream the open file to parse
	 * @param paintModel the paint model to add the commands to
	 * @return whether the complete file was successfully parsed
	 */
	public boolean parse(BufferedReader inputStream, PaintModel paintModel) {
		this.paintModel = paintModel;
		this.errorMessage="";

		// During the parse, we will be building one of the
		// following commands. As we parse the file, we modify
		// the appropriate command.

		CircleCommand circleCommand = null;
		RectangleCommand rectangleCommand = null;
		SquiggleCommand squiggleCommand = null;

		try {
			int state=0; Matcher m; String l;

			this.lineNumber=0;
			while ((l = inputStream.readLine()) != null) {
				this.lineNumber++;
				System.out.println(lineNumber+" "+l+" "+state);
				switch(state){
					case 0:
						m=pFileStart.matcher(l);
                        if(m.matches()){
							state=1;
							break;
						}
						else if("".equals(l)) {
                            state = 0;
                            break;
                        }
                        error("Expected Start of Paint Save File");
						return false;
					case 1: // Looking for the start of a new object or end of the save file
						m=pCircleStart.matcher(l);
						if(m.matches()){
							// ADD CODE!!!
                            state = 3;
                            System.out.println("It's a start of a circle get ready bois");
                            m=pColor.matcher(l);
                            if (m.matches()) {String c = inputStream.readLine();}


                            String f = inputStream.readLine();
                            String r = inputStream.readLine();



                            break;
						}m=pFileEnd.matcher(l);
						if(m.matches()) {
                            return true;
                        }

					case 2:
						// ADD CODE
						m=pCircleEnd.matcher(l);
						if (m.matches()) {
							state=1;
							break;
						}

					case 3:
						m=pRectangleStart.matcher(l);
						if(m.matches()){
							// ADD CODE!!!
                            System.out.println("It's a start of a circle get ready bois");
                            state=4;
							break;
						}m=pRectangleEnd.matcher(l);
						if (m.matches()) {
							state=1;
							break;
						}
					case 4:
						m=pSquiggle.matcher(l);
						if(m.matches()){
							// ADD CODE!!!
							state=5;
							break;
						}m=pSquiggleEnd.matcher(l);
						if (m.matches()) {
							state=1;
							break;
						}
					case 5:
						error("We were expecting a new shape object but found none ");
				}
				}
			}catch (Exception e){
            error("We got a error");
        }

		return true;
	}
}