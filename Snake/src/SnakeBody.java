import java.awt.Color;
import java.awt.Graphics;

public class SnakeBody {
	private int x, y, bodyWidth;
	private int rVal, gVal ,bVal;
	
	public SnakeBody(int x, int y, int bodyWidth) {
		this.x = x;
		this.y = y;
		this.bodyWidth = bodyWidth;
		getColor();
	}
	
	public void setPosition(int newX, int newY) {
		x = newX;
		y = newY;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void getColor() {
		rVal = (int) (Math.random()*100+1);
		gVal = (int) (Math.random()*255+1);
		bVal = 255;
		//bVal = (int) (Math.random()*255+1);
	}
	
	public void drawPart(Graphics g) {
		g.setColor( new Color(rVal, gVal, bVal) );
		g.fillRect(x, y, bodyWidth, bodyWidth);
	}
}
