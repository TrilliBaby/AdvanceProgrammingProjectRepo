package javaEntertainment;

public class Manager extends Employee {
	
	private String position;

	public Manager(Manager m) {
		super(m);
		if (m == null) {
			throw new IllegalArgumentException("Manager object cannot be null");
		}
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
		if (position == null || position.trim().isEmpty()) {
			throw new IllegalArgumentException("You must enter your position");
		}
		this.position = position;
	}

	@Override
	public String toString() {
		return "\nPosition = " + position +
				super.toString();			   
	}
}
