package com.gdu.app05.service;

import org.springframework.http.ResponseEntity;

import com.gdu.app05.domain.Movie;

public class MovieServiceImpl implements MovieService {

	@Override
	public String getBoxOffice(String targetDt) {
		
		String serviceKey = "2e005d9ceb805a68f34a2b8f483ccea7";
		String apiURL = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=" + serviceKey + "&targetDt=" + targetDt;
		
		try {
			
			apiURL += ""
		}
		
		Movie movie = null;
		
	
		return null;
	}

}
