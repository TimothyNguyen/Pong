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
		speedX = (double)(10 * Math.cos(Math.toRadians(45)) + 5);
		speedY = (double)(-10 * (double)Math.sin(Math.toRadians(45)) + 5);
		radius = 40;
		color = Color.BLUE;
	}

	public double getX() { return x; }
	public double getY() { return y; }
	public double getRadius() { return radius; }
	public Color getColor() { return color; }

	public void move(Paddle left, Paddle right) {
		double minX = radius;
		double minY = radius;
		double maxX = Board.getBoardWidth() - (radius * 2);
		double maxY = Board.getBoardHeight() - (radius * 2);

		x += speedX;
		y += speedY;

		if(x < minX || x > maxX) speedX = -speedX;
		if(y < minY || y > maxY) speedY = -speedY;

		/**
		 * Collision detection right here for paddle and ball
		 */
		if(x <= left.getX() + left.getWidth()/2) {
			if(y >= left.getY() - left.getHeight() && y <= left.getY() + left.getHeight()) {
				speedX = -speedX;
				speedY = -speedY;
			}
		}
		if(x >= right.getX() - right.getWidth()/2) {
			if(y >= right.getY() - left.getHeight()/2 && y <= right.getY() + left.getHeight()/2) {
				speedX = -speedX;
				speedY = -speedY;
			}
		}
	}
}
