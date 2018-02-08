package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class TextPanel extends JPanel
{
	JPanel tPanel;
	JTextField textField;
	private static final int TEXT_WIDTH = 600;
	private static final int TEXT_HEIGHT = 100;
	
	public TextPanel()
	{
		textP();
	}
	
	private void textP()
	{
		tPanel = new JPanel(new FlowLayout(SwingConstants.LEADING, 10, 10));
		add(tPanel);

		textField = new JTextField(50);
		
		textField.setText("Enter text here!!");

		JTextArea textArea = new JTextArea(/*TEXT_WIDTH, TEXT_HEIGHT*/);

		textArea.setFont(new Font("Serif", Font.ITALIC, 30));
		textArea.setEditable(false);
//		JScrollPane scrollPane = new JScrollPane(textArea);
//		pane.add(scrollPane, BorderLayout.LINE_END);
		
		tPanel.add(textField, BorderLayout.LINE_END);

	}

}
