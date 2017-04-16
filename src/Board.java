import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Board extends JPanel {

	private Ball ball;
	private Paddle lPaddle;
	private Paddle rPaddle;
	private static int boardWidth;
	private static int boardHeight;
	
	public Board() {
		// width and height
		boardWidth = 1200;
		boardHeight = 800;
		ball = new Ball();
		lPaddle = new Paddle(60);
		rPaddle = new Paddle(getBoardWidth() - 100);
		startGame();
	}
	
	public static int getBoardWidth() 	{ return boardWidth;  }
	public static int getBoardHeight() { return boardHeight; }
	
	public void startGame() {
		Thread gameThread = new Thread() {
			public void run() {
				while(true) {
					ball.move();
					repaint();
					try {
						Thread.sleep(1000/30);
					} catch(InterruptedException ex) {}
				}
			}
		};
		gameThread.start();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getBoardWidth(), getBoardHeight());
		
		g.setColor(Color.BLUE);
		g.fillOval((int) ball.getX(), (int) ball.getY(), (int)ball.getRadius(), (int)ball.getRadius());
		
		g.setColor(Color.GREEN);
		g.fillRect((int)lPaddle.getX(), (int)lPaddle.getY(), (int)lPaddle.getWidth(), (int)lPaddle.getHeight());
		g.fillRect((int)rPaddle.getX(), (int)rPaddle.getY(), (int)rPaddle.getWidth(), (int)rPaddle.getHeight());
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Pong");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new Board());
		frame.setSize(getBoardWidth(), getBoardHeight());
		frame.setVisible(true);
	}
	
}
