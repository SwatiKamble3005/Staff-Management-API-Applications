package com.tka.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.entity.Staff;

@Repository
public class StaffDao {

	@Autowired
	SessionFactory factory;

	public boolean insertStaff(Staff staff) {

		Session session = factory.openSession();
		session.save(staff);
		session.beginTransaction().commit();
		return true;

	}

	public List<Staff> getAllStaff() {

		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Staff.class);
		List<Staff> allstaff = criteria.list();
		return allstaff;

	}

	public Staff getStaffFromId(int staffid) {

		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Staff.class);
		criteria.add(Restrictions.eq("staffid", staffid));
		Staff staff = (Staff) criteria.uniqueResult();
		return staff;
	}

	public List<Staff> getStaffWithSalaryMoreThan20k() {

		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Staff.class);
		criteria.add(Restrictions.gt("salary", 20000.00));
		List<Staff> list = criteria.list();
		return list;

	}

	public List<Staff> getStaffWithExperienceBetween10to20() {

		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Staff.class);
		criteria.add(Restrictions.between("experience", 10, 20));
		List<Staff> list = criteria.list();
		return list;
	}

	public List<Staff> getMaxSalaryStaffInfo() {

		Session session = factory.openSession();
		Criteria maxSalaryCriteria = session.createCriteria(Staff.class);
		maxSalaryCriteria.setProjection(Projections.max("salary"));
		Double maxsalary = (Double) maxSalaryCriteria.uniqueResult();
		Criteria staffCriteria = session.createCriteria(Staff.class);
		staffCriteria.add(Restrictions.eq("salary", maxsalary));
		List maxsalaryStaff = staffCriteria.list();
		return maxsalaryStaff;

	}

	public boolean updateSalaryById(int staffid) {

		Session session = factory.openSession();
		Staff staff = session.get(Staff.class, staffid);
		if (staff != null) {

			staff.setSalary(staff.getSalary() + 5000);
			session.update(staff);
			session.beginTransaction().commit();
			return true;
		} else {

			return false;
		}

	}

	public List<String> getNameOfMinExperienceStaff() {

		Session session = factory.openSession();
		Criteria minExpcriteria = session.createCriteria(Staff.class);
		minExpcriteria.setProjection(Projections.min("experience"));
		Integer minExperience = (Integer) minExpcriteria.uniqueResult();
		Criteria staffNameCriteria = session.createCriteria(Staff.class);
		staffNameCriteria.add(Restrictions.eq("experience", minExperience));
		staffNameCriteria.setProjection(Projections.property("name"));
		List<String> names = staffNameCriteria.list();
		return names;

	}

	public List<Staff> getStaffWithProfile(String profile) {

		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Staff.class);
		criteria.add(Restrictions.eq("profile", profile));
		List<Staff> list = criteria.list();
		return list;
	}

	public List<Staff> getStaffExceptProfile(String profile) {

		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Staff.class);
		criteria.add(Restrictions.ne("profile", profile));
		List<Staff> list = criteria.list();
		return list;
	}

}
