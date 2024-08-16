package com.user.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {

	private String hotelId;
	private String hotelName;
	private String hoteLocation;
	private String hotelAbout;
}
