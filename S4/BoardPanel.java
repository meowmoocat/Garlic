package S4;

import javax.imageio.ImageIO;
import javax.swing.*;

import S3.Weapon;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

class BoardPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private static final int FRAME_WIDTH = 750, FRAME_HEIGHT = 750;  // must be even
	private static final float COL_OFFSET = 52f, ROW_OFFSET = 29f;
	private static final float COL_SCALE = 26.9f, ROW_SCALE = 27.1f;
	private static final int TOKEN_RADIUS = 12;   // must be even

	private final Tokens tokens;
	private final Weapons weapons;
	private BufferedImage boardImage;

	public BufferedImage book;
	public BufferedImage bored;
	public BufferedImage gradcap;
	public BufferedImage librocop;
	public BufferedImage microscope;
	public BufferedImage seagull;

	BoardPanel(Tokens tokens, Weapons weapons) {
		this.tokens = tokens;
		this.weapons = weapons;
		setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
		setBackground(Color.WHITE);
		try {
			boardImage = ImageIO.read(this.getClass().getResource("cluedo board.jpg"));
		} catch (IOException ex) {
			System.out.println("Could not find the image file " + ex.toString());
		}
		weaponsReadIn();
	}


	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 =(Graphics2D) g;
		g2.drawImage(boardImage, 0, 0, FRAME_WIDTH, FRAME_HEIGHT, this);
		for (Token suspect : tokens) {
			int x = Math.round(suspect.getPosition().getCol()*COL_SCALE + COL_OFFSET);
			int y = Math.round(suspect.getPosition().getRow()*ROW_SCALE + ROW_OFFSET);
			g2.setColor(Color.BLACK);
			Ellipse2D.Double ellipseBlack = new Ellipse2D.Double(x,y,2*TOKEN_RADIUS,2*TOKEN_RADIUS);
			g2.fill(ellipseBlack);
			Ellipse2D.Double ellipseColour = new Ellipse2D.Double(x+2,y+2,2*TOKEN_RADIUS-4,2*TOKEN_RADIUS-4);
			g2.setColor(suspect.getColor());
			g2.fill(ellipseColour);
		}
		for (S4.Weapon weapon : weapons) {
			int x = Math.round(weapon.getPosition().getCol()*COL_SCALE + COL_OFFSET);
			int y = Math.round(weapon.getPosition().getRow()*ROW_SCALE + ROW_OFFSET);
			if(weapon.getName().equalsIgnoreCase("book"))
				g2.drawImage(book, x, y, 4*TOKEN_RADIUS, 4*TOKEN_RADIUS, this);
			if(weapon.getName().equalsIgnoreCase("Bored"))
				g2.drawImage(bored, x, y, 4*TOKEN_RADIUS, 4*TOKEN_RADIUS, this);
			if(weapon.getName().equalsIgnoreCase("gradcap"))
				g2.drawImage(gradcap, x, y, 4*TOKEN_RADIUS, 4*TOKEN_RADIUS, this);
			if(weapon.getName().equalsIgnoreCase("librocop"))
				g2.drawImage(librocop, x, y, 4*TOKEN_RADIUS, 4*TOKEN_RADIUS, this);
			if(weapon.getName().equalsIgnoreCase("microscope"))
				g2.drawImage(microscope, x, y, 4*TOKEN_RADIUS, 4*TOKEN_RADIUS, this);
			if(weapon.getName().equalsIgnoreCase("seagull"))
				g2.drawImage(seagull, x, y, 4*TOKEN_RADIUS, 4*TOKEN_RADIUS, this);
		}
	}

	public void refresh() {
		revalidate();
		repaint();
	}

	//reads in images for weapons
	public void weaponsReadIn()
	{
		for(S4.Weapon weapon : weapons)
		{
			if(weapon.getName().equals("Book"))
			{
				try
				{
					book = ImageIO.read(this.getClass().
							getResource("book.jpg"));		
				}catch(IOException ex)
				{
					System.out.println("Could not find the image file "
							+ ex.toString());
				}
			}
			else if(weapon.getName().equals("Bored"))
			{
				try
				{
					bored = ImageIO.read(this.getClass().
							getResource("bored_1.jpg"));		
				}catch(IOException ex)
				{
					System.out.println("Could not find the image file "
							+ ex.toString());
				}
			}
			else if(weapon.getName().equals("Gradcap"))
			{
				try
				{
					gradcap = ImageIO.read(this.getClass().
							getResource("gradcap.png"));		
				}catch(IOException ex)
				{
					System.out.println("Could not find the image file "
							+ ex.toString());
				}
			}
			else if(weapon.getName().equals("Librocop"))
			{
				try
				{
					librocop = ImageIO.read(this.getClass().
							getResource("librocop.jpg"));		
				}catch(IOException ex)
				{
					System.out.println("Could not find the image file "
							+ ex.toString());
				}
			}
			else if(weapon.getName().equals("Microscope"))
			{
				try
				{
					microscope = ImageIO.read(this.getClass().
							getResource("MICROSCOPE.png"));		
				}catch(IOException ex)
				{
					System.out.println("Could not find the image file "
							+ ex.toString());
				}
			}
			else if(weapon.getName().equals("Seagull"))
			{
				try
				{
					seagull = ImageIO.read(this.getClass().
							getResource("seagull.jpg"));		
				}catch(IOException ex)
				{
					System.out.println("Could not find the image file "
							+ ex.toString());
				}
			}
		}
	}
}
