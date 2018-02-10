package ui;

/* created by
 * Anna Davison	16382333
 * James Kearns	15467622
 * Orla Keating	15205679
 */

//this is the class for game it will have most of the functionality

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class Game extends JFrame
{
	private static final int FRAME_WIDTH = 1000;
	private static final int FRAME_HEIGHT = 700;
	
	public Game()
	{
		gameFrame();
	}
	
	//creates the frame for the board, text, and info panels
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
