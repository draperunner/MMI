package oving1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class ButtonsNText extends JPanel implements ActionListener, KeyListener {

	public JTextField textLine;
	public JToggleButton upperCaseButton;
	public JToggleButton lowerCaseButton;
	public JCheckBox continuousButton;
	public ButtonGroup buttonGroup;

	public ButtonsNText() {

		textLine = new JTextField(10);
		textLine.setName("TextLine");
		textLine.addKeyListener(this);
		add(textLine);

		buttonGroup = new ButtonGroup();
		
		upperCaseButton = new JToggleButton("Upper Case");
		upperCaseButton.setName("UpperCaseButton");
		add(upperCaseButton);
		buttonGroup.add(upperCaseButton);
		upperCaseButton.addActionListener(this);
		upperCaseButton.setSelected(true);

		lowerCaseButton = new JToggleButton("Lower Case");
		lowerCaseButton.setName("LowerCaseButton");
		add(lowerCaseButton);
		buttonGroup.add(lowerCaseButton);
		lowerCaseButton.addActionListener(this);

		continuousButton = new JCheckBox("Continuous?");
		continuousButton.setName("ContinuousButton");
		add(continuousButton);

	}

	public void toUpper() {
		textLine.setText(textLine.getText().toUpperCase());
	}

	public void toLower() {
		textLine.setText(textLine.getText().toLowerCase());
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (upperCaseButton.isSelected()) {
			toUpper();
		} else if (lowerCaseButton.isSelected()) {
			toLower();
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		int caret = textLine.getCaretPosition();
		if (continuousButton.isSelected()) {
			
			if (upperCaseButton.isSelected()) {
				toUpper();
			} else if (lowerCaseButton.isSelected()) {
				toLower();
			}
		}
		textLine.setCaretPosition(caret);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (upperCaseButton.isSelected()) {
				toUpper();
			} else if (lowerCaseButton.isSelected()) {
				toLower();
			}
		}
	}

	public static void main(String[] args) {

		ButtonsNText bnt = new ButtonsNText();
		JFrame frame = new JFrame();
		frame.setContentPane(bnt);
		frame.pack();
		frame.setVisible(true);
	}
}