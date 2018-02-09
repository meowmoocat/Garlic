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
	
//	JPanel iPanel = new JPanel();			//windows ftw!!
	static JTextArea textArea = new JTextArea(20, 25);
//	static JTextField textField = new JTextField(10);
	
	static JScrollPane scrollPane = new JScrollPane(textArea);
	
//	private static AListener listener = new AListener();
	
	public InfoPanel()
	{
//		add(iPanel);
		infoP();
	}
	
	private void infoP()
	{
		
//		textArea.setActionCommand("Enter");
//		textArea.addActionListener(listener);
		
		scrollPane.setHorizontalScrollBarPolicy
			(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy
			(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		textArea.setEditable(false);
		
		this.add(textArea, BorderLayout.EAST);
		
//		iPanel.getRootPane().add(textField);
//		iPanel.getRootPane().add(scrollPane);
		
//		JTextArea textArea = new JTextArea(/*TEXT_WIDTH, TEXT_HEIGHT*/);
//
//		textArea.setFont(new Font("Serif", Font.ITALIC, 30));
//		textArea.setEditable(false);
//		JScrollPane scrollPane = new JScrollPane(textArea);
//
//		iPanel.add(scrollPane, BorderLayout.LINE_END);
	}
	
//	public static class AListener implements ActionListener
//	{
//		public void actionPerformed(final ActionEvent event)
//		{
//			String enteredText = textField.getText();
//			textArea.append(enteredText + "\n");
//			textField.setText("");
//		}
//	}
}