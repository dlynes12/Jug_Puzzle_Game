package ca.utoronto.utm.paint;

import java.util.Observable;
import java.util.Observer;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

class PaintPanel extends StackPane implements Observer, EventHandler<MouseEvent> {

	private PaintModel model; // slight departure from MVC, because of the way painting works
	private View view; // So we can talk to our parent or other components of the view
	private Canvas canvas;
	private ShapeManipulatorStrategy strategy;
	
	public PaintPanel(PaintModel model, View view) {

		this.canvas = new Canvas(300, 300);
		this.getChildren().add(this.canvas);
		// The canvas is transparent, so the background color of the
		// containing pane serves as the background color of the canvas.
		this.setStyle("-fx-background-color: blue");

		this.addEventHandler(MouseEvent.ANY, this);
		this.model = model;
		this.model.addObserver(this);
		this.view = view;
		this.setShapeManipulatorStrategy(new ShapeManipulatorStrategy(this.model)); // set to the empty strategy
	}

	public void repaint() {
		GraphicsContext g = this.canvas.getGraphicsContext2D();
		g.clearRect(0, 0, this.getWidth(), this.getHeight());
		this.model.executeAll(g);
	}

	@Override
	public void update(Observable o, Object arg) {
		this.repaint();
	}

	@Override
	public void handle(MouseEvent event) {
		this.strategy.handle(event);
	}
	public void setShapeManipulatorStrategy(ShapeManipulatorStrategy strategy) {
		this.strategy = strategy;
	}
}

