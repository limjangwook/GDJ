package com.gdu.app05.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
	
	@GetMapping("/")
	public String index() {
		return "index";  // index.jsp로 forward
	}
	
	@GetMapping("movie")
	public String movie() {
		return "movie";
	}
	
	@ResponseBody
	@GetMapping

}
