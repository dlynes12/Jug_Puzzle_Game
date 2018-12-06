package ca.utoronto.utm.paint;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class ShapeChooserPanel extends GridPane implements EventHandler<ActionEvent> {

	private View view; // So we can talk to our parent or other components of the view
	public ArrayList<String> commands = new ArrayList<String>();
	public String command;
	private int radius;

	public ShapeChooserPanel(View view) {

		this.view = view;


		String[] buttonLabels = { "Circle", "Rectangle", "Squiggle" };

		int row = 0;
		for (String label : buttonLabels) {
			Button button = new Button(label);
			button.setMinWidth(100);
			this.add(button, 0, row);
			row++;
			button.setOnAction(this);
		}
	}

	@Override
	public void handle(ActionEvent event) {
		this.command = (((Button) event.getSource()).getText());
		this.commands.add(this.command);
		this.view.setPaintPanelShapeManipulatorStrategy(ShapeManipulatorFactory.create(command, view.getPaintModel()));
		PaintPanel n = view.getPaintPanel();
		System.out.println(this.command);

	}

}
