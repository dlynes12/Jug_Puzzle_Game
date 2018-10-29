package ca.utoronto.utm.scribble;

import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

class ScribblePanel extends StackPane implements EventHandler<MouseEvent> {

	// https://docs.oracle.com/javafx/2/canvas/jfxpub-canvas.htm

	int i = 0;
	ArrayList<Pair> drawingPoints;
	Canvas canvas;

	public ScribblePanel() {
		
		this.canvas = new Canvas(400, 400);
		this.getChildren().add(this.canvas);
		this.setStyle("-fx-background-color: blue");
		this.setEventHandler(MouseEvent.ANY, this);

		drawingPoints = new ArrayList<Pair>();
	}

	public void repaint() {

		// get the graphics context of the canvas (where to draw)
		GraphicsContext g2d = this.canvas.getGraphicsContext2D();

		// first clear the canvas
		g2d.clearRect(0, 0, this.getWidth(), this.getHeight());

		// Origin is at the top left of the window 50 over, 75 down
		g2d.setStroke(Color.WHITE);
		g2d.strokeText("i=" + i, 50, 75);
		i = i + 1;

		// Draw bubbles
		for (Pair p : this.drawingPoints) {
			g2d.strokeOval(p.getX(), p.getY(), 4, 4);
		}

		// Line drawing
		for (int i = 0; i < this.drawingPoints.size() - 1; i++) {
			Pair p1 = this.drawingPoints.get(i);
			Pair p2 = this.drawingPoints.get(i + 1);
			g2d.strokeLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
		}
	}

	@Override
	public void handle(MouseEvent event) {

		if (event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
			mouseDragged(event);
		} else if (event.getEventType() == MouseEvent.MOUSE_MOVED) {
			mouseMoved(event);
		}
	}

	public void mouseDragged(MouseEvent arg0) {
		System.out.println("Dragged " + arg0.getX() + " " + arg0.getY());
		this.drawingPoints.add(new Pair((int) arg0.getX(), (int) arg0.getY()));
		this.repaint(); // schedule a call to paint (and so paintComponent)
	}

	public void mouseMoved(MouseEvent arg0) {
		System.out.println("Moved " + arg0.getX() + " " + arg0.getY());
	}
}
