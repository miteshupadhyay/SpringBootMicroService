package com.miteshtech.rest.SampleRest.dto;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Description about the University")
public class University {

	private int unversityId;
	
	@Size(min = 3,message = "University Name Name should have atleast 3 characters")
	@ApiModelProperty(notes = "University Name Name should have atleast 3 characters")
	private String universityName;
	private String universityCode;
	
	@Past(message = "Registration Date can't be Future Date")
	private Date universityRegDate;
	
	
	
	public int getUnversityId() {
		return unversityId;
	}
	public void setUnversityId(int unversityId) {
		this.unversityId = unversityId;
	}
	public String getUniversityName() {
		return universityName;
	}
	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}
	public String getUniversityCode() {
		return universityCode;
	}
	public void setUniversityCode(String universityCode) {
		this.universityCode = universityCode;
	}
	public Date getUniversityRegDate() {
		return universityRegDate;
	}
	public void setUniversityRegDate(Date universityRegDate) {
		this.universityRegDate = universityRegDate;
	}
	
	public University(int unversityId, String universityName, String universityCode, Date universityRegDate) {
		this.unversityId = unversityId;
		this.universityName = universityName;
		this.universityCode = universityCode;
		this.universityRegDate = universityRegDate;
	}
	
	
	
}
