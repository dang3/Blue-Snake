import javax.swing.JFrame;

@SuppressWarnings("serial")
public class FrameMaker extends JFrame {
	public FrameMaker() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocation(200,200);
		setTitle("SNAKE");
	}
}