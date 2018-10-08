package ca.utoronto.utm.assignment1.q2;

public class Jug {
    public int level;
    public int capacity;
    public int identifier;
    public int moves = 0;
    public Jug(int identifier, int level, int capacity) {
    	this.identifier = identifier;
        this.level = level;
        this.capacity = capacity;
        this.moves = 0;

    }
    public String toString() {
    	return (this.identifier + ":(" + this.level + "/" + this.capacity);
    }
}
