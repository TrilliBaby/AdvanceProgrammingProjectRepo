package javaEntertainment;

public class Invoice {
	private String inId;
	private DateTime bookingDate; 
	private DateTime issueDate; 
	private DateTime issueTime; 
	private float amountOwned;
	private float amountPaid;
	private float cost;
	
	public Invoice() {
		inId = "";
		bookingDate = new DateTime(); 
	    issueDate = new DateTime(); 
		issueTime = new DateTime(); 
		amountOwned = 0;
		amountPaid = 0;
		cost = 0;
	}
	
	public Invoice(String inId, DateTime bookingDate, DateTime issueDate, DateTime issueTime, float amountOwned, float amountPaid,float cost) 
	{
		this.inId = inId;
		this.bookingDate = bookingDate; 
		this.issueDate = issueDate; 
		this.issueTime = issueTime; 
		this.amountOwned = amountOwned;
		this.amountPaid = amountPaid;
		this.cost = cost;
	}
	
	public Invoice(Invoice i) 
	{
		i.inId = inId;
		i.bookingDate = bookingDate; 
		i.issueDate = issueDate; 
		i.issueTime = issueTime; 
		i.amountOwned = amountOwned;
		i.amountPaid = amountPaid;
		i.cost = cost;
	}
	
	
	
	public String getInId() {
		return inId;
	}





	public void setInId(String inId) {
		this.inId = inId;
	}





	public DateTime getBookingDate() {
		return bookingDate;
	}





	public void setBookingDate(DateTime bookingDate) {
		this.bookingDate = bookingDate;
	}





	public DateTime getIssueDate() {
		return issueDate;
	}





	public void setIssueDate(DateTime issueDate) {
		this.issueDate = issueDate;
	}





	public DateTime getIssueTime() {
		return issueTime;
	}





	public void setIssueTime(DateTime issueTime) {
		this.issueTime = issueTime;
	}





	public float getAmountOwned() {
		return amountOwned;
	}





	public void setAmountOwned(float amountOwned) {
		this.amountOwned = amountOwned;
	}





	public float getAmountPaid() {
		return amountPaid;
	}





	public void setAmountPaid(float amountPaid) {
		this.amountPaid = amountPaid;
	}





	public float getCost() {
		return cost;
	}





	public void setCost(float cost) {
		this.cost = cost;
	}





	@Override
	public String toString() {
		return "Invoice [INID=" + inId + ", BookingDate=" + bookingDate + ", IssueDate=" + issueDate + ", IssueTime="
				+ issueTime + ", AmountOwned=" + amountOwned + ", AmountPaid=" + amountPaid + ", Cost=" + cost + "]";
	}
	 
	
	
	
}
