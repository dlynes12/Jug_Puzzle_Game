package ca.utoronto.utm.paint;
import javafx.scene.canvas.GraphicsContext;
import java.util.ArrayList;

public class SquiggleCommand extends PaintCommand {
	public SquiggleCommand(Squiggle squiggle){
		super(squiggle);
	}
	
	@Override
	public void execute(GraphicsContext g) {
		Squiggle squiggle = (Squiggle)this.shape;
		ArrayList<Point> points = squiggle.getPoints();
		g.setStroke(squiggle.getColor());
		for(int i=0;i<points.size()-1;i++){
			Point p1 = points.get(i);
			Point p2 = points.get(i+1);
			g.strokeLine(p1.x, p1.y, p2.x, p2.y);
		}
		
	}
}
