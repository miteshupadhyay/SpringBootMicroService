package com.miteshtech.rest.SampleRest.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.miteshtech.rest.SampleRest.dto.University;

@Component
public class UniversityService {

	private static List<University> universities = new ArrayList<University>();

	private static int universityCount = 3;

	static {
		universities.add(new University(101, "Bosco", "BSC", new Date()));
		universities.add(new University(201, "Oxford", "OXF", new Date()));
		universities.add(new University(301, "California", "CFN", new Date()));
	}

	public List<University> findAll() {
		return universities;
	}

	public University save(University university) {
		Integer unversityId = university.getUnversityId();
		if (unversityId==null || unversityId==0) {
			university.setUnversityId(++universityCount);
		}
		universities.add(university);
		return university;
	}

	public University findOne(int id) {
		for (University university : universities) {
			if (university.getUnversityId() == id) {
				return university;
			}
		}
		return null;
	}
	
	public University deleteByUniversityId(int uId) {
		Iterator<University> iterator=universities.iterator();
		while(iterator.hasNext()) {
			University university=iterator.next();
			if(university.getUnversityId()==uId) {
				iterator.remove();
				return university;
			} 
		}
		
		return null;
	}
}
