package com.tka.controller;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tka.entity.Staff;
import com.tka.service.StaffService;

@RestController
public class StaffController {
	
	@Autowired
	SessionFactory factory;
	
	@Autowired
	StaffService service;

	@PostMapping("insert")
	public String insertStaff(@RequestBody Staff staff) {
		
		return service.insertStaff(staff);

	}
	
	@GetMapping("allstaff")
	public List<Staff> getAllStaff() {
		
		return service.getAllStaff();
	}
	
	@GetMapping("fetchfromid/{staffid}")
	public Staff getStaffFromId(@PathVariable int staffid) {
		
		return service.getStaffFromId(staffid);
	}
	
	@GetMapping("salary-morethan20k")
	public List<Staff> getStaffWithSalaryMoreThan20k() {
		
	return service.getStaffWithSalaryMoreThan20k();
	}
	
	@GetMapping("exp-between10-20")
	public List<Staff> getStaffWithExperienceBetween10to20() {
		
	return	service.getStaffWithExperienceBetween10to20();
	}
	
	@GetMapping("max_salary_staff")
	public List<Staff> getMaxSalaryStaffInfo() {
		
	return	service.getMaxSalaryStaffInfo();
	}
	
	@GetMapping("update_salary/{staffid}")
	public String updateSalaryById(@PathVariable int staffid) {
		
	 return service.updateSalaryById(staffid);
	}
	
	@GetMapping("min_experience_name")
	public List<String> getNameOfMinExperienceStaff() {
		
	return service.getNameOfMinExperienceStaff();
	}
	
	@GetMapping("staff_with_profile/{profile}")
	public List<Staff> getStaffWithProfile(@PathVariable String profile) {
		
	return service.getStaffWithProfile(profile);
	}
	
	@GetMapping("staff_except_profile/{profile}")
	public List<Staff> getStaffExceptProfile(@PathVariable String profile) {
		
	  return service.getStaffExceptProfile(profile);
	}

}
