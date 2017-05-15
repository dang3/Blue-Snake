import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Rules {
	private World world;
	private ArrayList<SnakeBody> snake;
	private int panelWidth, panelHeight, snakeWidth;
	
	public Rules(World world) {
		this.world = world;
		world.acceptRules(this);
		panelWidth = world.panel.getPanelWidth();
		panelHeight = world.panel.getPanelHeight();
		snakeWidth = world.getSnakeWidth();
		snake = world.getSnakeList();
	}
	
	public void checkFoodEaten() {
		int foodX = world.food.getFoodX();
		int foodY = world.food.getFoodY();
		int headX = snake.get(0).getX();
		int headY = snake.get(0).getY();

		if( headX == foodX && headY == foodY ) {
			// Get location of last body part
			int snakeSize = snake.size() - 1; 
			int tailX = snake.get(snakeSize).getX();
			int tailY = snake.get(snakeSize).getY();
			// Add to snake body
			snake.add( new SnakeBody(tailX - snakeWidth, tailY, snakeWidth ) );
			// Reset food location
			world.food.setFoodLocation();
			world.increaseScore();	// increase score
			world.panel.updateScore(); // display score
		}
	}
	
	public boolean collideWithSelf() {
		int headX = snake.get(0).getX();
		int headY = snake.get(0).getY();
		
		for(int i = 1; i < snake.size(); i++) {
			SnakeBody currentPart = snake.get(i);
			if(headX == currentPart.getX() && headY == currentPart.getY())
				return true;
		}
		return false;
	}
	
	public boolean hitEdge() {
		int headX = snake.get(0).getX();
		int headY = snake.get(0).getY();
		
		if( headX >= (panelWidth - (snakeWidth+9)) || headX <= 0 || 
				headY >= (panelHeight - (snakeWidth)) || headY <= 0)
			return true;
		else
			return false;
	}
	
	public void gameOver() {
		// Stop Timer
		world.time.stop();
		
		// Setup window
		FrameMaker gameOverFrame = new FrameMaker();
		JPanel gameOverPanel = new JPanel( new BorderLayout() );
		gameOverPanel.setPreferredSize( new Dimension(300,100) );
		gameOverFrame.add(gameOverPanel);
		gameOverFrame.setLocation(400,400);
		gameOverFrame.setTitle("GAME OVER");
		gameOverFrame.pack();
		gameOverFrame.setVisible(true);
		
		// Contents of window
		JLabel gameOverLabel = new JLabel("GAME OVER");
		gameOverLabel.setFont( new Font("", Font.BOLD, 40) );
		gameOverLabel.setHorizontalAlignment(JLabel.CENTER);
		gameOverPanel.add(gameOverLabel);
	}
	
	public void checkLostGame() {
		if( hitEdge() || collideWithSelf())
			gameOver();
	}
}
