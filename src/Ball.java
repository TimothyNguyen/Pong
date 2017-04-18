import java.awt.Color;

public class Ball {

	private double x, y;
	private double speedX, speedY;
	private double radius;
	private Color color;

	public Ball() {
		x = (int)Board.getBoardWidth()/2;
		y = (int)Board.getBoardHeight()/2;
		// TODO: Change the angle of the ball so it isn't boring
		speedX = (double)(10  * Math.cos(Math.toRadians(randomAngle())) + 5);
		speedY = (double)(-10 * (double)Math.sin(Math.toRadians(randomAngle())) + 5);
		radius = 40;
		color = Color.BLUE;
	}

	public double getX() { return x; }
	public double getY() { return y; }
	public double getRadius() { return radius; }
	public Color getColor() { return color; }

	/**
	 * angle from 30 - 60 degrees
	 */

	private int randomAngle() {
		return (int)(Math.random() * 31 + 30);
	}

	public void move(Paddle left, Paddle right) {
		double minX = 0;
		double minY = radius;
		double maxX = Board.getBoardWidth();
		double maxY = Board.getBoardHeight() - (radius * 2);

		x += speedX;
		y += speedY;

		if(y <= minY || y >= maxY) speedY = -speedY;
		if(x <= minX || x >= maxX) {
			x = (int)Board.getBoardWidth()/2;
			y = (int)Board.getBoardHeight()/2;
		}
		/**
		 * Collision detection right here for paddle and ball - still flawed but better than nothing
		 */
		if(x <= left.getX() + left.getWidth() && x - radius/2 >= left.getX() - left.getHeight()) {
			if(y + radius <= left.getY() + left.getHeight()) {
				speedX = (double)(10  * Math.cos(Math.toRadians(randomAngle())) + 5);
				speedY = -(double)(-10 * (double)Math.sin(Math.toRadians(randomAngle())) + 5);
			}
		}
		if(x >= right.getX() - right.getWidth() && x - radius/2 >= right.getX() - left.getHeight()) {
			if(y + radius <= right.getY() + left.getHeight()) {
				speedX = -(double)(10  * Math.cos(Math.toRadians(randomAngle())) + 5);
				speedY = -(double)(-10 * (double)Math.sin(Math.toRadians(randomAngle())) + 5);
			}
		}
	}
}
