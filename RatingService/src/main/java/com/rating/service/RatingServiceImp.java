package com.rating.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rating.model.Rating;
import com.rating.repository.RatingRepository;

@Service
public class RatingServiceImp implements RatingService {

	@Autowired
	private RatingRepository ratingRepo;
	
	@Override
	public Rating createRating(Rating rating) {
		// TODO Auto-generated method stub
		
		String randomId =UUID.randomUUID().toString();
		rating.setRatingId(randomId);
		return ratingRepo.save(rating);
	}

	@Override
	public List<Rating> getAllRating() {
		// TODO Auto-generated method stub
		return ratingRepo.findAll();
	}

	@Override
	public Rating getSingleRating(String ratingId) {
		// TODO Auto-generated method stub
		return ratingRepo.findById(ratingId).orElseThrow();
	}

	@Override
	public List<Rating> getRatingByUserId(String userId) {
		// TODO Auto-generated method stub
		return ratingRepo.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelId) {
		// TODO Auto-generated method stub
		return ratingRepo.findByHotelId(hotelId);
	}

}
