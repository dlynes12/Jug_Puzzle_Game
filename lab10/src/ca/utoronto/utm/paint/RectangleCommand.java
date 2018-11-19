package ca.utoronto.utm.paint;
import javafx.scene.canvas.GraphicsContext;

public class RectangleCommand extends PaintCommand {
	public RectangleCommand(Rectangle rectangle){
		super(rectangle);
	}
	
	@Override
	public void execute(GraphicsContext g) {
		// TODO Auto-generated method stub
		Rectangle rectangle = (Rectangle)this.shape;
		g.setStroke(rectangle.getColor());
		Point topLeft = rectangle.getTopLeft();
		Point dimensions = rectangle.getDimensions();
		if(rectangle.isFill()){
			g.fillRect(topLeft.x, topLeft.y, dimensions.x, dimensions.y);
		} else {
			g.strokeRect(topLeft.x, topLeft.y, dimensions.x, dimensions.y);
		}
	}
}
