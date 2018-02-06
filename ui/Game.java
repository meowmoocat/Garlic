package ui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Game extends JFrame
{
	private static final int FRAME_WIDTH = 800;
	private static final int FRAME_HEIGHT = 800;
	
	public Game()
	{
		gameFrame();
	}
	
	public void gameFrame()
	{
		SwingUtilities.invokeLater(new Runnable(){
			public void run()
			{
				JFrame frame = new JFrame();
				frame.setTitle("Cluedo");
				frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
				frame.setLayout(new BorderLayout());
				frame.add(new BoardPanel(), BorderLayout.CENTER);
				frame.add(new TextPanel(), BorderLayout.SOUTH);
				frame.add(new InfoPanel(), BorderLayout.EAST);
			}
		});
	}
	
}
