package ca.utoronto.utm.assignment1.puzzle;

/**
 * Capture the state of a puzzle as well 
 * as the move that led to this state. 
 * @author arnold
 *
 * NOTE: YOU ARE NOT ALLOWED TO MODIFY ANY PART OF THIS PACKAGE!!
 */
public class State {
	private State previousState; // may be null
	private Move move; // move applied to the puzzle in previous state results in puzzle
	private Puzzle puzzle;
	
	public State(State previousState, Move move, Puzzle puzzle) {
		this.previousState=previousState;
		this.move = move;
		this.puzzle=puzzle;
	}
	
	public Puzzle getPuzzle() { return this.puzzle; }
	public State getPreviousState() { return this.previousState; }
	public Move getMove() { return this.move; }
}
