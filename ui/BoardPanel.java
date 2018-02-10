package ui;

/* created by
 * Anna Davison	16382333
 * James Kearns	15467622
 * Orla Keating	15205679
 */

//this will have all the required information for the board
//such as:
//rooms and tiles
//player/weapon positions

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

//import ui.Weapons;

@SuppressWarnings("serial")
public class BoardPanel extends JPanel
{
	private static final int BOARD_WIDTH = 600;
	private static final int BOARD_HEIGHT = 600;
	
	private static final int SQUARES_CORRIDOR_MOVEMENT = 22;	//approx pixels of each corridor square
	
	private static final int TOTAL_SQUARES_WIDTH = 24;//width = 24
	private static final int TOTAL_SQUARES_HEIGHT = 25;//height = 25
	
	public String[][] board = new String[TOTAL_SQUARES_HEIGHT][TOTAL_SQUARES_WIDTH];
	
	JPanel bPanel = new JPanel();
	
	private BufferedImage boardImage;
	
	//images for weapons
	public BufferedImage dagger;
	public BufferedImage candlestick;
	public BufferedImage rope;
	public BufferedImage pipe;
	public BufferedImage revolver;
	public BufferedImage spanner;
	
	public BoardPanel()
	{
		add(bPanel);
		boardP();
//		squares();			keeping for reference
		
		weaponsReadIn();
	}
	
	public void squares()
	{
		//read in text file
		String squaresFile = "boardCode.txt";
		
		String line = null;
		
		try
		{
			FileReader fileRead = new FileReader(squaresFile);

			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(fileRead);

			int i=0;

			while((line = br.readLine()) != null)
			{
				String[] tempArray = line.split(" ");
				
				for(int j=0; j<TOTAL_SQUARES_WIDTH; j++)
				{
					board[i][j] = tempArray[j];
				}
				i++;
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
		
		//test
		for(int i=0; i<TOTAL_SQUARES_HEIGHT; i++)
		{
			for(int j=0; j<TOTAL_SQUARES_WIDTH; j++)
			{
				System.out.print(" " + board[i][j]);
			}
			System.out.println("");
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
	
	
	
	public void paintComponent(Graphics g, int x, int y)
	{
		super.paintComponents(g);
		Graphics2D g2 = (Graphics2D) g;
		
		g2.drawImage(boardImage, 0, 0, BOARD_WIDTH, BOARD_HEIGHT,
						this);
		
		Color scarlettColour= new Color(255, 0, 0);
		Color mustardColour= new Color(255, 255, 0);
		Color whiteColour= new Color(255, 255, 255);
		Color greenColour= new Color(50, 205, 50);
		Color peacockColour= new Color(0, 191, 255);
		Color plumColour= new Color(148, 0, 211);
		
		g2.setColor(scarlettColour);
	    g2.fill(new Ellipse2D.Float(191, 542, 20, 20));
	    g2.setColor(mustardColour);
	    g2.fill(new Ellipse2D.Float(40, 390, 20, 20));
	    g2.setColor(whiteColour);
	    g2.fill(new Ellipse2D.Float(233, 23, 20, 20));
	    g2.setColor(greenColour);
	    g2.fill(new Ellipse2D.Float(342, 23, 20, 20));
	    g2.setColor(peacockColour);
	    g2.fill(new Ellipse2D.Float(534, 151, 20, 20));
	    g2.setColor(plumColour);
	    g2.fill(new Ellipse2D.Float(534, 433, 20, 20));
	    
	    g2.drawImage(dagger, 80, 70, 30, 30, this);
	    g2.drawImage(candlestick, 80, 515, 30, 30, this);
	    g2.drawImage(rope, 320, 515, 30, 30, this);
	    g2.drawImage(pipe, 500, 70, 30, 30, this);
	    g2.drawImage(revolver, 250, 70, 30, 30, this);
		g2.drawImage(spanner, 500, 200, 30, 30, this);
	}
	
	public void weaponsReadIn()
	{
		try
		{
			dagger = ImageIO.read(this.getClass().
					getResource("\\Images\\knife.jpg"));		
		}catch(IOException ex)
		{
			System.out.println("Could not find the image file "
					+ ex.toString());
		}
		
		try
		{
			candlestick = ImageIO.read(this.getClass().
					getResource("\\Images\\candlestick.png"));		
		}catch(IOException ex)
		{
			System.out.println("Could not find the image file "
					+ ex.toString());
		}
		
		try
		{
			rope = ImageIO.read(this.getClass().
					getResource("\\Images\\rope.jpg"));		
		}catch(IOException ex)
		{
			System.out.println("Could not find the image file "
					+ ex.toString());
		}
		
		try
		{
			pipe = ImageIO.read(this.getClass().
					getResource("\\Images\\lead pipe.jpg"));		
		}catch(IOException ex)
		{
			System.out.println("Could not find the image file "
					+ ex.toString());
		}
		
		try
		{
			revolver = ImageIO.read(this.getClass().
					getResource("\\Images\\revolver.jpg"));		
		}catch(IOException ex)
		{
			System.out.println("Could not find the image file "
					+ ex.toString());
		}
		
		try
		{
			spanner = ImageIO.read(this.getClass().
					getResource("\\Images\\spanner.jpg"));		
		}catch(IOException ex)
		{
			System.out.println("Could not find the image file "
					+ ex.toString());
		}
	}
	
	public void paintComponentWeapons(Graphics w)
	{
		super.paintComponent(w);
		Graphics2D w2 = (Graphics2D) w;
		
	    
	    w2.drawImage(dagger, 80, 70, 30, 30, this);
	    w2.drawImage(candlestick, 80, 515, 30, 30, this);
	    w2.drawImage(rope, 320, 515, 30, 30, this);
	    w2.drawImage(pipe, 500,70,30,30,this);
	    w2.drawImage(revolver, 250, 70, 30, 30, this);
		w2.drawImage(spanner, 500, 200, 30, 30, this);
	}

	
}
