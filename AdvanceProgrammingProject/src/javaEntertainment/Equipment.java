package javaEntertainment;

import java.io.Serializable;

public class Equipment implements Serializable{

	private static final long serialVersionUID = 1L;
	private String equipId; 
	private String name; 
	private String type; 
	private String status; 
	private float cost;
	
	
	public Equipment() {
		
		equipId = ""; 
		name = ""; 
		type = ""; 
		status = ""; 
		cost = 0;
	}
	
	public Equipment(String equipId, String name, String type, String status, float cost) {
		
		this.equipId = equipId; 
		this.name = name; 
		this.type = type; 
		this.status = status; 
		this.cost = cost;
	}
	
	public Equipment(Equipment e) {
		
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
		this.equipId = equipId;
	}





	public String getName() {
		return name;
	}





	public void setName(String name) {
		this.name = name;
	}





	public String getType() {
		return type;
	}





	public void setType(String type) {
		this.type = type;
	}





	public String getStatus() {
		return status;
	}





	public void setStatus(String status) {
		this.status = status;
	}





	public Float getCost() {
		return cost;
	}





	public void setCost(Float cost) {
		this.cost = cost;
	}





	@Override
	public String toString() {
		return "Equipment [equipId=" + equipId + ", name=" + name + ", type=" + type + ", status=" + status + ", cost="
				+ cost + "]";
	} 
	
	

}
