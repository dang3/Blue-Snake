
public class Driver {
	public Driver() {
		FrameMaker frame = new FrameMaker();
		DisplayPanel panel = new DisplayPanel(400,400);
		Food food = new Food();
		World world = new World(panel,food);
		Rules rules = new Rules(world);
		Listener listener = new Listener(world);
		frame.addKeyListener(listener);
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		Driver game = new Driver();
	}
		
		
		
		
}


