package ca.utoronto.utm.paint;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
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
    private Pattern pSquiggleStart = Pattern.compile("^Squiggle$");
    private Pattern pSquiggleEnd = Pattern.compile("^EndSquiggle$");
    private Pattern pPoints = Pattern.compile("(\\d+,\\d+)");
    private Pattern pSquigglePointStart = Pattern.compile("points$");
    private Pattern pSquigglePointEnd = Pattern.compile("end points$");
    private Pattern pSquigglePoints = Pattern.compile("(\\d+,\\d+)");



    // ADD MORE!!

    GraphicsContext g;
    /**
     * Store an appropriate error message in this, including
     * lineNumber where the error occurred.
     *
     * @param mesg
     */
    private void error(String mesg) {
        this.errorMessage = "Error in line " + lineNumber + " " + mesg + "\n";
        System.out.println(getErrorMessage());
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
                            circleCommand = new CircleCommand(null, 0);
                            state = 5;
                            break;
                        }
                        state = 2;
                        break;
                    case 2:
                        m = pRectangleStart.matcher(l);
                        if (m.matches()){
                            rectangleCommand = new RectangleCommand(null,null);
                            state=7;
                            break;
                        }
                        state = 3;
                        break;
                    case 3:
                        m=pSquiggleStart.matcher(l);
                        if (m.matches()){
                            squiggleCommand = new SquiggleCommand();
                            state=9;
                            break;
                        }
                        state = 4;
                        break;
                    case 4:
                        m = pFileEnd.matcher(l);
                        if (m.matches()) {
                            return true;
                        } else if (!m.matches()) {
                            return  false;

                        }

                    case 5:
                        // Circle one
                        m = pColor.matcher(l);
                        if (m.find()) {
                            String[] colors = m.group(1).split("\\W");
                           circleCommand.setColor(Integer.parseInt(colors[0]), Integer.parseInt(colors[1]), Integer.parseInt(colors[2]));
                            state=6;
                            break;
                        }


                    case 6:
                        m=pFill.matcher(l);
                        if (m.find()) {
                            circleCommand.setFill(Boolean.parseBoolean(m.group(1)));
                            state=11;
                            break;
                        }
                    case 7:
                    // Rectangle one
                    m = pColor.matcher(l);
                    if (m.find()) {
                        String[] colors = m.group(1).split("\\W");
                        circleCommand.setColor(Integer.valueOf(colors[0]), Integer.valueOf(colors[1]), Integer.valueOf(colors[2]));
                        state=8;
                        break;
                        }
                        return false;

                    case 8:
                        m=pFill.matcher(l);
                        if (m.find()) {
                            circleCommand.setFill(Boolean.parseBoolean(m.group(1)));
                            state=16;
                            break;
                        }
                    case 9:
                    // Squiggle one
                    m = pColor.matcher(l);
                    if (m.find()) {
                        String[] colors = m.group(1).split("\\W");
                        squiggleCommand.setColor(Integer.valueOf(colors[0]), Integer.valueOf(colors[1]), Integer.valueOf(colors[2]));
                        state=10;
                        break;
                    }
                    return false;

                    case 10:
                        m=pFill.matcher(l);
                        if (m.find()) {
                            circleCommand.setFill(Boolean.parseBoolean(m.group(1)));
                            state=18;
                            break;
                        }

                    case 11:

                        m = pCenter.matcher(l);
                        System.out.println(l);
                        System.out.println(m.group(1));

                        System.out.println();

                        if (m.find()) {
                            String[] coordinates = m.group(1).split(",");
                            System.out.println(coordinates.toString());
                            Point p = new Point(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1]));
                            circleCommand.setCentre(p);
                            state=12;
                            break;
                        }
                    case 12:
                        m = pRadius.matcher(l);
                        if (m.find()) {
                            Integer r = Integer.parseInt(m.group(1));
                            CircleCommand c = new CircleCommand(circleCommand.getCentre(),r);
                            c.setColor(circleCommand.getColor());c.setFill(circleCommand.isFill());
                            circleCommand = c;
                            circleCommand.setRadius(r);
                            state=15;
                            break;
                        }

                    case 13:
                        m = pRectangleEnd.matcher(l);
                        if (m.matches()) {
                            circleCommand.execute(g);
                            state = 1;
                            break;
                        }
                    case 14:
                        m = pSquiggleEnd.matcher(l);
                        if (m.matches()) {
                            squiggleCommand.execute(g);
                            state = 1;
                            break;
                        }
                    case 15:
                        m = pCircleEnd.matcher(l);
                        if (m.matches()){
                            circleCommand.execute(g);
                            state = 1;
                            break;
                        }
                    case 16:
                        //p1 for rectangle
                        m=pPoints.matcher(l);
                        if (m.matches()){
                            String[] points = m.group(1).split(",");
                            Point p1 = new Point(Integer.parseInt(points[0]), Integer.parseInt(points[1]));
                            rectangleCommand.setP1(p1);
                            state=17;
                            break;
                        }
                    case 17:
                        //p2 for rectangle
                        m=pPoints.matcher(l);
                        if (m.matches()) {
                            String[] points2 = m.group(1).split(",");
                            Point p2 = new Point(Integer.parseInt(points2[0]), Integer.parseInt(points2[1]));
                            rectangleCommand.setP2(p2);
                            state = 13;
                            break;
                        }
                    case 18:
                        //Initial point part of Squiggle EX. points
                        m=pSquigglePointStart.matcher(l);
                        if (m.matches()){
                            state=19;
                            break;
                        }
                    case 19://The rest of the following points for squiggle
                        m=pSquigglePoints.matcher(l);
                        if (m.matches()) {
                            String[] sqp = m.group(1).split(",");
                            Point p = new Point(Integer.parseInt(sqp[0]), Integer.parseInt(sqp[1]));
                            squiggleCommand.add(p);
                            state = 19;
                            break;
                        }
                        state=20;
                        break;

                    case 20:
                        //The End of the points for squiggle
                        m=pSquigglePointEnd.matcher(l);
                        if (m.matches()) {
                            state = 14;
                            break;
                        }
                        return false;


                }
            }
        } catch (Exception e) {
            error("We got a error");
        }
        System.out.println("Done");
        return true;
    }
}