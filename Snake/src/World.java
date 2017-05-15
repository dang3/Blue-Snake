import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

public class World implements ActionListener {
	private ArrayList<SnakeBody> snake = new ArrayList<>();
	DisplayPanel panel;
	Food food;
	Rules rules;
	Timer time;
	private final int initialSize = 1;
	private int xPos = 45, yPos = 30, snakeBodyWidth = 15;
	private int xDirection, yDirection;
	private final int delay = 100;
	private int score = 0;
	
	public World(DisplayPanel panel, Food food) {
		this.panel = panel;
		this.food = food;
		panel.acceptWorld(this);
		food.acceptWorld(this);
		initializeBody();
		initializeDirection();
		time = new Timer(delay, this);
		time.start();
	}
	
	public ArrayList<SnakeBody> getSnakeList() {
		return snake;
	}
	
	public void initializeDirection() {
		xDirection = 1;
		yDirection = 0;
	}
	
	public void increaseScore() {
		score++;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setXDir(int x) {
		xDirection = x;
	}
	
	public void setYDir(int y) {
		yDirection = y;
	}
	
	public int getXDir() {
		return xDirection;
	}
	
	public int getYDir() {
		return yDirection;
	}
	
	public void acceptRules(Rules rules) {
		this.rules = rules;
	}
	
	public int getSnakeWidth() {
		return snakeBodyWidth;
	}
	
	public void initializeBody() {
		for(int i = 0; i < initialSize; i++) 
			snake.add( new SnakeBody(  xPos - (i*(snakeBodyWidth)), yPos, snakeBodyWidth) );
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		updateSnakePos( snake.get(0).getX() + (xDirection*snakeBodyWidth),  snake.get(0).getY() + (yDirection*snakeBodyWidth) );
		rules.checkFoodEaten();
		rules.checkLostGame();
		panel.repaint();
	}
	
	public void updateSnakePos(int newX, int newY) {
		int oldX, oldY;
		for(int i = 0; i < snake.size(); i++) {
			SnakeBody currentPart = snake.get(i);
			oldX = currentPart.getX();
			oldY = currentPart.getY();
			currentPart.setPosition(newX, newY);
			newX = oldX;
			newY = oldY;
		}
	}
}