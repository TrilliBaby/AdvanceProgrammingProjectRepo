package javaEntertainment;

public class Manager extends Employee {
	
	private String position;

	public Manager(Manager m) {
		super(m);
		this.position = m.position;
	}

	public Manager() {
		super();
		this.position = "";
	}

	public Manager(Employee e, String position) {
		super(e);
		this.position = position;
	}

	public Manager(Person p, String userName, String trn, String password, String position) {
		super(p, userName, trn, password);
		this.position = position;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "\nPosition = " + position +
				super.toString();			   
	}
}
