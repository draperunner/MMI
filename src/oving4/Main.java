package oving4;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;

import oving3.Gender;
import oving3.Person;

public class Main {

	public static void main(String[] args) {
		
		PersonListPanel panel = new PersonListPanel();
		JFrame frame = new JFrame();
		frame.setContentPane(panel);
		frame.pack();
		frame.setVisible(true);
		
		Person ola = new Person("Ola Nordmann", "13021988", Gender.male, "ola@nordmann.no", 180);
		Person arne = new Person("Arne Gran", "12121948", Gender.male, "arne@gran.no", 175);
		Person kari = new Person("Kari Nordmann", "07091998", Gender.female, "kari@nordmann.no", 163);
		
		DefaultListModel<Person> model = new DefaultListModel<Person>();
		model.addElement(ola);
		model.addElement(arne);
		model.addElement(kari);
		
		panel.setModel(model);
	}

}
