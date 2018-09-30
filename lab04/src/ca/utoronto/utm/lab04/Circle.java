package ca.utoronto.utm.lab04;
/**
 * A Circle is a Shape. Circles have all methods and attributes of Shape and
 * then some more.
 * @author Arnold Rosenbloom
 */
public class Circle extends Shape {

	private int radius;

	/**
	 * Initialize a red circle with radius 10, position 100,100
	 */
	public Circle() {
		this("red", 10, 100, 100);
	}

	/**
	 * Initialize a new circle with specified Color, radius and position
	 *
	 * @param c the desired color
	 * @param r the desired radius
	 * @param x the desired x coordinate
	 * @param y the desired x coordinate
	 */
	public Circle(String c, int radius, int x, int y) {
		super(c, x, y); // Tell the Shape
		setRadius(radius);
	}

	/**
	 * Set the radius of this circle and tell our observer that we have changed
	 *
	 * @param r the desired radius
	 * @return nothing
	 */
	public void setRadius(int r) {
		if (r > 0)
			radius = r;
	}

	/**
	 * @return the radius of this
	 */
	public int getRadius() {
		return radius;
	}

	/**
	 * @return a String representation of this
	 */
	public String toString() {
		String s = super.toString() + " Radius: " + getRadius();
		return (s);
	}

}
