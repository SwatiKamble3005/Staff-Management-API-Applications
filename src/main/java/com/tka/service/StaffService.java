package com.tka.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.tka.dao.StaffDao;
import com.tka.entity.Staff;
import com.tka.exception.StaffNotFound;

@Service
public class StaffService {

	@Autowired
	StaffDao dao;

	public String insertStaff(Staff staff) {

		staff.setDateofcreation(LocalDateTime.now());
		staff.setDateofmodification(LocalDateTime.now());
		boolean isInserted = dao.insertStaff(staff);

		if (isInserted) {

			return "Staff Inserted Successfully";
		} else {

			return "Failed to insert";
		}
	}

	public List<Staff> getAllStaff() {

		return dao.getAllStaff();
	}

	public Staff getStaffFromId(int staffid) {

		Staff staff = dao.getStaffFromId(staffid);

		if (staff != null) {

			return staff;

		} else {

			throw new StaffNotFound();
		}
	}

	public List<Staff> getStaffWithSalaryMoreThan20k() {

		return dao.getStaffWithSalaryMoreThan20k();

	}

	public List<Staff> getStaffWithExperienceBetween10to20() {

		return dao.getStaffWithExperienceBetween10to20();

	}

	public List<Staff> getMaxSalaryStaffInfo() {

		return dao.getMaxSalaryStaffInfo();

	}

	public String updateSalaryById(int staffid) {

		boolean isUpdated = dao.updateSalaryById(staffid);

		if (isUpdated) {

			return "Salary Updated Successfully";
		} else {

			return "Employee Not Found ";
		}

	}

	public List<String> getNameOfMinExperienceStaff() {

		return dao.getNameOfMinExperienceStaff();

	}

	public List<Staff> getStaffWithProfile(String profile) {

		return dao.getStaffWithProfile(profile);
	}

	public List<Staff> getStaffExceptProfile(String profile) {

		return dao.getStaffExceptProfile(profile);
	}

}
