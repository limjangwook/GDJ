package com.gdu.staff.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gdu.staff.domain.StaffDTO;
import com.gdu.staff.service.StaffService;

@Controller
public class StaffController {

	@Autowired
	private StaffService staffService;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@ResponseBody
	@GetMapping(value="/list.json", produces = "application/json; charset=UTF-8")
	public List<StaffDTO> list() {
		return staffService.getStaffList();
	}
	
	@ResponseBody
	@PostMapping(value="/add", produces="text/plain; charset=UTF-8")
	public ResponseEntity<String> add(StaffDTO staff){
		return staffService.addStaff(staff);
	}
	
	@ResponseBody
	@GetMapping(value="/find.json", produces = "application/json; charset=UTF-8")
	public StaffDTO find(HttpServletRequest request) {
		String sno = request.getParameter("sno");
		return staffService.getfindStaff(sno);
	}
	
}
