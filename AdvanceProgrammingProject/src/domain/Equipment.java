package domain;

import java.io.Serializable;

public class Equipment implements Serializable {

    private static final long serialVersionUID = 1L;
    private String equipId;
    private String name;
    private String type;
    private String status;
    private double cost;
    private double amount;

    public Equipment() {
        equipId = "";
        name = "";
        type = "";
        status = "";
        cost = 0;
    }

    public Equipment(String equipId, String name, String type, float cost) {
        this.equipId = equipId;
        this.name = name;
        this.type = type;
        this.cost = cost;
    }

    public Equipment(Equipment e) {
        if (e == null) {
            throw new IllegalArgumentException("Equipment object cannot be null");
        }
        this.equipId = e.equipId;
        this.name = e.name;
        this.type = e.type;
        this.status = e.status;
        this.cost = e.cost;
    }

    public String getEquipId() {
        return equipId;
    }

    public void setEquipId(String equipId) {
        if (equipId == null || equipId.trim().isEmpty()) {
            throw new IllegalArgumentException("Equipment ID cannot be empty");
        }
        this.equipId = equipId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("You must enter the name of the equipment");
        }
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if (type == null || type.trim().isEmpty()) {
            throw new IllegalArgumentException("You must enter the type of equipment");
        }
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if (status == null || status.trim().isEmpty()) {
            throw new IllegalArgumentException("You must enter the status");
        }
        this.status = status;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        if (cost < 0) {
            throw new IllegalArgumentException("Cost cannot be negative");
        }
        this.cost = cost;
    }
    
    
    public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "\nEquipment Id = " + equipId + 
				"\nName = " + name + 
				"\nType = " + type + 
				"\nStatus = " + status +
				"\nCost = "+ cost +
				"\nAmount = " + amount;
	} 
}