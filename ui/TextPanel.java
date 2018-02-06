package ui;

import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TextPanel extends JPanel
{
	private static final int TEXT_WIDTH = 600;
	private static final int TEXT_HEIGHT = 200;
	
	public TextPanel()
	{
		
	}
	
	private void textP()
	{
		JTextField textField = new JTextField(20);
		JTextArea textArea = new JTextArea(10, 10);
		textArea.setFont(new Font("Serif", Font.ITALIC, 64));
		textArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textArea);
	}
}
