package ui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


@SuppressWarnings("serial")
public class InfoPanel extends JPanel
{
	
	static JTextArea textArea = new JTextArea(200, 25);
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
		
		this.add(textArea, BorderLayout.EAST);
		
	}
	
}