package com.hotel.services;

import java.util.List;

import com.hotel.model.Hotel;

public interface HotelService {

	public Hotel createHotel(Hotel hotel);
	
	public List<Hotel> getAllHotel();
	
	public Hotel getSingleHotel(String hotelId);
	
	
}
