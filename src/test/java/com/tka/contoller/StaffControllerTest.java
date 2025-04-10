package com.tka.contoller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.tka.controller.StaffController;
import com.tka.entity.Staff;
import com.tka.service.StaffService;

@ExtendWith(MockitoExtension.class)
public class StaffControllerTest {

	@InjectMocks
	StaffController uc;

	@Mock
	StaffService service;

	@Test
	public void insertStaffTest() {

		Staff staff = new Staff();
		when(service.insertStaff(staff)).thenReturn(anyString());
		String msg = uc.insertStaff(staff);
		assertNotNull(msg);

	}

	@Test
	public void getAllStaffTest() {

		List<Staff> staffs = new ArrayList<Staff>();
		when(service.getAllStaff()).thenReturn(staffs);
		List<Staff> allStaff = uc.getAllStaff();
		assertNotNull(allStaff);

	}

	@Test
	public void getStaffFromId() {

		Staff staff = new Staff();
		staff.setStaffid(5);
		when(service.getStaffFromId(staff.getStaffid())).thenReturn(staff);
		Staff result = uc.getStaffFromId(staff.getStaffid());
		assertNotNull(result);

	}

	@Test
	public void getStaffWithSalaryMoreThan20k() {

		List<Staff> staffs = new ArrayList<Staff>();
		when(service.getStaffWithSalaryMoreThan20k()).thenReturn(staffs);
		List<Staff> result = uc.getStaffWithSalaryMoreThan20k();
		assertNotNull(result);

	}

	@Test
	public void getStaffWithExperienceBetween10to20() {

		List<Staff> staffs = new ArrayList<Staff>();
		when(service.getStaffWithExperienceBetween10to20()).thenReturn(staffs);
		List<Staff> result = uc.getStaffWithExperienceBetween10to20();
		assertNotNull(result);

	}

	@Test
	public void getMaxSalaryStaffInfo() {

		List<Staff> staffs = new ArrayList<Staff>();
		when(service.getMaxSalaryStaffInfo()).thenReturn(staffs);
		List<Staff> result = uc.getMaxSalaryStaffInfo();
		assertNotNull(result);
	}

	@Test
	public void updateSalaryById() {

		Staff staff = new Staff();
		staff.setStaffid(3);
		when(service.updateSalaryById(staff.getStaffid())).thenReturn(anyString());
		String result = uc.updateSalaryById(staff.getStaffid());
		assertNotNull(result);

	}
	
	@Test
	public void getNameOfMinExperienceStaff() {
		
		List<String> names=new ArrayList<String>();
		when(service.getNameOfMinExperienceStaff()).thenReturn(names);
		List<String> result = uc.getNameOfMinExperienceStaff();
		assertNotNull(result);
	}
	
	@Test
	public void getStaffWithProfile() {
		
		Staff staff=new Staff();
		staff.setProfile("test");
		List<Staff> staffs=new ArrayList<Staff>();
		when(service.getStaffWithProfile(staff.getProfile())).thenReturn(staffs);
		List<Staff> result = uc.getStaffWithProfile(staff.getProfile());
		assertNotNull(result);
	}
	
	@Test
	public void getStaffExceptProfile() {
		
		Staff staff=new Staff();
		staff.setProfile("test");
		List<Staff> staffs=new ArrayList<Staff>();
		when(service.getStaffExceptProfile(staff.getProfile())).thenReturn(staffs);
		List<Staff> result = uc.getStaffExceptProfile(staff.getProfile());
		assertNotNull(result);
	}
}
