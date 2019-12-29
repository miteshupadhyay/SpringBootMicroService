package com.miteshtech.rest.SampleRest.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.miteshtech.rest.SampleRest.model.Sample;

@RestController
public class SampleController {

	@Autowired
	private MessageSource messageSource;
		
	//@RequestMapping(method = RequestMethod.GET,path = "/first") //Older way of defining the mapping
	@GetMapping("/myFirstMessage")
	public String getFirstMessage() {
		return "This is my first message";
	}
	
	@GetMapping("/myFirstMessageByBean")
	public Sample getFirstMessageByBean() {
		return new Sample("My First Bean Message");
	}
	
	@GetMapping("/myFirstMessagePathVariable/{name}")
	public Sample getFirstMessagePathVariable(@PathVariable String name) {
		return new Sample("Welcome "+name);
	}
	
	@GetMapping("/i18N")
	public String getInternationaliztionMessage(@RequestHeader(name="Accept-Language",required = false) Locale locale) {
		return messageSource.getMessage("good.morning.message",null, locale);
	}
	
}
