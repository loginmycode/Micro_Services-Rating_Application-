package com.user.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.user.model.Rating;

import jakarta.ws.rs.Path;

//@FeignClient(name ="RATING_SERVICE")

public interface RatingService {

	//@GetMapping("/ratings/getsingle/{ratingId}")
	//public Rating getRating(@PathVariable("ratingId") String ratingId);
	
}
