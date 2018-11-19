package ca.utoronto.utm.paint;
import javafx.scene.input.MouseEvent;

class SquiggleManipulatorStrategy extends ShapeManipulatorStrategy {
	SquiggleManipulatorStrategy(PaintModel paintModel) {
		super(paintModel);
	}

	private Squiggle squiggle;
	@Override
	public void mouseDragged(MouseEvent e) {
		this.squiggle.add(new Point((int)e.getX(), (int)e.getY()));
	}

	@Override
	public void mousePressed(MouseEvent e) {
			this.squiggle = new Squiggle();
			SquiggleCommand squiggleCommand = new SquiggleCommand(this.squiggle);
			this.addCommand(squiggleCommand);
	}
}
