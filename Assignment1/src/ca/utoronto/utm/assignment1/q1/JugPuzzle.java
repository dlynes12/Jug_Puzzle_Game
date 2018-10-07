package ca.utoronto.utm.assignment1.q1;
/**
 * 
 * @param <Jug>
 * @lynessdan
 *
 */
public class JugPuzzle {
   public int moves = 0;
   public Jug[] jugs;

    public JugPuzzle() {
        jugs = new Jug[3];
        jugs[0] = new Jug(0,8,8);
        jugs[1] = new Jug(1,0,5);
        jugs[2] = new Jug(2,0,3);

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
    	return (moves + " " + jugs[0] + " " + jugs[1] + " " + jugs[2]);
    }
}

