package com.oyo.search.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oyo.search.pojo.Filter;
import com.oyo.search.pojo.SearchParams;
import com.oyo.search.pojo.TriggerDataModel;
import com.oyo.search.util.TransformUtil;

@RestController
public class HotelsSearchController {

	private static final Logger log = LoggerFactory.getLogger(HotelsSearchController.class);

	@RequestMapping("/search/hotels")
	public String searchHotels(HttpServletRequest request) {
		log.info(request.getRequestURL().toString());
		return request.getQueryString();
	}

	@RequestMapping("/search/hotels2")
	public SearchParams hotels2(@ModelAttribute SearchParams json, HttpServletRequest request) {
		log.info(request.getRequestURL().toString());
		return json;
	}

	@RequestMapping("/search/hotels3")
	public Filter hotels3(@ModelAttribute Filter filters) {
		return filters;
	}

	@RequestMapping("/test/{id}")
	public TriggerDataModel test(@PathVariable(value = "id") String id, HttpServletRequest request) {
		String str = "{\"hotel_ids\":[2],\"log_type\":\"SEARCH_SERVICE_HOTEL\",\"source\":\"Hotel\",\"data\":[{\"field_name\":\"wifi_autoconnect\",\"value\":true},{\"field_name\":\"website\",\"value\":\"www.hoteltest.com\"},{\"field_name\":\"short_address\",\"value\":\"short\"},{\"field_name\":\"updated_at\",\"value\":\"2017-11-30T16:42:21.215+05:30\"}]}";
		TriggerDataModel triggerObj = TransformUtil.fromJson(str, TriggerDataModel.class);
		triggerObj.setData_unique_id(id);
		log.info(request.getRequestURL().toString());
		return triggerObj;
	}

}