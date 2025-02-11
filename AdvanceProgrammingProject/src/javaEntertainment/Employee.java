package javaEntertainment;

import java.io.Serializable;

public class Employee extends Person implements Serializable{

	private static final long  serialVersionUID = 1L;
	private String userName;
	private String trn;
	private String password;
	
	public Employee(Employee e) {
		super(e);
		this.userName = e.userName;
		this.trn = e.trn;
		this.password = e.password;
	}
	
	public Employee() {
		super();
		this.userName = "";
		this.trn = "";
		this.password = "";		
	}
	
	public Employee(Person p, String userName, String trn, String password) {
		super(p);
		this.userName = userName;
		this.trn = trn;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTrn() {
		return trn;
	}

	public void setTrn(String trn) {
		this.trn = trn;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return 	"\nEmployee User Name = " + userName +
				"\nFirst Name = " + firstName +
				"\nLast Name = " + lastName +
				"\nTRN = " + trn +
				"\nPassword = " + password +
				"\nDate Of Birth = " + dOB +
				"\nAddress = " + address +
				"\nEmail = " + email;
	}
	
	
}
