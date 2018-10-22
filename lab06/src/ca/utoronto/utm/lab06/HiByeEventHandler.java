package ca.utoronto.utm.lab06;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class HiByeEventHandler implements EventHandler<ActionEvent> {

	public HiByeEventHandler() {
	}

	// 1) Modify this so that it prints out which button was pressed.
	// Hint: Lookup ActionEvent
	// 2) Modify this so that it sets the text field to which button was pressed
	// Hint: this event handler will need access to a the text field

	public void handle(ActionEvent event) {

		System.out.println(" button pressed");
		return;
	}
}
