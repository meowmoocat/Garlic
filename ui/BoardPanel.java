package ui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class BoardPanel extends JPanel
{
	private static final int BOARD_WIDTH = 600;
	private static final int BOARD_HEIGHT = 600;
	
	private BufferedImage boardImage;
	
	public BoardPanel()
	{
		boardP();
	}
	
	private void boardP()
	{
		try
		{
			boardImage = ImageIO.read(this.getClass().getResource("\\Images\\cluedo board.jpg"));		
		}catch(IOException ex)
		{
			System.out.println("Could not find the image file " + ex.toString());
		}
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponents(g);
		Graphics2D g2 = (Graphics2D) g;
		
		g2.drawImage(boardImage, 0, 0, BOARD_WIDTH, BOARD_HEIGHT, this);
	}
}