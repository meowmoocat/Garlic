package ui;

//this will have all the required information for the board
//such as:
//rooms and tiles
//player/weapon positions

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class BoardPanel extends JPanel
{
	private static final int BOARD_WIDTH = 600;
	private static final int BOARD_HEIGHT = 600;
	
	private static final int SQUARES_WIDTH = 24;//width = 24
	private static final int SQUARES_HEIGHT = 25;//height = 25
	
	private BufferedImage boardImage;
	JPanel bPanel = new JPanel();
	
	public BoardPanel()
	{
		add(bPanel);
		boardP();
		squares();
	}
	
	public void squares()
	{
		//read in text file
		String squaresFile = "boardCode.txt";
		
		String line = null;
		
		try
		{
			FileReader fileRead = new FileReader(squaresFile);
			
			BufferedReader br = new BufferedReader(fileRead);
			
			while((line = br.readLine()) != null)
			{
				for(int i=0; i<SQUARES_WIDTH; i++)
				{
					for(int j=0; j<SQUARES_HEIGHT; j++)
					{
						System.out.println("line: " + line);
						System.out.println("i "+i+", j "+j);
					}
				}
				System.out.println("s");
			}
		}
		catch(FileNotFoundException e)
		{
			System.out.println("file not found!!");
		}
		catch(IOException e)
		{
			System.out.println("error reading file!!");
		}
	}
	
	private void boardP()
	{
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