package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Donar {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int donarId;
	private int contact;
	private String donarName;
	private String address;
	private String category;
	private int quantity;

	@Column(name = "picByte", length = 1000)
	private byte[] picByte;

	public String getUserName() {
		return donarName;
	}

	
	public Donar(int donarId, int contact, String donarName, String address, String category, int quantity,
		 byte[] picByte) {
		super();
		this.donarId = donarId;
		this.contact = contact;
		this.donarName = donarName;
		this.address = address;
		this.category = category;
		this.quantity = quantity;
		this.picByte = picByte;
	}


	public int getDonarId() {
		return donarId;
	}

	public void setDonarId(int donarId) {
		this.donarId = donarId;
	}

	public String getDonarName() {
		return donarName;
	}

	public void setDonarName(String donarName) {
		this.donarName = donarName;
	}

	public byte[] getPicByte() {
		return picByte;
	}

	public void setPicByte(byte[] picByte) {
		this.picByte = picByte;
	}


	public int getContact() {
		return contact;
	}


	public void setContact(int contact) {
		this.contact = contact;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
