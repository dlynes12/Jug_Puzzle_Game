package ca.utoronto.utm.lab06;

import javafx.scene.layout.FlowPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ButtonPanel extends FlowPane implements EventHandler<ActionEvent> {

	TextField tf;

	public ButtonPanel() {

		Button b;

		b = new Button("Up");
		this.getChildren().add(b);
		b.setOnAction(this);

		b = new Button("Down");
		this.getChildren().add(b);
		b.setOnAction(this);

		b = new Button("Left");
		this.getChildren().add(b);
		b.setOnAction(this);

		b = new Button("Right");
		this.getChildren().add(b);
		b.setOnAction(this);

		tf = new TextField();
		tf.setPrefColumnCount(10);
		this.getChildren().add(tf);
	}

	public void handle(ActionEvent event) {

		tf.setText(((Button) (event.getSource())).getText());
		return;
	}

}
