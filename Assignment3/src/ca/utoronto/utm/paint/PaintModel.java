package ca.utoronto.utm.paint;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javafx.scene.canvas.GraphicsContext;

public class PaintModel extends Observable implements Observer {
    public ArrayList<PaintCommand> commands = new ArrayList<PaintCommand>();
    Point p  = new Point(1,3);
    private CircleCommand circleCommand = new CircleCommand(p, 5);
    private RectangleCommand rectangleCommand = new RectangleCommand(p, p);
    private SquiggleCommand squiggleCommand = new SquiggleCommand();


    public void save(PrintWriter writer) {
	    Integer i=0;
        ArrayList<String> shapes = new ArrayList<String>();

        for (PaintCommand com : this.commands) {
            if (com.getClass().isInstance(circleCommand)){shapes.add("Circle");shapes.add("EndCircle");}
            if (com.getClass().isInstance(rectangleCommand)){shapes.add("Rectangle");shapes.add("EndRectangle");}
            if (com.getClass().isInstance(squiggleCommand)){shapes.add("Squiggle");shapes.add("EndSquiggle");}
            String[] temp = com.toString().split("\n");
            if (i < shapes.size()) {
                writer.println(shapes.get(i));
                for (String c : temp) {
                    writer.println("    " + c);
                }
                i++;
            writer.println(shapes.get(i));
            i++;
            }
            System.out.println(temp);

        }
        writer.println("End Paint Save File");
        writer.close();

		
	}
	public void reset(){
		for(PaintCommand c: this.commands){
			c.deleteObserver(this);
		}
		this.commands.clear();
		this.setChanged();
		this.notifyObservers();
	}
	
	public void addCommand(PaintCommand command){
		this.commands.add(command);
		command.addObserver(this);
		this.setChanged();
		this.notifyObservers();
	}


	public void executeAll(GraphicsContext g) {
		for(PaintCommand c: this.commands){
			c.execute(g);
		}
	}
	
	/**
	 * We Observe our model components, the PaintCommands
	 */
	@Override
	public void update(Observable o, Object arg) {
		this.setChanged();
		this.notifyObservers();
	}
}
