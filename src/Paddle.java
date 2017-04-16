import java.awt.Rectangle;

public class Paddle {

	private double x, y;
	private int width, height;
	private final int speed = 40;

	public Paddle(int x) {
		this.x = x;
		y = Board.getBoardHeight()/2;
		width = 50;
		height = 100;
	}


	public double getX() { return x; }
	public double getY() { return y; }
	public void upY() { this.y += speed; }
	public void downY() { this.y -= speed; }
	public int getWidth() { return width; }
	public int getHeight() { return height; }

	public Rectangle getBounds() {
		return new Rectangle((int) getX(), (int)getY(),
				getWidth(), getHeight());
	}

}
