package oving4;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import oving3.Gender;
import oving3.Person;

public class PersonRenderer implements ListCellRenderer {

	protected static Border noFocusBorder = new EmptyBorder(15, 1, 1, 1);
	protected static TitledBorder focusBorder = new TitledBorder(LineBorder.createGrayLineBorder(), "Name:");
	protected DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();
	
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
		JLabel label = (JLabel) defaultRenderer.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		Person p = (Person) value;
		
		ImageIcon maleIcon = new ImageIcon("C:\\Program Files\\eclipse\\workspace\\MMI\\bin\\oving4\\male.png");
		ImageIcon femaleIcon = new ImageIcon("C:\\Program Files\\eclipse\\workspace\\MMI\\bin\\oving4\\female.png");
		
		label.setIcon(p.getGender()==Gender.male ? maleIcon : femaleIcon);
		label.setText(p + " " + p.getEmail());
		return label;
	}

}
