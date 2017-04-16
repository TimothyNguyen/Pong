import java.awt.Color;

public class Ball {

	private double x, y;
	private double speedX, speedY;
	private double radius;
	private Color color;
	
	public Ball() {
		x = (int)Board.getBoardWidth()/2;
		y = (int)Board.getBoardHeight()/2; 
		speedX = 5;
		speedY = 5;
		radius = 30;
		color = Color.BLUE;
	}
	
	public double getX() { return x; }
	public double getY() { return y; }
	public double getRadius() { return radius; }
	public Color getColor() { return color; }
	
	public void move() {
		double minX = radius;
		double minY = radius;
		double maxX = Board.getBoardWidth() - (radius * 2);
		double maxY = Board.getBoardHeight() - (radius * 2);
		
		x += speedX;
		y += speedY;
		
		if(x < minX || x > maxX) speedX = -speedX;
		if(y < minY || y > maxY) speedY = -speedY; 
	}
}
