package com.gdu.search;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;


public class ApiSearchBook {

	public static void main(String[] args) {
		
		String clientId = "hH2OXbYPtntBQJfT0oQF";
		String clientSecret ="epWavnnFZ9";
		
		try {
			
			Scanner sc = new Scanner(System.in);
			System.out.print("검색하세용 >>> ");
			String book = sc.next();
			sc.nextLine();
			sc.close();
			
			String apiURL = "https://openapi.naver.com/v1/search/book?query=" + URLEncoder.encode(book, "UTF-8");
	         
	        URL url = new URL(apiURL);
	        HttpURLConnection con = (HttpURLConnection) url.openConnection();
	        con.setRequestMethod("GET");
	        con.setRequestProperty("X-Naver-Client-Id", clientId);
	        con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
	         
	        BufferedReader br = null;
	         
	        if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
	           br = new BufferedReader(new InputStreamReader(con.getInputStream()));
	        } else {
	           br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
	        }
	         
	        StringBuilder sb = new StringBuilder();
	        String line;
	         
	        while((line = br.readLine()) != null) {
	           sb.append(line);
	        }
	         
	        br.close();
	        con.disconnect();
			
			JSONObject obj = new JSONObject(sb.toString());
			JSONArray items = obj.getJSONArray("items");
			
			File dir = new File("C:/download");
			if(dir.exists() == false) {
				dir.mkdirs();
			}
			
			
			File file = new File(dir, book + ".html");
			PrintWriter out = new PrintWriter(file);
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset=\"UTF-8\">");
			out.println("<title>" + book + "</title>");
			out.println("</head>");
			out.println("<body>");
			for(int i = 0; i < items.length(); i++) {
	            JSONObject item = items.getJSONObject(i);
	            String title = item.getString("title");
	            String link = item.getString("link");
	            String image = item.getString("image");
	            out.println("<a href="+ link +">" + title + "</a><br>");
	            out.println("<img src=\""+ image + "\" width=\"150px\"><br>");
	            out.println("<hr>");
	         }
			out.println("</body>");
			out.println("</html>");
			out.close();
			
			System.out.println("Success");
			
		} catch (Exception e) {
			
			try {
				
				File dir = new File("C:/download/log");
				if(dir.exists() == false) {
					dir.mkdirs();
				}
				
				File file = new File(dir, "error_log.txt");
				PrintWriter out = new PrintWriter(file);
				
				Date date = new Date();
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd a HH:mm:ss");
				System.out.println(simpleDateFormat.format(date));
				
				out.println("예외메시지       " + e.getMessage());
		        out.println("예외발생시간    " + simpleDateFormat.format(date));
				out.close();
				
				System.out.println("Fail");
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
}
