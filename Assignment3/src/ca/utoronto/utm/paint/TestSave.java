package ca.utoronto.utm.paint;

import java.io.PrintWriter;
import java.io.File;
import java.io.IOException;

import javafx.scene.paint.Color;

public class TestSave {
	public static void main(String [] args) throws Exception{
		TestSave t = new TestSave();
		t.saveTest1();
			t.saveTest2();
			t.saveTest3();
			t.saveTest4();
			t.saveTest5();
			t.saveTest6();
			t.saveTest7();

	}

	private void doSaveTestCase(String fileName, PaintModel paintModel) throws IOException {
		PrintWriter writer = new PrintWriter(new File(fileName));
                View.save(writer, paintModel);
		writer.close();
	}

	public void saveTest1() throws IOException {
		PaintModel pm = new PaintModel();
		this.doSaveTestCase("basic_nospace.txt", pm);
	}
	public void saveTest2() throws IOException {
		/**
		Circle
			color:255,0,0
			filled:true
			center:(123,58)
			radius:11
		EndCircle
		**/
		PaintModel pm = new PaintModel();
		PaintCommand c = new CircleCommand(new Point(123,58), 11);
		c.setFill(true);
		c.setColor(Color.rgb(255,0,0));
		pm.addCommand(c);
		this.doSaveTestCase("circle_single.txt", pm);
	}
	public void saveTest3() throws IOException {
		/**
		Paint Save File Version 1.0
		Circle
			color:81,240,22
			filled:false
			center:(65,62)
			radius:9
		End Circle
		Circle
			color:25,76,32
			filled:true
			center:(123,58)
			radius:11
		End Circle
		End Paint Save File
		**/
		PaintModel pm = new PaintModel();
		PaintCommand c;

		c = new CircleCommand(new Point(65,62), 9);
		c.setFill(false);
		c.setColor(Color.rgb(81,240,22));
		pm.addCommand(c);

		c = new CircleCommand(new Point(123,58), 11);
		c.setFill(true);
		c.setColor(Color.rgb(25,76,32));
		pm.addCommand(c);

		this.doSaveTestCase("circle_multi.txt", pm);
	}
	public void saveTest4() throws IOException {
		/**
		Rectangle
			color:36,18,161
			filled:false
			p1:(62,102)
			p2:(138,110)
		End Rectangle
		**/
		PaintModel pm = new PaintModel();
		PaintCommand c;
		c = new RectangleCommand(new Point(62,102), new Point(138,110));
		c.setFill(false);
		c.setColor(Color.rgb(36,18,161));
		pm.addCommand(c);
		this.doSaveTestCase("rectangle_single.txt", pm);
	}
	public void saveTest5() throws IOException {
		/**
		Paint Save File Version 1.0
		Rectangle
			color:36,18,161
			filled:false
			p1:(62,102)
			p2:(138,110)
		End Rectangle
		Rectangle
			color:32,10,156
			filled:true
			p1:(100,96)
			p2:(130,67)
		End Rectangle
		End Paint Save File
		**/

		PaintModel pm = new PaintModel();
		PaintCommand c;

		c = new RectangleCommand(new Point(62,102), new Point(138,110));
		c.setFill(false);
		c.setColor(Color.rgb(36,18,161));
		pm.addCommand(c);

		c = new RectangleCommand(new Point(100,96), new Point(130,67));
		c.setFill(true);
		c.setColor(Color.rgb(32,10,156));
		pm.addCommand(c);
		this.doSaveTestCase("rectangle_multi.txt", pm);
	}
	public void saveTest6() throws IOException {
		/**
		Paint Save File Version 1.0
		Squiggle
			color:115,164,133
			filled:true
			points
				point:(87,82)
				point:(87,84)
			end points
		End Squiggle
		End Paint Save File
		**/
		PaintModel pm = new PaintModel();
		SquiggleCommand c;

		c = new SquiggleCommand();
		c.add(new Point(87,82));
                c.add(new Point(87,84));
		c.setFill(true);
		c.setColor(Color.rgb(115,164,133));

		pm.addCommand(c);

		this.doSaveTestCase("squiggle_single.txt", pm);
	}
	public void saveTest7() throws IOException {
		PaintModel pm = new PaintModel();
       		PaintCommand c;

                c = new CircleCommand(new Point(65,62), 9);
                c.setFill(false);
                c.setColor(Color.rgb(81,240,22));
                pm.addCommand(c);

                c = new CircleCommand(new Point(123,58), 11);
                c.setFill(true);
                c.setColor(Color.rgb(25,76,32));
                pm.addCommand(c);

		SquiggleCommand s;
		
		s = new SquiggleCommand();
		s.add(new Point(1,2));
                s.add(new Point(3,4));
		s.add(new Point(5,6));
		s.setFill(true);
		s.setColor(Color.rgb(1,2,3));
		pm.addCommand(s);

		s = new SquiggleCommand();
		s.add(new Point(4,5));
                s.add(new Point(6,7));
		s.add(new Point(8,9));
		s.add(new Point(10,11));
		s.add(new Point(12,13));
		s.setFill(true);
		s.setColor(Color.rgb(4,5,6));
		pm.addCommand(s);

		c = new RectangleCommand(new Point(62,102), new Point(138,110));
		c.setFill(false);
		c.setColor(Color.rgb(36,18,161));
		pm.addCommand(c);

		s = new SquiggleCommand();
		s.add(new Point(7,8));
                s.add(new Point(9,10));
		s.add(new Point(11,12));
		s.add(new Point(13,14));
		s.add(new Point(15,16));
		s.setFill(true);
		s.setColor(Color.rgb(7,8,9));
		pm.addCommand(s);

		this.doSaveTestCase("multishapes.txt", pm);
	}
}
