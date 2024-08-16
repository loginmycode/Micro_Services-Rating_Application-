package com.rating.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rating.model.Rating;

public interface RatingRepository extends MongoRepository<Rating, String>{

	//creta custom method
	
	public List<Rating> findByUserId(String userId);
	
	public List<Rating> findByHotelId(String hotelId);
	
}
