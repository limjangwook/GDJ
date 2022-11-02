package com.gdu.app05.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MovieServiceImpl implements MovieService {

	@Override
	public String getBoxOffice(String targetDt) {
		
		String serviceKey = "2e005d9ceb805a68f34a2b8f483ccea7";
		String apiURL = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=" + serviceKey + "&targetDt=" + targetDt;
		StringBuilder sb = null;
		
		try {
			
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			
			BufferedReader br =null;
			if(con.getResponseCode() == 200) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			
			sb = new StringBuilder();
			
			String line;
			while((line = br.readLine()) != null) {
				sb.append(line);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		return sb.toString();
	}

}
