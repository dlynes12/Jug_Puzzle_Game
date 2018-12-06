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
    private String errorMessage = ""; // error encountered during parse
    private PaintModel paintModel;

    /**
     * Below are Patterns used in parsing
     */
    private Pattern pFileStart = Pattern.compile("^PaintSaveFileVersion1.0$");
    private Pattern pFileEnd = Pattern.compile("^EndPaintSaveFile$");
    private Pattern pCircleStart = Pattern.compile("^Circle$");
    private Pattern pCircleEnd = Pattern.compile("^EndCircle$");
    private Pattern pColor = Pattern.compile("(\\d{1,3},\\d{1,3},\\d{1,3})$");
    private Pattern pRadius = Pattern.compile(":\\d+$");
    private Pattern pCenter = Pattern.compile("\\d+,\\d+");
    private Pattern pFill = Pattern.compile("(false|true)$");
    private Pattern pRectangleStart = Pattern.compile("^Rectangle$");
    private Pattern pRectangleEnd = Pattern.compile("^EndRectangle$");
    private Pattern pSquiggle = Pattern.compile("^Squiggle$");
    private Pattern pSquiggleEnd = Pattern.compile("^EndSquiggle$");


    // ADD MORE!!

    /**
     * Store an appropriate error message in this, including
     * lineNumber where the error occurred.
     *
     * @param mesg
     */
    private void error(String mesg) {
        this.errorMessage = "Error in line " + lineNumber + " " + mesg;
    }

    /**
     * @return the error message resulting from an unsuccessful parse
     */
    public String getErrorMessage() {
        return this.errorMessage;
    }

    /**
     * Parse the inputStream as a Paint Save File Format file.
     * The result of the parse is stored as an ArrayList of Paint command.
     * If the parse was not successful, this.errorMessage is appropriately
     * set, with a useful error message.
     *
     * @param inputStream the open file to parse
     * @param paintModel  the paint model to add the commands to
     * @return whether the complete file was successfully parsed
     */
    public boolean parse(BufferedReader inputStream, PaintModel paintModel) {
        this.paintModel = paintModel;
        this.errorMessage = "";

        // During the parse, we will be building one of the
        // following commands. As we parse the file, we modify
        // the appropriate command.

        CircleCommand circleCommand = null;
        RectangleCommand rectangleCommand = null;
        SquiggleCommand squiggleCommand = null;

        try {
            int state = 0;
            Matcher m;
            String l;

            this.lineNumber = 0;
            while ((l = inputStream.readLine().replaceAll("\\s+", "")) != null) {
                this.lineNumber++;
                System.out.println(lineNumber + " " + l + " " + state);
                switch (state) {
                    case 0:
                        m = pFileStart.matcher(l);
                        if (m.matches()) {
                            state = 1;
                            break;
                        }
                        error("Expected Start of Paint Save File");
                        return false;
                    case 1: // Looking for the start of a new object or end of the save file
                        m = pCircleStart.matcher(l);
                        if (m.matches()) {
                            state = 2;
                            break;
                        }
                    case 2:
                        m = pRectangleStart.matcher(l);
                        if (m.matches()){
                            state=3;
                            break;
                        }
                    case 3:
                        m=pSquiggle.matcher(l);
                        if (m.matches()){
                            state=4;
                        }
                    case 4:
                        m = pFileEnd.matcher(l);
                        if (m.matches()) {
                            return true;
                        } else if (!m.matches()) {
                            return  false;

                        }


                    case 5:
                        // ADD CODE
                        m = pColor.matcher(l);
                        if (m.find()) {
                            String[] colors = m.group(1).split("\\W");
                            circleCommand.setColor(Integer.valueOf(colors[0]), Integer.valueOf(colors[1]), Integer.valueOf(colors[2]));
                            System.out.println();
                            break;
                        }

                    case 6:
                        m=pFill.matcher(l);
                        if (m.find()) {
                            System.out.println("Fill has been set");
                            circleCommand.setFill(Boolean.parseBoolean(m.group(1)));
                            break;
                        }
                    case 7:
                        m = pCenter.matcher(l);
                        if (m.find()) {
                            System.out.println("Fill has been set");
                            String[] coordinates = m.group(1).split(",");
                            circleCommand.setCentre(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1]));
                            break;
                        }
                    case 8:
                        m = pRadius.matcher(l);
                        if (m.find()) {
                            System.out.println("Fill has been set");
                            circleCommand.setRadius(Integer.parseInt(m.group(1)));
                            break;
                        }

                    case 9:
                        m = pRectangleStart.matcher(l);
                        if (m.matches()) {
                            // ADD CODE!!!
                            System.out.println("It's a start of a circle get ready bois");
                            state = 4;
                            break;
                        }
                    case 10:
                        m = pRectangleEnd.matcher(l);
                        if (m.matches()) {
                            state = 1;
                            break;
                        }
                    case 11:
                        m = pSquiggle.matcher(l);
                        if (m.matches()) {
                            // ADD CODE!!!
                            state = 5;
                            break;
                        }
                    case 12:
                        m = pSquiggleEnd.matcher(l);
                        if (m.matches()) {
                            state = 1;
                            break;
                        }
                    case 13:
                        error("We were expecting a new shape object but found none ");
                        return true;
                }
            }
        } catch (Exception e) {
            error("We got a error");
        }
        System.out.println("Done");
        return true;
    }
}