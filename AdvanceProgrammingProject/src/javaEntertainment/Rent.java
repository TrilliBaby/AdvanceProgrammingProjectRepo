package javaEntertainment;

public class Rent {
	
	
	private float amountOwed;
	private DateTime date; 
	private DateTime time;
	private float cost;
	private float amountPaid; 
	private DateTime duration;
	private String status;

	public Rent()
	{
		amountOwed = 0;
		date = new DateTime(); 
		time = new DateTime();
		cost = 0;
		amountPaid = 0; 
		duration = new DateTime();
		status = "";
	}
	
	public Rent(float amountOwed, DateTime date, DateTime time, float cost, float amountPaid, DateTime duration, String status)
	{
		this.amountOwed = amountOwed;
		this.date = date; 
		this.time = time;
		this.cost = cost;
		this.amountPaid = amountPaid; 
		this.duration = duration;
		this.status = status;
	}
	
	public Rent(Rent r)
	{
		if (r == null) {
            throw new IllegalArgumentException("Rent object cannot be null");
        }
		this.amountOwed = r.amountOwed;
		this.date = r.date; 
		this.time = r.time;
		this.cost = r.cost;
		this.amountPaid = r.amountPaid; 
		this.duration = r.duration;
		this.status = r.status;
	}
	
	public float getAmountOwed() {
		return amountOwed;
	}
	
	public void setAmountOwed(float amountOwed) {
		 if (amountOwed < 0) {
	            throw new IllegalArgumentException("Amount owed cannot be negative");
	        }
		this.amountOwed = amountOwed;
	}
	
	public DateTime getDate() {
		return date;
	}
	
	public void setDate(DateTime date) {
		if (date == null) {
            throw new IllegalArgumentException("There must be a time");
        }
		this.date = date;
	}
	
	public DateTime getTime() {
		return time;
	}
	
	public void setTime(DateTime time) {
		if (time == null) {
            throw new IllegalArgumentException("There must be a time");
        }
		this.time = time;
	}
	
	public float getCost() {
		return cost;
	}
	
	public void setCost(float cost) {
		if (cost < 0) {
            throw new IllegalArgumentException("Cost cannot be negative");
        }
		this.cost = cost;
	}
	
	public float getAmountPaid() {
		return amountPaid;
	}
	
	public void setAmountPaid(float amountPaid) {
		if (amountPaid < 0) {
            throw new IllegalArgumentException("Amount paid cannot be negative");
        }
		this.amountPaid = amountPaid;
	}
	
	public DateTime getDuration() {
		return duration;
	}
	
	public void setDuration(DateTime duration) {
		if (duration == null) {
			throw new IllegalArgumentException("There must be a duration");
		}
		this.duration = duration;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		if (status == null || status.trim().isEmpty()) {
            throw new IllegalArgumentException("There must be a status");
        }
		this.status = status;
	}

	@Override
	public String toString() {
		return "\nRent = " + amountOwed +
				"\nDate = " + date +
				"\nTime = " + time +
				"\nCost = " + cost + 
				"\nAmount Paid = " + amountPaid +
				"\nDuration = " + duration +
				"\nStatus = " + status;
		
	}
	
	
}
