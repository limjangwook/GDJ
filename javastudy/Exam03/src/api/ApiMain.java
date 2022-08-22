package api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class ApiMain {

	public static void m1() {
		
	
		String serviceKey = "xUAiTKzO5U/aUArq7s7DjB7QwkWRuMJKT/Q+mry57W8VPTfWFIn5/1NkhtSmxUUG9RqRNgOJU02PfPRWK0lmMg==";
		
		StringBuilder urlBuilder = new StringBuilder();
		
		try {
			urlBuilder.append("http://apis.data.go.kr/B552061/AccidentDeath");
			urlBuilder.append("?serviceKey=").append(URLEncoder.encode(serviceKey, "UTF-8"));
			urlBuilder.append("&searchYear=2021");
			urlBuilder.append("&siDo=1100");
			urlBuilder.append("&guGun=1125");
			urlBuilder.append("numOfRows=10");
			urlBuilder.append("pageNo=1");
			
		} catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		String apiURL = urlBuilder.toString();
		
		URL url = null;
		HttpURLConnection con = null;
		
		try {
			url = new URL(apiURL);
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Content_Type", "application/json; charset=UTF-8");
		} catch(MalformedURLException e) {
			System.out.println("API 주소 오류");
		} catch(IOException e) {
			System.out.println("API 접속 실패");
		}
		
		BufferedReader reader = null;
		StringBuilder sb = new StringBuilder();
		
		try {
			if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			
			String line = null;
			while((line = reader.readLine()) != null) {
				sb.append(line);
			}
			reader.close();
			
		} catch(IOException e) {
			System.out.println("API 응답실패");
		}
		
		String response = sb.toString();
		
		File file = new File("accident.txt");
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(response);
			bw.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void m2() {
		
		File file = new File("accident.txt");
		List<Accident> accidents = new ArrayList<>();
		
		try {
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			
			NodeList accidentList = doc.getElementsByTagName("accidentList");
			
			for(int i = 0; i < accidentList.getLength(); i++) {
				
				Element acd = (Element)accidentList.item(i);
				/*
				NodeList movieCdList = boxOffice.getElementsByTagName("movieCd");
				Node movieCd = movieList.item(0);
				String movieCd = movieCd Node.getTextContent();
				*/
				String occrrncDt = acd.getElementsByTagName("occrrnc_dt").item(0).getTextContent();
				String occrrncDayCd = acd.getElementsByTagName("occrrnc_day_cd").item(0).getTextContent();
				String dthDnvCnt = acd.getElementsByTagName("dth_dnv_cnt").item(0).getTextContent();
				String injpsnCnt = acd.getElementsByTagName("injpsn_cnt").item(0).getTextContent();
				
				Accident accident = Accident.builder()
						.occrrncDt(occrrncDt)
						.occrrncDayCd(occrrncDayCd)
						.dthDnvCnt(dthDnvCnt)
						.injpsnCnt(injpsnCnt)
						.build();
				
				accidents.add(accident);
			}  
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		for(Accident accident : accidents) {
			System.out.println(accident);
		}
		
	}


	public static void main(String[] args) {
		m1();
	}

}
