package ca.utoronto.utm.assignment1.q2;

import java.util.ArrayList;

import ca.utoronto.utm.assignment1.puzzle.Puzzle;
import ca.utoronto.utm.assignment1.puzzle.States;

/**
 * A Jug Puzzle consists of three Jugs (numbered 0,1 and 2) with capacities 8,5
 * and 3 respectively. Initially, jug 0 is full, the other two are empty. The
 * player of the game spills liquid between the jugs (move) until both jugs 0
 * and 1 contain 4 units of liquid each. When a player makes a move, one Jug spills into
 * another. The JugPuzzle knows how many moves have taken place since the start
 * of the game. A spill ends as soon as one jug is empty or one jug is filled.
 * 
 * @author csc207student
 */

// NOTE: Class doc explains why one would use this class. 

public class JugPuzzle extends Puzzle {
	
	// NOTE: All instance vars are private
	// NOTE: jugs should be an array. 
	// Why? The number of Jugs is fixed for the life of the JugPuzzle.
	private Jug[] jugs;
	private int moves;

	/**
	 * Create a new JugPuzzle with three jugs, capacities 8,5,3
	 * and initial amounts 8,0,0. The goal is to achieve amounts
	 * 4,4,0. Initially the number of moves is 0.
	 */
	public JugPuzzle() {
		this.jugs = new Jug[3];
		this.jugs[0] = new Jug(8, 8);
		this.jugs[1] = new Jug(5);
		this.jugs[2] = new Jug(3);
		this.moves = 0;
	}
	
	/**
	 * Create a new JugPuzzle as a deep copy of other.
	 * @param other the JugPuzzle whose state this will replicate
	 */
	public JugPuzzle(JugPuzzle other) {
		
		// NOTE: Logic for deep copy should be split between
		// JugPuzzle and Jug. JugPuzzle should not need to know
		// how to copy a Jug. JugPuzzle should ask Jug to duplicate.
		// Why: It is the responsibility of a Jug to understand
		// what determines the Jugs state.
		
		this.jugs = new Jug[other.jugs.length];
		for(int i=0;i<this.jugs.length;i++) {
			this.jugs[i]=new Jug(other.jugs[i]);
		}
		this.moves = other.moves;
	}
	
	/**
	 * 
	 * @return the number of moves since the start of the game
	 */
	public int getMoves() {
		return moves;
	}

	/**
	 * Return a list of all moves that can be made on this JugPuzzle.
	 * @return An array list of all possible moves
	 */
	public ArrayList<JugPuzzleMove> getAllMoves() {
		// NOTE: I can't see a good reason for making allMoves part of the instance
		// You may consider making allMoves static, with an associated static variable.
		// This is a flexible compromise.
		
		ArrayList<JugPuzzleMove> allMoves=new ArrayList<JugPuzzleMove>();
		for(int i=0;i<this.jugs.length;i++) {
			for(int j=0;j<this.jugs.length;j++) {
				allMoves.add(new JugPuzzleMove(i,j));
			}
		}
		return allMoves;
	}
	
	/**
	 * 
	 * @return whether this is solved, that is 4 units in jugs 0 and 1 each.
	 */
	public boolean isPuzzleSolved() {
		return jugs[0].getAmount() == 4 && jugs[1].getAmount() == 4;
	}

	/**
	 * Make a single move of the JugPuzzle, that is spill Jug 'from' into Jug 'to'.
	 * This counts as a single move.
	 * 
	 * @param from an integer identifying a jug
	 * @param to an integer identifying a jug
	 */
	public void move(int from, int to) {
		// NOTE: JugPuzzle should not be directly modifying Jug internal state in move
		// NOTE: all logic for spill from/to is in jug.
		// NOTE: Why: Spilling from one jug to another involves only Jug concepts.
		
		if(0<=from && from<jugs.length && 0<=to && to<jugs.length){
			jugs[from].spillInto(jugs[to]);
			moves++;
		}
	}

	/**
	 * @return a string representation of this
	 */
	public String toString() {
		return moves + " " + " 0:" + jugs[0] + " 1:" + jugs[1] + " 2:" + jugs[2];
	}

	@Override
	public void nextStates(States states) {
		for(JugPuzzleMove move: this.getAllMoves()){
			// Only consider moves that could make a difference in the state of the JugPuzzle
			if(move.getFrom()!=move.getTo()) {
				JugPuzzle tempPuzzle = new JugPuzzle(this);
				tempPuzzle.move(move);
				states.add(tempPuzzle, move);
			}
		}
	}

	/**
	 * Make a move on this as specified by move
	 * @param move the move to apply to this
	 */
	public void move(JugPuzzleMove move) {
		this.move(move.getFrom(), move.getTo());
	}
	
	// NOTE: overload existing methods, do not repeat them
	// NOTE: no long chains of if to choose the jug
}
