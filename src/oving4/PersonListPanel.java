package oving4;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import oving3.Person;
import oving3.PersonPanel;

public class PersonListPanel extends JPanel implements ListSelectionListener,
		ActionListener {

	JList<Person> personList;
	PersonPanel personPanel;
	DefaultListModel model;
	JButton newPersonButton;
	JButton deletePersonButton;

	public PersonListPanel() {
		setLayout(new GridLayout(2, 2));

		personList = new JList<Person>();
		personList.setName("PersonList");
		personList.addListSelectionListener(this);
		personList.setCellRenderer(new PersonRenderer());
		add(personList);

		personPanel = new PersonPanel();
		personPanel.setName("PersonPanel");
		add(personPanel);

		newPersonButton = new JButton("New Person");
		newPersonButton.setName("NewPersonButton");
		newPersonButton.addActionListener(this);
		add(newPersonButton);

		deletePersonButton = new JButton("Delete Person");
		deletePersonButton.setName("DeletePersonButton");
		deletePersonButton.addActionListener(this);
		add(deletePersonButton);
	}

	public DefaultListModel getModel() {
		return model;
	}

	public void setModel(DefaultListModel dlm) {
		model = dlm;
		personList.setModel(model);

	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (personList.getSelectedValue() != null)
			personPanel.setModel((Person) personList.getSelectedValue());

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == newPersonButton) {
			model.addElement(new Person("New Person"));
		} else if (e.getSource() == deletePersonButton) {
			if (personList.getSelectedIndex() != -1) 
				model.remove(personList.getSelectedIndex());
		}

	}
}
