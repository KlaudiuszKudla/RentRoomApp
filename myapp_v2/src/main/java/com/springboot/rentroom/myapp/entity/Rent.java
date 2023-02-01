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
import jakarta.persistence.Table;

@Entity
@Table(name = "rent")
public class Rent {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rent_id")
	private int id;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name = "user_id")
	private User user4;
	
	@Column(name = "start_time")
	private String startTime;
	
	@Column(name = "end_time")
	private String endTime;
	
	@Column(name = "rent_price")
	private int rentPrice;
	
	@Column(name = "payment_method")
	private String paymentMethod;
	
	@ManyToMany(fetch=FetchType.LAZY,
				cascade = {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH})
	@JoinTable(
			name = "rent_room",
			joinColumns=@JoinColumn(name="rent_id"),
			inverseJoinColumns=@JoinColumn(name="room_id")
			)
	private List<Room> rooms;
	
	public Rent() {
		
	}

	public Rent(String startTime, String endTime, int rentPrice, String paymentMethod) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
		this.rentPrice = rentPrice;
		this.paymentMethod = paymentMethod;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser4() {
		return user4;
	}

	public void setUser4(User user4) {
		this.user4 = user4;
	}


	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public int getRentPrice() {
		return rentPrice;
	}

	public void setRentPrice(int rentPrice) {
		this.rentPrice = rentPrice;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}
	
	public void addRoom(Room theRoom) {
		
		if(rooms == null) {
			rooms = new ArrayList<>();
		}
		rooms.add(theRoom);
	}

	@Override
	public String toString() {
		return "Rent [id=" + id + ", user4=" + user4 + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", rentPrice=" + rentPrice + ", paymentMethod=" + paymentMethod + ", rooms=" + rooms + "]";
	}
	
	

}
