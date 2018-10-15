package ca.utoronto.utm.assignment1.q2;
import java.util.ArrayList;

import ca.utoronto.utm.assignment1.puzzle.Move;
/**
 * Capture a single move on the JugPuzzle. 
 * @author arnold
 *
 */
public class JugPuzzleMove implements Move {
	private int from, to;

	/**
	 * Create a new JugPuzzleMove capturing a pour from jug 'from' to jug 'to'
	 * @param from 
	 * @param to
	 */
	public JugPuzzleMove(int from, int to) {
		this.from=from;
		this.to=to;
	}
	/**
	 * @return a string representation of this
	 */
	public String toString() {
		return from+" to "+to;
	}

	/**
	 * @return the source jug for the move
	 */
	public int getFrom() {
		return this.from;
	}
	
	/**
	 * @return the destination jug for the move
	 */
	public int getTo() {
		return this.to;
	}
}
