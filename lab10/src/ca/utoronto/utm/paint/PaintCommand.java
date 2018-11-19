package ca.utoronto.utm.paint;
import java.util.Observer;

import javafx.scene.canvas.GraphicsContext;

public abstract class PaintCommand {
	Shape shape;
	public PaintCommand(Shape shape) {
		this.shape=shape;
	}
	public void addObserver(Observer o) {
		this.shape.addObserver(o);
	}
	public abstract void execute(GraphicsContext g);
}
