package ca.utoronto.utm.paint;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.awt.*;

public class CircleCommand extends PaintCommand {
	private Point centre;
	private int radius;

	public CircleCommand(Point centre, int radius){
		this.centre = centre;
		this.radius = radius;

	}
	public Point getCentre() { return centre; }
	public void setCentre(Point centre) {
		this.centre = centre; 
		this.setChanged();
		this.notifyObservers();
	}
	public void setCentre(int x, int y){
		Point p = new Point(x, y);
		this.centre = p;
	}
    public String toString(){
	    String s= super.toString();
        s+="\tcenter:("+this.centre.x+","+this.centre.y+")\n";
        s+="\tradius:"+this.radius+"\n";
        return s;
    }
	public int getRadius() { return radius; }
	public void setRadius(int radius) { 
		this.radius = radius; 
		this.setChanged();
		this.notifyObservers();
	}
	public void execute(GraphicsContext g){
		int x = this.getCentre().x;
		int y = this.getCentre().y;
		int radius = this.getRadius();
		if(this.isFill()){
			g.setFill(this.getColor());
			g.fillOval(x-radius, y-radius, 2*radius, 2*radius);
		} else {
			g.setStroke(this.getColor());
			g.strokeOval(x-radius, y-radius, 2*radius, 2*radius);
		}
	}
}
