package ui;

/* created by
 * Anna Davison	16382333
 * James Kearns	15467622
 * Orla Keating	15205679
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class BoardPanel extends JPanel
{
	int X, Y;	//this is the transitions for moving scarlett

	int SCARLETT_X;	//scarletts initial position
	int SCARLETT_Y;
	int MOVE_Y;		//this is the transitions for moving spanner

	private static final int BOARD_WIDTH = 600;		//board Image dimensions
	private static final int BOARD_HEIGHT = 600;


	private BufferedImage boardImage; //for reading in image

	//images for weapons
	public BufferedImage dagger;
	public BufferedImage candlestick;
	public BufferedImage rope;
	public BufferedImage pipe;
	public BufferedImage revolver;
	public BufferedImage spanner;

	public BoardPanel()
	{

		boardP();	//reads in board image
		weaponsReadIn();	//reads in weapons image
		this.X = 0;
		this.Y = 0;
		SCARLETT_X = 191;
		SCARLETT_Y = 542;
		MOVE_Y = 0;

		moveScarlett();
		moveSpanner();

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

		g2.drawImage(boardImage, 0, 0, BOARD_WIDTH, BOARD_HEIGHT, this);

		Color scarlettColour= new Color(255, 0, 0);	//sets colours for each character
		Color mustardColour= new Color(255, 255, 0);
		Color whiteColour= new Color(255, 255, 255);
		Color greenColour= new Color(50, 205, 50);
		Color peacockColour= new Color(0, 191, 255);
		Color plumColour= new Color(148, 0, 211);


		//draws icon for players in their required locations
		g2.setColor(scarlettColour);
		g2.fill(new Ellipse2D.Float(SCARLETT_X + X, SCARLETT_Y + Y, 20, 20));
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


		//puts weapons in rooms!!!
		g2.drawImage(dagger, 80, 70, 30, 30, this);
		g2.drawImage(candlestick, 80, 515, 30, 30, this);
		g2.drawImage(rope, 320, 515, 30, 30, this);
		g2.drawImage(pipe, 500, 70, 30, 30, this);
		g2.drawImage(revolver, 250, 70, 30, 30, this);
		g2.drawImage(spanner, 500, 200 + MOVE_Y, 30, 30, this);

	}


	//tests of player movement using mouseListener
	public void moveScarlett()
	{
		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				X = 0;
				Y = -22; //moves scarlett north by one square
				repaint();
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});
	}


	//test of weapon image movement 
	public void moveSpanner()
	{
		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub

				MOVE_Y = 200; //moves spanner from billiard room to library
				repaint();
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});
	}


	//reads in images for weapons
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

}
