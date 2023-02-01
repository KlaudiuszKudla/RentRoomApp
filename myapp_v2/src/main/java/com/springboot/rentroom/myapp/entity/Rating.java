package com.springboot.rentroom.myapp.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "rating")
public class Rating {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="rating_id")
	private int id;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name = "room_id")
	private Room room1;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name = "user_id")
	private User user3; 
	
	@Column(name ="rating_score")
	private int ratingScore;
	
	@Column(name = "rating_comment")
	private String ratingComment;
	
	@Column(name = "rating_date")
	private String ratingDate;
	
	
	public Rating() {
		
	}

	public Rating(int ratingScore, String ratingComment, String ratingDate) {
		super();
		this.ratingScore = ratingScore;
		this.ratingComment = ratingComment;
		this.ratingDate = ratingDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRatingScore() {
		return ratingScore;
	}

	public void setRatingScore(int ratingScore) {
		this.ratingScore = ratingScore;
	}

	public String getRatingComment() {
		return ratingComment;
	}

	public void setRatingComment(String ratingComment) {
		this.ratingComment = ratingComment;
	}

	public String getRatingDate() {
		return ratingDate;
	}

	public void setRatingDate(String ratingDate) {
		this.ratingDate = ratingDate;
	}
	
	
	
	public Room getRoom1() {
		return room1;
	}

	public void setRoom1(Room room1) {
		this.room1 = room1;
	}

	public User getUser3() {
		return user3;
	}

	public void setUser3(User user3) {
		this.user3 = user3;
	}

	@Override
	public String toString() {
		return "Rating [id=" + id + ", ratingScore=" + ratingScore + ", ratingComment=" + ratingComment
				+ ", ratingDate=" + ratingDate + "]";
	}
	
	
}
