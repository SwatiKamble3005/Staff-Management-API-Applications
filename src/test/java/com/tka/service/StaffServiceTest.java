package com.tka.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.tka.dao.StaffDao;
import com.tka.entity.Staff;
import com.tka.exception.StaffNotFound;

@ExtendWith(MockitoExtension.class)
public class StaffServiceTest {

	@InjectMocks
	StaffService service;

	@Mock
	StaffDao dao;

	@Test
	public void insertStaffTest_ForSuccess() {

		Staff staff = new Staff();
		when(dao.insertStaff(staff)).thenReturn(true);
		String result = service.insertStaff(staff);
		assertNotNull(result);
	}

	@Test
	public void insertStaffTest_ForFail() {

		Staff staff=new Staff();
		when(dao.insertStaff(staff)).thenReturn(false);
		String result = service.insertStaff(staff);
		assertNotNull(result);
	}
	
	@Test
	public void getAllStaff() {
		
		List<Staff> staffs=new ArrayList<Staff>();
		when(dao.getAllStaff()).thenReturn(staffs);
		List<Staff> result = service.getAllStaff();
		assertNotNull(result);
	}
	
	@Test
	public void getStaffFromId_Exist() {
		
		Staff staff=new Staff();
		staff.setStaffid(4);
		when(dao.getStaffFromId(staff.getStaffid())).thenReturn(staff);
		Staff result = service.getStaffFromId(staff.getStaffid());
		assertNotNull(result);
	}
	
	@Test
	public void getStaffFromId_NotExist() {
		int staffId = 7;
		when(dao.getStaffFromId(staffId)).thenReturn(null);
		assertThrows(StaffNotFound.class, () -> service.getStaffFromId(staffId));
	}
	
	@Test
	public void getStaffWithSalaryMoreThan20k() {
		
		List<Staff> staffs=new ArrayList<Staff>();
		when(dao.getStaffWithSalaryMoreThan20k()).thenReturn(staffs);
		List<Staff> result = service.getStaffWithSalaryMoreThan20k();
		assertNotNull(result);
		
	}
	
	@Test
	public void getStaffWithExperienceBetween10to20() {
		
		List<Staff> staffs=new ArrayList<Staff>();
		when(dao.getStaffWithExperienceBetween10to20()).thenReturn(staffs);
		List<Staff> result = service.getStaffWithExperienceBetween10to20();
		assertNotNull(result);
		
	}
	@Test
	public void getMaxSalaryStaffInfo() {
		
		List<Staff> staffs=new ArrayList<Staff>();
		when(dao.getMaxSalaryStaffInfo()).thenReturn(staffs);
		List<Staff> result=service.getMaxSalaryStaffInfo();
		assertNotNull(result);
		
	}
	
	@Test
	public void updateSalaryById_Success() {
		
		int staffid=2;
		when(dao.updateSalaryById(staffid)).thenReturn(true);
		String result = service.updateSalaryById(staffid);
		assertNotNull(result);
		
	}
	
	@Test
	public void updateSalaryById_Fail() {
		
		int staffid=2;
		when(dao.updateSalaryById(staffid)).thenReturn(false);
		String result = service.updateSalaryById(staffid);
		assertNotNull(result);
	}
	
	@Test
	public void getNameOfMinExperienceStaff() {
		
		List<String> names=new ArrayList<String>();
		when(dao.getNameOfMinExperienceStaff()).thenReturn(names);
		List<String> result = service.getNameOfMinExperienceStaff();
		assertNotNull(result);
	}
	
	@Test
	public void getStaffWithProfile() {
		
		String profile="test";
		List<Staff> staffs=new ArrayList<Staff>();
		when(dao.getStaffWithProfile(profile)).thenReturn(staffs);
		List<Staff> result = service.getStaffWithProfile(profile);
		assertNotNull(result);
	}

	@Test
	public void getStaffExceptProfile() {
		
		String profile="test";
		List<Staff> staffs=new ArrayList<Staff>();
		when(dao.getStaffExceptProfile(profile)).thenReturn(staffs);
		List<Staff> result = service.getStaffExceptProfile(profile);
		assertNotNull(result);
	}

}
