package javaEntertainment;

public class Report {
	private String rId;  
	private int totalBookings; 
	private DateTime dateGenerated; 
	private DateTime timeGenerated;
	private float totalRevenues;
	
	

	public Report()
	{
		rId = "" ;  
		totalBookings = 0; 
		dateGenerated = new DateTime(); 
		timeGenerated =new DateTime();
		totalRevenues = 0;
	}
	public Report(String RID, int TotalBookings, DateTime DateGenerated, DateTime TimeGenerated,float TotalRevenues)
	{
		this.rId = RID;
		this.totalBookings = TotalBookings;
		this.dateGenerated = DateGenerated;
		this.timeGenerated = TimeGenerated;
		this.totalRevenues = TotalRevenues;
	}
	public Report(Report r) 
	{
		this.rId = r.rId;
		this.totalBookings = r.totalBookings;
		this.dateGenerated = r.dateGenerated;
		this.timeGenerated = r.timeGenerated;
		this.totalRevenues = r.totalRevenues;
    }
	
	
	public String getRID() {
		return rId;
	}
	public void setRID(String rID) {
		rId = rID;
	}
	public int getTotalBookings() {
		return totalBookings;
	}
	public void setTotalBookings(int totalBookings) {
		this.totalBookings = totalBookings;
	}
	public DateTime getDateGenerated() {
		return dateGenerated;
	}
	public void setDateGenerated(DateTime dateGenerated) {
		this.dateGenerated = dateGenerated;
	}
	public DateTime getTimeGenerated() {
		return timeGenerated;
	}
	public void setTimeGenerated(DateTime timeGenerated) {
		this.timeGenerated = timeGenerated;
	}
	public float getTotalRevenues() {
		return totalRevenues;
	}
	public void setTotalRevenues(float totalRevenues) {
		this.totalRevenues = totalRevenues;
	}
	
	@Override
	public String toString() {
		return "Report [RID=" + rId + ", TotalBookings=" + totalBookings + ", DateGenerated=" + dateGenerated
				+ ", TimeGenerated=" + timeGenerated + ", TotalRevenues=" + totalRevenues + "]";
	}
	
	
	
	
	
}
