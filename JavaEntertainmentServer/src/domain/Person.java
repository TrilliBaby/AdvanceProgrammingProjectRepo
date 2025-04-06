package domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Person implements Serializable{
	
	protected String name;
	protected int age;
	protected Date dOB;
	protected String address;
	protected String email;
	
	
	public Person (Person p) {
		if (p == null) {
            throw new IllegalArgumentException("Person object cannot be null");
        }
		
		this.name = p.name;
		this.age = p.age;
		this.dOB = p.dOB;
		this.address = p.address;
		this.email = p.email;
	}
	
	public Person () {
		this.name= "";
		this.age = 0;
		this.dOB = new Date();
		this.address = "";
		this.email = "";
	}
	
	public Person(String name, int age, Date date, String address, String email) {
		this.name = name;
		this.age = age;
		this.dOB = date;
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

	public String getName() {
		return name;
	}

	public void setName(String ame) {
		if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("First name cannot be empty.");
        }
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if (age < 0 ) {
			throw new IllegalArgumentException("Age cannot be negative");
		}
		

		this.age = age;
	}

	public Date getdOB() {
		return dOB;
	}

	public void setdOB(Date dOB) {
		
		
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
