package oving4;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import oving3.PersonPanel;

public class PersonListPanel extends JPanel {

	
	JList personList;
	PersonPanel personPanel;
	DefaultListModel model;
	
	
	public PersonListPanel() {
		personList = new JList();
		personList.setName("PersonList");
		add(personList);
		
		personPanel = new PersonPanel();
		personPanel.setName("PersonPanel");
		add(personPanel);
	}
	
	public DefaultListModel getModel() {
		return model;
	}
	
	public void setModel(DefaultListModel dlm) {
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		PersonListPanel panel = new PersonListPanel();
		JFrame frame = new JFrame();
		frame.setContentPane(panel);
		frame.pack();
		frame.setVisible(true);;
	}
	
	
}
