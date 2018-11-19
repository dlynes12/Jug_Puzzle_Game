package ca.utoronto.utm.paint;
import javafx.scene.canvas.GraphicsContext;

public class CircleCommand extends PaintCommand {
	public CircleCommand(Circle circle){
		super(circle);
	}
	public void execute(GraphicsContext g){
		Circle circle = (Circle)this.shape;
		g.setStroke(circle.getColor());
		int x = circle.getCentre().x;
		int y = circle.getCentre().y;
		int radius = circle.getRadius();
		if(circle.isFill()){
			g.fillOval(x-radius, y-radius, 2*radius, 2*radius);
		} else {
			g.strokeOval(x-radius, y-radius, 2*radius, 2*radius);
		}
	}
}
