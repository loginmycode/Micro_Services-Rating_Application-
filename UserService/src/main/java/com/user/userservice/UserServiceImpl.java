package com.user.userservice;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.user.exception.ResourceNotFoundException;
import com.user.external.HotelService;
import com.user.model.Hotel;
import com.user.model.Rating;
import com.user.model.User;
import com.user.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {

	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private HotelService hotelService;
	
	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		String randomId =UUID.randomUUID().toString();
		//generates unique userid
		user.setUserId(randomId);
		return userRepo.save(user);
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public User getSingleUser(String userId) {
		// TODO Auto-generated method stub
		//fetch rating of the above users from Rating-Service 
		//http://localhost:8083/ratings/getsingle/.....useraId.....
		User user = userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("Given Userid not found on server"+userId));
		
		Rating [] ratingsOfUser =restTemplate.getForObject("http://Rating-Service/ratings/getbyuserId/"+user.getUserId(), Rating[].class);
		logger.info("{} ",ratingsOfUser);
		
		List<Rating> ratings =Arrays.stream(ratingsOfUser).toList();
		
		List<Rating> ratingList = ratings.stream().map(rating->{
			
		//	ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://Hotel-Service/hotels/getsingle/"+rating.getHotelId(), Hotel.class);
			Hotel hotel = hotelService.getHotel(rating.getHotelId());
			//Hotel hotel =forEntity.getBody();
			//logger.info("response status code ", forEntity.getStatusCode());
			rating.setHotel(hotel);
			return rating;
			
		}).collect(Collectors.toList());
		//return rating.getHotelId();
		user.setRatings(ratingList);
		return user;
	}

}
