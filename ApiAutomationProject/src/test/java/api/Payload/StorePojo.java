package api.Payload;

import com.github.javafaker.DateAndTime;

public class StorePojo {
/*
 * {
  "id": 0,
  "petId": 0,
  "quantity": 0,
  "shipDate": "2024-01-08T15:22:22.576Z",
  "status": "placed",
  "complete": true
}*/
	int id ;
	int petId;
	int quantity ;
	DateAndTime shipDate;
	String status;
	boolean complete;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getPetId() {
		return petId;
	}
	public void setPetId(int petId) {
		this.petId = petId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public DateAndTime getShipDate() {
		return shipDate;
	}
	public void setShipDate(DateAndTime dateandtime) {
		this.shipDate = dateandtime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public boolean getComplete() {
		return complete;
	}
	public void setComplete(boolean complete) {
		this.complete = complete;
	}
	
	
	
	
}
