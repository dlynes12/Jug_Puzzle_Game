package ca.utoronto.utm.lab04;

/**
 * A Shape has a position and a color (all of which can be modified).
 * @author Arnold Rosenbloom
 */

public abstract class Shape {

	private int x, y; // position of the shape
	private String color;

	/**
	 * Initialize a new Shape with specified color and position
	 *
	 * @param c the desired color
	 * @param x the desired x coordinate
	 * @param y the desired x coordinate
	 */
	public Shape(String c, int x, int y) {
		setPosition(x, y);
		setColor(c);
	}

	/**
	 * Set the position of this Shape
	 *
	 * @param x the new x coordinate
	 * @param y the new x coordinate
	 */
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Set the x coordinate of this Shape
	 *
	 * @param x the new x coordinate
	 */
	public void setX(int x) {
		setPosition(x, y);
	}

	/**
	 * Set the y coordinate of this Shape
	 *
	 * @param y the new y coordinate
	 */
	public void setY(int y) {
		setPosition(x, y);
	}

	/**
	 * Set the color of this Shape
	 *
	 * @param c the new color
	 */
	public void setColor(String c) {
		color = c;
	}

	/**
	 * @return the x coordinate of this
	 */
	public int getX() {
		return x;
	}

	/**
	 * @return the y coordinate of this
	 */
	public int getY() {
		return y;
	}

	/**
	 * @return the Color of this
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @return a String representation of this
	 */
	public String toString() {
		String s = "Color:" + color + " (" + x + "," + y + ")";
		return (s);
	}

}
