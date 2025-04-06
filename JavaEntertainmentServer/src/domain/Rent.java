package domain;

import java.io.Serializable;

public class Rent implements Serializable{
	private String customerId; 
    private String equipmentId;
	private double amountOwed;
	private float amountPaid; 
	private int duration;

	public Rent()
	{
		customerId = "";
		equipmentId = "";
		amountOwed = 0;
		amountPaid = 0; 
		duration = 0;
	}
	
	public Rent(double amount, String equipmentId)
	{
		this.amountOwed = amount;
		this.equipmentId = equipmentId;
	
	}
	
	public Rent(Rent r)
	{
		if (r == null) {
            throw new IllegalArgumentException("Rent object cannot be null");
        }
		this.amountOwed = r.amountOwed;
		this.amountPaid = r.amountPaid; 
		this.duration = r.duration;
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
	
	public double getAmountOwed() {
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
	

	@Override
	public String toString() {
		return "Rent = " + amountOwed +
				"\nAmount Paid = " + amountPaid +
				"\nDuration = " + duration;
		
	}
	
}
