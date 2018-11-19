package ca.utoronto.utm.paint;
import javafx.scene.input.MouseEvent;

class RectangleManipulatorStrategy extends ShapeManipulatorStrategy {
	RectangleManipulatorStrategy(PaintModel paintModel) {
		super(paintModel);
	}

	private Rectangle rectangle;
	
	@Override
	public void mouseDragged(MouseEvent e) {
		Point p2=new Point((int)e.getX(), (int)e.getY());
		this.rectangle.setP2(p2);
	}

	@Override
	public void mousePressed(MouseEvent e) {
			Point p1 = new Point((int)e.getX(), (int)e.getY());
			Point p2 = new Point((int)e.getX(), (int)e.getY());

			Rectangle rectangle = new Rectangle(p1,p2);
			this.rectangle = rectangle;
			RectangleCommand rectangleCommand = new RectangleCommand(this.rectangle);
			this.addCommand(rectangleCommand);
	}
}
