package ui;

//this will have all the required information for the board
//such as:
//rooms and tiles
//player/weapon positions

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class BoardPanel extends JPanel
{
	private static final int BOARD_WIDTH = 600;
	private static final int BOARD_HEIGHT = 600;
	
	private static final int SQUARES_WIDTH = 24;//width = 24
	private static final int SQUARES_HEIGHT = 25;//height = 25
	
	private BufferedImage boardImage;
	JPanel BPanel;
	
	public BoardPanel()
	{
		boardP();
		
		
	}
	
	private void boardP()
	{
		BPanel = new JPanel();
		add(BPanel);
		//Reads in the image
		try
		{
			boardImage = ImageIO.read(this.getClass().
					getResource("\\Images\\cluedo board.jpg"));		
		}catch(IOException ex)
		{
			System.out.println("Could not find the image file "
								+ ex.toString());
		}
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponents(g);
		Graphics2D g2 = (Graphics2D) g;
		
		g2.drawImage(boardImage, 0, 0, BOARD_WIDTH, BOARD_HEIGHT,
						this);
	}
	
	
}