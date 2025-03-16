package domain;

import java.io.Serializable;

public class Employee extends Person implements Serializable {

    private static final long serialVersionUID = 1L;
    private String userName;
    private String trn;
    private String password;

    public Employee(Employee e) {
        super(e);
        if (e == null) {
            throw new IllegalArgumentException("Employee object cannot be null");
        }
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
        setUserName(userName);
        setTrn(trn);
        setPassword(password);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        if (userName == null || userName.trim().isEmpty()) {
            throw new IllegalArgumentException("You must enter a username.");
        }
        this.userName = userName;
    }

    public String getTrn() {
        return trn;
    }

    public void setTrn(String trn) {
        if (trn == null || !trn.matches("\\d{9}")) {
            throw new IllegalArgumentException("TRN must be exactly 9 digits");
        }
        this.trn = trn;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password == null || password.length() < 8) {
            throw new IllegalArgumentException("Password must be at least 8 characters long");
        }
        this.password = password;
    }

    @Override
    public String toString() {
        return "\nEmployee User Name = " + userName +
               "\nFirst Name = " + firstName +
               "\nLast Name = " + lastName +
               "\nTRN = " + trn +
               "\nPassword = " + password +
               "\nDate Of Birth = " + dOB +
               "\nAddress = " + address +
               "\nEmail = " + email;
    }
}
