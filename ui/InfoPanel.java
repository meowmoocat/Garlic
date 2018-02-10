package ui;

/* created by
 * Anna Davison	16382333
 * James Kearns	15467622
 * Orla Keating	15205679
 */

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


@SuppressWarnings("serial")
public class InfoPanel extends JPanel
{

	static JTextArea textArea = new JTextArea(35, 30);		//set dimensions
	static JScrollPane scrollPane = new JScrollPane(textArea);//create scrolls bars for text area


	public InfoPanel()
	{
		infoP();
	}

	//adds scroll bars to text area
	private void infoP()
	{

		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		textArea.setEditable(false);				//so people can't cheat!!

		this.add(scrollPane, BorderLayout.EAST);	

	}

}
