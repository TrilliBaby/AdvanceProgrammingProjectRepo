package domain;

import java.io.Serializable;

public class Rent implements Serializable{
	
	private String rentId;
	private String customerId; 
    private String equipmentId;
	private float amountOwed;
	private float amountPaid; 
	private int duration;
	private String status;

	public Rent()
	{
		rentId = "";
		amountOwed = 0;
		amountPaid = 0; 
		duration = 0;
		status = "";
	}
	
	public Rent(String customerId, String equipmentId, int duration)
	{
		this.customerId = customerId;
        this.equipmentId = equipmentId;
		this.amountOwed = amountOwed;
		this.amountPaid = amountPaid; 
		this.duration = duration;
		this.status = status;
	}
	
	public Rent(Rent r)
	{
		if (r == null) {
            throw new IllegalArgumentException("Rent object cannot be null");
        }
		this.rentId = r.rentId;
		this.amountOwed = r.amountOwed;
		this.amountPaid = r.amountPaid; 
		this.duration = r.duration;
		this.status = r.status;
	}
	
	public String getRentId() {
		return rentId;
	}
	
	public void setRentId(String rentId) {
		if (rentId == null || rentId.trim().isEmpty()) {
            throw new IllegalArgumentException("Rent ID cannot be empty");
        }
		this.rentId = rentId;
	}
	
	public String getCustomerId() {
        return customerId;
    }
    
    public void setCustomerId(String customerId) {
        if (customerId == null || customerId.trim().isEmpty()) {
            throw new IllegalArgumentException("Customer ID cannot be empty");
        }
        this.customerId = customerId;
    }
    
    public String getEquipmentId() {
        return equipmentId;
    }
    
    public void setEquipmentId(String equipmentId) {
        if (equipmentId == null || equipmentId.trim().isEmpty()) {
            throw new IllegalArgumentException("Equipment ID cannot be empty");
        }
        this.equipmentId = equipmentId;
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
	

	
	public float getAmountPaid() {
		return amountPaid;
	}
	
	public void setAmountPaid(float amountPaid) {
		if (amountPaid < 0) {
            throw new IllegalArgumentException("Amount paid cannot be negative");
        }
		this.amountPaid = amountPaid;
	}
	
	public int getDuration() {
		return duration;
	}
	
	public void setDuration(int duration) {
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
		return "Rent ID = " + rentId +
				"\nRent = " + amountOwed +
				"\nAmount Paid = " + amountPaid +
				"\nDuration = " + duration +
				"\nStatus = " + status;
		
	}
	
}
