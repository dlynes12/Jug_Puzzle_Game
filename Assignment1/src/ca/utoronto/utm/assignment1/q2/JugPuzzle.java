package ca.utoronto.utm.assignment1.q2;

import ca.utoronto.utm.assignment1.puzzle.Puzzle;
import ca.utoronto.utm.assignment1.puzzle.States;
import ca.utoronto.utm.assignment1.puzzle.Move;
import ca.utoronto.utm.assignment1.q2.Jug;

/**
 * 
 * @param <Jug>
 * @lynessdan
 *
 */
public class JugPuzzle extends Puzzle {
   public int moves = 0;
   public Jug[] jugs;
   public Move[] allPossibleMoves;
   public Puzzle tempPuzzle;
   

    public JugPuzzle() {
        this.jugs = new Jug[3];
        this.jugs[0] = new Jug(0,8,8);
        this.jugs[1] = new Jug(1,0,5);
        this.jugs[2] = new Jug(2,0,3);

    }
    
    public Move[] allPossibleMoves() {
		return allPossibleMoves;
    	
    	
    }
    public boolean isPuzzleSolved() {
        return (jugs[0].level == 4 && jugs[1].level == 4);
    }

    public int getMoves() {
        return moves;
    }

    public void move(int j1, int j2) {
        moves++;
        int j2_num = jugs[j2].capacity - jugs[j2].level;
        if (jugs[j1].level <= j2_num){
            jugs[j2].level += jugs[j1].level;
            jugs[j1].level = 0;
        }else {
        	jugs[j2].level = jugs[j2].capacity;
        	jugs[j1].level -= j2_num;
        }  		 
        
    }
    public String toString() {
    	return (moves + " " + this.jugs[0] + " " + this.jugs[1] + " " + this.jugs[2]);
    }

	public void nextStates(States states) {
		// TODO Auto-generated method stub
		for(Move move: allPossibleMoves){
 			 tempPuzzle = this.copy();
 		     states.add(tempPuzzle, move);
 		      }
 		  }

	private JugPuzzle copy() {
		JugPuzzle pCopy = new JugPuzzle();
		pCopy.jugs = this.jugs;
		return pCopy;
	}
		
}

