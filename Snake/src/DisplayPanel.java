import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Iterator;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class DisplayPanel extends JPanel {
	private World world;
	private FrameMaker frame;
	private Font scoreFont = new Font("", Font.PLAIN, 20);
	private JLabel scoreLabel = new JLabel();
	private Iterator<SnakeBody> itr;
	private int width, height;

	public DisplayPanel(int x, int y) {
		width = x;
		height = y;
		setPreferredSize( new Dimension(width,height) );
		setVisible(true);
		setBackground(Color.PINK);
		setLayout( new BorderLayout() );
		initializeScoreLabel();
	}
	
	private void initializeScoreLabel() {
		scoreLabel.setText("Score: 0");
		scoreLabel.setFont(scoreFont);
		add(scoreLabel, BorderLayout.NORTH);
	}
	
	public void updateScore() {
		scoreLabel.setText("Score: " + world.getScore());
	}
	
	public int getPanelWidth() {
		return width;
	}
	
	public int getPanelHeight() {
		return height;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// Draw the snake
		itr = world.getSnakeList().iterator();
		while( itr.hasNext() ) {
			itr.next().drawPart(g);
		}
		// Draw food
		world.food.drawFood(g);
	}
	
	public void acceptWorld(World world) {
		this.world = world;
	}
}
