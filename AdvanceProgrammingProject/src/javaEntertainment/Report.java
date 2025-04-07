/*
Group Members: Brianna Mowatt, Oconnor Burton, Chadrick Atkinson, Gabrielle Flash & Robert Dowe
Date: April 6, 2025
Project: Java Entertainment
*/

package javaEntertainment;

import java.io.Serializable;

public class Report implements Serializable{

	private static final long serialVersionUID = 1L;
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
		if (r == null) {
            throw new IllegalArgumentException("Equipment object cannot be null");
        }
		this.rId = r.rId;
		this.totalBookings = r.totalBookings;
		this.dateGenerated = r.dateGenerated;
		this.timeGenerated = r.timeGenerated;
		this.totalRevenues = r.totalRevenues;
    }
	
	
	public String getRID() {
		return rId;
	}
	
	public void setRID(String rId) {
		if (rId == null || rId.trim().isEmpty()) {
            throw new IllegalArgumentException("Report ID cannot be empty");
        }
		this.rId = rId;
	}
	
	public int getTotalBookings() {
		return totalBookings;
	}
	
	public void setTotalBookings(int totalBookings) {
		if (totalBookings < 0) {
            throw new IllegalArgumentException("Total Bookings cannot be negative");
        }
		this.totalBookings = totalBookings;
	}
	
	public DateTime getDateGenerated() {
		return dateGenerated;
	}
	
	public void setDateGenerated(DateTime dateGenerated) {
		if (dateGenerated == null) {
            throw new IllegalArgumentException("There must be a date");
        }
		this.dateGenerated = dateGenerated;
	}
	
	public DateTime getTimeGenerated() {
		return timeGenerated;
	}
	
	public void setTimeGenerated(DateTime timeGenerated) {
		if (timeGenerated == null) {
            throw new IllegalArgumentException("There must be a time");
        }
		this.timeGenerated = timeGenerated;
	}
	
	public float getTotalRevenues() {
		return totalRevenues;
	}
	
	public void setTotalRevenues(float totalRevenues) {
		if (totalRevenues < 0) {
	        throw new IllegalArgumentException("Total revenues cannot be negative.");
	    }
		this.totalRevenues = totalRevenues;
	}
	
	@Override
	public String toString() {
		return "\nReport Id = " + rId +
				"\nTotal Bookings = " + totalBookings +
				"\nDate Generated = " + dateGenerated +
				"\nTime Generated = " + timeGenerated + 
				"\nTotal Revenues = " + totalRevenues;
	}
	
	
	
}
