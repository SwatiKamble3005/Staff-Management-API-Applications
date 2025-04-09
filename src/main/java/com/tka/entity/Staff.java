package com.tka.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Staff {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int staffid;
	private String name;
	private String profile;
	private double salary;
	private int experience;

	private LocalDateTime dateofcreation;
	private LocalDateTime dateofmodification;

	public int getStaffid() {
		return staffid;
	}

	public void setStaffid(int staffid) {
		this.staffid = staffid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public LocalDateTime getDateofcreation() {
		return dateofcreation;
	}

	public void setDateofcreation(LocalDateTime dateofcreation) {
		this.dateofcreation = dateofcreation;
	}

	public LocalDateTime getDateofmodification() {
		return dateofmodification;
	}

	public void setDateofmodification(LocalDateTime dateofmodification) {
		this.dateofmodification = dateofmodification;
	}

}
