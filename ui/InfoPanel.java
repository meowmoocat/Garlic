package ui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class InfoPanel extends JPanel
{
	
	static JTextArea textArea = new JTextArea(20, 25);
	static JScrollPane scrollPane = new JScrollPane(textArea);
	
	
	public InfoPanel()
	{
		infoP();
	}
	
	private void infoP()
	{
		
		
		scrollPane.setHorizontalScrollBarPolicy
			(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy
			(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		textArea.setEditable(false);
		
		this.add(scrollPane, BorderLayout.EAST);
		
	}
	
}
