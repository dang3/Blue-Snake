import java.awt.Color;
import java.awt.Graphics;

public class Food {
	private World world;
	private int foodX, foodY;
	private int foodSize = 15;
	private int multFactorX, multFactorY;
	
	public Food() {
		setFoodLocation();
//		foodSize = world.getSnakeWidth();
//		multFactorX = (world.panel.getPanelWidth()/foodSize) - 1;
		
	}
	
	public int getFoodX() {
		return foodX;
	}
	
	public int getFoodY() {
		return foodY;
	}

	public void setFoodLocation() {
		// x & y coords are multiples of 15
		foodX = (int)((Math.random()*25) + 1)*15;
		foodY = (int)((Math.random()*25) + 1)*15;
	}
	
	public void drawFood(Graphics g) {
		g.setColor(Color.RED);
		g.fillOval(foodX, foodY, foodSize, foodSize);
	}
	
	public void acceptWorld(World world) {
		this.world = world;
	}
}
