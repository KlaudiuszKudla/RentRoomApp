package com.springboot.rentroom.myapp.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="user")
public class User {
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int id;
	
	
	@Column(name = "user_password_digest")
	private String userPasswordDigest;
	
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "user_surname")
	private String userSurname;
	
	@Column(name = "user_type")
	private String userType;
	
	@Column(name = "user_phone")
	private String userPhone;
	
	@Column(name = "user_email")
	private String userEmail;
	
	@OneToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "location_id")
	private Location location;
	
	
	@OneToMany(mappedBy= "user2",
			fetch=FetchType.LAZY,
		cascade={CascadeType.PERSIST, CascadeType.MERGE,
				CascadeType.DETACH, CascadeType.REFRESH})
	private List<Room> rooms;
	
	@OneToMany(mappedBy="user3", 
			fetch=FetchType.LAZY,
			cascade = CascadeType.ALL)
	private List<Rating> ratings;
	
	@OneToMany(mappedBy="user4", 
			fetch=FetchType.LAZY,
			cascade = CascadeType.ALL)
	private List<Rent> rents;
	
	
	public User() {
		
	}
	public User(String userPasswordDigest, String userName, String userSurname, String userType,
			String userPhone, String userEmail) {
		super();
		this.userPasswordDigest = userPasswordDigest;
		this.userName = userName;
		this.userSurname = userSurname;
		this.userType = userType;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserPasswordDigest() {
		return userPasswordDigest;
	}

	public void setUserPasswordDigest(String userPasswordDigest) {
		this.userPasswordDigest = userPasswordDigest;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserSurname() {
		return userSurname;
	}

	public void setUserSurname(String userSurname) {
		this.userSurname = userSurname;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	

		public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	
	
	public List<Room> getRooms() {
		return rooms;
	}
	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}
	
	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}
	
	
	public List<Rent> getRents() {
		return rents;
	}
	public void setRents(List<Rent> rents) {
		this.rents = rents;
	}
	
	
	@Override
	public String toString() {
		return "myUser [id=" + id + ", userPasswordDigest=" + userPasswordDigest + ", userName=" + userName
				+ ", userSurname=" + userSurname + ", userType=" + userType + ", userPhone=" + userPhone
				+ ", userEmail=" + userEmail +  ", location=" + location + "]";
				
	}
	
	
	public void add(Room tempRooms) {
		
		if(rooms == null) {
			rooms = new ArrayList<>();
		}
		rooms.add(tempRooms);
		tempRooms.setUser2(this);
	}
	
 public void addRating(Rating theRating) {
		
		if(ratings == null) {
			
			ratings = new ArrayList<>();
		}
		ratings.add(theRating);
	}
 
 public void addRents(Rent theRent) {
		
		if(rents == null) {
			
			rents = new ArrayList<>();
		}
		rents.add(theRent);
	}
	

}
