package ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JTextField;


public class TextPanel extends JPanel
{
	
	JTextField textField;
	
	public TextPanel()
	{
		
		textP();
	}

	private void textP()
	{
		
		textField = new JTextField(50);
		
		textField.setText("");


		
		this.add(textField, BorderLayout.SOUTH);


		//action listener that moves text to text area when return is pressed
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});

	}
	
//	public String getString()
//	{
//		String text = textField.getText();
////		textArea.append(text + "\n");
////		textField.selectAll();
////
////		//Make sure the new text is visible, even if there
////		//was a selection in the text area.
////		textArea.setCaretPosition(textArea.getDocument().getLength());
//		
//		return text;
//	}

}
