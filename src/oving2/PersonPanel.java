package oving2;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import oving1.ButtonsNText;

public class PersonPanel extends JPanel implements ActionListener, ChangeListener {

	private Person model;
	private JLabel nameLabel, emailLabel, dateOfBirthLabel, genderLabel, heightLabel;
	private JTextField nameTextField, emailTextField, dateOfBirthTextField;
	private JComboBox gender;
	private JSlider height;

	public PersonPanel() {

		GridBagConstraints c;
		setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		
		c.gridx = 0;
		c.gridy = 0;
		nameLabel = new JLabel("Name:");
		add(nameLabel, c);

		c.gridx = 1;
		nameTextField = new JTextField(10);
		nameTextField.setName("NamePropertyComponent");
		nameTextField.addActionListener(this);
		add(nameTextField, c);

		c.gridx = 0;
		c.gridy = 1;
		emailLabel = new JLabel("Email:");
		add(emailLabel, c);
		
		c.gridx = 1;
		emailTextField = new JTextField(10);
		emailTextField.setName("EmailPropertyComponent");
		emailTextField.addActionListener(this);
		add(emailTextField, c);

		c.gridx = 0;
		c.gridy = 2;
		dateOfBirthLabel = new JLabel("Date of Birth:");
		add(dateOfBirthLabel, c);
		
		c.gridx = 1;
		dateOfBirthTextField = new JTextField(10);
		dateOfBirthTextField.setName("DateOfBirthPropertyComponent");
		dateOfBirthTextField.addActionListener(this);
		add(dateOfBirthTextField, c);

		c.gridx = 0;
		c.gridy = 3;
		JLabel genderLabel = new JLabel("Gender:");
		add(genderLabel, c);
		
		c.gridx = 1;
		gender = new JComboBox();
		gender.setName("GenderPropertyComponent");
		gender.addItem(Gender.male);
		gender.addItem(Gender.female);
		gender.addActionListener(this);
		add(gender, c);

		c.gridx = 0;
		c.gridy = 4;
		heightLabel = new JLabel("Height:");
		add(heightLabel, c);
		
		c.gridx = 1;
		height = new JSlider(120, 220);
		height.setName("HeightPropertyComponent");
		height.addChangeListener(this);
		add(height, c);
	}

	public Person getModel() {
		return model;
	}

	public void setModel(Person model) {
		this.model = model;
		nameTextField.setText(model.getName());
		emailTextField.setText(model.getEmail());
		dateOfBirthTextField.setText(model.getDateOfBirth());
		gender.setSelectedItem(model.getGender());
		height.setValue(model.getHeight());
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == nameTextField) {
			model.setName(nameTextField.getText());
		}
		else if (e.getSource() == emailTextField) {
			model.setEmail(emailTextField.getText());
		}
		else if (e.getSource() == dateOfBirthTextField) {
			model.setDateOfBirth(dateOfBirthTextField.getText());
		}
		else if (e.getSource() == gender) {
			model.setGender((Gender) gender.getSelectedItem());
		}
		else if (e.getSource() == height) {
			model.setHeight(height.getValue());
		}	
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		model.setHeight(height.getValue());		
	}


	public static void main(String[] args) {
		PersonPanel pp = new PersonPanel();
		JFrame frame = new JFrame();
		frame.setContentPane(pp);
		frame.pack();
		frame.setVisible(true);

	}
}	