package javaEntertainment;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Person {
	
	protected String firstName;
	protected String lastName;
	protected int age;
	protected String dOB;
	protected String address;
	protected String email;
	
	
	public Person (Person p) {
		if (p == null) {
            throw new IllegalArgumentException("Person object cannot be null");
        }
		
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
	
	 private boolean isAgeValid(String dOB, int age) {
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	        LocalDate birthDate = LocalDate.parse(dOB, formatter);
	        LocalDate currentDate = LocalDate.now();
	        int calculatedAge = Period.between(birthDate, currentDate).getYears();
	        return calculatedAge == age;
	    }

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if (firstName == null || firstName.trim().isEmpty()) {
            throw new IllegalArgumentException("First name cannot be empty.");
        }
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if (lastName == null || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be empty.");
        }
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if (age < 0 ) {
			throw new IllegalArgumentException("Age cannot be negative");
		}
		
		if (!isAgeValid(dOB, age)) {
            throw new IllegalArgumentException("The age does not match the date of birth.");
        }
		this.age = age;
	}

	public String getdOB() {
		return dOB;
	}

	public void setdOB(String dOB) {
		if (dOB == null || dOB.trim().isEmpty()) {
			throw new IllegalArgumentException("You must enter a Date of birth");
		}
		
		if (!isAgeValid(dOB, age)) {
            throw new IllegalArgumentException("The Date of birth does not match the age");
        }
		this.dOB = dOB;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		if (address == null || address.trim().isEmpty()) {
            throw new IllegalArgumentException("You must enter an address");
        }
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("You must enter an email");
        }
		this.email = email;
	}

}
