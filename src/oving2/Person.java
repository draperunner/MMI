package oving2;

public class Person {

	private String name;
	private String dateOfBirth;
	private Gender gender;
	private String email;
	private int height;
	
	
	
	
	public Person(String name, String dateOfBirth, Gender gender, String email, int height) {
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.email = email;
		this.height = height;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public Gender getGender() {
		return gender;
	}


	public void setGender(Gender gender) {
		this.gender = gender;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}
	
	public Person(String name) {
		setName(name);
	}


	public String toString() {
		return getName() + " " + getDateOfBirth() + " " + getEmail() + " " + getGender() + " " + getHeight();
	}
}
