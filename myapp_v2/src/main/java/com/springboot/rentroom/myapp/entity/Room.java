package com.springboot.rentroom.myapp.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "room")
public class Room {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "room_id")
	private int id;
	
	@ManyToOne(fetch=FetchType.LAZY,cascade = {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name = "user_id")
    private User user2;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "location_id")
	private Location location;
	
	@Column(name = "room_size")
	private int roomSize;
	
	@Column(name = "room_status")
	private String roomStatus;
	
	@Column( name = "room_type")
	private String roomType;
	
	@Column( name = "room_capacity")
	private int roomCapacity;
	
	@OneToMany(fetch=FetchType.LAZY, cascade= CascadeType.ALL)
	@JoinColumn(name = "room_id")
	private List<Rating> ratings;
	
	@ManyToMany(fetch=FetchType.LAZY,
			cascade = {CascadeType.PERSIST, CascadeType.MERGE,
		CascadeType.DETACH, CascadeType.REFRESH})
	@JoinTable(
		name = "rent_room",
		joinColumns=@JoinColumn(name="room_id"),
		inverseJoinColumns=@JoinColumn(name="rent_id")
		)
private List<Rent> rents;
	

	
	
	
	public Room() {
		
	}

	

	public Room(int roomSize, String roomStatus, String roomType, int roomCapacity) {
		super();
		this.roomSize = roomSize;
		this.roomStatus = roomStatus;
		this.roomType = roomType;
		this.roomCapacity = roomCapacity;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public int getRoomSize() {
		return roomSize;
	}

	public void setRoomSize(int roomSize) {
		this.roomSize = roomSize;
	}

	public String getRoomStatus() {
		return roomStatus;
	}

	public void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public int getRoomCapacity() {
		return roomCapacity;
	}

	public void setRoomCapacity(int roomCapacity) {
		this.roomCapacity = roomCapacity;
	}
	
	
	


	public User getUser2() {
		return user2;
	}



	public void setUser2(User user2) {
		this.user2 = user2;
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
		return "Room [id=" + id + ", location=" + location + ", roomSize=" + roomSize
				+ ", roomStatus=" + roomStatus + ", roomType=" + roomType + ", roomCapacity=" + roomCapacity + "]";
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
