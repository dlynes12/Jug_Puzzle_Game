package ca.utoronto.utm.lab04;
import java.util.Scanner;

public class PlayWithShapes {

	// 0) Review OO notes/examples from lecture
	// 1) Declare a variable "shapes" that will reference an array of reference to Shape
	Shape [] shapes;
	public PlayWithShapes() {
	
		// 2) Make shapes equal a new array of 10 references to Shapes
		
		// 3) point shapes[0], ..., shapes[9] to new Rectangles and Circles
		shapes[0]=new Circle("magneta", 4, 4, 4);
		shapes[1]=new Rectangle("purple", 7, 11, 11, 30);
		shapes[2]=new Circle("black", 3, 3, 3);
		shapes[3]=new Circle("blue", 4, 4, 4);
		shapes[5]=new Circle("green", 10, 10, 12);
		shapes[4]=new Rectangle("marine", 5, 5, 5, 5);
		shapes[6]=new Circle("yellow", 6, 10, 10);
		shapes[7]=new Rectangle("kiwi green", 5, 5, 5, 5);
		shapes[8]=new Circle("orange", 4, 1, 1);
		shapes[9]=new Circle("red", 10, 5, 5);
		// ...
		
	}
	
	/**
	 * Print the String representation of all Shapes referenced to 
	 * within the "shapes" array.s
	 * (This calls the .toString() method for each Shape).
	 */
	public void printShapes() {
		for (Shape s:shapes) {
			System.out.println(s);
		}
	}
	
	// 4) Complete moveShapes below to satisfy its javadoc

	/**
	 * Change the position of all referenced Shapes in the shapes array 
	 * by the given dx and dy
	 * @param dx the amount to change all shapes x coordinates
	 * @param dy the amount to change all shapes y coordinates
	 */
	public void moveShapes(int dx, int dy) {
		//TODO: Complete this method
		for (Shape s:shapes){
			s.setX(s.getX() + dx);
			s.setY(s.getY() + dy);
		}
		
	}

	// 4) Complete colorShapes below to satisfy its javadoc

	/**
	 * Change the color of all referenced Shapes in the shapes array
	 * to the given color
	 * @param c the color that all the shapes should be set to
	 */
	public void colorShapes(String c) {
		for(Shape s:shapes){
			s.setColor(c);
		}
		
		//TODO: Complete this method
	}
	
	
	public static void main(String[] args) {
		
		PlayWithShapes s = new PlayWithShapes();
		
		// 5) Move all of the shapes around a bit
		Scanner scanner=new Scanner(System.in);
		while(true){
			System.out.println("Enter 'move' or 'color': ");
			String choice = scanner.nextLine();
			if (choice.equals("move")) {
				System.out.print("dx: ");
				String dxs=scanner.nextLine();
				int dx=Integer.parseInt(dxs);
			
				System.out.print("dy: ");
				String dys=scanner.nextLine();
				int dy=Integer.parseInt(dys);
			
				s.moveShapes(dx, dy);
				s.printShapes();
			} else if (choice.equals("color")) {
				System.out.print("what color?: ");
				String newColor = scanner.nextLine();
				s.colorShapes(newColor);
				s.printShapes();
			}
		}
	}

}