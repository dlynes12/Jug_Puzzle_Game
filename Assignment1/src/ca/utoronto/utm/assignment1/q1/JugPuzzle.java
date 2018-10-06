package ca.utoronto.utm.assignment1.q1;
/**
 * 
 * @author lynessdan
 *
 */
public class JugPuzzle {
    public int moves = 0;
    ca.utoronto.utm.assignment1.q1.Jug[] jugs;

    public void JugPuzzle() {
        jugs = new ca.utoronto.utm.assignment1.q1.Jug[3];
        jugs[0] = new ca.utoronto.utm.assignment1.q1.Jug(8,8);
        jugs[1] = new ca.utoronto.utm.assignment1.q1.Jug(0,5);
        jugs[2] = new ca.utoronto.utm.assignment1.q1.Jug(0,3);

    }

    public boolean isPuzzleSolved()
    {
        return (jugs[0].level == 4 && jugs[1].level == 4);
    }

    public int getMoves() {
        return moves;
    }

    public void move(int j1, int j2) {
        moves++;
        int j2_num = jugs[j2].capacity - jugs[j2].level;
        if (!(jugs[j1].level - j2_num < 0)){
            jugs[j1].level =- jugs[j2].capacity;
            jugs[j2].level =+ j2_num;
        }
    }
	
}
