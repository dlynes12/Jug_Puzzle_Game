package ca.utoronto.utm.lab04;

/**
 * A Rectangle is a Shape. Rectangles have all methods and attributes of Shape and
 * then some more.
 * @author Arnold Rosenbloom
 */
public class Rectangle extends Shape {

	private int width;
	private int height;

	/**
	 * Initialize a green Rectangle with width 10, height 20, position 100,100
	 */
	public Rectangle() {
		this("green", 10, 20, 100, 100);
	}

	/**
	 * Initialize a new Rectangle with specified color, width, height and
	 * position
	 *
	 * @param c
	 *            the desired color
	 * @param width
	 *            the desired width
	 * @param height
	 *            the desired height
	 * @param x
	 *            the desired x coordinate
	 * @param y
	 *            the desired x coordinate
	 */
	public Rectangle(String c, int width, int height, int x, int y) {
		super(c, x, y);
		setWidth(width);
		setHeight(height);
	}

	/**
	 * Set the width of this, tell our observer that we have changed
	 *
	 * @param w
	 *            the desired width
	 * @return nothing
	 */
	public void setWidth(int w) {
		if (w > 0)
			width = w;
	}

	/**
	 * Set the height of this, tell our observer that we have changed
	 *
	 * @param h
	 *            the desired height
	 * @return nothing
	 */
	public void setHeight(int h) {
		if (h > 0)
			height = h;
	}

	/**
	 * @return the width of this
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @return the height of this
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @return a String representation of this
	 */
	public String toString() {
		String s = super.toString() + " Width: " + getWidth() + " Height: " + getHeight();
		return (s);
	}

}
