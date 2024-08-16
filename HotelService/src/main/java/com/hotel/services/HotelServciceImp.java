package com.hotel.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.exception.ResourceNotFoundException;
import com.hotel.model.Hotel;
import com.hotel.repository.HotelRepository;

@Service
public class HotelServciceImp implements HotelService {

	@Autowired
	private HotelRepository hotelRepo;
	@Override
	public Hotel createHotel(Hotel hotel) {
		// TODO Auto-generated method stub
		
		String randomId = UUID.randomUUID().toString();
		hotel.setHotelId(randomId);
		return hotelRepo.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotel() {
		// TODO Auto-generated method stub
		return hotelRepo.findAll();
	}

	@Override
	public Hotel getSingleHotel(String hotelId) {
		// TODO Auto-generated method stub
		return hotelRepo.findById( hotelId).orElseThrow(()-> new ResourceNotFoundException("hotel with given Id not found"+hotelId));
	}
}



