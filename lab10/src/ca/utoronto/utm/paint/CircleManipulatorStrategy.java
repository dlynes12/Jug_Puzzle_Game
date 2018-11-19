package ca.utoronto.utm.paint;
import javafx.scene.input.MouseEvent;

class CircleManipulatorStrategy extends ShapeManipulatorStrategy {
	private Circle circle;
	
	public CircleManipulatorStrategy(PaintModel paintModel) {
		super(paintModel);
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		int x1=circle.getCentre().x, y1=circle.getCentre().y;
		int x2=(int)e.getX(), y2=(int)e.getY();
		
		int radius = (int)Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
		this.circle.setRadius(radius);
	}

	@Override
	public void mousePressed(MouseEvent e) {
			Point centre = new Point((int)e.getX(), (int)e.getY());
			this.circle=new Circle(centre, 0);
			CircleCommand circleCommand = new CircleCommand(this.circle);
			this.addCommand(circleCommand);
	}
}
