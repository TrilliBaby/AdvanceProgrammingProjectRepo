package javaEntertainment;

public class Customer extends Person{
	
	private String cusID;
	private String phoneNumber;
	private char gender;
	
	
	public Customer(Customer c) {
		super(c);
		this.cusID = c.cusID;
		this.phoneNumber = c.phoneNumber;
		this.gender = c.gender;
	}
	
	public Customer() {
		super();
		this.cusID = "";
		this.phoneNumber = "";
		this.gender = ' ';
	}
	
	public Customer(Person p, String cusID, String phoneNumber, char gender) {
		super(p);
		this.cusID = cusID;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
	}

	public String getCusID() {
		return cusID;
	}

	public void setCusID(String cusID) {
		this.cusID = cusID;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
	    return "Customer" + 
	           "\n  Customer ID = " + cusID + 
	           "\n  First Name = " + firstName + 
	           "\n  Last Name = " + lastName + 
	           "\n  Gender = " + gender + 
	           "\n  Age = " + age + 
	           "\n  Date of Birth = " + dOB + 
	           "\n  Phone Number = " + phoneNumber + 
	           "\n  Email = " + email + 
	           "\n  Address = " + address;
	}


	
	
	
	
	
	
	

}
