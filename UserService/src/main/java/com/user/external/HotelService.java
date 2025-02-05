package com.user.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.user.model.Hotel;

@FeignClient(name ="HOTEL-SERVICE")
public interface HotelService {

	
	@GetMapping("/hotels/getsingle/{hotelId}")
	public Hotel getHotel(@PathVariable("hotelId") String hotelId);
;
	
}
