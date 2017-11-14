package com.oyo.search.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HotelsSearchController {
	
	@RequestMapping("/search/hotels")
	public String searchHotels (HttpServletRequest request) {
		return request.getQueryString();
	}
}