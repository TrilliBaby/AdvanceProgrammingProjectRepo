package javaEntertainment;

public class Event {
	
	private String eID;  
	private String name;
	private String address; 
	private int duration ;
	private DateTime eventDate;
	private DateTime eventTime;
	private String status; 
	
	public Event()
	{
		eID = "";  
		name = "";
		address = ""; 
		duration = 0 ;
		eventDate = new DateTime();
		eventTime = new DateTime();
		status = "";
	}
	

	
	public Event(String eID, String name, String address, int duration, DateTime eventDate, DateTime eventTime,  String status)
	{
		
			this.eID = eID;  
			this.name = name;
			this.address = address; 
			this.duration = duration;
			this.eventDate = eventDate;
			this.eventTime = eventTime;
			this.status = status;
		
	}
	
	public Event(Event e)
	{
		this.eID = e.eID;  
		this.name = e.name;
		this.address = e.address; 
		this.duration = e.duration;
		this.eventDate = e.eventDate;
		this.eventTime = e.eventTime;
		this.status = e.status;
	}



	public String geteID() {
		return eID;
	}



	public void seteID(String eID) {
		this.eID = eID;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public int getDuration() {
		return duration;
	}



	public void setDuration(int duration) {
		this.duration = duration;
	}



	public DateTime getEventDate() {
		return eventDate;
	}



	public void setEventDate(DateTime eventDate) {
		this.eventDate = eventDate;
	}



	public DateTime getEventTime() {
		return eventTime;
	}



	public void setEventTime(DateTime eventTime) {
		this.eventTime = eventTime;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	@Override
	public String toString() {
		return "Event [eID=" + eID + ", name=" + name + ", address=" + address + ", duration=" + duration
				+ ", eventDate=" + eventDate + ", eventTime=" + eventTime + ", status=" + status + "]";
	}
	
	


}
