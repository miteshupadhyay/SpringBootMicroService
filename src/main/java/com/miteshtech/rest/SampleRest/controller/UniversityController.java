package com.miteshtech.rest.SampleRest.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.miteshtech.rest.SampleRest.dto.University;
import com.miteshtech.rest.SampleRest.exception.UniversityNotFoundException;
import com.miteshtech.rest.SampleRest.service.UniversityService;

@RestController
public class UniversityController {

	@Autowired
	private UniversityService universityService;
	
	@GetMapping("/universities")
	public List<University> retrieveAllUniversities(){
		return universityService.findAll();
	}
	
	@GetMapping("/universities/{universityId}")
	public University retrieveUniversity(@PathVariable int universityId) {
		University university = universityService.findOne(universityId);
		if(university==null)
			throw new UniversityNotFoundException("Entered University Id "+universityId+ " doesn't exist");
		
		/*
		 * Resource<University> resource=new Resource<University>(university);
		 * linkTo(methodOn(this.getClass()).retrieveAllUniversities());
		 * //resource.add(linkTo.withRel("All-Universities")); //resource.add(linkTo.);
		 */		
		return university;
	}
	
	@PostMapping("/universities")
	public ResponseEntity<Object> createUniversity(@Valid @RequestBody University university) {
		University savedUniversity = universityService.save(university);
		
		URI uri = ServletUriComponentsBuilder
						.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(savedUniversity.getUnversityId())
						.toUri();		
		return ResponseEntity.created(uri).build();		
		
	}
	
	@DeleteMapping("/universities/{universityId}")
	public void deleteUniversity(@PathVariable int universityId) {
		University university = universityService.deleteByUniversityId(universityId);
		if(university==null)
			throw new UniversityNotFoundException("Entered University Id "+universityId+ " doesn't exist");
	}	
}
