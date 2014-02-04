package oving3;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PassivePersonPanel extends PersonPanel {

	private JTextField genderTextField;
	private JTextField heightTextField;

	public PassivePersonPanel() {
		super();
		remove(gender);
		remove(height);

		c.gridx = 1;
		c.gridy = 3;
		genderTextField = new JTextField(10);
		genderTextField.setName("GenderPropertyComponent");
		genderTextField.addActionListener(this);
		add(genderTextField, c);

		c.gridy = 4;
		heightTextField = new JTextField(10);
		heightTextField.setName("HeightPropertyComponent");
		heightTextField.addActionListener(this);
		add(heightTextField, c);

		setEditable(false);

		setModel(new Person("Ola Nordmann", "19900101", Gender.male,
				"ola@nordmann.no", 180));
	}

	private void setEditable(boolean b) {
		nameTextField.setEnabled(b);
		emailTextField.setEnabled(b);
		dateOfBirthTextField.setEnabled(b);
		genderTextField.setEnabled(b);
		heightTextField.setEnabled(b);
	}

	private String getGenderString() {
		if (model.getGender() == Gender.male)
			return "male";
		return "female";
	}

	@Override
	public void viewAll() {
		nameTextField.setText(model.getName());
		emailTextField.setText(model.getEmail());
		dateOfBirthTextField.setText(model.getDateOfBirth());
		genderTextField.setText(getGenderString());
		heightTextField.setText(Integer.toString(model.getHeight()));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == nameTextField) {
			model.setName(nameTextField.getText());
		} else if (e.getSource() == emailTextField) {
			model.setEmail(emailTextField.getText());
		} else if (e.getSource() == dateOfBirthTextField) {
			model.setDateOfBirth(dateOfBirthTextField.getText());
		} else if (e.getSource() == genderTextField) {
			if (genderTextField.getText().equals("male")) {
				model.setGender(Gender.male);
			} else if (genderTextField.getText().equals("female")) {
				model.setGender(Gender.female);
			}

		} else if (e.getSource() == heightTextField) {
			model.setHeight(Integer.parseInt(heightTextField.getText()));
		}
		System.out.println(model);
	}

	@Override
	public void propertyChange(PropertyChangeEvent e) {
		if (e.getPropertyName().equals("name")) {
			nameTextField.setText(model.getName());
		} else if (e.getPropertyName().equals("email")) {
			emailTextField.setText(model.getEmail());
		} else if (e.getPropertyName().equals("dateOfBirth")) {
			dateOfBirthTextField.setText(model.getDateOfBirth());
		} else if (e.getPropertyName().equals("gender")) {
			genderTextField.setText(getGenderString());
		} else if (e.getPropertyName().equals("height")) {
			heightTextField.setText(Integer.toString(model.getHeight()));
		}
	}

	public static void main(String[] args) {
		PersonPanel pp = new PassivePersonPanel();
		JFrame frame = new JFrame();
		frame.setContentPane(pp);
		frame.pack();
		frame.setVisible(true);
	}
}
