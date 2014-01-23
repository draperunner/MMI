package oving2;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

import oving1.ButtonsNText;

public class PersonPanel extends JPanel {

	private Person model;

	private GridBagLayout layout;
	private JLabel nameLabel, emailLabel, dateOfBirthLabel, genderLabel,
			heightLabel;
	private JTextField nameTextField, emailTextField, dateOfBirthTextField;
	private JComboBox gender;
	private JSlider height;

	public PersonPanel() {

		JLabel nameLabel = new JLabel("Name:");
		nameTextField = new JTextField(10);
		nameTextField.setName("NamePropertyComponent");

		JLabel emailLabel = new JLabel("Email:");
		emailTextField = new JTextField(10);
		emailTextField.setName("EmailPropertyComponent");

		JLabel dateOfBirthLabel = new JLabel("Date of Birth:");
		dateOfBirthTextField = new JTextField(10);
		dateOfBirthTextField.setName("DateOfBirthPropertyComponent");

		JLabel genderLabel = new JLabel("Gender:");
		gender = new JComboBox();
		gender.setName("GenderPropertyComponent");
		gender.addItem(Gender.male);
		gender.addItem(Gender.female);

		JLabel heightLabel = new JLabel("Height:");
		height = new JSlider(120, 220);
		height.setName("HeightPropertyComponent");

		layout = new GridBagLayout();
		layout.addLayoutComponent("", nameLabel);
		layout.addLayoutComponent("Name", nameTextField);
		layout.addLayoutComponent("Email", emailTextField);
		layout.addLayoutComponent("Date of Birth", dateOfBirthTextField);
		layout.addLayoutComponent("Gender", gender);
		layout.addLayoutComponent("Height", height);

		add(nameLabel);
		add(nameTextField);
		add(emailLabel);
		add(emailTextField);
		add(dateOfBirthLabel);
		add(dateOfBirthTextField);
		add(genderLabel);
		add(gender);
		add(heightLabel);
		add(height);

		Person per = new Person("Per");
		per.setEmail("per@byrkjeland.net");
		per.setDateOfBirth("030685");
		per.setGender(Gender.male);
		per.setHeight(183);
		setModel(per);
	}

	public Person getModel() {
		return model;
	}

	public void setModel(Person model) {
		this.model = model;
		update();
	}

	private void update() {
		nameTextField.setText(model.getName());
		emailTextField.setText(model.getEmail());
		dateOfBirthTextField.setText(model.getDateOfBirth());
		gender.setSelectedItem(model.getGender());
		height.setValue(model.getHeight());
	}

	public static void main(String[] args) {
		PersonPanel pp = new PersonPanel();
		pp.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		JFrame frame = new JFrame();
		frame.setContentPane(pp);
		frame.pack();
		frame.setVisible(true);
	}

}
