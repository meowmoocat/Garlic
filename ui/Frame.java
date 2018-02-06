package ui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Frame extends JPanel
{
	private static final int FRAME_WIDTH = 600;
	private static final int FRAME_HEIGHT = 600;
	
	private BufferedImage boardImage;
	
	public Frame()
	{
		//call in stuff for board
		boardPanel();
		
		//call in stuff for text
		
		//call in stuff for input
		
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		
	}
	
	private void boardPanel()
	{
		
		try
		{
			boardImage = ImageIO.read(Frame.class.getResource("\\Images\\cluedo board.jpg"));		
		}catch(IOException ex)
		{
			System.out.println("Could not find the image file " + ex.toString());
		}
		
//		JPanel panel = new JPanel();
		

	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponents(g);
		Graphics2D g2 = (Graphics2D) g;
		
		g2.drawImage(boardImage, 0, 0, FRAME_WIDTH, FRAME_HEIGHT, this);
	}
	
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable(){
			public void run()
			{
				
				JFrame frame = new JFrame();
				frame.setTitle("Cluedo");
				frame.setSize(FRAME_WIDTH+200, FRAME_HEIGHT+200);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
				frame.add(new Frame());
			}
		});
	}


}
