package com.oyo.search.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oyo.search.pojo.Filter;
import com.oyo.search.pojo.SearchParams;

@RestController
public class HotelsSearchController {
	
	@RequestMapping("/search/hotels")
	public String searchHotels (HttpServletRequest request) {
		return request.getQueryString();
	}
	
	@RequestMapping("/search/hotels2")
	public SearchParams hotels2 (@ModelAttribute SearchParams json) {
		return json;
	}
	
	@RequestMapping("/search/hotels3")
	public Filter hotels3 (@ModelAttribute Filter filters) {
		return filters;
	}
	
}