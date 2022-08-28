package com.in10minutes.basic.springaopin10steps.data;

import org.springframework.stereotype.Repository;

import com.in10minutes.basic.springaopin10steps.aspect.TrackTime;

@Repository
public class Dao1 {
	
	@TrackTime
	public String retrieveSomething() {
		return "Dao1";
	}

}
