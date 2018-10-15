package ca.utoronto.utm.assignment1.puzzle;

/**
 * Implement this interface to define a move. For example,
 * if this was a chess puzzle (for example mate in 3), 
 * a Move might look like E3-E5. If this was a TicTacToe 
 * puzzle, a move might look like 0 or 3, where we identify
 * each position on the board by 0,1,2,3,4,5,6,7,8.
 * For use by the solver to print out a puzzle solution.
 * NOTE: YOU ARE NOT ALLOWED TO MODIFY ANY PART OF THIS PACKAGE!!
 * @author arnold
 *
 */
public interface Move {
	public String toString();
}
