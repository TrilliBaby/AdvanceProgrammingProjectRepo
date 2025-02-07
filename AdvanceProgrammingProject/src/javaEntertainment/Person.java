package javaEntertainment;

public class Person {
	
	protected String firstName;
	protected String lastName;
	protected int age;
	protected String dOB;
	protected String address;
	protected String email;
	
	
	public Person (Person p) {
		this.firstName = p.firstName;
		this.lastName = p.lastName;
		this.age = p.age;
		this.dOB = p.dOB;
		this.address = p.address;
		this.email = p.email;
	}
	
	public Person () {
		this.firstName = "";
		this.lastName = "";
		this.age = 0;
		this.dOB = "";
		this.address = "";
		this.email = "";
	}
	
	public Person(String firstName, String lastName, int age, String dOB, String address, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.dOB = dOB;
		this.address = address;
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getdOB() {
		return dOB;
	}

	public void setdOB(String dOB) {
		this.dOB = dOB;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	

}
