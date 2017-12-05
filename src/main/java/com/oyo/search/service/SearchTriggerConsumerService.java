package com.oyo.search.service;

import org.assertj.core.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.oyo.search.constants.SearchClassType;
import com.oyo.search.listener.SearchTriggerListener;
import com.oyo.search.pojo.AbstractPojo;
import com.oyo.search.pojo.TriggerDataModel;

public class SearchTriggerConsumerService {

	private static final Logger log = LoggerFactory.getLogger(SearchTriggerListener.class);

	public void consume(final TriggerDataModel triggerObj) {
		if (!(validateType(triggerObj) && validateClass(triggerObj))) {
			log.info("Invalid type or class.");
			return;
		}
		if (triggerObj.getType().equalsIgnoreCase("push")) {
			// fit data in model as per class
		} else if (triggerObj.getType().equalsIgnoreCase("pull")) {
			SearchDataRetrievalService searchDataRetrievalService = new SearchDataRetrievalService();
			AbstractPojo pojo = searchDataRetrievalService.getDataFromExternalApi(triggerObj.getSource(), triggerObj.getData_unique_id());
			log.info("Data received : " + pojo.toString());
		}

	}

	private boolean validateType(final TriggerDataModel triggerObj) {
		if (triggerObj.getType().equalsIgnoreCase("pull")) {
			return true;
		} else if (triggerObj.getType().equalsIgnoreCase("push")) {
			if (Arrays.isNullOrEmpty(triggerObj.getData()))
				return false;
			return true;
		} else {
			return false;
		}
	}

	private boolean validateClass(final TriggerDataModel triggerObj) {
		SearchClassType sourceClass = SearchClassType.findByValue(triggerObj.getSource());
		if (sourceClass == null)
			return false;
		return true;
	}

}