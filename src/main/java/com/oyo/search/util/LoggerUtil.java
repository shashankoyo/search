/**
 *
 */
package com.oyo.search.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.oyo.search.constants.Constants;

/**
 * The {@code LoggerUtil} class is for logging {@literal Data} to log files.
 */
public class LoggerUtil {

	private static final Logger logger = LoggerFactory.getLogger(LoggerUtil.class);

	private static final Logger cpTriggerLog = LoggerFactory.getLogger("cptriggerstash");

	private static final Logger prTriggerLog = LoggerFactory.getLogger("prtriggerstash");

	private static final Logger spTriggerLog = LoggerFactory.getLogger("sptriggerstash");

    private static final Logger fpTriggerLog = LoggerFactory.getLogger("fptriggerstash");
    
    private static final Logger hgTriggerLog = LoggerFactory.getLogger("hgtriggerstash");

	/**
	 * {@code JSON} {@link Object} is logged to log file. This method converts
	 * {@code Object} to {@code JSON}.
	 * @param obj
	 */
	private static String readValueAsString(Object obj) {
		String data = "";
		try {
			data = TransformUtil.toJson(obj);
		} catch (Exception e) {
			logger.error("#LoggerUtil:Could not parse object: {}", obj);
		}
		logger.info("Sending data to logstash: {}", data);
		return data;
	}

	public static void info(Object kafkaTriggerDataModel, String triggerLogFile) {
		String data = readValueAsString(kafkaTriggerDataModel);
		log(triggerLogFile, data);
	}

	public static void log(String triggerLogFile, String data) {
		getLogger(triggerLogFile).warn("{}", data);
	}

	/**
	 * Returns the logger to which the logging has to be done.
	 * @param triggerLogFile
	 * @return
	 */
	private static Logger getLogger(String triggerLogFile) {
		Logger log = logger;
		switch (triggerLogFile) {
			case Constants.COST_PRICE_TRIGGER_LOG_FILE:
				log = cpTriggerLog;
				break;
			case Constants.PRICING_RULE_TRIGGER_LOG_FILE:
				log = prTriggerLog;
				break;
			case Constants.SELLING_PRICE_TRIGGER_LOG_FILE:
				log = spTriggerLog;
				break;
			case Constants.FLAT_PRICE_TRIGGER_LOG_FILE:
				log = fpTriggerLog;
				break;
			case Constants.HOTEL_GRAPH_TRIGGER_LOG_FILE:
				log = hgTriggerLog;
				break;
			default:
				break;
		}
		return log;
	}

}