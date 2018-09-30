package ca.utoronto.utm.assignment1.puzzle;

import java.util.ArrayList;
/**
 * 
 * @author arnold
 *
 * NOTE: YOU ARE NOT ALLOWED TO MODIFY ANY PART OF THIS PACKAGE!!
 */
public class States extends ArrayList<State>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private State previousState;
	
	/** 
	 * Only can be created by this package. Users will be passed an instance
	 * and call its add method.
	 */
	States() { } 
	
	/**
	 * All adds after setPreviousState will refer back to
	 * the earlier state. printSolution uses previousState to
	 * follow a path from solved puzzle back to initial puzzle
	 * and so can print the moves needed to solve the puzzle.
	 * @param previousState the state all subsequent adds should point to
	 */
	void setPreviousState(State previousState) {
		this.previousState = previousState;
	}
	
	/**
	 * Add a puzzle and move to this list of States
	 * @param puzzle
	 * @param move
	 */
	public void add(Puzzle puzzle, Move move) {
		State s = new State(this.previousState, move, puzzle);
		this.add(s);
	}
}
