package ca.utoronto.utm.assignment1.q1;
import javaa.io.*;
import java.util.*;
import Jug.*;
/**
 * @daniel_lynes
 * This class allows a console user to play an instance of JugPuzzle.
 */
public class JugPuzzleController {
        private static final String INVALID_INPUT_MESSAGE="Invalid number, please enter 0,1 or 2";

        private Scanner scanner;
        private ca.utoronto.utm.assignment1.q1.JugPuzzle jugPuzzle;

        /**
         * Constructs a new JugPuzzleController with a new JugPuzzle, 
         * ready to play with a user at the console.
         */
        public JugPuzzleController(){
                jugPuzzle=new ca.utoronto.utm.assignment1.q1.JugPuzzle();
                scanner=new Scanner(System.in);
        }

        /**
         * getMove() is a method that gets the next move
         * from the player by getting input from the keyboard
         * and checking if it is a possible move.
         * If it is a possible move it will use make the move by
         * passing it to the play() method.
         * @param message (Tells what needs to be entered ex (Spill from jug # to jug #))
         * @param lower   (The jug denoted by the smallest number)
         * @param upper   (The jug denoted by the largest number)
         * @return        (It returns the move selected by the player)
         */
        private int getMove(String message, int lower, int upper){
                int move;
                while(true){
                        try {
                                System.out.print(message);
                                String line=scanner.nextLine();
                                move=Integer.parseInt(line);
                                if(lower<=move && move<=upper){
                                        return move;
                                } else {
                                        System.out.println(INVALID_INPUT_MESSAGE);
                                }
                        }
                        catch(NumberFormatException e){
                                System.out.println(INVALID_INPUT_MESSAGE);
                        }
                }
        }
        /**
         * play() is a method that does not return anything,
         * but it will print out a message when the puzzle gets solved.
         * until then it will ask the player to move the water between the jugs.
         *
         */
        public void play(){
                while(!jugPuzzle.isPuzzleSolved()){
                        System.out.println(jugPuzzle); // called the toString() method of jugPuzzle
                        int from, to;
                        from = getMove("spill from jug: ", 0,2);
                        to   = getMove("into jug: ",0,2);
                        jugPuzzle.move(from,to);
                }
                if(jugPuzzle.getMoves()==1) {
                    System.out.println("Congrats you solved it in "+jugPuzzle.getMoves()+" move!!");
                } else {
                	System.out.println("Congrats you solved it in "+jugPuzzle.getMoves()+" moves!!");
                }
        }

        public static void main(String [] args){
                JugPuzzleController jpcc=new JugPuzzleController();
                jpcc.play();
        }
}
