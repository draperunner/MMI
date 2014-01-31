package oving3;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Person {

	private String name = null;
	private String dateOfBirth = null;
	private Gender gender = null;
	private String email = null;
	private int height = 0;
	private PropertyChangeSupport pcs;

	public Person() {
		pcs = new PropertyChangeSupport(this);
	}

	public Person(String name, String dateOfBirth, Gender gender, String email,
			int height) {
		pcs = new PropertyChangeSupport(this);
		setName(name);
		setDateOfBirth(dateOfBirth);
		setGender(gender);
		setEmail(email);
		setHeight(height);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		String oldValue = this.name;
		this.name = name;
		pcs.firePropertyChange("name", oldValue, name);
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		String oldValue = this.dateOfBirth;
		this.dateOfBirth = dateOfBirth;
		pcs.firePropertyChange("dateOfBirth", oldValue, dateOfBirth);
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		Gender oldValue = this.gender;
		this.gender = gender;
		pcs.firePropertyChange("gender", oldValue, gender);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		String oldValue = this.email;
		this.email = email;
		pcs.firePropertyChange("email", oldValue, email);

	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		int oldValue = this.height;
		this.height = height;
		pcs.firePropertyChange("height", oldValue, height);
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(listener);
	}
	
	public String toString() {
		return (getName() + " " + getDateOfBirth() + " " + getEmail() + " " + getGender() + " " + getHeight());
	}

}
