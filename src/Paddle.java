import java.awt.Rectangle;

public class Paddle {

	// Paddle instance variables
	private double x, y;
	private int width, height;
	private final int speed = 25;

	public Paddle(int x) {
		this.x = x;
		y = Board.getBoardHeight()/2;
		width = 50;
		height = 100;
	}

	// Mutators and accessors
	public double getX() { return x; }
	public double getY() { return y; }
	public void upY() { 
		if(this.y <= 0) this.y = 0;
		else this.y -= speed; 
	}
	public void downY() { 
		if(this.y >= Board.getBoardHeight() - height) this.y = Board.getBoardHeight() - height;
		else this.y += speed; 
	}
	public int getWidth() { return width; }
	public int getHeight() { return height; }

	// Collision Detection
	public Rectangle getBounds() {
		return new Rectangle((int) getX(), (int)getY(),
				getWidth(), getHeight());
	}

}
