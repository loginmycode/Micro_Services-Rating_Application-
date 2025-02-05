package com.rating.service;

import java.util.List;

import com.rating.model.Rating;

public interface RatingService {

	//create
	public Rating createRating(Rating rating);
	
	
	//getall
	public List<Rating>  getAllRating();
	
	
	//getsingle
	public Rating getSingleRating(String ratingId);
	
	//get all by userId
	public List<Rating> getRatingByUserId(String userId);
	
	//get all by hotelid
	
	public List<Rating> getRatingByHotelId(String hotelId);
}
