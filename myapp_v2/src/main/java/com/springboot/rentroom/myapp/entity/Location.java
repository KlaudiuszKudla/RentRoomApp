package com.springboot.rentroom.myapp.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "location")
public class Location {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "location_id")
	private int id;
	
	@Column(name = "street_address")
	private String streetAddress;
	
	@Column( name = "postal_code")
	private String postalCode;
	
	@Column(name = "city_name")
	private String cityName;
	
	@OneToOne(mappedBy = "location",
			fetch=FetchType.LAZY,
			cascade ={CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH})
	private User user;
	
	
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Location() {
		
	}
	

	public Location( String streetAddress, String postalCode, String cityName) {
		super();
		this.streetAddress = streetAddress;
		this.postalCode = postalCode;
		this.cityName = cityName;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}



	@Override
	public String toString() {
		return "Location [id=" + id + ", streetAddress=" + streetAddress + ", postalCode=" + postalCode + ", cityName="
				+ cityName + "]";
	}
	
	
	
	
  
}
