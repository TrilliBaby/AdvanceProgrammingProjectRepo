package domain;

import java.io.Serializable;

public class Customer extends Person implements Serializable {

    private static final long serialVersionUID = 1L;
    private String cusID;
    private String phoneNumber;
    private char gender;
    private String empId;

    public Customer(Customer c) {
        super(c);
        if (c == null) {
            throw new IllegalArgumentException("Customer object cannot be null");
        }
        this.cusID = c.cusID;
        this.phoneNumber = c.phoneNumber;
        this.gender = c.gender;
        this.empId = c.empId;
    }

    public Customer() {
        super();
        this.cusID = "";
        this.phoneNumber = "";
        this.gender = ' ';
        this.empId = "";
    }

    public Customer(Person p, String cusID, String phoneNumber, char gender, String empId) {
        super(p);
        setCusID(cusID);
        setPhoneNumber(phoneNumber);
        setGender(gender);
        setEmpId(empId);
    }
    
    

    public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getCusID() {
        return cusID;
    }

    public void setCusID(String cusID) {
        if (cusID == null || cusID.trim().isEmpty()) {
            throw new IllegalArgumentException("Customer ID cannot be empty");
        }
        this.cusID = cusID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || !phoneNumber.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone number must be exactly 10 digits");
        }
        this.phoneNumber = phoneNumber;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        if (gender != 'M' && gender != 'F' && gender != 'O') {
            throw new IllegalArgumentException("Gender must be 'M' (Male), 'F' (Female), or 'O' (Other)");
        }
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Customer" +
               "\n  Customer ID = " + cusID +
               "\n  Name = " + name +
               "\n  Gender = " + gender +
               "\n  Age = " + age +
               "\n  Date of Birth = " + dOB +
               "\n  Phone Number = " + phoneNumber +
               "\n  Email = " + email +
               "\n  Address = " + address +
               "\n  Employee ID = " + empId ;
        	
    }
}
