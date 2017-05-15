import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Listener implements KeyListener {
	World world;
	
	public Listener(World world) {
		this.world = world;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if( key == KeyEvent.VK_RIGHT && world.getXDir() != -1 ) {
			world.setXDir(1);
			world.setYDir(0);
		}
		else if( key == KeyEvent.VK_DOWN && world.getYDir() != -1 ) {
			world.setXDir(0);
			world.setYDir(1);
		}
		else if( key == KeyEvent.VK_UP && world.getYDir() != 1 ) {
			world.setXDir(0);
			world.setYDir(-1);
		}
		else if( key == KeyEvent.VK_LEFT && world.getXDir() != 1 ) {
			world.setXDir(-1);
			world.setYDir(0);
		}
	}
	
	// Methods not used
	@Override
	public void keyReleased(KeyEvent arg0) {
		;
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		;
	}
}
