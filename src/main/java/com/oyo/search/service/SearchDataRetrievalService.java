package com.oyo.search.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import com.oyo.search.constants.SearchClassType;
import com.oyo.search.pojo.AbstractPojo;
import com.oyo.search.pojo.TriggerDataModel;

public class SearchDataRetrievalService {

	RestTemplate restTemplate;

	public SearchDataRetrievalService() {
		restTemplate = new RestTemplate();
	}

	private static final Logger log = LoggerFactory.getLogger(SearchDataRetrievalService.class);

	public AbstractPojo getDataFromExternalApi(final String triggerSource, final String id) {
		String url = SearchClassType.findByValue(triggerSource).url();
		url = url + "/" + id;
		// fetch data from url
		try {
			AbstractPojo model = restTemplate.getForObject(url, TriggerDataModel.class);
			System.out.println(model.toString());
			return model;
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		return null;
	}
}