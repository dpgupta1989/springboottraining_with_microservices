package com.example.springboot.training.api;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Item {

	@Id
	@Column(name="ITEM_ID")
	private int itemId;
	
	@Column(name="ITEM_NAME")
	private String itemName;
	
	@Column(name="ITEM_PRICE")
	private int itemPrice;
	
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

}
