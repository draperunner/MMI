package oving3;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PersonPanel extends JPanel implements ActionListener, ChangeListener, PropertyChangeListener {

	protected Person model;
	private JLabel nameLabel, emailLabel, dateOfBirthLabel, genderLabel,
			heightLabel;
	protected JTextField nameTextField, emailTextField, dateOfBirthTextField;
	protected JComboBox<Gender> gender;
	protected JSlider height;
	protected GridBagConstraints c;

	public PersonPanel() {

		setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;

		nameLabel = new JLabel("Name:");
		add(nameLabel, c);

		c.gridx = 1;
		addNameTextField(c);

		c.gridx = 0;
		c.gridy = 1;
		emailLabel = new JLabel("Email:");
		add(emailLabel, c);

		c.gridx = 1;
		addEmailTextField(c);

		c.gridx = 0;
		c.gridy = 2;
		dateOfBirthLabel = new JLabel("Date of Birth: ");
		add(dateOfBirthLabel, c);

		c.gridx = 1;
		addDateOfBirthTextField(c);

		c.gridx = 0;
		c.gridy = 3;
		JLabel genderLabel = new JLabel("Gender:");
		add(genderLabel, c);

		c.gridx = 1;
		addGenderComboBox(c);

		c.gridx = 0;
		c.gridy = 4;
		heightLabel = new JLabel("Height:");
		add(heightLabel, c);

		c.gridx = 1;
		addHeightSlider(c);
		
	}

	private void addHeightSlider(GridBagConstraints c) {
		height = new JSlider(120, 220);
		height.setName("HeightPropertyComponent");
		height.addChangeListener(this);
		height.setPaintTicks(true);
		height.setPaintLabels(true);
		height.setMajorTickSpacing(20);
		add(height, c);
	}

	private void addGenderComboBox(GridBagConstraints c) {
		gender = new JComboBox<Gender>();
		gender.setName("GenderPropertyComponent");
		gender.addItem(Gender.male);
		gender.addItem(Gender.female);
		gender.addActionListener(this);
		add(gender, c);
	}

	private void addDateOfBirthTextField(GridBagConstraints c) {
		dateOfBirthTextField = new JTextField(10);
		dateOfBirthTextField.setName("DateOfBirthPropertyComponent");
		dateOfBirthTextField.addActionListener(this);
		add(dateOfBirthTextField, c);
	}

	private void addEmailTextField(GridBagConstraints c) {
		emailTextField = new JTextField(10);
		emailTextField.setName("EmailPropertyComponent");
		emailTextField.addActionListener(this);
		add(emailTextField, c);
	}

	private void addNameTextField(GridBagConstraints c) {
		c.fill = GridBagConstraints.HORIZONTAL;
		nameTextField = new JTextField(10);
		nameTextField.setName("NamePropertyComponent");
		nameTextField.addActionListener(this);
		add(nameTextField, c);
	}

	public Person getModel() {
		return model;
	}

	public void setModel(Person model) {
		this.model = model;
		model.addPropertyChangeListener(this);
		viewAll();
	}

	protected void viewAll() {
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
		} else if (e.getSource() == emailTextField) {
			model.setEmail(emailTextField.getText());
		} else if (e.getSource() == dateOfBirthTextField) {
			model.setDateOfBirth(dateOfBirthTextField.getText());
		} else if (e.getSource() == gender) {
			model.setGender((Gender) gender.getSelectedItem());
		}
		System.out.println(model);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		model.setHeight(height.getValue());
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
			gender.setSelectedItem(model.getGender());
		} else if (e.getPropertyName().equals("height")) {
			height.setValue(model.getHeight());
		}
	}

	public static void main(String[] args) {
		PersonPanel pp = new PersonPanel();
		JFrame frame = new JFrame();
		frame.setContentPane(pp);
		frame.pack();
		frame.setVisible(true);
	}
}