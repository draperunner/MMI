package oving3;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PassivePersonPanel extends PersonPanel {

	public PassivePersonPanel() {
		super();
		remove(gender);
		remove(height);
		
		c.gridx = 1;
		c.gridy = 3;
		JTextField gender = new JTextField(10);
		gender.setName("GenderPropertyComponent");
		gender.addActionListener(this);
		add(gender, c);

		c.gridy = 4;
		JTextField height = new JTextField(10);
		height.setName("HeightPropertyComponent");
		height.addActionListener(this);
		add(height, c);
		
		setEditable(false);
	}
	
	private void setEditable(boolean b) {
		nameTextField.setEnabled(b);
		emailTextField.setEnabled(b);
		dateOfBirthTextField.setEnabled(b);
		gender.setEnabled(b);
		height.setEnabled(b);
	}
	
	
	public static void main(String[] args) {
		PersonPanel pp = new PassivePersonPanel();
		JFrame frame = new JFrame();
		frame.setContentPane(pp);
		frame.pack();
		frame.setVisible(true);
	}
	

}
