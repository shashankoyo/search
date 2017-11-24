package com.oyo.search.constants;

import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;

public interface Constants {

	int MAX_REQUEST_SIZE = 50000;

	int MAX_MONTHS = 6;

	int AGREEMENT_TOTAL_MONTH_DAYS = 30;

	double DEFAULT_FLAGSHIP_OWNER_REVENUE_SHARE_FACTOR = 0.25d;

	String EMPTY_ATTRIBUTE = "<EMPTY>";

	Double DEFAULT_TAKE_RATE = 15.0;

	String TIME_ZONE_ASIA_KOLKATA = "Asia/Kolkata";

	ZoneId DEFAULT_ZONE_ID = ZoneId.of(TIME_ZONE_ASIA_KOLKATA);

	// LOG FILES
	/** {@link Logger} where {@literal Cost Price} triggers will be logged */
	String COST_PRICE_TRIGGER_LOG_FILE = "cptriggerstash";

	/** {@link Logger} where {@literal Pricing Rule} triggers will be logged */
	String PRICING_RULE_TRIGGER_LOG_FILE = "prtriggerstash";

	/**
	 * {@link Logger} where {@literal Consumer Price} triggers will be logged
	 */
	String SELLING_PRICE_TRIGGER_LOG_FILE = "sptriggerstash";

	/**
	 * {@link Logger} where {@literal Flat Price} triggers will be logged
	 */
	String FLAT_PRICE_TRIGGER_LOG_FILE = "fptriggerstash";

	/**
	 * {@link Logger} where {@literal Hotel Graph} triggers will be logged
	 */
	String HOTEL_GRAPH_TRIGGER_LOG_FILE = "hgtriggerstash";

	// AEROSPIKE
	/**
	 * Max number of keys for which {@literal Aerospike} get query will be done.
	 */
	int AEROSPIKE_BATCH_COUNT = 5000;

	// AEROSPIKE KEYS
	String KEY_HOTEL_ID = "hid";
	String KEY_DATE = "date";
	String KEY_CATEGORY = "category";
	String KEY_PRICING_LOGIC = "pLogic";
	String KEY_PRICES = "prices";
	String KEY_SELLING_PRICES = "sPrices";
	String KEY_TIMESTAMP = "ts";

	//List<AgreementType> SMART_AGREEMENT_TYPES = Arrays.asList(AgreementType.MG_ROLLING, AgreementType.AUTO_PILOT, AgreementType.FRANCHISE);

	String[] WEEKENDS = { "Friday", "Saturday" };
	String[] WEEKDAYS = { "Monday", "Tuesday", "Wednesday", "Thursday", "Sunday" };
	Integer FLAT_PRICE_CALCULATION_MONTHS = 7;
	Double DEFAULT_DISCOUNT = 0.25;

	int NO_OF_DAYS_FOR_GRAPH_CALCULATION = 4;

	Double[][] SMART_OWNER_CONTROL_LIMITS = { { 15D, -5D, 15D, 1D }, { -15D, -10D, 10D, 0D }, { -100D, -15D, 5D, 2D } };

	List<String> LEISURE_CITIES_FOR_NEIGHBOURS = Arrays.asList("Goa", "Jaipur");
	
	String JSON_PARSE_ERROR = "Error while parsing json";

	String JOB_FAILED_ERROR = "Error while running job";

}
